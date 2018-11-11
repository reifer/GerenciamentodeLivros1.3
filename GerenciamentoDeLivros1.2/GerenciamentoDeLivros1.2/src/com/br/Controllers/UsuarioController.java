package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.br.Dao.GenericDaoException;
import com.br.Dao.UsuarioDao;
import com.br.Dao.UsuarioDaoImpl;
import com.br.Models.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	public UsuarioController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Para acessar usuarios utilize a pagina de <a href=\"./usuario.jsp\">usuario</a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			UsuarioDao uDao = new UsuarioDaoImpl();
			if("adiciona".equals(cmd)){
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(request.getParameter("id")));
				u.setNome(request.getParameter("nome"));
				u.setEmail(request.getParameter("email"));
				u.setTipo(request.getParameter("tipo"));
				u.setTelefone(request.getParameter("telefone"));
				uDao.adiciona(u);
				session.setAttribute("LISTA", u);
				msg = "Usuario adicionado com sucesso!";
			}else if("pesquisar".equals(cmd)){
				Usuario u = uDao.pesquisarPorId(Integer.parseInt(request.getParameter("txtId")));
				session.setAttribute("LISTA", u);
				msg = "Usuario encontrado " + u + " usuarios"; 
			}else if("remover".equals(cmd)){
				String nome = request.getParameter("txtNome");
				uDao.remover(nome);
				msg = "Usuario com Nome " + nome + " foi removido com sucesso!";
			}else if("editar".equals(cmd)){
				//String id = request.getParameter("txtId");
				Usuario u = uDao.pesquisarPorId(Integer.parseInt(request.getParameter("txtId")));
				session.setAttribute("USUARIO_ATUAL", u);
				msg = "Dados do Usuario foram alterados com sucesso!";
			}else if("salvar".equals(cmd)){
				Usuario u = new Usuario();
				String nome = request.getParameter("txtNome");
				String id = request.getParameter("txtId");
				u.setNome(request.getParameter("nome"));
				u.setEmail(request.getParameter("email"));
				u.setTelefone(request.getParameter("telefone"));
				u.setTipo(request.getParameter("tipo"));
				session.setAttribute("LISTA", u);
				msg = "Usuario salvo com sucesso!";
			}
		} catch (GenericDaoException e) {
			msg = "Erro ao acessar o usuario.";
			e.printStackTrace();
		}
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./usuario.jsp");
	}
}