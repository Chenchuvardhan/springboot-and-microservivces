package in.makemytrip.service;

import java.util.List;

import in.makemytrip.dto.Ticket;
import lombok.SneakyThrows;

public interface ITicketService {
public abstract List<Ticket> getTickets() throws Exception;
public abstract Ticket saveTicket(Ticket ticket)throws Exception;
}
