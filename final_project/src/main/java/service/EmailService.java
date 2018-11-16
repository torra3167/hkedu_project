//package service;
//
//import java.util.Random;
//
//import org.apache.ibatis.session.SqlSession;
//
//import command.EmailCommand;
//import model.Email;
//import model.Member;
//import repository.EmailRepository;
//
//public class EmailService {
//
//	SqlSession sqlSession;
//	EmailRepository emailRepository;
//	Member member;
//	Email email;
//	public Integer sendEmail(EmailCommand emailCommand) throws Exception {
//		System.out.println("EmailService SendEmail start");
//		email.setForName(emailCommand.getMemberName());
//		email.setReceiver(emailCommand.getMemberEmail());
//		member.setMemberEmail(emailRepository.selectByEmailAndName(email).toString());
//		member.setMemberPass(getRandomPassword(8));
//		System.out.println("emailService " + member.getMemberPass());
//		return emailRepository.updatePW(member);
//	}
//	
//	public static String getRandomPassword(int length) {
//		StringBuffer temp=new StringBuffer();
//		Random rnd=new Random();
//		for(int i=0; i<length; i++) {
//			int rIndex=rnd.nextInt(3);
//			switch(rIndex) {
//			case 0:
//				temp.append((char)((int)(rnd.nextInt(26))+97));
//				break;
//			case 1:
//				temp.append((char)((int)(rnd.nextInt(26))+65));
//				break;
//			case 2:
//				temp.append((rnd.nextInt(10)));
//				break;
//			}
//		}
//		System.out.println(temp.toString());
//		return temp.toString();
//	}
//
//}
