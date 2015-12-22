package fr.gtm.proxibanquesi.test;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.CompteDao;
import fr.gtm.proxibanquesi.dao.ConseillerDao;
import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.dao.IConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.CompteService;
import fr.gtm.proxibanquesi.service.ConseillerService;
import fr.gtm.proxibanquesi.service.IClientService;
import fr.gtm.proxibanquesi.service.ICompteService;
import fr.gtm.proxibanquesi.service.IConseillerService;

public class Main {

	public static void main(String[] args) {
		

		
		// DAO CREATE conseiller OK
//		IConseillerDao dao = new ConseillerDao();
//		Conseiller c1 = new Conseiller("De Bruyn", "Alexandre");
//		c1.setIduser(1);
//		c1.setIdagence(1);
//		try {
//			dao.insert(c1);
//		} catch (LigneExistanteException e) {
//			System.out.println(e.getMessage());
//		}
		
		// DAO READ conseiller

//		Conseiller c3 = new Conseiller();
//		c3.setIdcons(1);
//		System.out.println(c3);
//		try {
//			dao.read(c3);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			System.out.println(c3);
//		}
		
		// DAO getID conseiller OK
//		Conseiller c4 = new Conseiller();
//		c4.setNom("De Bruyn");
//		c4.setPrenom("Alex");
//		System.out.println(c4);
//		try {
//			c4 = dao.getID(c4);
//			dao.read(c4);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(c4);
//		// USER
//		User u4 = new User(c4, "alexdeb", "pass");
//		System.out.println(u4);
		
		
		// DAO UPDATE conseiller OK
//		Conseiller c2 = new Conseiller("De Bruyn", "Alex");
//		c2.setIdcons(1);
//		c2.setIduser(1);
//		c2.setIdagence(1);
//		IConseillerDao dao = new ConseillerDao();
//		try {
//			System.out.println(dao.update(c2));
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		

		// DAO CREATE client OK
//		Conseiller c5 = new Conseiller();
//		c5.setLogin("alexdeb");
//		c5.setMdp("pass");
//		IConseillerService serv = new ConseillerService();
//		try {
//			c5 = serv.checkUser(c5);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(c5);
//		IClientDao dao = new ClientDao();
		
//		Client cli1 = new Client("Halliday", "Johnny", "22 rue de Paris", "78470", "Saint-Remy-les-chevreuse", "0130524939", c5.getIdcons());
//		System.out.println(cli1);
//		
//		int res = 0;
//		try {
//			res = dao.create(cli1);
//		} catch (LigneExistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
		
		// DAO READ Client OK
//		Client cli2 = new Client();
//		cli2.setId(1);
//		System.out.println(cli2);
//		try {
//			cli2 = dao.read(cli2);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(cli2);
		
		// DAO getId Client OK
//		Client cli3 = new Client();
//		cli3.setNom("Halliday");
//		cli3.setPrenom("Johnny");
//		cli3.setAdresse("22 rue de Paris");
//		System.out.println(cli3);
//		try {
//			cli3 = dao.getID(cli3);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(cli3);
		
		// DAO update Client OK
//		Client cli4 = new Client();
//		cli4.setId(1);
//		try {
//			cli4 = dao.read(cli4);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());;
//		}
//		System.out.println(cli4);
//		cli4.setNom("Smet");
//		cli4.setPrenom("Jean-Philippe");
//		int res = 0;
//		try {
//			res = dao.update(cli4);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
		
//		IClientService servcli = new ClientService();
		// SERVICE Client create OK
//		Client cli1 = new Client("Ballavoine", "Daniel", "36 quai des Orfevres", "75001", "Paris", "0130527865", c5.getIdcons());
//		System.out.println(cli1);
//		try {
//			cli1 = servcli.createClient(cli1);
//		} catch (LigneExistanteException | LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(cli1);
		
		// DAO Client getListe OK
//		ArrayList<Integer> liste = new ArrayList<Integer>();
//		liste = dao.getListeClients(c5.getIdcons());
//		for(int i = 0; i < liste.size(); i++) {
//			System.out.println(liste.get(i));
//		}
		
		// Service conseiller getlisteclient OK
//		c5 = serv.getListeClients(c5);
//		System.out.println(c5);
//		ArrayList<Client> listeClients = new ArrayList<Client>();
//		try {
//			listeClients = serv.getClients(c5);
//			for(int i = 0; i < listeClients.size(); i++) {
//				System.out.println(listeClients.get(i));
//			}
//		} catch (LigneInexistanteException e) {
//			System.out.println("Une erreur s'est produite.");
//		}
//		
		// DAO compte create
//		Client cli5 = listeClients.get(1);
//		ICompteDao daocompte = new CompteDao();
//		CompteEpargne compte1 = new CompteEpargne();
//		compte1.setIdcli(cli5.getId());
//	    daocompte.createEpargne(compte1);
//	    CompteCourant compte2 = new CompteCourant();
//	    compte2.setIdcli(cli5.getId());
//	    System.out.println(compte2);
//	    int res=0;
//	    res = daocompte.createCourant(compte2);
//	    System.out.println(res);
	    
	    // DAO Compte getliste
//		Client cli = new Client();
//		cli.setId(2);
//		ICompteDao daocompte = new CompteDao();
//		ArrayList<Integer> liste = new ArrayList<Integer>();
//		liste = daocompte.getListeComptesCourant(2);
//		for(int i = 0; i < liste.size(); i++) {
//			System.out.println(liste.get(i));
//		}
		
		// Service client getlistecomptes
//		cli = servcli.getListeComptesEpargne(cli);
//		try {
//			ArrayList<CompteEpargne> listeComptes = servcli.getComptesEpargne(cli);
//			if(listeComptes != null) {
//				for(int i= 0; i < listeComptes.size(); i++) {
//					System.out.println(listeComptes.get(i));
//				}
//			}
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		// DAO update compte OK
//		CompteCourant cc1 = new CompteCourant(5000);
//		cc1.setNumCompte(6);
//		cc1.setAutorisationDecouvert(1000);
//		int res = 0;
//		try {
//			res = daocompte.updateCourant(cc1);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
//		
//		CompteEpargne ce1 = new CompteEpargne(0.5);
//		ce1.setNumCompte(2);
//		ce1.setSolde(1000);
//		try {
//			res = daocompte.updateEpargne(ce1);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
//		
		// DAO COMPTE delete OK
//		ICompteDao daocompte = new CompteDao();
//		CompteEpargne ce = new CompteEpargne();
//		ce.setNumCompte(1);
//		int res = 0;
//		try {
//			res = daocompte.delete(ce);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
		
		// DAO CLIENT DELETE
//		IClientDao dao = new ClientDao();
//		Client cli = new Client();
//		cli.setId(21);
//		int res = 0;
//		try {
//			res = dao.delete(cli);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
		
		// DAO Conseiller DELETE
//		IConseillerDao dao = new ConseillerDao();
//		Conseiller cons = new Conseiller();
//		cons.setIdcons(3);
//		int res = 0;
//		try {
//			res = dao.delete(cons);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(res);
		
//		CompteEpargne ce = new CompteEpargne(0.2);
//		ce.setSolde(2000);
//		ce.setIdcli(1);
//		ICompteDao dao = new CompteDao();
//		dao.createEpargne(ce);
//		System.out.println(ce);
//		CompteCourant cc = new CompteCourant(6000);
//		cc.setAutorisationDecouvert(500);
//		cc.setIdcli(1);
//		ICompteService serv = new CompteService();
//		System.out.println(serv.creerCompte(cc));
		
		// Service compte consulter
//		CompteCourant cc = new CompteCourant();
//		cc.setNumCompte(6);
//		ICompteService serv = new CompteService();
//		try {
//			serv.consulterCompte(cc);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(cc);
		
		// Service compte update
//		CompteCourant cc = new CompteCourant();
//		cc.setNumCompte(6);
//		cc.setSolde(3500);
//		cc.setIdcli(2);
//		cc.setAutorisationDecouvert(100);
//		ICompteService serv = new CompteService();
//		try {
//			serv.modifierCompte(cc);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
		
		// Service compte delete
//		CompteCourant cc = new CompteCourant();
//		cc.setNumCompte(6);
//		ICompteService serv = new CompteService();
//		try {
//			serv.supprimerCompte(cc);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
		
		// Service client consulter
		IClientService serv = new ClientService();
		Client cli = new Client();
//		cli.setId(1);
//		try {
//			cli = serv.consulterClient(cli);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(cli);
//		
//		cli.setNom("Halliday");
//		cli.setPrenom("Johnny");
//		try {
//			serv.modifierClient(cli);
//		} catch (LigneInexistanteException e) {
//			System.out.println(e.getMessage());
//		}
		
		cli.setId(2);
		try {
			serv.supprimerClient(cli);
		} catch (LigneInexistanteException e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	
	
}