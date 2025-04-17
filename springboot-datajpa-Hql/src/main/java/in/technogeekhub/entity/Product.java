package in.technogeekhub.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
@Id
@SequenceGenerator(name="seq1",sequenceName ="productId",initialValue = 1000,allocationSize = 2)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")
private Integer productId;
@NonNull
private String productName;
@NonNull
private Double price;
@CreationTimestamp()
@Column(insertable = true, updatable = false)
private LocalDateTime insertedAt;
@UpdateTimestamp
@Column(insertable = false,updatable = true)
private LocalDateTime updatedAt;
@Version
private Integer ModificationCount;
}
