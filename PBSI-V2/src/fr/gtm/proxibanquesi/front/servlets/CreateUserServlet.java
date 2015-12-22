package fr.gtm.proxibanquesi.front.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ConseillerService;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IConseillerService serv = new ConseillerService();
		// Creation du conseiller
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		boolean gerant = request.getParameter("gerant") != null;
		
		Conseiller cons = new Conseiller(nom, prenom, login, mdp, gerant);
	
		RequestDispatcher dispatcher;
		
		try {
			cons = serv.createConseiller(cons);
			cons = serv.getListeClients(cons);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("user", cons);
			ArrayList<Client> listeClients = serv.getClients(cons);
			maSession.setAttribute("clients", listeClients);
			dispatcher = request.getRequestDispatcher("user-page.jsp");
		} catch (LigneExistanteException e)
		{
			dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("message", new String("Ce compte existe déja."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
			
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("message", new String("Un problème est survenu."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

}
