package fr.gtm.proxibanquesi.front.servlets;

import java.io.IOException;

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
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.IClientService;

/**
 * Servlet implementation class ModifClientServlet
 */
@WebServlet("/ModifClient")
public class ModifClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Modif(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Modif(request,response);
	}
	
	protected void Modif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IClientService serv = new ClientService();
		HttpSession usersession = request.getSession();
		Client cli = (Client) usersession.getAttribute("client");
		// Creation du client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String codepostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		Client client = new Client(nom, prenom, adresse, codepostal, ville, telephone, cli.getCons());
		client.setId(cli.getId());
		
		RequestDispatcher dispatcher;
		try {
			serv.modifierClient(client);
			request.setAttribute("message", new String("Les infos du client sont bien modifiées."));
			dispatcher = request.getRequestDispatcher("user-page.jsp");
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("GClientModif.jsp");
			request.setAttribute("message", new String("Un problème est survenu."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		} finally {
			usersession.removeAttribute("client");
		}
		
		dispatcher.forward(request, response);
	}

}
