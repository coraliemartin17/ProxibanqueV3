package fr.gtm.proxibanquesi.junit;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.proxibanquesi.service.ClientService;

public class ClientDAOTest {

	static ClientService cli;
	
	@BeforeClass
	public static void appelClient() {
		cli = new ClientService();
	}
	
	@Test
	public void create() {
		//n1 : appel
		
		//n2 : 
	}
	
}
