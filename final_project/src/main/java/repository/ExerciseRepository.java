package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.ExerciseCatA;
import category.ExerciseCatACatB;
import category.ExerciseCatB;

import model.Exercise;
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

}
