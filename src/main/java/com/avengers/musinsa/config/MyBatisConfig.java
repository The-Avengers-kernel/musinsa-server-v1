package com.avengers.musinsa.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan({"com.avengers.musinsa.test", "com.avengers.musinsa.domain.user.mapper"})
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // Mapper XML 파일 위치 설정
        sessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:com.avengers.musinsa/*.xml")
        );

        // Type Aliases 패키지 설정
        sessionFactory.setTypeAliasesPackage("com.avengers.musinsa.test");

        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}