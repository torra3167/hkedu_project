package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Aca;
import model.Bca;
import model.Cca;
import model.Comment;
import model.Member;

public class CommentSessionRepository extends AbstractRepository {
	
	private SqlSession sqlSession;
	private final String namespace = "repository.mapper.commentMapper";
	
	
	
	public Integer insertComment(Comment comment) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			System.out.println("Repository " + comment.getCommentNo());
			Integer i = sqlSession.insert(namespace + ".insertComment", comment);
			
			if(i > 0) {
				sqlSession.commit(); 
			} else {
				sqlSession.rollback();
			}
			return i;
			
		} finally {
			sqlSession.close();
		}
	}



	public List<Comment> selectCommentByCondtion(Comment comment) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			Long commentNo = comment.getCommentNo();
			return sqlSession.selectList(namespace + ".selectCommentByCondtion", comment);

		} finally {
			sqlSession.close();
		}
		
	}



	public Integer updateComment(Comment comment) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
		 Integer i =sqlSession.update(namespace + ".updateComment", comment);
		 if(i > 0) {
			 sqlSession.commit();
		 } else {
			 sqlSession.rollback();
		 }
		 return i;
		} finally {
			sqlSession.close();
		}
		
	}



	public Integer deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
		Integer i = sqlSession.delete(String.format("%s.deleteComment", namespace), comment);
		
		if(i > 0) {
			 sqlSession.commit();
		 } else {
			 sqlSession.rollback();
		 }
		 return i;
		 
		} finally {
			sqlSession.close();
		}
		
	}



	public List ajaxSelect(Long result) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		if(result == 1) {
			statement = namespace + ".ajaxSelect";
		} else if(result == 2) {
			statement = namespace + ".ajaxSelect2";
		}
		try {
		return sqlSession.selectList(statement);
		
		} finally {
			sqlSession.close();
		}
	}



	public Member memberSelect(Member mb) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Member)sqlSession.selectOne(namespace + ".memberSelect", mb);

		} finally {
			sqlSession.close();
		}
	}



	public List<Aca> acaSelect() {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return sqlSession.selectList(namespace + ".acaSelect");
		
		} finally {
			sqlSession.close();
		}
		
	}



	public List<Bca> bcaSelect(Aca aca) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("CommentSessionRepository " + aca.getAnum());
			return sqlSession.selectList(namespace + ".bcaSelect", aca);
			
		} finally {
			
			sqlSession.close();
		}
		
	}



	public List<Cca> ccaSelect(Bca bca) {
		
			 sqlSession = getSqlSessionFactory().openSession();
			 String statement = namespace + ".ccaSelect";
			try {
				return sqlSession.selectList(statement,bca);
			} finally {
				sqlSession.close();
			}
		}
	}


