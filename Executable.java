import java.sql.*;

public class Executable {
    public static void main(String[] args) {
        Connection c;
        Class.forName("com.mysql.jdbc.Dri");
        c=DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/mabd","monlog","monpass");
    

    }
}
