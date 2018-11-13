package repository;

import org.apache.ibatis.session.SqlSession;

import model.Program;

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

}
