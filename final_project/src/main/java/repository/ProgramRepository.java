package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import category.ExerciseCatA;
import category.ExerciseCatACatB;
import category.ExerciseCatB;
import category.FoodCatC;
import command.ProgramCommand;
import model.Food;
import model.FoodProFood;
import model.ProFood;
import model.ProReview;
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
			/*for(Object temp : list) {
				ProgramExerciseUpload peu = (ProgramExerciseUpload)temp;
				System.out.println(peu.getExerciseContent() + "REPO EXERCISECONTENT!!!");
			}*/
			return list;
			
		} finally {
			sqlSession.close();
		}
	}

	public ExerciseCatACatB selectExerciseCatACatB(ExerciseCatACatB exerciseCatACatB) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			ExerciseCatACatB exerciseCatACatBResult = 
					(ExerciseCatACatB)sqlSession.selectOne("repository.mapper.exerciseMapper.selectExerciseCatACatB", exerciseCatACatB);
			
			return exerciseCatACatBResult;
		} finally {
			sqlSession.close();
		}
	}

	public List<ExerciseCatACatB> selectExerciseCatACatBList(List<ExerciseCatACatB> categoryNumbers) {
		sqlSession = getSqlSessionFactory().openSession();
		List<ExerciseCatACatB> categoryResult = new ArrayList<ExerciseCatACatB>();
		try {
			for(Object temp : categoryNumbers) {
				ExerciseCatACatB exerciseCatACatB = (ExerciseCatACatB)temp;
				ExerciseCatACatB exerciseCatACatBNames = (ExerciseCatACatB)sqlSession.selectOne("repository.mapper.exerciseMapper.selectExerciseCatACatBList", exerciseCatACatB);
				categoryResult.add(exerciseCatACatBNames);
			}
			
			
			return categoryResult;
		} finally {
			sqlSession.close();
		}
	}

	public List<FoodCatC> ccaSelect() {
		sqlSession = getSqlSessionFactory().openSession();
		String statement = "repository.mapper.foodMapper.ccaSelect";
		try {
			return sqlSession.selectList(statement);
		} finally {
			sqlSession.close();
		}
	}

	

	public void insertProFood(ProgramCommand programCommand, String[] selectedFoodNos) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			for (int i = 0; i < selectedFoodNos.length; i++) {
				Food food = sqlSession.selectOne("repository.mapper.foodMapper.selectSellerFood",
						Integer.parseInt(selectedFoodNos[i]));
				
				Integer selectProFoodNo = sqlSession.selectOne(namespace + ".selectSequenceNumber");
				
				ProFood proFood = new ProFood(selectProFoodNo, food.getFoodNo(), food.getSellerEmail(), 
						food.getFoodCatANo(), food.getFoodCatBNo(), food.getFoodCatCNo(), 
						programCommand.getProNo(), programCommand.getCoachEmail());
				
				Integer insertProFoodResult = sqlSession.insert(namespace + ".insertProFood", proFood);
				
				if(insertProFoodResult > 0) {
					sqlSession.commit();
				} else {
					System.out.println("프로그램 식품 등록 실패");
					sqlSession.rollback();
				}
			}

		} finally {
			sqlSession.close();
		}

	}

	public List<FoodProFood> selectProFoodList() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			 List<FoodProFood> foodProFoodList = sqlSession.selectList(namespace + ".selectProFoodList");
			 
			 return foodProFoodList;
		} finally {
			sqlSession.close();
		}
	}

	public List<FoodProFood> selectFoodProFoodOneByProFoodNo(int proFoodNo) {
		sqlSession = getSqlSessionFactory().openSession();

		try {
			List<FoodProFood> foodProFoodList = sqlSession.selectList(namespace + ".selectFoodProFoodOneByProFoodNo", proFoodNo);

			return foodProFoodList;
		} finally {
			
			sqlSession.close();
		}
	}

	public int proUpdateApprove(int proNo) {
		
		sqlSession = getSqlSessionFactory().openSession();
		try {
			 Integer result = sqlSession.insert(namespace + ".proUpdateApprove", proNo);

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

	public int proUpdateReject(Program program) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			 Integer result = sqlSession.insert(namespace + ".proUpdateReject", program);

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

	public List<ProReview> selectProReviewListByProNo(int proNo) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			return sqlSession.selectList("repository.mapper.proReviewMapper.selectProReviewListByProNo", proNo);

		} finally {
			sqlSession.close();
		}
	}
	
	
	}

	


