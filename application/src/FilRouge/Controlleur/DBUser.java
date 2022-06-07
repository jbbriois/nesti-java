package FilRouge.Controlleur;

import FilRouge.Model.MUser;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUser {

    static public ArrayList getUsersFromDB() throws SQLException {
        ArrayList<MUser> arr = new ArrayList<>();
        arr = MUser.getUsers();
        return arr;
    }       
    
    
    static public boolean deleteUserByIdToBD(int id) throws SQLException {
        boolean success = false;
        MUser.deleteUserById(id);
        return success;
    }
    
    static public boolean addUserToDB(MUser user) throws SQLException {
        boolean success = false;
        MUser.addUser(user);
        return success;
    }
    
}
