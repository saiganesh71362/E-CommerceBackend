package com.travtronics.ecomerce.dto;

import java.util.List;

import com.travtronics.ecomerce.entity.OrderStatus;

public class OrderDTO {
	private Long orderId;
	private double totalAmount;
	private OrderStatus status;
	private List<OrderItemDTO> items;

	public OrderDTO() {
	}

	public OrderDTO(Long orderId, double totalAmount, OrderStatus status, List<OrderItemDTO> items) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.items = items;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

}
