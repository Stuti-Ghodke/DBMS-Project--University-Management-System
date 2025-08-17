package uni.manage.sys;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnExample
{
    Connection connection;
    Statement statement;

    ConnExample()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management", "<username>", "<password>");

            statement= connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
