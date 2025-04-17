package in.hetero.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
	@Id
	@SequenceGenerator(allocationSize=1,initialValue =1,name = "itemgen" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="itemgen")
	private Integer id;
	private String name;
	private Double price;
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDate createdAt;
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDate updatedAt;
}
