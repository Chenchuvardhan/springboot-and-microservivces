package in.disney.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="city_tbl")
@Entity
public class City {
	@Id
	private Integer cityId;
	private String cityName;
	@ManyToOne
	@JoinColumn(name="sid")
	private State state;
}
