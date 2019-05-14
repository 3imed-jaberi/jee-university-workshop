<!-- Import all package here .. -->
<%@page import="java.util.ArrayList"%>
<%@page import="com.isamm.imedjaberi.Livre"%>
<%@page import="com.isamm.imedjaberi.Etudiant"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> List Emprunts </title>
</head>
<body>
   <!-- Dipslay the current student details if you in part 3 or the finded if you in part 2 -->
   <h1>
    <%= (((Etudiant)request.getAttribute("EtudiantRelative")) != null )
    							?
    	((Etudiant)request.getAttribute("EtudiantRelative")).getPrenom() 
    		+ " " +
    	((Etudiant)request.getAttribute("EtudiantRelative")).getNom() 
    							: 
    	""
    %> 
   </h1>
   <!-- Just for the part 3 : destroy the session -->
   <a href="/Logout"> Logout </a>
   
   <table>
     <thead>
         <tr>
            <td> Titre </td>
            <td> Auteur </td>
            <td> Date Emprunt </td>
         </tr>
     </thead>
     <tbody>
        <% for ( Livre L : (ArrayList<Livre>)request.getAttribute("LivresEmpruntes") ) { %>
         <tr>
            <td> <%= L.getTitre() %> </td>
            <td> <%= L.getAuteur() %> </td>
            <td> <%= L.getDateEmprunt() %> </td>
         </tr>
    	<% } %>
     </tbody>
   </table>
</body>
</html>