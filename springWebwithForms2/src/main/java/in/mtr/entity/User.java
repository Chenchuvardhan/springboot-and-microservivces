package in.mtr.entity;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="Users_Data")
public class User {
	@Id
	@SequenceGenerator(name="gen1",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")
	private Integer id;
	@NonNull
	@Column(length=30,name="Name")
	@NotEmpty(message = "name is mandatory")
	private String name;
	@NonNull
	@Column(length=30,name="email",unique=true)
	@NotEmpty(message = "email is mandatory")
	private String email;
	@NonNull
	@Column(length=50,name="address")
	@NotEmpty(message = "addesss is madatory")
	private String address;
	@NonNull
	@Column(length=30,name="Ph-no")
	@jakarta.validation.constraints.NotNull(message="mobile number is mandatory")
	private Long mobileNumber;
	@CreationTimestamp()
	@Column(insertable=true,updatable=false,length=30,name="Created Time")
	private LocalDate createdAt;
	@UpdateTimestamp()
	@Column(insertable =false,updatable =true,length=30,name="Updated Time")
	private LocalDate updatedAt;
}
