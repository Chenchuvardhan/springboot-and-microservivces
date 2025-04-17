package in.gmail.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Country {
	@Id
	@SequenceGenerator(allocationSize=1,name="gen1",initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen1")
	private Integer cid;
	private String countryName;
	@OneToMany(mappedBy="country",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private List<States> slist;
}
