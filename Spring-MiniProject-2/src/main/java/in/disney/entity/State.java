package in.disney.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="state_tbl")
@Entity
public class State {
	@Id
	private Integer sid;
	private String stateName;
	@ManyToOne
	@JoinColumn(name="cid")
	private Country country;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="state")
	private List<City> cityList;
}
