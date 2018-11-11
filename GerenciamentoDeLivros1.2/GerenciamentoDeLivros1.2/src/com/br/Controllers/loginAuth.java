package com.br.Controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class loginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		String msg = null;
		HttpSession session = request.getSession();
		
		//System.out.println(user + pass);

		//if (user.equals("admin") && pass.equals("admin")) {
			//System.out.println("home");
			response.sendRedirect("./home.jsp");
		//} else {
		//	System.out.println("login");
			//response.sendRedirect("./login.jsp");
		//}
	}
}
