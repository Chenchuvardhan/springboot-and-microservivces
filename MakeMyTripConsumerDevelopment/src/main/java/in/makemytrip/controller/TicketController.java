package in.makemytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.makemytrip.dto.Ticket;
import in.makemytrip.service.ITicketService;

@Controller
public class TicketController {
	@Autowired
	private ITicketService ticketService;
    @GetMapping("/tickets")
	public String requestToRest(Model model)throws Exception {
        List<Ticket> tickets = ticketService.getTickets();
        model.addAttribute("tickets", tickets);
		return "viewtickets";
	}
    @GetMapping("/dashboard")
    public String LoadDashBoard() {
    	return "dashboard";
    }
    @GetMapping("/GetTicketPage")
    public String getPassengerDetailsPage(Model model) {
    	Ticket ticket = new Ticket();
    	model.addAttribute("ticket", ticket);
    	return "ticketbooking";
    }
    @PostMapping("/bookticket")
    public String bookTicket(Ticket tkt,Model model) throws Exception {
    	Ticket saveTicket = ticketService.saveTicket(tkt);
    	Ticket ticket=new Ticket();
    	model.addAttribute("ticket",ticket);
    	model.addAttribute("status","Ticket Booked with "+saveTicket.getTicketId());
    	return "ticketbooking";
    }
}
