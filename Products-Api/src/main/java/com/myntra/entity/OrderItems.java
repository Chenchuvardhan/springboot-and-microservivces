package com.myntra.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class OrderItems {
	@Id
	@SequenceGenerator(name = "orderitemsgen", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitemsgen")
	private Integer orderItemId; // PK
	private String imageUrl;
	private Double unitPrice;
	private Integer quantity;
    @ManyToOne
    @JoinColumn(name="product_id")
	private Products product;// product_id FK
    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;
	//order_id        FK

}
