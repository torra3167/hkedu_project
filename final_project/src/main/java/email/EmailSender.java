package email;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import command.EmailCommand;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(EmailCommand emailCommand) throws Exception{
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			System.out.println("emailSender "+emailCommand.getReceiver());
			msg.setSubject(emailCommand.getSubject()); //메일 제목
			msg.setText(emailCommand.getContent());
			msg.setFrom(new InternetAddress(emailCommand.getFromName()));
			msg.setRecipient(RecipientType.TO, new InternetAddress(emailCommand.getReceiver()));
			msg.setText("text","UTF-8", "html");
			mailSender.send(msg);
		} catch (Exception e) {
			System.out.println("Messaging Exception");
			e.printStackTrace();
		}
		try {
			mailSender.send(msg);
		} catch (Exception e) {
			System.out.println("MailException 발생");
			e.printStackTrace();
		}
		
	}
}