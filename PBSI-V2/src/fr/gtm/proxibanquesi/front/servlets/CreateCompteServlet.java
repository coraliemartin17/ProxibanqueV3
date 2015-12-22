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
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.CompteService;
import fr.gtm.proxibanquesi.service.IClientService;
import fr.gtm.proxibanquesi.service.ICompteService;

/**
 * Servlet implementation class CreateCompteServlet
 */
@WebServlet("/CreateCompte")
public class CreateCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CreateCompte(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CreateCompte(request, response);
	}

	protected void CreateCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO E1: récuperer information
		HttpSession maSession = request.getSession();
		Client client = (Client) maSession.getAttribute("client");
		String type = request.getParameter("typeCompte");
		String somme = request.getParameter("somme");
		Double montant = Double.parseDouble(somme);
		RequestDispatcher dispatcher;
		// TODO E2: avoir les infos dans la bdd
		ICompteService serv = new CompteService();
		int res = 0;
		if(type.equals("CompteCourant")){
			CompteCourant compte = new CompteCourant();
			compte.setSolde(montant);
			compte.setIdcli(client.getId());
			res = serv.creerCompte(compte);
		}
		else {
			CompteEpargne compte = new CompteEpargne();
			compte.setSolde(montant);
			compte.setIdcli(client.getId());
			res = serv.creerCompte(compte);
		}
		if(res != 0){
			dispatcher = request.getRequestDispatcher("GCompte.jsp");
			request.setAttribute("message", new String("Compte créé avec succès"));
		} else {
			dispatcher = request.getRequestDispatcher("GCompte.jsp");
			request.setAttribute("message", new String("Un problème est survenu"));
		}

		dispatcher.forward(request, response);
	}
}
