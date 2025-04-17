package in.counceller.dto;

import lombok.Data;

@Data
public class DashBoardDto {
private Integer totalEnquiries;
private Integer openEnquiries;
private Integer closedEnquiries;
private Integer lostEnquiries;
}
