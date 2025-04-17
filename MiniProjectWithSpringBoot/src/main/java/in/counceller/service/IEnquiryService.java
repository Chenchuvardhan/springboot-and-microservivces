package in.counceller.service;

import java.util.List;

import in.counceller.dto.DashBoardDto;
import in.counceller.dto.EnquiryDto;
import in.counceller.dto.EnquiryFilterDto;
import in.counceller.entity.Enquiry;

public interface IEnquiryService {
 public DashBoardDto getDashBoard(int councellorId);
 public boolean addEnquiry(Enquiry enquiry);
 public List<Enquiry> getEnquiries(int CouncelllorId);
 public List<Enquiry> getEnquiries(int CouncellorId,EnquiryFilterDto filter)throws Exception;
 public EnquiryDto getEnquiry(int enquiryId) throws Exception;
}
