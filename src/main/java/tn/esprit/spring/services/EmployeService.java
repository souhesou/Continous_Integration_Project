package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService implements IEmployeService {
	
	private static final Logger l = LogManager.getLogger(EmployeService.class);
	
	@Autowired
	EmployeRepository ie;
	
	@Override
	public Employe addEmploye(Employe employe)
	{
		return ie.save(employe); 
		
	}
	@Override
	public List<Employe> retrieveAllEmploye(){
		List<Employe> employees = null; 
		try {
	
			l.info("In retrieveAllEmploye() : ");
			employees = (List<Employe>) ie.findAll();  
			for (Employe employe : employees) {
				l.debug("employe +++ : " + employe);
			} 
			l.info("Out of retrieveAllEmployes() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmployes() : " + e);
		}

		return employees;
		
	}
	
	
	@Override
	public void remove(String idEmploye)
	{
		ie.deleteById(Long.parseLong(idEmploye));
	}
	
	@Override
	public Employe updateEmploye(Employe employe)
	{
		return ie.save(employe);

	}
	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveEmploye id = " + id);
		Employe e =  ie.findById(Long.parseLong(id)).get(); 
		l.info("employe returned : " + e);
		return e; 
	

	}
	
	

}
