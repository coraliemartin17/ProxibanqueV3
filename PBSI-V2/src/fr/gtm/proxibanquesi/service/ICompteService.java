package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du COmpte
 * Elle liste les m�thodes de CRUD d'un compte.
 * @author Alexandre et Coralie
 *
 */
public interface ICompteService {
	
	/**
	 * M�thode pour cr�er un compte courant
	 * @param compte : compte courant
	 * @return
	 */
	public int creerCompte(CompteCourant compte);
	
	/**
	 * M�thode pour cr�er un compte �pargne
	 * @param compte : compte �pargne
	 * @return
	 */
	public int creerCompte(CompteEpargne compte);
	
	/**
	 * M�thode pour lire les informations d'un compte courant.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteCourant consulterCompte(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * M�thode pour lire les informations d'un compte �pargne.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public CompteEpargne consulterCompte(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier le solde d'un compte courant.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int modifierCompte(CompteCourant compte) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier le solde d'un compte �pargne.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int modifierCompte(CompteEpargne compte) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un compte.
	 * @param compte : un compte
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerCompte(Compte compte) throws LigneInexistanteException;
	
	/**
	 * M�thode de virement d'un compte courant vers un compte courant.
	 * @param compteDebiteur : compte courant
	 * @param compteCrediteur : compte courant
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteCourant compteDebiteur, CompteCourant compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * M�thode de virement d'un compte �pargne vers un compte �pargne.
	 * @param compteDebiteur : compte �pargne
	 * @param compteCrediteur : compte �pargne
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteEpargne compteDebiteur, CompteEpargne compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * M�thode de virement d'un compte courant vers un compte �pargne.
	 * @param compteDebiteur : compte courant
	 * @param compteCrediteur : compte �pargne
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteCourant compteDebiteur, CompteEpargne compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * M�thode de virement d'un compte �pargne vers un compte courant.
	 * @param compteDebiteur : compte �pargne
	 * @param compteCrediteur : compte courant
	 * @param montant
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(CompteEpargne compteDebiteur, CompteCourant compteCrediteur, Double montant) throws SoldeInsuffisantException, LigneInexistanteException;
	
	/**
	 * M�thode pour d�terminer le type d'un compte soit Courant, soit Epargne.
	 * @param id
	 * @return
	 * @throws LigneInexistanteException
	 */
	public String typeCompte(int id) throws LigneInexistanteException;
	
}
