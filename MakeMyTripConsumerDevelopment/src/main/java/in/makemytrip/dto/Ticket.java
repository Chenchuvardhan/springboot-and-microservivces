package in.makemytrip.dto;

import lombok.Data;

@Data
public class Ticket {
private Integer ticketId;
private String name;
private String email;
private String gender;
private String trainNum;
private String dob;
private String doj;
private String source;
private String destination;
private String ticketStatus;
}
