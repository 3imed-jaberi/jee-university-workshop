package com.isamm.imedjaberi;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Recherche")
public class RechercheS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RechercheS() {
        super();
    }

	/**
	 * HERE USE THE POST REQUEST .. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the name ( i don't need here to use try/catch beacaut there are some default value in the forms .. 
		String nameE = request.getParameter("nameE");
		try {
			// here get all 'Etudiant'(Student) value from database and put it in the request object then check when sould be dispatch .. 
			Connection connect = Connecteur.getConnection();
			String requette_SQL = "SELECT * FROM `etudiant` WHERE nom = ? ";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setString(1,nameE);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if ( resultSet.next()){
				Etudiant etudiant = new Etudiant();
				
				 etudiant.setId(resultSet.getInt(1));
				 etudiant.setNom(resultSet.getString(2));
				 etudiant.setPrenom(resultSet.getString(3));
				 etudiant.setTel(resultSet.getString(4));
				 etudiant.setNiveau(resultSet.getString(5));
				 
				 request.setAttribute("etudiant", etudiant);
				
				 getServletContext().getRequestDispatcher("/Emprunt").forward(request, response);
				 
				 connect.close();
			}else{
				connect.close();
				response.sendRedirect("Erreur.html");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
