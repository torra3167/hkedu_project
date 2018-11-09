package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import model.Member;
import model.MemberSurvey;

@Repository
public class MemberRepository extends AbstractRepository {
	
	private final String namespace="repository.mapper.memberMapper";
	
	public Integer insertMember(Member member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".insertMember";
		try {
			System.out.println("repository "+member.getMemberEmail());
			Integer result=sqlSession.insert(statement,member);
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
	}

	public Integer countSurvey() {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".countSurvey";
		System.out.println("Repository countSurvey1");
		MemberSurvey i=null;
		try {
			i =  (MemberSurvey)sqlSession.selectOne(statement);
			System.out.println("countSurvey : " + i);
			return i.getSurvNo();
		} finally {
			sqlSession.close();
		}
	}

	public Integer insertSurvey1(MemberSurvey memberSurvey) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".insertSurvey1";
		try {
			System.out.println("repository "+memberSurvey.getSurvNo());
			Integer result=sqlSession.insert(statement, memberSurvey);
			return result;
		} finally {
			sqlSession.close();
		}
	}

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
