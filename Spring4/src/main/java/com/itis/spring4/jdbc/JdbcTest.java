package com.itis.spring4.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Jdbc
 * @Author LCX
 * @Date 2021 2021-06-05 10:38 p.m.
 * spring 对 jdbc 的支持
 **/
public class JdbcTest {
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
    /**
     * 更新
     */
    @Test
    public void update() {
       String sql = "UPDATE users SET user_name=? WHERE id=?";
       jdbcTemplate.update(sql,"summerlv",1);
    }

    /**
     * 批量插入
     * 修改一条数据需要一个 Object 类型的数组
     */
    @Test
    public void batchInsert() {
       String sql = "insert into users(user_name,password) values(?,?)";
        List<Object[]> batchArgs = new ArrayList<>(5);
        batchArgs.add(new Object[]{"summer","111"});
        batchArgs.add(new Object[]{"lvlv","222"});
        batchArgs.add(new Object[]{"lvsummer","333"});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /**
     * 从数据库查询结果
     * RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
     * 使用 sql 中 列的别名完成列名和类属性名的映射，例如 user_name 对应 userName
     * 不支持级联属性的查询与映射
     */
    @Test
    public void query() {
       String sql = "select id, user_name userName, password from users where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(user);
    }
}
