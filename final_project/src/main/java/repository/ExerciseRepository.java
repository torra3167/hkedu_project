package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.ExerciseCatA;
import category.ExerciseCatACatB;
import category.ExerciseCatB;
import model.Exercise;
import model.ExerciseExerciseCatA;
import model.ExerciseRec;
import model.ExerciseRecCommand;
import model.ProgramExercise;
import model.Upload;

@Repository
public class ExerciseRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.exerciseMapper";

	public int insertExercise(Exercise exercise) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			int result = sqlSession.insert(namespace + ".insertExercise", exercise);
			/* System.out.println("Exercise REPOSITORY" + result); */

			if (result > 0) {
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

			return (Integer) sqlSession.selectOne(namespace + ".selectExerciseNumber");

		} finally {
			sqlSession.close();
		}
	}

	public List<Upload> exerciseList() {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			List<Upload> list = sqlSession.selectList(namespace + ".uploadList");
			return list;
		} finally {
			sqlSession.close();
		}
	}

	public int insertUpload(List<Upload> lists) {
		int result = 0;
		sqlSession = getSqlSessionFactory().openSession();
		try {

			for (Upload upload : lists) {
				sqlSession.insert(namespace + ".insertUpload", upload);
				result++;
			}
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public Integer updateExercise(Exercise exercise) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			Integer updateResult = sqlSession.insert(namespace + ".updateExercise", exercise);
			System.out.println("UPDATE EXERCISE " + updateResult);

			if (updateResult > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return updateResult;

		} finally {
			sqlSession.close();
		}
	}

	public Integer updateUpload(Upload upload) {

		sqlSession = getSqlSessionFactory().openSession();

		try {
			Integer resultUpload = sqlSession.insert(namespace + ".updateUpload", upload);
			System.out.println("UPDATE UPLOAD " + resultUpload);

			if (resultUpload > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return resultUpload;

		} finally {
			sqlSession.close();
		}
	}

	public Integer updateProgramExercise(ProgramExercise programExercise) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer resultProgramExercise;
		try {
			resultProgramExercise = sqlSession.update("repository.mapper.programMapper.updateProgramExercise", programExercise);
			System.out.println("UPDATE ProgramExercise " + resultProgramExercise);

			if (resultProgramExercise > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return resultProgramExercise;

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

	public int updateUploadCategory(Upload upload) {
		sqlSession = getSqlSessionFactory().openSession();

		try {
			Integer resultUploadCategory = sqlSession.insert(namespace + ".updateUploadCategory", upload);
			System.out.println("UPDATE CATEGORY UPLOAD " + resultUploadCategory);

			if (resultUploadCategory > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return resultUploadCategory;

		} finally {
			sqlSession.close();
		}
	}

	public Exercise selectExerciseByExerciseNumber(int exerciseNumber) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			Exercise exercise = 
					(Exercise)sqlSession.selectOne(namespace + ".selectExerciseByExerciseNumber", exerciseNumber);
			
			return exercise;
		} finally {
			sqlSession.close();
		}
	}

	public ExerciseRec selectProPayByMemberEmail(String memberEmail) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			ExerciseRec exerciseRec = sqlSession.selectOne(namespace + ".selectProPayByMemberEmail",
					memberEmail);
			
			if(exerciseRec == null) {
				System.out.println("selectProPayByMemberEmail 실패" );
			}
			
			return exerciseRec;

		} finally {
			sqlSession.close();
		}
		
	}

	

	public List<ExerciseExerciseCatA> selectExerciseExerciseCatANameByMemberEmail(String memberEmail) {
		
		sqlSession = getSqlSessionFactory().openSession();
		
		try {

			List<ExerciseExerciseCatA> eecaList = 
					sqlSession.selectList(namespace + ".selectExerciseExerciseCatANameByMemberEmail", memberEmail);
			
			for(int i = 0; i < eecaList.size(); i++) {
				ExerciseExerciseCatA eeca = (ExerciseExerciseCatA)eecaList.get(i);
			
			ExerciseCatA exerciseCatA = 
					(ExerciseCatA)sqlSession.selectOne(namespace + ".selectCatANameByExerciseCatANumber",eeca.getExerciseCatANumber());
			eeca.setExerciseCatAName(exerciseCatA.getExerciseCatAName());
			eecaList.get(i).setExerciseCatAName(exerciseCatA.getExerciseCatAName());
			}
			return eecaList;
			
		} finally {
			sqlSession.close();
		}
	}

	public List<ExerciseRec> selectExerciseRecordByMemberEmail(String memberEmail) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			List<ExerciseRec> exerciseRecList = sqlSession.selectList(namespace + ".selectExerciseRecordByMemberEmail",
					memberEmail);

			return exerciseRecList;

		} finally {
			sqlSession.close();
		}
	}

	public void insertExerciseRec(ExerciseRecCommand exerciseRecCommand) {
		sqlSession = getSqlSessionFactory().openSession();
		int result = 0;		
		//멤버이메일, 프로그램번호, 코치이메일, 체중, 등록일
		ExerciseRec exerciseRec = new ExerciseRec(exerciseRecCommand.getMemberEmail(), exerciseRecCommand.getProNo(), exerciseRecCommand.getCoachEmail(),
				exerciseRecCommand.getExerciseRecordWeight(), exerciseRecCommand.getExerciseRecordRegdate());
		
		try {
			
		for(int i = 0; i < exerciseRecCommand.getExerciseRecordName().length; i++) {
			
			exerciseRec.setExerciseRecordName(exerciseRecCommand.getExerciseRecordName()[i]);
			exerciseRec.setExerciseRecordKg(Integer.parseInt(exerciseRecCommand.getExerciseRecordKg()[i]));
			exerciseRec.setExerciseRecordTimes(Integer.parseInt(exerciseRecCommand.getExerciseRecordTimes()[i]));
			
			Integer exerciseResult = sqlSession.insert(namespace + ".insertExerciseRec", exerciseRec);
					
					if(exerciseResult > 0) {
						result++;
					}
			}
		
			if (result > 0) {
				sqlSession.commit();
				System.out.println(result + " insertExerciseRec");
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();

		}
	}
}
