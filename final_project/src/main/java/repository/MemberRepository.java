package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.javafx.css.CssError.InlineStyleParsingError;

import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import model.Member;
import model.MemberSurvey;

@Repository
public class MemberRepository extends AbstractRepository {

	private final String namespace = "repository.mapper.memberMapper";

	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertMember";
		try {
			System.out.println("repository " + memberJoinCommand.getMemberEmail());
			Integer result = sqlSession.insert(statement, memberJoinCommand);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Member memberSelect(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".memberSelect";
		System.out.println("Repository " + member.getMemberEmail());
		try {
			return sqlSession.selectOne(statement, member);
		} finally {
			sqlSession.close();
		}
	}

	public Integer survey1Write(MemberSurvey survey) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".survey1Write";
		try {
			System.out.println("repository " + survey.getSurvNo());
			Integer result = sqlSession.insert(statement, survey);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
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

	public Integer selectSurveyNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Integer) sqlSession.selectOne(namespace + "selectSurveyNo");
		} finally {
			sqlSession.close();
		}
	}

	public String selectByNameAndPhone(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			String email = sqlSession.selectOne(namespace + ".selectByNameAndPhone", member);
			return email;
		} finally {
			sqlSession.close();
		}
	}

	public Member selectByEmail(String email) {
		System.out.println("Repository selectByEmail "+email);
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Member)sqlSession.selectOne(namespace + ".selectByEmail", email);
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateMember(Member member) {
		System.out.println("repository memberUpdate "+member.getMemberEmail());
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			Integer result=sqlSession.update(namespace+".updateMember", member);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
