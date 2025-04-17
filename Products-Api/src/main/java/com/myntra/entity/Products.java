package com.myntra.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
public class Products {
   @Id
   @SequenceGenerator(name="prodgen",initialValue = 1,allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prodgen")
   private Integer productId;
   private String productName;
   private String description;
   private String title;
   private String imageUrl;
   private BigDecimal unitPrice;
   private Boolean active;
   private Integer unitsStock;
   @CreationTimestamp
   @Column(insertable = true,updatable = false)
   private LocalDate createdDate;
   @UpdateTimestamp
   @Column(insertable=false,updatable = true)
   private LocalDate updatedDate;
   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
}
