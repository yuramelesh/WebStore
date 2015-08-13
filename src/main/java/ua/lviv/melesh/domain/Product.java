package ua.lviv.melesh.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
		@NamedQuery(name = "Product.findById", query = "select p from Product p where p.id=:id"),
		@NamedQuery(name = "Product.findByName", query = "select p from Product p where p.name=:name"),
		@NamedQuery(name = "Product.findByCategory", query = "select p from Product p where p.category=:category") })
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private String category;
	@Column
	private Integer price;
	@Column
	private String photo;
	@Column
	private String description;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "user")
	private List<UserOrder> userOrder;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "product")
	private List<Photos> photos;

	public Product() {
		super();
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category="
				+ category + ", price=" + price + ", photo=" + photo
				+ ", description=" + description + ", userOrder=" + userOrder
				+ ", photos=" + photos + "]";
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(getClass() == obj.getClass()))
			return false;
		else {
			Product p = (Product) obj;
			if (p.id == this.id)
				return true;
			else
				return false;
		}
	}
}
