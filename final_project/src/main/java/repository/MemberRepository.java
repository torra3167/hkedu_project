package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.MemberJoinCommand;
import command.MemberSurveyCommand;

@Repository
public class MemberRepository extends AbstractRepository {
	
	private final String namespace="mapper.memberMapper";
	
	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".instertMember";
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

	public Integer survey1Write(MemberSurveyCommand memberSurveyCommand) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".survey1Write";
		try {
			System.out.println("repository "+memberSurveyCommand.getSurvNo());
			Integer result=sqlSession.insert(statement,memberSurveyCommand);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
