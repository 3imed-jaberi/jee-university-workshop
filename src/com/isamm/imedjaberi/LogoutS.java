package com.isamm.imedjaberi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Logout")
public class LogoutS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutS() {
        super();
    }

	  /**
	   * Here i redirect to recherche etudiant page .. you can create login file then redirect .. 
	   * This is my attempt for do the part 1 & the part 2 .. 
	   */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if(request.getParameter("logout") != null ){  
			  request.getSession(false).invalidate();
			  response.sendRedirect("RechercheEtudiant.jsp");
		//}
		
	}
	

}
