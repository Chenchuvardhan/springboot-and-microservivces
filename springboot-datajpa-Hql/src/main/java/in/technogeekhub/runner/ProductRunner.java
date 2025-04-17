package in.technogeekhub.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.technogeekhub.logfiles.ProductLogger;
import in.technogeekhub.service.IProductServiceMngm;
@Component
public class ProductRunner implements CommandLineRunner
{
	@Autowired
	private IProductServiceMngm productService;
	@Autowired
	private ProductLogger prodLogger;

	@Override
	public void run(String... args) throws Exception
	{
		prodLogger.productLogging();
		/*try {
			
			String reg = productService.registerdProduct();
			
			System.out.println("\033[1;32m"+reg+"\033[1;0m");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

	}

}
