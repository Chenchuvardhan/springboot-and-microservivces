package in.welcome.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Id
	@SequenceGenerator(name = "automatic",initialValue = 100,allocationSize = 2)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "automatic")
	private Integer id;
	@Nonnull
	private String name;
	@Nonnull
	private String country;
	@Nonnull
	private Integer age;
	@Nonnull
	private String gender;
	@CreationTimestamp
	@Column(updatable = false,insertable = true)
	private String insertedAt;
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private String updatedAt;
	@Version
	private Integer modificationCount;
	
	
}
