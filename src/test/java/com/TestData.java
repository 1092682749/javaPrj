package com;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestData {
    public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 模拟打卡时间
        String time = "2019-04-15 12:00:00";
        Date date = format.parse(time);

        // 获取今天应到时间
        Date currentData = new Date();
        String currentStr = format.format(currentData);
        String dateStr = currentStr.split(" ")[0];
        String todayStr = dateStr + " 09:00:00";
        Date shouldTime = format.parse(todayStr);

        long difference = shouldTime.getTime() - date.getTime();

        double s = (double) difference / 1000;

        if (s > 0) {
            System.out.println("您的打卡时间是:" + time + "今天应到时间为：" + todayStr + "恭喜您没有迟到！");
        } else {
            s = Math.abs(s);
            System.out.println("您的打卡时间是:" + time + "今天应到时间为：" + todayStr);
            System.out.println("您迟到了：" + s/60 +"s");
            System.out.println("您迟到了：" + s/(60*60) +"小时");
        }

        // 以下是假如你的数据是从数据库获得且类型为time
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/development", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("select  * from time_test");
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        Date date1 = (Date) resultSet.getObject("time");
        System.out.println(date1.toString());

    }
}
