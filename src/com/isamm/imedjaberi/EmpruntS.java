package com.isamm.imedjaberi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Emprunt")
public class EmpruntS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpruntS() {
        super();
    }

	/**
	 * HERE USE THE POST REQUEST .. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the 'Etudiant'(Student) object value from 'RchercheS' Servlet  .. 
		Etudiant E = (Etudiant) request.getAttribute("etudiant");
		// create a new session - part 3 of the workshop - .. 
		HttpSession s = request.getSession(true);
		// put the 'Etudiant'(Student) in the session - part 3 of the workshop - .. 
		s.setAttribute("CurrentEtudiant", E);


		try {
			
			// here get all 'Livres'(Books) value from database and put it in arraylist then send that to jsp file .. 
			Connection connect = Connecteur.getConnection();
			String requette_SQL = "SELECT * FROM `livre` WHERE idEtudiant = ? ";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setInt(1,E.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			ArrayList<Livre> myList = new ArrayList<Livre>();

			while ( resultSet.next()){
				
				 Livre livre = new Livre();
				
				 livre.setId(resultSet.getInt(1));
				 livre.setTitre(resultSet.getString(2));
				 livre.setAuteur(resultSet.getString(3));
				 livre.setDateEmprunt(resultSet.getString(4));
				 livre.setEdition(resultSet.getString(5));
				 
				 myList.add(livre);
				
			}
			
			request.setAttribute("EtudiantRelative", E);
			request.setAttribute("LivresEmpruntes", myList);
			
			getServletContext().getRequestDispatcher("/ListeEmprunts.jsp ").forward(request, response);
			connect.close();
		}catch(SQLException ex){
			System.out.println("ListeLiveEmpruntes : " + ex);
		}
	}


}
