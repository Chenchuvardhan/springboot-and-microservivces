package in.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "phoneNumbers")
@Entity
public class PhoneNumber {
	@Id
	@SequenceGenerator(name = "gen1",allocationSize =1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen1")
	private Integer PhoneNumberId;
	@NonNull
	private String contactName;
	@NonNull
	private String mobileNumber;
	@ManyToOne()
	@JoinColumn(name="personId")
	private MobilePhoneUser mobilePhoneUser;
	@Override
	public String toString() {
		return "PhoneNumber [PhoneNumberId=" + PhoneNumberId + ", contactName=" + contactName + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
}
