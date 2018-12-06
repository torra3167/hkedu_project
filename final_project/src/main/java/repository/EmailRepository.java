package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.ChangePWCommand;
import command.FindIDCommand;

@Repository
public class EmailRepository extends AbstractRepository {

	private final String namespace = "repository.mapper.emailMapper";

	public Integer countSellerID(String email) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".countSellerID";
		try {
			System.out.println("EMAILREPOSITORY CountSellerID " + email);
			Integer result = sqlSession.selectOne(statement, email);
			System.out.println("repository email " + email);
			if (result > 0) {
				sqlSession.commit();
			}
			System.out.println("repository result " + result);
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public String selectByEmail(FindIDCommand findIDCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println("selectByEmail REPO" );
		System.out.println(findIDCommand.getEmail());
		System.out.println(findIDCommand.getPhone());

		try {
			String selectEmail = sqlSession.selectOne(namespace + ".selectByEmail", findIDCommand);
			System.out.println("selectByEmail" + selectEmail);
			
			return selectEmail;
			
		} finally {
			sqlSession.close();
		}
	}

	public Integer changePW(ChangePWCommand changePWCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".updatePWSelect";
		String statement2 = namespace + ".updatePWMember";
		String statement3 = namespace + ".updatePWSeller";
		String statementMember = namespace+".updatePWSelectMember";
		String email=changePWCommand.getEmail();
		String nowPW=changePWCommand.getNowPW();
		Integer i=0;
		try {
			if(nowPW==null) {
				String divide = sqlSession.selectOne(statement, email);
				System.out.println("withoutnowPW Divide "+divide);
				if(divide.equals("p")) {
					i=sqlSession.update(statement2, changePWCommand);
					System.out.println(i);
				} else if(divide.equals("s")) {
					i=sqlSession.update(statement3, changePWCommand);
					System.out.println(i);
				}
			}else if(nowPW!=null) {
				String divide=sqlSession.selectOne(statementMember, changePWCommand);
				System.out.println("with Member nowPW Divide "+divide);
				if(divide==null) {
					i=0;
				}else {
					if(divide.equals("p")) {
						i=sqlSession.update(statement2, changePWCommand);
						System.out.println(i);
					} else if(divide.equals("s")) {
						i=sqlSession.update(statement3, changePWCommand);
						System.out.println(i);
					}
				}
			}
			
			if(i>0) {
				sqlSession.commit();
			}
			return i;
		} finally {
			sqlSession.close();
		}
	}
}
