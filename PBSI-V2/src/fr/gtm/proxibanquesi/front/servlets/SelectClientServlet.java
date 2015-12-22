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
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.CompteService;
import fr.gtm.proxibanquesi.service.ConseillerService;
import fr.gtm.proxibanquesi.service.IClientService;
import fr.gtm.proxibanquesi.service.ICompteService;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Servlet implementation class ModifClientServlet
 */
@WebServlet("/SelectClient")
public class SelectClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		remplirForm(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		remplirForm(request,response);
	}

	protected void remplirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Definir redirection
		String redirect = request.getParameter("redirect");
		// TODO E1 : recup le Idclient 
		String Id = request.getParameter("id");
		int monVraiId = Integer.parseInt(Id);
		// TODO E2 :comparer
		RequestDispatcher dispatcher;
		Client userTemp = new Client();
		userTemp.setId(monVraiId);
		IClientService serv = new ClientService();
//		ICompteService servco = new CompteService();
		Client cli;
		try {
			cli = serv.consulterClient(userTemp);
			cli = serv.getListeComptesCourant(cli);
			cli = serv.getListeComptesEpargne(cli);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("client", cli);
			ArrayList<Compte> listeComptes = new ArrayList<Compte>();
			listeComptes.addAll(serv.getComptesCourant(cli));
			listeComptes.addAll(serv.getComptesEpargne(cli));
			
			maSession.setAttribute("comptes", listeComptes);
			if(redirect.equals("client")) {
				dispatcher = request.getRequestDispatcher("GClientModif.jsp");
			} else 	dispatcher = request.getRequestDispatcher("GCompte.jsp");
			
			
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("GClientModif.jsp");
			request.setAttribute("message", new String("Un problème est survenu."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		}
		// TODO E3 : afficher les données du client dans le formulaire
		dispatcher.forward(request, response);
	}
	
}
