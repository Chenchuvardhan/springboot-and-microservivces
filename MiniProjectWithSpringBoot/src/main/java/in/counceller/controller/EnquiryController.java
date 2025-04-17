package in.counceller.controller;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.counceller.dto.EnquiryDto;
import in.counceller.dto.EnquiryFilterDto;
import in.counceller.entity.Councellor;
import in.counceller.entity.Enquiry;
import in.counceller.service.ICouncellorMgmtService;
import in.counceller.service.IEnquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
public class EnquiryController {
	@Autowired
	private ICouncellorMgmtService councellorMgmtService;
	@Autowired
	private IEnquiryService enquiryService;
	public static Councellor councellor;
	private HttpSession httpSession;
	@GetMapping("/addenquiry")
	public String addEnquiry(Model model) {
		EnquiryDto enquiryDto=new EnquiryDto();
		model.addAttribute("enquirydto", enquiryDto);
		return "enquiryfile";
	}
	@GetMapping("/logout")
	public String logOut(Model model) {
	    //httpSession.invalidate();
		councellor=null;
		Councellor cnlr=new Councellor();
	    model.addAttribute("councellordto", cnlr);
	    return "loginfile";
	}
	@PostMapping("/saveenquiry")
	public String saveEnquiry(EnquiryDto enquiryDto,Model model)throws Exception {
		Enquiry enquiry=new Enquiry();
		System.out.println(enquiryDto);
		System.out.println("enquiryDTo :"+enquiryDto);
		BeanUtils.copyProperties(enquiry,enquiryDto);
		System.out.println(councellor);
		enquiry.setCouncellor(this.councellor);
		enquiryService.addEnquiry(enquiry);
		EnquiryDto enquiryDto1=new EnquiryDto();
		model.addAttribute("enquirydto", enquiryDto1);
		return "enquiryfile";
	}
	@GetMapping("/viewenquiries")
	public String viewEnquiries(Model model) {
		EnquiryFilterDto filter=new EnquiryFilterDto();
		model.addAttribute("enquiryfilterdto", filter);
		List<Enquiry> enquiries = enquiryService.getEnquiries(councellor.getCid());
		model.addAttribute("enquiries",enquiries);
		return "viewenquiries";
	}
	@PostMapping("/filter")
	public String filterWithEnquiryDto(EnquiryFilterDto filter,Model model) throws Exception {
		System.out.println(filter);
		List<Enquiry> enquiries = enquiryService.getEnquiries(councellor.getCid(), filter);
		System.out.println(enquiries);
		EnquiryFilterDto fiter=new EnquiryFilterDto();
		model.addAttribute("enquiryfilterdto", fiter);
		model.addAttribute("enquiries",enquiries);
		return "viewenquiries";
	}
	@GetMapping("/editenquiry/{id}")
	public String editEnquiry(@PathVariable("id") Integer id,Model model)throws Exception {
		EnquiryDto enquiry = enquiryService.getEnquiry(id);
		System.out.println(enquiry);
		model.addAttribute("enquirydto", enquiry);
		return "enquiryfile";
	}
}
