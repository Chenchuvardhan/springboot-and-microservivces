package in.gmail.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class States {
	@Id
	@SequenceGenerator(allocationSize=100,name="gen2",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen2")
	private Integer sid;
	private String StateName;
	@ManyToOne()
	@JoinColumn(name="cid")
	private Country country;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="state")
	private List<City> clist;
}
