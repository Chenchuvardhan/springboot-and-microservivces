package in.nirma.mappings;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeDto {
	private Integer id;
	private String name;
	private Integer age;
	private Double salary;
	private LocalDate joinedAt;
}
