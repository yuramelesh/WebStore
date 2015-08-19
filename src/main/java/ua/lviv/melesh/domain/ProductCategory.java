package ua.lviv.melesh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "ProductCategory.findById", query = "select p from ProductCategory p where p.id=:id"),
		@NamedQuery(name = "ProductCategory.findByName", query = "select p from ProductCategory p where p.name=:name") })
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;

	public ProductCategory() {
		super();
	}

	public ProductCategory(String name) {
		super();
		this.name = name;
	}

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

	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + "]";
	}

}