package com.wangyang.basic.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InitData {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.151:3306/junit_test?characterEncoding=utf8&useSSL=false","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    @Test
    public static void insertData() throws SQLException {
        Connection connection = getConnection();
        String sql="insert into t_user(username,password)values(?,?)";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.execute("TRUNCATE TABLE t_user");
        for(int i=0;i<100;i++){
            ps.setString(1,getName());
            ps.setString(2,getNumber());
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        connection.close();
    }

    private static Random random = new Random();
    private static String getNumber() {
        return random.nextInt(50)+"";
    }

    private static String getName() {
        String[] s ={"王","张","刘","高","潘","侯","赵"};
        String[] e = {"阳","三","蛋","秋","黄"};
        String name =s[random.nextInt(s.length)]+e[random.nextInt(e.length)];
        return name;


    }
    @Test
    public void test(){
        System.out.println(random.nextInt(50));
    }
}
