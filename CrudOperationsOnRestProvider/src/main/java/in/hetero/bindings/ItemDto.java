package in.hetero.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ItemDto {
	private Integer id;
	private String name;
	private Double price;
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
