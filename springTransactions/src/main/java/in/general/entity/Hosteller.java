package in.general.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Hosteller {
	@Id
	@SequenceGenerator(name="gen1",initialValue=10000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")
	private Integer id;
	@NonNull
	private String aadharId;
	@NonNull
	private String name;
	@Column
	@NonNull
	private String adress;
	@Column
	@NonNull
	private Integer age;
	@Column
	@NonNull
	private Integer roomnumber;
	@Column
	@NonNull
	private Integer roomSharing;
	@Column
	@NonNull
	private Integer roomCost;
	@CreationTimestamp
	@Column(insertable=true,updatable=false)
	private LocalDateTime joiningDate;
	@NonNull
	@Column(insertable = true,updatable=false)
	private LocalDate endingDate;
	
	

}
