package com.travtronics.ecomerce.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "carti_id", nullable = false)
	private List<CartItem> cartItems = new ArrayList<>();

	private Double toatlPrice;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Double getToatlPrice() {
		return toatlPrice;
	}
	public void setToatlPrice(Double toatlPrice) {
		this.toatlPrice = toatlPrice;
	}

	
}
