package in.general.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.general.entity.Hosteller;
import in.general.service.HostellerService;
@Component
public class HostellerRunner implements CommandLineRunner {
	@Autowired
    private HostellerService hostelService;
	@Override
	public void run(String... args) throws Exception {
	Month month=LocalDateTime.now().getMonth();
	int maxLength = month.maxLength();
	LocalDate endingDate=LocalDate.now().plusDays(maxLength);
    Hosteller hs=new Hosteller("875788287153","Chenchuvardhan", 
    		                   "Nellore",24, 103, 4, 8000, endingDate);
    System.out.println(hostelService.saveHosteller(hs));
    
	}

}
