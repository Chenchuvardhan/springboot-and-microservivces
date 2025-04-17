package in.counceller.service;

import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.counceller.dto.CouncellorDto;
import in.counceller.entity.Councellor;
import in.counceller.repository.CouncellorRepository;

@Service
public class CouncellorMgmtServiceImpl implements ICouncellorMgmtService {
	@Autowired
	private CouncellorRepository councellorRepo;

	@Override
	public CouncellorDto login(CouncellorDto councellorDto)throws Exception {
		// Copy data from Councellordto object to Councellor EntityObject
		Councellor cnlr=new Councellor();
		BeanUtils.copyProperties(cnlr,councellorDto);
		Optional<Councellor> byEmailAndPassword = councellorRepo.findByEmailAndPassword(cnlr.getEmail(),cnlr.getPassword());
		if(byEmailAndPassword.isPresent()) {
			Councellor councellor = byEmailAndPassword.get();
			CouncellorDto councellorDto2=new CouncellorDto();
			BeanUtils.copyProperties(councellorDto2,councellor);
			System.out.println(councellor.getCid());
			return councellorDto2;
		}
		return null;
	}

	@Override
	public boolean uniqueEmailCheck(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(CouncellorDto councellorDto)throws Exception{
		Councellor cnlr=new Councellor();
		BeanUtils.copyProperties(cnlr, councellorDto);
		Councellor save = councellorRepo.save(cnlr);
		if(save.getEmail().equals(cnlr.getEmail())) {
			return true;
		}
		return false;
	}

}
