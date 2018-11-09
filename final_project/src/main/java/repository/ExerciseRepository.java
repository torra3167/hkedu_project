package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;
import model.ExerciseUpload;

@Repository
public class ExerciseRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.exerciseMapper";
	
	

	public int insertExercise(ExerciseUpload eu) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Integer)sqlSession.insert(namespace + ".insertExercise", eu);

		} finally {
			sqlSession.close();
		}
		
	}
	
	

}
