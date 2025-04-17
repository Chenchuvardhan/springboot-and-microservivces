package in.gmail.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.internet.MimeMessage;

@Controller
public class MailSendingController {
	@Autowired
	private JavaMailSender sender;
	@GetMapping("/mail")
	@ResponseBody
	public String sendingEmail()throws Exception {
		//Sending a Text message through mail sender 
		/*SimpleMailMessage textMsg=new SimpleMailMessage();
		textMsg.setTo("sharukhgurram@gmail.com");
		textMsg.setSubject("Greeting from Chenchuvardhan through SpringBoot application");
		textMsg.setText("Hai.. How are you? send me dia photo");
		sender.send(textMsg);
		*/
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		helper.setTo("sharukhgurram@gmail.com");
		helper.setSubject("Greeting from Chenchuvardhan through SpringBoot application");
		helper.setText("<h1 style='color:green;text-align:center'>Tell me Vidudhala 2 Review?</h1>",true);
		helper.addAttachment("Image",new File("C:\\UI\\welcome.jpeg"));
		sender.send(mimeMessage);
	
		return "Gmail Sent Successfully";
	}
}
