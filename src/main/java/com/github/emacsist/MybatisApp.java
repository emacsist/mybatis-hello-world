package com.github.emacsist;


import com.github.emacsist.mapper.PersonMapper;
import com.github.emacsist.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisApp {
    public static void main(String[] args) throws IOException {
        String resource = "com/github/emacsist/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.selectOne(1);
            System.out.println(person.getName());
        } finally {
            session.close();
        }
    }
}
