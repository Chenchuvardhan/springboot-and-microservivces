package in.makemytrip.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.SneakyThrows;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketsList {
public List<Ticket> tickets;
}
