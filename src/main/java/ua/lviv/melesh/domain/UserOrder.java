package ua.lviv.melesh.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "UserOrder.findById", query = "select p from UserOrder p where p.id=:id") })
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String descr;

	@Column
	private Integer summ;

	@Column
	private Date date;

	@Column
	private boolean status = false;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "products")
	private List<Product> products;

	public UserOrder() {
		super();
	}

	public UserOrder(String descr, Integer summ, Date date, boolean status,
			User user, List<Product> products) {
		super();
		this.descr = descr;
		this.summ = summ;
		this.date = date;
		this.status = status;
		this.user = user;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getSumm() {
		return summ;
	}

	public void setSumm(Integer summ) {
		this.summ = summ;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", descr=" + descr + ", summ=" + summ
				+ ", date=" + date + ", status=" + status + ", user=" + user
				+ "]";
	}

}