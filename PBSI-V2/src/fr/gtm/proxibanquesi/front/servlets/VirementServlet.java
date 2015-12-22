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
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.CompteService;
import fr.gtm.proxibanquesi.service.IClientService;
import fr.gtm.proxibanquesi.service.ICompteService;

/**
 * Servlet implementation class virementServlet
 */
@WebServlet("/Virement")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		virement(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		virement(request,response);
	}
	
	protected void virement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO E1: récup (idCompteDébité,idCompteCrédité,somme)  les données de l'IHM
		String DebId = request.getParameter("CompteDebiter");
		String CredId = request.getParameter("CompteCrediter");
		int deb = Integer.parseInt(DebId);
		int cred = Integer.parseInt(CredId);
		String somme = request.getParameter("somme");
		double montant = Double.parseDouble(somme);
		
		RequestDispatcher dispatcher;
		// TODO E2: Creer les comptes
		ICompteService serv = new CompteService();
		Compte cdeb1;
		Compte ccred1;
		try {
			if(serv.typeCompte(deb)=="Courant") {
				CompteCourant cdeb = new CompteCourant();
				cdeb.setNumCompte(deb);
				cdeb = serv.consulterCompte(cdeb);
				if(serv.typeCompte(cred)=="Courant") {
					CompteCourant ccred = new CompteCourant();
					ccred.setNumCompte(cred);
					ccred = serv.consulterCompte(ccred);
					serv.virement(cdeb, ccred, montant);
				}
				else {
					CompteEpargne ccred = new CompteEpargne();
					ccred.setNumCompte(cred);
					ccred = serv.consulterCompte(ccred);
					serv.virement(cdeb, ccred, montant);
				}
			}
			else {
				CompteEpargne cdeb = new CompteEpargne();
				cdeb.setNumCompte(deb);
				cdeb = serv.consulterCompte(cdeb);
				if(serv.typeCompte(cred)=="Courant") {
					CompteCourant ccred = new CompteCourant();
					ccred.setNumCompte(cred);
					ccred = serv.consulterCompte(ccred);
					serv.virement(cdeb, ccred, montant);
				}
				else {
					CompteEpargne ccred = new CompteEpargne();
					ccred.setNumCompte(cred);
					ccred = serv.consulterCompte(ccred);
					serv.virement(cdeb, ccred, montant);
				}
				
			}
			request.setAttribute("message", new String("Virement effectué."));
			dispatcher = request.getRequestDispatcher("virement.jsp");	
			
		} catch (SoldeInsuffisantException e1) {
			dispatcher = request.getRequestDispatcher("virement.jsp");
			request.setAttribute("message", new String("Solde créditeur insuffisant."));
		} catch (LigneInexistanteException e) {
			dispatcher = request.getRequestDispatcher("virement.jsp");
			request.setAttribute("message", new String("Un problème est survenu."));
			System.out.println(e.getMessage());
			System.out.println(request.getAttribute("message"));
		}

		dispatcher.forward(request, response);
	}

}
