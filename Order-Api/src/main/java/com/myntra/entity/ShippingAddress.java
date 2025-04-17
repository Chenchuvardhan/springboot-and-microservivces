package com.myntra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class ShippingAddress {
	@Id
	@SequenceGenerator(name="addrgen",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "addrgen")
	private Integer addrId;
	private String houseNum;
    private String street;
	private String city;
	private String state;
	private String zipcode;
    private String country;
}
