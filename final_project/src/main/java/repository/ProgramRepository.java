package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import category.ExerciseCatA;
import category.ExerciseCatB;
import model.ExerciseUpload;
import model.Program;
import model.ProgramExercise;
import model.ProgramExerciseUpload;

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

	public Integer insertProgramExercise(List<ProgramExercise> programList) {
		System.out.println("PROGRAM EXERCISE" );
		int result = 0;
		sqlSession = getSqlSessionFactory().openSession();
		try {
			
			for(ProgramExercise programExercise : programList) {
				sqlSession.insert(namespace + ".insertProgramExercise", programExercise);
				result++;
			}

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

	public List<ExerciseCatA> selectCatByExerciseCatAName(String[] exerciseCatANames) {
		List<ExerciseCatA> list = new ArrayList<ExerciseCatA>();
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			for(String exerciseCatAName : exerciseCatANames) {
				ExerciseCatA exerciseCatA = (ExerciseCatA)sqlSession.selectOne(namespace + ".selectCatByExerciseCatAName", exerciseCatAName);
				list.add(exerciseCatA);
			}
		return list;
		
		} finally {
			sqlSession.close();
		}
		
	}

	public Integer selectExerciseNumberByCategory(int exerciseCatANumber) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectExerciseNumberByCategory", exerciseCatANumber);
		
		} finally {
			sqlSession.close();
		}
	}

	public List<Program> programList() {
		
		sqlSession = getSqlSessionFactory().openSession();

		try {

			List<Program> list = sqlSession.selectList(namespace + ".programList");
			return list;
		} finally {
			sqlSession.close();
		}
	}

	public List<ProgramExercise> selectByProgramNumber(int programNumber) {
		// TODO Auto-generated method stub
				sqlSession = getSqlSessionFactory().openSession();
				List<ProgramExercise> list = null;
				try {
					
				list = sqlSession.selectList(namespace + ".selectByProgramNumber", programNumber);
				return list;
				
				} finally {
					sqlSession.close();
				}
		
	}

	public List<ProgramExerciseUpload> selectProgramExerciseUpload(int proNo) {
		List<ProgramExerciseUpload> list = new ArrayList<ProgramExerciseUpload>();
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			String statement = namespace + ".selectProgramExerciseUpload";
			
			list = sqlSession.selectList(statement, proNo);
			return list;
			
		} finally {
			sqlSession.close();
		}
	}

}
