package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceTest {
	
	@Autowired
	IEmployeService es ;
	
	@Test
	public void testRetrieveAllEmploye() {
		List<Employe> listEmployes = es.retrieveAllEmploye();
		Assert.assertEquals(7, listEmployes.size());
	}

	@Test
	public void testAddEmploye() throws ParseException {
		
		Employe e = new Employe("Souuuhee", "Saada", "souha.saada@esprit.tn", "123", Role.ADMINISTRATEUR);
		Employe employeadded = es.addEmploye(e) ;
		Assert.assertEquals(e.getNom(), employeadded.getNom());
	}
	
	@Test
	public void testModifyEmploye() throws ParseException   {
		
		Employe e = new Employe(17L,"Sousouuuu", "Saada", "souhei123.saada@esprit.tn", "123", Role.ADMINISTRATEUR);
		Employe employeModified = es.updateEmploye(e) ;
		Assert.assertEquals(e.getNom(), employeModified.getNom());
	}
	
	
	@Test
	public void testDeleteEmploye() {
		es.remove("17");
		Assert.assertNull(es.retrieveEmploye("17"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void testRetrieveEmploye() {
		Employe empR = es.retrieveEmploye("1");
		//Assert.assertEquals(1L, empR.getId().longValue());
		}
	*/
	
	
}
