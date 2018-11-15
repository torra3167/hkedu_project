//package email;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.stereotype.Repository;
//
//import model.Member;
//import repository.AbstractRepository;
//
//@Repository
//public class EmailRepository extends AbstractRepository {
//
//	private final String namespace = "repository.mapper.emailMapper";
//
//	public int updatePW(Member member) throws Exception {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		String statement = namespace + ".updatePw";
//		try {
//			System.out.println("repository "+member.getMemberEmail());
//			Integer result = sqlSession.update(statement, member);
//			if (result > 0) {
//				sqlSession.commit();
//			}
//			return result;
//		} finally {
//			sqlSession.close();
//		}
//	}
//	
//	public void sendEmail(Member member) throws Exception{
//		String fromName="환곰탈태";
//		
//	}
//}
