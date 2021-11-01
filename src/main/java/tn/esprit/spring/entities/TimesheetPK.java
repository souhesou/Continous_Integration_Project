package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimesheetPK implements Serializable {

	private static final long serialVersionUID = 5377539445871317492L;

	private long idMission;
	
	private long idEmploye;
	
	private Employe em; 
	private Mission m ;
	//Choisir le TemporalType selon le besoin metier
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	

	public TimesheetPK() {
		super();
	}
	
	public TimesheetPK(long idMission, long idEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idMission = idMission;
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	
	
	
	
	public TimesheetPK(Employe em, Mission m, Date dateDebut, Date dateFin) {
		super();
		this.em = em;
		this.m = m;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	//Pour que hibernate peut comparer deux objets (par exemple : recherche de l'objet dans le persistenceContext), 
	//Il doit pouvoir comparer les primary key des deux entites
	//Vu que l'entite a une clé composé, on doit implementer la methode equal.
	//Utiliser l'IDE pour générer le equal et le hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());

		return result;
	}

	public Employe getEm() {
		return em;
	}

	public void setEm(Employe em) {
		this.em = em;
	}

	public Mission getM() {
		return m;
	}

	public void setM(Mission m) {
		this.m = m;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimesheetPK other = (TimesheetPK) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idEmploye != other.idEmploye)
			return false;
		if (idMission != other.idMission)
			return false;
		return true;
	}

	public void setIdMission(long idMission) {
		this.idMission = idMission;
	}

	public long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public long getIdMission() {
		return idMission;
	}

}
