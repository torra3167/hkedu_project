package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.ExerciseCatA;
import category.ExerciseCatB;

import model.Exercise;


@Repository
public class ExerciseRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.exerciseMapper";
	
	

	public int insertExercise(Exercise exercise) {
/*		System.out.println("Exercise REPOSITORY ");
*/		sqlSession = getSqlSessionFactory().openSession();
		try {
			 int result = sqlSession.insert(namespace + ".insertExercise", exercise);
			/*	System.out.println("Exercise REPOSITORY" + result);*/

			 if(result > 0) {
				 sqlSession.commit();
			 } else {
				 sqlSession.rollback();
			 }
			 
			 return result;
		} finally {
			sqlSession.close();
		}
		
	}



	public List<ExerciseCatB> exerciseCatBSelect() {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return sqlSession.selectList(namespace + ".exerciseCatBSelect");
		
		} finally {
			sqlSession.close();
		}
	}



	public List<ExerciseCatA> exerciseCatASelect(ExerciseCatB bca) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return sqlSession.selectList(namespace + ".exerciseCatASelect", bca);
		
		} finally {
			sqlSession.close();
		}
	}



	public Integer selectExerciseNumber() {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectExerciseNumber");
		
		} finally {
			sqlSession.close();
		}
	}



	public List<Exercise> exerciseList() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		List<Exercise> list =  sqlSession.selectList(namespace + ".exerciseList");
		return list;
		} finally {
			sqlSession.close();
		}
	}
	
	

}
