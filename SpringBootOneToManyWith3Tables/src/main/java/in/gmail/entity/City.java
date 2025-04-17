package in.gmail.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City {
	@Id
	@SequenceGenerator(allocationSize=1000,name="gen3",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen3")
	private Integer cid;
	private String cityName;
	@ManyToOne()
	@JoinColumn(name="sid")
	private States state;
}
