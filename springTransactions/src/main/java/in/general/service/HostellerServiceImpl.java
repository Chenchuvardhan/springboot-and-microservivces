package in.general.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.general.entity.Hosteller;
import in.general.repository.HostellerRepository;
@Service
public class HostellerServiceImpl implements HostellerService {
	@Autowired
	private HostellerRepository hostelRepo;

	@Override
	public Hosteller saveHosteller(Hosteller hs) {

		return hostelRepo.save(hs);
	}

}
