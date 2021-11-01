package tn.esprit.spring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Timesheet implements Serializable{

	private static final long serialVersionUID = 3876346912862238239L;

	//idMission est a la fois primary key et foreign key
		@ManyToOne
	    @JoinColumn(name = "idMission", referencedColumnName = "id", insertable=false, updatable=false)
		private Mission mission;
		
		//idEmploye est a la fois primary key et foreign key
		
		@ManyToOne
	    @JoinColumn(name = "idEmploye", referencedColumnName = "id", insertable=false, updatable=false)
		private Employe employe;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean isValide;
	private String name;
	



	public Timesheet(long id, boolean isValide, String name) {
		super();
		this.id = id;
		this.isValide = isValide;
		this.name = name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Timesheet() {
		super();
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




	
	
}
