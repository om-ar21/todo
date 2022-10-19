package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.Hash;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		request.setCharacterEncoding("UTF-8");
		 UserDAO userdao=new UserDAO();
		 HttpSession session = request.getSession( true );
		    boolean messageinscriptionok=false;
			boolean inputvide=false;
			boolean mdppasidentique = false;
			boolean mdplength= false;
			boolean mdpweak= false;
			boolean emailinvalide = false;
			boolean userexiste = false;
			boolean messageconnexionno=false;
			boolean connected=false;
			//si le bouton inscription est cliqué 
			if(request.getParameter("binscription")!=null) {
				String nom = request.getParameter("nom");
				String email=request.getParameter("email");
				String mdp=request.getParameter("mdp");
				String cmdp=request.getParameter("cmdp");
				int d=userdao.verifyEmail(email);
				Pattern verifyEmail = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+"[A-zA-Z0-9_+&*-]+)*@"+
				"(?:[A-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
				Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
				Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
				Pattern lowerCasePatten = Pattern.compile("[a-z ]");
				Pattern digitCasePatten = Pattern.compile("[0-9 ]");
				
				//si les input sont vide 
				if ((nom.isEmpty() || nom.equals(" ")) ||(email.isEmpty() || email.equals(" ")) || (mdp.isEmpty()|| mdp.equals(" ")) || (cmdp.isEmpty()|| cmdp.equals(" "))) { 
							inputvide = true;	
					}
				//si l'email existe déja
				else if( d!=0) {
					userexiste=true;
				}
				//si l'email n'est pas valide
				 else if (!verifyEmail.matcher(email).matches()) { 
					emailinvalide = true;	
						
				}
				//si le mot de passe et la confirmation ne sont pas identique 
					else if (!mdp.equals(cmdp)) {
						 mdppasidentique=true;
					    }
					//mot de passe trop court
					 else if (mdp.length() < 8) {
						 mdplength=true;
					    }
					// caract�re sp�cial
					 else if (!specailCharPatten.matcher(mdp).find()) {
						 mdpweak=true;
					    }
					// majiscule
					 else if (!UpperCasePatten.matcher(mdp).find()) {
						 mdpweak=true;
					    }
					//miniscule
					  else if (!lowerCasePatten.matcher(mdp).find()) {
						  mdpweak=true;
					    }
					//chiffre
					  else if (!digitCasePatten.matcher(mdp).find()) {
						  mdpweak=true;
					    }
					  else {
						   
						    Hash hs = new Hash();
							String hpass = hs.hashPwd(mdp);
						    User u=new User(nom,email,hpass);
							userdao.save(u);
							System.out.println("INSCRIPTION OK");
							messageinscriptionok=true;
					    }
				
			}
			//si le bouton connexion est cliqué 
			if(request.getParameter("bconnexion")!=null ) {
				
				String email=request.getParameter("cemail");
				String password=request.getParameter("cpassword");
				Hash hs = new Hash();
				String hpass = hs.hashPwd(password);
				UserDAO utilisateurdao=new UserDAO();
				User u=utilisateurdao.connexion(email, hpass);
				if(u==null) {
					System.out.println("CONNEXION NO");
					messageconnexionno=true;
				}
				else {
					System.out.println("CONNEXION OK");
					
			        session.setAttribute( "userid", u.getId_user() );
			        session.setAttribute( "usernom", u.getNom() );
			        session.setAttribute( "usermail", u.getEmail() );
			        session.setAttribute( "isConnected", true );
					connected=true;
					response.sendRedirect("Index");  
				}
			}

			request.setAttribute("mdplength",mdplength);
			request.setAttribute("userexiste",userexiste);
			request.setAttribute("emailinvalide",emailinvalide);
			request.setAttribute("mdpweak",mdpweak);
			request.setAttribute("inputvide",inputvide);
			request.setAttribute("mdppasidentique",mdppasidentique);
			request.setAttribute("messageinscriptionok", messageinscriptionok);
			request.setAttribute("messageconnexionno", messageconnexionno);
			
		if(connected==false ) {
		request.getRequestDispatcher( "connexion.jsp" ).forward( request, response );
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
