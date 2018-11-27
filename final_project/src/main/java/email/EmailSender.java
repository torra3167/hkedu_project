//package email;
//
//import javax.mail.Message.RecipientType;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import command.EmailCommand;
//
//import org.springframework.mail.javamail.JavaMailSender;
//
//@Component
//public class EmailSender {
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	public void sendEmail(EmailCommand emailCommand) throws Exception{
//		MimeMessage msg = mailSender.createMimeMessage();
//		String subject="";
//		String contents="";
//		subject="<환곰탈태> 회원님의 임시 비밀번호를 발급해드립니다.";
//		contents="비밀번호";
//		try {
//			System.out.println("emailSender "+emailCommand.getMemberEmail());
//			msg.setSubject(subject); //메일 제목
//			msg.setText(contents, "text/html; charset=utf-8");
//			msg.setFrom(new InternetAddress(emailCommand.getMemberName()));
//			msg.setRecipient(RecipientType.TO, new InternetAddress(emailCommand.getMemberEmail()));
//			mailSender.send(msg);
//		} catch (Exception e) {
//			System.out.println("Messaging Exception");
//			e.printStackTrace();
//		}
//		try {
//			mailSender.send(msg);
//		} catch (Exception e) {
//			System.out.println("MailException 발생");
//			e.printStackTrace();
//		}
//		
//	}
//}