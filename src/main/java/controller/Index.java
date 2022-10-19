package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.Todo;
import model.TodoDAO;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
		boolean load=false;
		boolean vide=false;
		HttpSession session = request.getSession( true );
		int userid=(int)session.getAttribute("userid");
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Connexion"); 
		}else {
			TodoDAO tdao = new TodoDAO();
			ArrayList<Todo> todo = tdao.getAllByIduser(userid);
			ArrayList<Todo> todocheck = tdao.getAllByIduserCheck(userid);
			//si le bouton ajouter une tâche est cliqué 
			if(request.getParameter("addt")!=null) {
				String titre = request.getParameter("titre");
				String desc = request.getParameter("description");
				if (titre.isEmpty() || titre.equals(" ")) {
					vide=true;
				}else {
					
					Todo t = new Todo(userid,titre,desc);
					tdao.save(t);
					load=true;
					response.sendRedirect(request.getHeader("referer"));
				}
			}
			//si l'icone check est cliquée
			if(request.getParameter("check")!=null) {
				//je récupère l'id de la tâche
				int idtodo = Integer.valueOf(request.getParameter("check"));
				tdao.check(idtodo);
				load=true;
				response.sendRedirect(request.getHeader("referer"));
			}
			request.setAttribute("todo", todo);
			request.setAttribute("todocheck", todocheck);
		}
		request.setAttribute("vide", vide);
		if(!load) {
		request.getRequestDispatcher( "index.jsp" ).forward( request, response );
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
