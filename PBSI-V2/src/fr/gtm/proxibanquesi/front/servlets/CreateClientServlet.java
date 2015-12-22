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
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.ConseillerService;
import fr.gtm.proxibanquesi.service.IClientService;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Servlet implementation class CreateClientServlet
 */
@WebServlet("/CreateClient")
public class CreateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IClientService serv = new ClientService();
		HttpSession usersession = request.getSession();
		Conseiller user = (Conseiller) usersession.getAttribute("user");
		// Creation du client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String codepostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		int cons = user.getIdcons();
		Client client = new Client(nom, prenom, adresse, codepostal, ville, telephone, cons);

		
		RequestDispatcher dispatcher;
		try {
			client = serv.createClient(client);
			IConseillerService servcons = new ConseillerService();
			user = servcons.getListeClients(user);
			ArrayList<Client> listeClients = servcons.getClients(user);
			usersession.setAttribute("clients", listeClients);
			request.setAttribute("message", new String("Client créé avec succès."));
			dispatcher = request.getRequestDispatcher("user-page.jsp");
		} catch (LigneExistanteException e) {
			dispatcher = request.getRequestDispatcher("GClientNew.jsp");
			request.setAttribute("message", new String("Ce client existe déja."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("GClientNew.jsp");
			request.setAttribute("message", new String("Un problème est survenu."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		}
		
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
