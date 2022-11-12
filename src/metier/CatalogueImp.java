package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogueImp implements ICatalogue{
    @Override
    public List<Clients> clientByKeyword(String kw) {
        List<Clients> clients = new ArrayList<Clients>();
        try {
            Connection conn = getConnection();

            PreparedStatement ps = conn.prepareStatement("select  * from clients where NOM or PRENOM like ?");
            ps.setString(1, "%" + kw + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Clients c = new Clients();
                c.setIdClient(rs.getInt(1));
                c.setNomClient(rs.getString("NOM"));
                c.setPrenomClient(rs.getString("PRENOM"));
                clients.add(c);
            }
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_BANQUE", "root", "");
        return conn;
    }

    @Override
    public void addClient(Clients c) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into clients(NOM,PRENOM) values(?,?)");
            ps.setString(1, c.getNomClient());
            ps.setString(2, c.getPrenomClient());

            int nb = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public void connection(){

    }*/
}
