package com.itis.spring4.hibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ClassName HibernateTest
 * @Author LCX
 * @Date 2021 2021-06-06 10:00 a.m.
 * @Version 1.0
 **/
public class HibernateTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
    }

    /**
     * 创建数据库连接
     */
    @Test
    public void dataSourceTest() {
        DataSource dataSource = ctx.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
