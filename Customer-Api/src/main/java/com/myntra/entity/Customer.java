package com.myntra.entity;

import java.time.LocalDate;
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
public class Customer {
	@Id
	@SequenceGenerator(name="catgen",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custgen")
	private Integer customerId;
	private String customerName;
	private Integer email;
	private String phno;
	private String pwd;
	private String pwdUpdated;
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDate updatedDate;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customer")
	private List<Orders> orders;
}
