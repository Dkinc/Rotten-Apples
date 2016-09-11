package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsersManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		boolean valid = true;
		//TODO validate data and modify valid property accordingly
		if(valid){
			UsersManager.getInstance().regUser(username, name, password2, address, email);
			RequestDispatcher view = request.getRequestDispatcher("index.html");
			view.forward(request, response);
		}
	}

}
