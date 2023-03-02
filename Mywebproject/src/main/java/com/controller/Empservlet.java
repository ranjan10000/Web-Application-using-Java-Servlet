package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.Emppojo;
import com.model.Empmodel;

/**
 * Servlet implementation class Empservlet
 */
@WebServlet("/Empservlet")
public class Empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");

		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		Empmodel em = new Empmodel();
		em.setFirstname(firstname);
		em.setLastname(lastname);
		em.setUsername(username);
		em.setPwd(pwd);
		try {
		Emppojo dao=new Emppojo();
		 
		 boolean status = dao.mydao(em);
		
			if(status) {
				RequestDispatcher ds=getServletContext().getRequestDispatcher("/Login.jsp");
				ds.forward(request, response);
			}
			else {
				response.sendRedirect("unsucess.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
