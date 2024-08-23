package utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {

	private static SqlSessionFactory sqlSessionFactory;

	static { // static메서드 프로그램 실행과 동시에 팩토리를 만들어냄

		try {
			// mybatis-config.xml 읽어옴 ->패키지명/파일명
			String resource = "resource/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// SqlSessionFactoryBuilder 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

			// SqlSessionFactoryBuilder 가 최종적으로 SqlSessionFactory생성
			sqlSessionFactory = builder.build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 생성한걸 사용하기 위한 메서드 추가
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;

	}
}
