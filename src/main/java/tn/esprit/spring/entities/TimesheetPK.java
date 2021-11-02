package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimesheetPK implements Serializable {

	private static final long serialVersionUID = 5377539445871317492L;

	private int idMission;
	
	private int idEmploye;
	
	//NOSONARChoisir le TemporalType selon le besoin metier
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	

	public TimesheetPK() {
		super();
	}
	
	public TimesheetPK(int idMission, int idEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idMission = idMission;
		this.idEmploye = idEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	//NOSONARPour que hibernate peut comparer deux objets (par exemple : recherche de l'objet dans le persistenceContext), 
	//NOSONARIl doit pouvoir comparer les primary key des deux entites
	//NOSONARVu que l'entite a une clé composé, on doit implementer la methode equal.
	//NOSONARUtiliser l'IDE pour générer le equal et le hashcode
	//NOSONAR@Override
	//NOSONARpublic int hashCode() {
	//NOSONAR	final int prime = 31;
	//NOSONAR	int result = 1;
	//NOSONARresult = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
	//NOSONARresult = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
	//NOSONAR	result = prime * result + idEmploye;
	//NOSONARresult = prime * result + idMission;
	//NOSONARreturn result;
	//NOSONAR}

	//NOSONAR@Override
	//NOSONARpublic boolean equals(Object obj) {
	//NOSONAR	if (this == obj)
	//NOSONAR		return true;
	//NOSONAR	if ( (obj == null) )
	//NOSONARreturn false;
			//NOSONAR	if (getClass() != obj.getClass())
	//NOSONAR	return false;
	//NOSONAR	TimesheetPK other = (TimesheetPK) obj;
	//NOSONAR	if (dateDebut == null) {
	//NOSONAR		if (other.dateDebut != null)
	//NOSONAR	return false;
				//NOSONAR	} else if (!dateDebut.equals(other.dateDebut))
				//NOSONAR		return false;
			//NOSONAR	if (dateFin == null) {
			//NOSONAR	if (other.dateFin != null)
				//NOSONAR		return false;
			//NOSONAR	} else if (!dateFin.equals(other.dateFin))
			//NOSONAR		return false;
		//NOSONAR	if (idEmploye != other.idEmploye)
		//NOSONAR		return false;
		//NOSONAR	if (idMission != other.idMission)
			//NOSONAR		return false;
		//NOSONAR	return true;
		//NOSONAR}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
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

	public int getIdMission() {
		return idMission;
	}

}
