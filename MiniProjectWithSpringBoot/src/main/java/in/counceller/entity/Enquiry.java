package in.counceller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Enquiry {
	@Id
	@SequenceGenerator(name="dbdgen",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="dbdgen")
	private Integer eid;
	private String name;
	private Long phno;
	private String Course;
	private String classmode;
	private String status;
	@ManyToOne
	@JoinColumn(name="cid")
	private Councellor councellor;
}
