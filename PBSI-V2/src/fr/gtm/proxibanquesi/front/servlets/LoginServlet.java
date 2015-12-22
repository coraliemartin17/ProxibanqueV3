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
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ConseillerService;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifLogin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verifLogin(request, response);
	}
	
	protected void verifLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		
		RequestDispatcher dispatcher;
		
		Conseiller userTemp = new Conseiller();
		userTemp.setLogin(login);
		userTemp.setMdp(mdp);
		IConseillerService serv = new ConseillerService();
		Conseiller user;
		try {
			user = serv.checkUser(userTemp);
			user = serv.getListeClients(user);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("user", user);
			ArrayList<Client> listeClients = serv.getClients(user);
			maSession.setAttribute("clients", listeClients);
			dispatcher = request.getRequestDispatcher("user-page.jsp");
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("invalid-log.html");
		}

		
		dispatcher.forward(request, response);
		
	}

}
