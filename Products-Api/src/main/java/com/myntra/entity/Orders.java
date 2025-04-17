package com.myntra.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
	@Id
	@SequenceGenerator(name = "ordergen", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordergen")
	private Integer orderId; // PK
	private String orderTrackingNum;
	private Integer totalQuantity;
	private Double totalPrice;
	private String orderStatus; // (CREATED, CANCELLED, DELIVERED)
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime lastUpdated;
	private LocalDateTime deliveryDate;
	private String paymentStatus;
	private String razorPayOrderId; // razor_pay_payment_id
	private String invoiceUrl;

	// customer_id
	// FK
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	// addr_id FK
	@ManyToOne
	@JoinColumn(name="addr_id")
	private ShippingAddress shippingAddress;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "order")
    private List<Orders> order;
}
