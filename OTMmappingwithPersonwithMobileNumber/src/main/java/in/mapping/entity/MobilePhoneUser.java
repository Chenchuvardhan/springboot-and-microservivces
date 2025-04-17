package in.mapping.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Users_Data")
@Entity
public class MobilePhoneUser {
	@Id
	@SequenceGenerator(name = "gen2", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen2")
	private Integer personId;
	@NonNull
	private String email;
	@NonNull
	private String username;
	@NonNull
	private String mobileNumber;
	@NonNull
	private String gender;
    @OneToMany(mappedBy="mobilePhoneUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<PhoneNumber> phoneNumbersList;
	@Override
	public String toString() {
		return "MobilePhoneUser [personId=" + personId + ", email=" + email + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + ", gender=" + gender + "]";
	}
    
}
