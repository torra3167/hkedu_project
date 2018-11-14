package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import category.ExerciseCatA;
import category.ExerciseCatB;
import model.Program;
import model.ProgramExercise;

public class ProgramRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.programMapper";
	
	public Integer selectProgramNumber() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectProgramNumber");
		
		} finally {
			sqlSession.close();
		}
	}

	public Integer insertProgram(Program program) {
		System.out.println("PROGRAM REPOSITORY" );

		sqlSession = getSqlSessionFactory().openSession();
		try {
			 Integer result = sqlSession.insert(namespace + ".insertProgram", program);
			System.out.println("PROGRAM REPOSITORY" + result);

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

	public Integer insertProgramExercise(ProgramExercise programExercise) {
		System.out.println("PROGRAM EXERCISE" );

		sqlSession = getSqlSessionFactory().openSession();
		try {
			 Integer result = sqlSession.insert(namespace + ".insertProgramExercise", programExercise);
			System.out.println("PROGRAM EXERCISE" + result);

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

}
