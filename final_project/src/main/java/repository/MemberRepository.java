package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import model.Member;

@Repository
public class MemberRepository extends AbstractRepository {
	
	private final String namespace="repository.mapper.memberMapper";
	
	/*public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".insertMember";
		try {
			System.out.println("repository "+memberJoinCommand.getMemberEmail());
			Integer result=sqlSession.insert(statement,memberJoinCommand);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Member memberSelect(Member member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".memberSelect";
		System.out.println("Repository "+member.getMemberEmail());
		try {
			return sqlSession.selectOne(statement, member);
		} finally {
			sqlSession.close();
		}
	}*/

//	public Integer survey1Write(MemberSurveyCommand memberSurveyCommand) {
//		SqlSession sqlSession=getSqlSessionFactory().openSession();
//		String statement=namespace+".survey1Write";
//		try {
//			System.out.println("repository "+memberSurveyCommand.getSurvNo());
//			Integer result=sqlSession.insert(statement,memberSurveyCommand);
//			return result;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	public Integer survey2Write(MemberSurveyCommand memberSurveyCommand) {
//		SqlSession sqlSession=getSqlSessionFactory().openSession();
//		String statement=namespace+".survey2Write";
//		try {
//			System.out.println("repository "+memberSurveyCommand.getSurvNo());
//			Integer result=sqlSession.insert(statement, memberSurveyCommand);
//			if(result>0) {
//				sqlSession.commit();
//			}
//			return result;
//		} finally {
//			sqlSession.close();
//		}
//	}

}
