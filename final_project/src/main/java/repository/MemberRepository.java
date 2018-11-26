package repository;

import java.util.ArrayList;
import java.util.List;

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
		try {
			String email = sqlSession.selectOne(statement, member);
			System.out.println("MEMBERREPOSITORY SelectByNameAndPhone "+email);
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

	public Integer insertSurvey1(MemberSurvey survey) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertSurvey1";
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getMemberEmail());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvNo());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvHeight());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvWeight());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvEat());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvBMI());
		System.out.println("MEMBERREPOSITORY Survey1Write " + survey.getSurvAge());
		try {
			Integer result = sqlSession.update(statement, survey);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
/*
	public Integer selectSurveyNo(MemberSurveyCommand memberSurveyCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".selectSurveyNo";
		Integer surveyNo=(Integer) sqlSession.selectOne(statement);
		System.out.println(surveyNo);
		try {
			return surveyNo;
		} finally {
			sqlSession.close();
		}
	}*/
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
		System.out.println("MEMBERREPOSITORY Survey2Write " + memberSurvey.getMemberEmail());
		try {
			Integer result=sqlSession.update(statement, memberSurvey);
			System.out.println("repository "+result);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	public List<Member> memberList(){
		List<Member> memberList=new ArrayList<Member>();
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".memberList";
		System.out.println("MEMBERREPOSITORY MemberList");
		try {
			memberList=sqlSession.selectList(statement);
			return memberList;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteMemberList(String email) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".deleteFromMemberList";
		System.out.println("MEMBERREPOSITORY deleteMemberList " + email);
		try {
			Integer result = sqlSession.delete(statement, email);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int checkEmail(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".idChk";
		System.out.println("MEMBERREPOSITORY checkEmail " + id);
		try {
			Integer result = sqlSession.selectOne(statement, id);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
