package ua.com.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Commodity.findAll", query = "SELECT c FROM Commodity c"),
	@NamedQuery(name = "Commodity.findByCategory", query = "SELECT DISTINCT c FROM Commodity c LEFT JOIN FETCH c.category"),
	@NamedQuery(name = "Commodity.findByMaterial", query = "SELECT DISTINCT c FROM Commodity c LEFT JOIN FETCH c.material"),
	@NamedQuery(name = "Commodity.findByCountry", query = "SELECT DISTINCT c FROM Commodity c LEFT JOIN FETCH c.country"),
	@NamedQuery(name = "Commodity.findByCategoryId", query = "SELECT c FROM Commodity c WHERE c.category.id=:id"),
	@NamedQuery(name = "Commodity.findByCommodityId", query = "SELECT c FROM Commodity c WHERE c.id=:id")

})
@Table(name = "commodity")
public class Commodity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	public Commodity() {
	}
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Material material;
	
	@ManyToOne
	private Country  country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
