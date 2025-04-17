package in.counceller.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.counceller.dto.DashBoardDto;
import in.counceller.dto.EnquiryDto;
import in.counceller.dto.EnquiryFilterDto;
import in.counceller.entity.Councellor;
import in.counceller.entity.Enquiry;
import in.counceller.repository.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements IEnquiryService {
	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public DashBoardDto getDashBoard(int councellorId) {
		// TODO Auto-generated method stub
		List<Enquiry> list = enquiryRepository.findAllByCid(councellorId);
		System.out.println(list);
		DashBoardDto boardDto = new DashBoardDto();
		if (list.size()==0) {
			boardDto.setOpenEnquiries(0);
			boardDto.setClosedEnquiries(0);
			boardDto.setLostEnquiries(0);
			boardDto.setTotalEnquiries(0);
			return boardDto;
		}
		Integer total = (int)list.stream().count();
		Integer open=(int)list.stream().filter(s->s.getStatus().equalsIgnoreCase("open")).count();
		Integer close=(int)list.stream().filter(s->s.getStatus().equalsIgnoreCase("close")).count();
		Integer lost=(int)list.stream().filter(s->s.getStatus().equalsIgnoreCase("lost")).count();
		boardDto.setTotalEnquiries(total);
		boardDto.setOpenEnquiries(open);
		boardDto.setClosedEnquiries(close);
		boardDto.setLostEnquiries(lost);
		return boardDto;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry) {
		enquiryRepository.save(enquiry);
		return true;
	}

	@Override
	public List<Enquiry> getEnquiries(int CouncelllorId) {
		// TODO Auto-generated method stub
		List<Enquiry> allByCid = enquiryRepository.findAllByCid(CouncelllorId);
		return allByCid;
	}

	@Override
	public List<Enquiry> getEnquiries(int CouncellorId, EnquiryFilterDto filter)throws Exception {
		// TODO Auto-generated method stub
		Enquiry enquiry=new Enquiry();
		Councellor cnlr=new Councellor();
		cnlr.setCid(CouncellorId);
		if(filter.getClassmode().isEmpty())
			filter.setClassmode(null);
		if(filter.getCourse().isEmpty())
			filter.setCourse(null);
		if(filter.getStatus().isEmpty())
			filter.setStatus(null);
		BeanUtils.copyProperties(enquiry,filter);
		System.out.println("Enquiry :"+enquiry.getCourse());
		enquiry.setCouncellor(cnlr);
		Example<Enquiry> of = Example.of(enquiry);
		List<Enquiry> all = enquiryRepository.findAll(of);
		return all;
	}

	@Override
	public EnquiryDto getEnquiry(int enquiryId) throws Exception{
		// TODO Auto-generated method stub
		Optional<Enquiry> byId = enquiryRepository.findById(enquiryId);
		Enquiry enquiry = byId.get();
		EnquiryDto enquiryDto=new EnquiryDto();
		BeanUtils.copyProperties(enquiryDto,enquiry);
		return enquiryDto;
	}

}
