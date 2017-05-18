package test.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

/**
 * ConnectionTest Tester.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConnectionTestTest {


    /**
     * Method: handler()
     */
    @Test
    public void testHandler() throws Exception {
        //BasicDataSource dataSource = new BasicDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/tzspring");
        //dataSource.setUsername("root");
        //dataSource.setPassword("root");
        //
        //Connection connection = dataSource.getConnection();
        //System.out.println(connection);


        // 从配置文件获取 db 信息。
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //讲存储的实例。我通过getBean取出来.
        BasicDataSource dataSource = (BasicDataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        System.out.println(dataSource.getDriverClassName());
        System.out.println(dataSource.getUsername());
        System.out.println(dataSource.getPassword());

    }


} 
