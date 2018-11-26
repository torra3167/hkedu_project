package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;

@Repository
public class AdminRepository extends AbstractRepository {
	private final String namespace="repository.mapper.adminMapper";

	public List<Coach> coachList() {
		List<Coach> coachList=new ArrayList<Coach>();
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		System.out.println("AdminRepository CoachList");
		try {
			String statement=namespace+".coachList";
			coachList=sqlSession.selectList(statement);
			System.out.println(coachList.size());
			return coachList;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteCoach(String email) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".deleteCoach";
		System.out.println("AdminRepository deleteMemberList " + email);
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

	public Coach selectByEmail(String email) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".selectByEmail";
		System.out.println("AdminRepository SelectByEmail " + email);
		try {
			return (Coach) sqlSession.selectOne(statement, email);
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateCoach(Coach coach) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".updateCoach";
		System.out.println("AdminRepository UpdateCoach " + coach.getCoachEmail());
		System.out.println("AdminRepository UpdateCoach " + coach.getCoachName());
		System.out.println("AdminRepository UpdateCoach " + coach.getCoachPw());
		System.out.println("AdminRepository UpdateCoach " + coach.getCoachCareer());
		try {
			Integer result = sqlSession.update(statement, coach);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
