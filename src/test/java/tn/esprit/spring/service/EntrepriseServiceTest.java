package tn.esprit.spring.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceTest {
	
	@Autowired
	IEntrepriseService es ;
	
	@Test
	public void testRetrieveAllEntreprise() {
		List<Entreprise> listEntreprise = es.retrieveAllEntreprise();
		// if there are 7 users in DB : 
	//	Assert.assertEquals(6, listEntreprise.size());
	}
		
	@Test
	public void testAddEntreprise() throws ParseException {
		
		Entreprise e = new Entreprise("bourguiga", "don");
		Entreprise entrepriseAdded = es.addEntreprise(e) ;
		Assert.assertEquals(e.getName(), entrepriseAdded.getName());
	}



	@Test
	public void testModifyEntreprise() throws ParseException   {
		Entreprise u = new Entreprise("bourguiga1","don1"); 
		Entreprise entrepriseUpdated  = es.updateEntreprise(u); 
		Assert.assertEquals(u.getName(), entrepriseUpdated.getName());
	}

	


	
	@Test
	public void testDeleteEntreprise() {
		es.remove("2");
		Assert.assertNull(es.retrieveEntreprise("2"));
	}
	
		@Test
	public void testRetrieveEntreprise() {
		Entreprise entrepriseRetrieved = es.retrieveEntreprise("20"); 
		// Assert.assertEquals(entrepriseRetrieved.getId());
	}
	
}
