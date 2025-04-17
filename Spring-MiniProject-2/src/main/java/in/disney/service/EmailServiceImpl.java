package in.disney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
@Service
public class EmailServiceImpl implements IEmailService {
	@Autowired
	private JavaMailSender sender;

	@Override
	@SneakyThrows
	public boolean sendPasswordThroughEmail(String to, String Subject, String body) {
		// TODO Auto-generated method stub
		try {
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(Subject);
			helper.setText("<h1 style='color:green;text-align:center'> Your Password is " + body + "</h1>", true);
			sender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
