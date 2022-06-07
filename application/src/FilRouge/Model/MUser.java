package FilRouge.Model;

import FilRouge.Controlleur.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MUser {

    static Connection cnx = DBConnect.connect();

    int id;
    String username;
    String password;
    int role;

    public MUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return id + "- " + username;
    }

    static public ArrayList getUsers() throws SQLException {
        ArrayList<MUser> arr = new ArrayList<>();
        MUser user = null;
        try {

            String query = "SELECT  id_user, username, pwd, id_role  FROM nesti_user";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                user = new MUser();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(resultSet.getInt(4));
                arr.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println(arr);
            return arr;
        }

    }

    static public boolean deleteUserById(int id) throws SQLException {
        boolean success = false;
        try {
            String query = "DELETE FROM nesti_user WHERE id_user ='" + id + "'";
            Statement smt = cnx.prepareStatement(query);
            smt.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public boolean addUser(MUser user) throws SQLException {
        boolean success = false;
        try {
            String query = "INSERT INTO nesti_user (username,login,pwd,id_role) VALUES(?,?,?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, user.getUsername());
            smt.setString(2, "true");
            smt.setString(3, user.getPassword());
            smt.setInt(4, user.getRole());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

}
