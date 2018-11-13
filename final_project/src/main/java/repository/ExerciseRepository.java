package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.ExerciseCatA;
import category.ExerciseCatB;

import model.Exercise;
import model.Upload;


@Repository
public class ExerciseRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.exerciseMapper";
	
	

	public int insertExercise(Exercise exercise) {
		sqlSession = getSqlSessionFactory().openSession();
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



	public List<Upload> exerciseList() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		List<Upload> list =  sqlSession.selectList(namespace + ".uploadList");
		return list;
		} finally {
			sqlSession.close();
		}
	}



	public int insertUpload(List<Upload> lists) {
		int result = 0;
			sqlSession = getSqlSessionFactory().openSession();
				try {
					 
					 for(Upload upload : lists) {
						 sqlSession.insert(namespace + ".insertUpload", upload);
						 result++;
					 }
					 
					 if(result > 0) {
						 sqlSession.commit();
					 } else {
						 sqlSession.rollback();
					 }
				} finally {
					sqlSession.close();
				}
				return result;
	}



	
	
	

}
