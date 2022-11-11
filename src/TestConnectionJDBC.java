import java.sql.*;

public class TestConnectionJDBC {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/DB_BANQUE";
            String user = "root";
            String psw = "";
            Connection conn = DriverManager.getConnection(url, user, psw);
            PreparedStatement ps = conn.prepareStatement("select * from clients");
            ResultSet rs =  ps.executeQuery();
/*

          while (rs.next()) {
              System.out.println(rs.getInt(1)  + " " + rs.getString("NOM"));
          }
*/
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i<=rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i<=rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t");
                }
                System.out.println();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

