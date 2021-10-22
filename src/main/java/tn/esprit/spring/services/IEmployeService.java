package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;

public interface IEmployeService {
	

	public Employe addEmploye(Employe employe);
	public List<Employe> retrieveAllEmploye();
	public void remove(String idEmploye);
	public Employe updateEmploye(Employe employe);
	public Employe retrieveEmploye(String id);
	
}
