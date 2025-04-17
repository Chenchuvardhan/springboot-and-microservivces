package in.counceller.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.counceller.dto.CouncellorDto;
import in.counceller.dto.DashBoardDto;
import in.counceller.entity.Councellor;
import in.counceller.service.ICouncellorMgmtService;
import in.counceller.service.IEnquiryService;

@Controller
public class CouncellerController {
	@Autowired
	private ICouncellorMgmtService councellorService;
	@Autowired
	private IEnquiryService enquiryService;

	@GetMapping("/")
	public String login(Model model) {
		CouncellorDto councellorDto = new CouncellorDto();
		model.addAttribute("councellordto", councellorDto);
		return "loginfile";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		CouncellorDto councellorDto = new CouncellorDto();
		model.addAttribute("councellordto", councellorDto);
		return "registerfile";
	}

	@PostMapping("/checkuser")
	public String checkingUser(CouncellorDto councellorDto,Model model)throws Exception {
		// return "dashboardfile";
		CouncellorDto councellorDto2 = councellorService.login(councellorDto);
		System.out.println("CouncellorDto2 :"+councellorDto2);
		if(councellorDto2!=null) {
			Councellor cnlr=new Councellor();
			BeanUtils.copyProperties(cnlr, councellorDto2);
			EnquiryController.councellor=cnlr;
			System.out.println(EnquiryController.councellor.getCid());
			DashBoardDto dashBoard = enquiryService.getDashBoard(councellorDto2.getCid());
			System.out.println("dashboardofSoniya"+dashBoard);
			model.addAttribute("total", dashBoard.getTotalEnquiries());
			model.addAttribute("open", dashBoard.getOpenEnquiries());
			model.addAttribute("close", dashBoard.getClosedEnquiries());
			model.addAttribute("lost", dashBoard.getLostEnquiries());
			return "dashboardfile";
		}
		model.addAttribute("msg","Check email or Password");
        CouncellorDto councellorDto3=new CouncellorDto();
        model.addAttribute("councellordto", councellorDto3);
		return "loginfile";
	}

	@PostMapping("/save")
	public String saveUser(CouncellorDto cnlrDto,Model model)throws Exception{
		System.out.println(cnlrDto);
		boolean register = councellorService.register(cnlrDto);
		if(register) {
		CouncellorDto councellorDto2 = councellorService.login(cnlrDto);
		System.out.println(councellorDto2);
		if(councellorDto2!=null) {
			Councellor cnlr=new Councellor();
			BeanUtils.copyProperties(cnlr, councellorDto2);
			EnquiryController.councellor=cnlr;
			DashBoardDto dashBoard = enquiryService.getDashBoard(councellorDto2.getCid());
			System.out.println(dashBoard);
			model.addAttribute("total", dashBoard.getTotalEnquiries());
			model.addAttribute("open", dashBoard.getTotalEnquiries());
			model.addAttribute("close", dashBoard.getTotalEnquiries());
			model.addAttribute("lost", dashBoard.getTotalEnquiries());
			return "dashboardfile";
		}
		}
		CouncellorDto councellorDto = new CouncellorDto();
		model.addAttribute("councellordto", councellorDto);
		model.addAttribute("msg","please provide valid details");
		return "registerfile";
	}
}