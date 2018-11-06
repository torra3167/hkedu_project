package repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AbstractRepository {

	private static SqlSessionFactory ssf;
	
	static {
		setSqlSessionFactory();
	}
	
	private static void setSqlSessionFactory() {
		String resource = "config.xml";
		InputStream is;
		try {
			is = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		return ssf;
	}
	
	
}
