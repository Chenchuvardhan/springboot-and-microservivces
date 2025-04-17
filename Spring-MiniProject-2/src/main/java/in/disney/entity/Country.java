package in.disney.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name="country_tbl")
@Entity
public class Country {
	@Id
	private Integer cid;
    private String countryName;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="country")
    private List<State> stateList;
}
