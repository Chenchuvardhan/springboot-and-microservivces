package in.nirma.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
public class Employee {
	@Id
	@SequenceGenerator(initialValue=1,allocationSize=1,name="empgen")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="empgen")
	private Integer id;
	@Column(length=45)
	private String name;
	@Column(length=45)
	private Integer age;
	@Column(length=45)
	private Double salary;
	@CreationTimestamp
	@Column(length=45,insertable=true,updatable=false)
	private LocalDate joinedAt;
}
