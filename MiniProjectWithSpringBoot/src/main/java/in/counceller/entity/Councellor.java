package in.counceller.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Councellor {
	@Id
	@SequenceGenerator(name="councellorgenerartor",initialValue=100,allocationSize=2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="councellorgenerartor")
	private Integer cid;
	@Column(length=30)
	private String name;
	@Column(length=40,unique=true)
	private String email;
	@Column(length=30)
	private String password;
	@Column(length=40,unique=true)
	private Long phno;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="councellor")
	private List<Enquiry> list;
}
