package ex2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MainEx2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String sql="select * from persoane where nume=? and varsta<?";
        try {
            Connection connection = DriverManager.getConnection (url, "root", "pisica");
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, "Vladut");
            ps.setInt(2, 18);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                System.out.println("id="+rs.getInt(1)+", nume= " + rs.getString(2)
                        + ", varsta="+rs.getInt(3));
            connection.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
