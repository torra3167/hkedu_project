package email;

import org.apache.ibatis.session.SqlSession;

import command.EmailCommand;

public class EmailService {

	SqlSession sqlSession;
	public int sendEmail(EmailCommand emailCommand) {
		EmailRepository emailRepository=sqlSession.getMapper(EmailRepository.class);
		EmailCommand resultCommand=emailRepository.updatePW(emailCommand);
		return 0;
	}

}
