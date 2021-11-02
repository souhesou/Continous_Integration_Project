package tn.esprit.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import org.junit.Assert;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IDepartementService;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceTest {
	
	@Autowired
	IDepartementService ds ;
	
	@Test
	public void testRetrieveAllEmploye() {
		List<Departement> listDepartements = ds.retrieveAllDepartements();
		Assert.assertEquals(1, listDepartements.size());
	}
	
	@Test
	public void testAddDepartement() throws ParseException {
		
		
		Departement d = new Departement("new", null );
		Departement departementadded = ds.addDepartement(d) ;
		Assert.assertEquals(d.getName(), departementadded.getName());
	}
	@Test
	public void testModifyDepartement() throws ParseException   {
		
		Departement d = new Departement(10,"change",null);
		Departement departementModified = ds.updateDepartement(d) ;
		Assert.assertEquals(d.getName(), departementModified.getName());
	}
	
	@Test
	public void testRetrieveDepartement() {
		Departement d = ds.retrieveDepartement("10");
		Assert.assertEquals(10, d.getId());
		}
	
	
	@Test
	public void testDeleteDepartement() {
		ds.remove("9");
		Assert.assertNull(ds.retrieveDepartement("9"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
