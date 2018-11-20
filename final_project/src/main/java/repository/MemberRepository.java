package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Member;
import model.MemberSurvey;

@Repository
public class MemberRepository extends AbstractRepository {

	private final String namespace = "repository.mapper.memberMapper";

	public Integer insertMember(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertMember";
		try {
			System.out.println("MEMBERREPOSITORY InsertMember " + member.getMemberEmail());
			Integer result = sqlSession.insert(statement, member);
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
		System.out.println("MEMBERREPOSITORY MemberSelect " + member.getMemberEmail());
		try {
			return sqlSession.selectOne(statement, member);
		} finally {
			sqlSession.close();
		}
	}

	public String selectByNameAndPhone(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".selectByNameAndPhone";
		System.out.println("MEMBERREPOSITORY SelectByNameAndPhone " + member.getMemberEmail());
		try {
			String email = sqlSession.selectOne(statement, member);
			return email;
		} finally {
			sqlSession.close();
		}
	}

	public Member selectByEmail(String email) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".selectByEmail";
		System.out.println("MEMBERREPOSITORY SelectByEmail " + email);
		try {
			return (Member) sqlSession.selectOne(statement, email);
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateMember(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".updateMember";
		System.out.println("MEMBERREPOSITORY UpdateMember " + member.getMemberEmail());
		try {
			Integer result = sqlSession.update(statement, member);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer deleteMember(Member member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".deleteMember";
		System.out.println("MEMBERREPOSITORY DeleteMember " + member.getMemberEmail());
		try {
			Integer result = sqlSession.delete(statement, member);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer insertSurvey1(MemberSurvey memberSurvey) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertSurvey1";
		System.out.println("MEMBERREPOSITORY Survey1Write " + memberSurvey.getMemberEmail());
		try {
			Integer result = sqlSession.insert(statement, memberSurvey);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer selectSurveyNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".selectSurveyNo";
		try {
			return (Integer) sqlSession.selectOne(statement);
		} finally {
			sqlSession.close();
		}
	}
	public MemberSurvey selectSurvByEmail(String email) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".selectSurvByEmail";
		System.out.println("MEMBERREPOSITORY SelectSurvByEmail "+email);
		try {
			return (MemberSurvey) sqlSession.selectOne(statement, email);
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateSurvey2(MemberSurvey memberSurvey) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".updateSurvey2";
		System.out.println("MEMBERREPOSITORY Survey1Write " + memberSurvey.getMemberEmail());
		try {
			Integer result=sqlSession.update(statement, memberSurvey);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
