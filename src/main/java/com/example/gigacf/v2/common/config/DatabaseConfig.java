package com.example.gigacf.v2.common.config;

import org.springframework.core.io.Resource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/* 디비와 마이바티스 설정 클래스
 * 참고사이트 : https://doozi0316.tistory.com/entry/Spring-Boot-MyBatis-MySQL-%EC%97%B0%EB%8F%99-%EB%B0%A9%EB%B2%95
 */

@Configuration
@MapperScan ("com.example.gigacf.v2") // @Mapper가 있는 클래스를 담을 범위 설정
public class DatabaseConfig {

	
	
	/*
	 ** Datasource 객체 생성 후 bean 등록
	 *
	 * - 커넥션 풀의 커넥션을 관리하기 위한 객체
	 * - 이 객체를 통해 커넥션을 획득 반납 등의 작업을 한다.
	 * - 스프링부트가 자동으로 해주므로 활성화는 안 시킴.
	 * @ConfigurationProperties
	 * - 외부 설정 파일(application.properties)을 참조할 때 쓰는 방법 중 하나이다.(ex. @Value)
	 * - application.properties의 key를 같은 값으로 시작하게 구현해두면(접두어), 이를 묶어서 Bean으로 등록할 수 있다. (여기선 spring.datasource로 구현해뒀음)
	 * - 즉, 아래 코드처럼 prefix = "spring.datasource" 라고 하면 spring.datasource가 접두어로 붙어 있는 application.properties 값들을 참조할 수 있다.
	 * - 이 어노테이션을 @Bean이 붙은 메소드에 붙여주면 써드파티 컴포넌트(여기선 Datasource, 즉, 플러그인이나 라이브러리) 에 바인딩을 할 수 있다
	 * - 즉, Datasource가 application.properties에 spring.datasource 로 시작되는 값들을 참조해서 쓴다는 것이다.
	 * 
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    */
	
	
	/* 
	 * SqlSessionFactory 객체 생성 후 bean 등록
	 * 
	 * @Bean : indicating that it will create and configure a SqlSessionFactory bean.
	 * SqlSessionFactory : DB와 MyBatis를 연결해주는 객체
	 * SqlSessionFactoryBean : SqlSessionFactory를 생성해주는 클래스
	 * setDataSource() : 앞서 정의한 datasource를 참조하게 한다.
	 * PathMatchingResourcePatternResolver
	 * - resource 위치 검색을 돕는 Spring class
	 * - getResources() 로 경로 검색을 해 SqlSessionFactory에 mapper 와 mybatis-config를 set해준다.
	 */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:sqlmapper/v2/*.xml"));

        Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"); // classpath는 resource
        sessionFactory.setConfigLocation(myBatisConfig);

        return sessionFactory.getObject();
    }
}
