package hibernate;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



//@Entity(name="alien_table2") sets the entity name used in JPQL/HQL queries (not the table name).
//@Table(name="alien_table2") sets the actual table name in the database.
//You can use a different entity name and table name, but usually they are the same for clarity.
@Entity(name="alien_table")//--> changing the table name
//@Table(name="alien_table2")
public class Alien {

	
	@Id
//	@Column(name = "alien_id")
	private int aid;
	private String aName;
	//@Transient 
	//excludes certain field
	private String tech;
	@OneToMany(mappedBy = "alien")
	// If you only specify it here, and not in the other entity, Hibernate will create a join table to manage the relationship.
	// you need to specify the relationship type
			// One Alien can have many Laptops.
			// 'mappedBy = "alien"' means the 'alien' field in the Laptop entity owns the relationship.
	
	private List<Laptop> laptops;
	
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	public int getAid() {
		return aid;
	}
	public String getTech() {
		return tech;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setAName(String aname) {
		this.aName = aname;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aName=" + aName + ", tech=" + tech + ", laptop=" + laptops + "]";
	}
	
	
}
