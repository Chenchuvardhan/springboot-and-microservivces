package in.disney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
@Id
@SequenceGenerator(name="usergen",initialValue=1,allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="usergen")
private Integer userId;
private String name;
private String email;
private String password;
private String passwordStatus;
@ManyToOne
@JoinColumn(name="cid")
private Country country;
@ManyToOne
@JoinColumn(name="sid")
private State state;
@ManyToOne
@JoinColumn(name="city_id")
private City city;
}
