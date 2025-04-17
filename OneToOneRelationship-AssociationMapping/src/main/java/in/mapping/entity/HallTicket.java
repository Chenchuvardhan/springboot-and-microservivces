package in.mapping.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "HallTicket_Details")
@NoArgsConstructor
@RequiredArgsConstructor
public class HallTicket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hallTicketNumber;
	@NonNull
    private String studentName;
	@NonNull
    private LocalDate dataOfBirth;
	@NonNull
	private Integer centreCode;
}
