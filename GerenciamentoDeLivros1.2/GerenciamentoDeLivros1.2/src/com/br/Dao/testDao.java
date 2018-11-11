package com.br.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.br.Models.Emprestimo;

//import com.br.Models.Livro;
//import com.br.Models.Usuario;

public class testDao {
	public static void main(String[] args) {
		
		Emprestimo em = new Emprestimo();
		EmprestimoDaoImpl d = null;
		
		try {
			d = new EmprestimoDaoImpl();
		} catch (GenericDaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		em.setId(1);
		em.setIdLivro(2);
		em.setIdUsuario(3);
		em.setDatainicio("10/10/2018");
		em.setDatafim("20/10/2018");
		
		try {
			d.adiciona(em);
			System.out.println("Funcionou");
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		//HEITOR PODE FAZER ISSO AQUI
		try {
			UsuarioDaoImpl d = new UsuarioDaoImpl();
			List<Usuario> usuario = new ArrayList<>();
			usuario = d.getAllUser();
			System.out.println("BUSCOU " + usuario);
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//////////////////USUARIO /////////////////////////////////

		Usuario u = new Usuario();
		UsuarioDaoImpl d = null;

		try {
			d = new UsuarioDaoImpl();
		} catch (GenericDaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		u.setId(2);
		u.setNome("Oracle");
		u.setEmail("oracle.java@oracle.com.br");
		u.setTipo("Funcionario");
		u.setTelefone("987651234");
		
		
		try {
			d.salvar(u);
			System.out.println("Funcionou, alterou");
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			d.remover("Java");
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			System.out.println("Funcionou, deletou");
			e.printStackTrace();
		}
		
		try {
			d.pesquisarPorId(1);
			System.out.println("Funcionou Achou o " + u.getNome() + " do Aluno");
		} catch (GenericDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		 * try { d.adiciona(u); System.out.println("Funcionou"); } catch
		 * (GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
	     ////////////////// LIVRO /////////////////////////////////
		 * Livro l = new Livro();
		 * 
		 * LivroDaoImpl d = null; try { d = new LivroDaoImpl(); } catch
		 * (GenericDaoException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 * 
		 * l.setId(2); l.setNome("O ACHIMENTO2"); l.setGenero("ficcao");
		 * l.setAutor("Tara"); l.setEditora("Beby"); l.setSatus(true);
		 * 
		 * try { d.adiciona(l); System.out.println("Funcionou"); } catch
		 * (GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try { d.remover(1); System.out.println("Funcionou"); }
		 * catch(GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try { d.pesquisarPorAutor("Tara"); System.out.println("Funcionou");
		 * }catch (GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try { d.pesquisarPorId(1); System.out.println("Funcionou"); } catch
		 * (GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * try { d.salvar(1, l); System.out.println("Funcionou"); } catch
		 * (GenericDaoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}
