package FilRouge.Controlleur;

import FilRouge.Model.MOrder;
import static FilRouge.Model.MOrder.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBOrder {

    static public boolean addCommandToDB(MOrder command) throws SQLException {
        boolean success = false;
        MOrder.addCommand(command);
        return success;
    }

    static public ArrayList<String> GetPackagingFromDB() throws SQLException {
        ArrayList<String> pack = null;
        pack = GetPackaging();
        return pack;
    }

    static public ArrayList<String> GetUnitFromDB() throws SQLException {
        ArrayList<String> unit = null;
        unit = GetUnit();
        return unit;
    }

    static public ArrayList GetOrdersFromDB() throws SQLException {
        ArrayList<MOrder> arr = new ArrayList<>();
        arr = GetOrders();
        return arr;

    }

    static public MOrder GetOrdersDetailsFromDB(String id_order) throws SQLException {
        MOrder ord = new MOrder();
        ord = GetOrdersDetails(id_order);
        return ord;
    }

    static public boolean changeStatusFromDB(int id_order, String status) throws SQLException {

        MOrder ord = new MOrder();
        ord.changeStatus(id_order,status);
        return false;
        
    }

}
