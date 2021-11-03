package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {

	
	
	public Entreprise addEntreprise(Entreprise entreprise);
	public List<Entreprise> retrieveAllEntreprise();
	public void remove(String id);
	public Entreprise updateEntreprise(Entreprise entreprise);
	public Entreprise retrieveEntreprise(String id);
	
}
