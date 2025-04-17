package in.springprofiles;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
	@Id
	@SequenceGenerator(name = "gen1",initialValue = 1,allocationSize =100)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")
	private Integer studentId;
	@NonNull
	@Column(length = 30)
	private String studentName;
	@NonNull
	@Column(length = 10)
	private Integer studentAge;
	@NonNull
	@Column(length=12)
	private String mobileNumber;
	

}
