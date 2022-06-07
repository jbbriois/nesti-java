package FilRouge.Model;

import FilRouge.Controlleur.DBArticle;
import FilRouge.Controlleur.DBConnect;
import static FilRouge.Model.MArticles.cnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MOrder {

    static Connection cnx = DBConnect.connect();

    private int id_article;
    private int id_order;
    private int id_package;
    private int id_mesure;
    private int id_user;
    private Date creation_date;
    private String status;
    private String name_mesure;
    private String kind_package;
    private float price;
    private String description_package;
    private float quantity;
    private MArticles article;

    public MOrder() {
    }

    public float getPrice() {
        return price;
    }

    public MArticles getArticle() {
        return article;
    }

    public void setArticle(MArticles article) {
        this.article = article;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getId_package() {
        return id_package;
    }

    public void setId_package(int id_package) {
        this.id_package = id_package;
    }

    public int getId_user() {
        return id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_mesure() {
        return id_mesure;
    }

    public void setId_mesure(int id_mesure) {
        this.id_mesure = id_mesure;
    }

    public String getName_mesure() {
        return name_mesure;
    }

    public void setName_mesure(String name_mesure) {
        this.name_mesure = name_mesure;
    }

    public String getKind_package() {
        return kind_package;
    }

    public void setKind_package(String kind_package) {
        this.kind_package = kind_package;
    }

    public String getDescription_package() {
        return description_package;
    }

    public void setDescription_package(String description_package) {
        this.description_package = description_package;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    @Override
    public String toString() {
        return "MOrder{" + "id_article=" + id_article + ", id_order=" + id_order + ", id_package=" + id_package + ", id_mesure=" + id_mesure + ", id_user=" + id_user + ", creation_date=" + creation_date + ", status=" + status + ", name_mesure=" + name_mesure + ", kind_package=" + kind_package + ", price=" + price + ", description_package=" + description_package + ", quantity=" + quantity + ", article=" + article + '}';
    }

    public String toStringPack() {
        return id_package + "-" + kind_package + "/ description : " + description_package;
    }

    public String toStringUnit() {
        return id_mesure + "-" + name_mesure;
    }

    static public ArrayList GetOrders() throws SQLException {
        ArrayList<MOrder> arr = new ArrayList<>();
        MOrder ord = null;
        try {
            String query = "SELECT  id_order, status_order , creation_date , id_user FROM nesti_order";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                ord = new MOrder();
                ord.setId_order(resultSet.getInt(1));
                ord.setStatus(resultSet.getString(2));
                ord.setCreation_date(resultSet.getDate(3));
                ord.setId_user(resultSet.getInt(4));
                arr.add(ord);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            String queryDetail = "SELECT  id_article , quantity_order  FROM order_detail WHERE id_order='" + ord.id_order + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryDetail);
            while (resultSet.next()) {
                ord.setId_article(resultSet.getInt(1));
                ord.setQuantity(resultSet.getFloat(2));
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            String queryPack = "SELECT id_unit, id_packaging, quantity  FROM pack WHERE id_article='" + ord.getId_article() + "' AND quantity='" + ord.getQuantity() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryPack);
            while (resultSet.next()) {
                ord.setId_mesure(resultSet.getInt(1));
                ord.setId_package(resultSet.getInt(2));
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            String queryPrice = "SELECT  price  FROM nesti_price WHERE id_article='" + ord.getId_article() + "' AND app_date='" + ord.getCreation_date() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryPrice);
            while (resultSet.next()) {
                ord.setPrice(resultSet.getFloat(1));
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            ord.setArticle(DBArticle.getArticleByIdFromDB(ord.getId_article()));
        }

        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            String queryUnit = "SELECT name_unit FROM nesti_unit WHERE id_unit='" + ord.getId_mesure() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryUnit);
            while (resultSet.next()) {
                ord.setName_mesure(resultSet.getString(1));
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            ord = arr.get(i);
            String queryUnit = "SELECT type_packaging, description_packaging FROM nesti_packaging WHERE id_packaging='" + ord.getId_package() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryUnit);
            while (resultSet.next()) {
                ord.setKind_package(resultSet.getString(1));
                ord.setDescription_package(resultSet.getString(2));
            }

        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }

        return arr;
    }

    static public MOrder GetOrdersDetails(String id_order) throws SQLException {
        MOrder ord = new MOrder();
        try {
            String query = "SELECT  id_order, status_order , creation_date , id_user FROM nesti_order WHERE id_order='" + id_order + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                ord = new MOrder();
                ord.setId_order(resultSet.getInt(1));
                ord.setStatus(resultSet.getString(2));
                ord.setCreation_date(resultSet.getDate(3));
                ord.setId_user(resultSet.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            String queryDetail = "SELECT  id_article , quantity_order  FROM order_detail WHERE id_order='" + ord.id_order + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryDetail);
            while (resultSet.next()) {
                ord.setId_article(resultSet.getInt(1));
                ord.setQuantity(resultSet.getFloat(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        try {
            String queryPack = "SELECT id_unit, id_packaging, quantity  FROM pack WHERE id_article='" + ord.getId_article() + "' AND quantity='" + ord.getQuantity() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryPack);
            while (resultSet.next()) {
                ord.setId_mesure(resultSet.getInt(1));
                ord.setId_package(resultSet.getInt(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            String queryPrice = "SELECT  price  FROM nesti_price WHERE id_article='" + ord.getId_article() + "' AND app_date='" + ord.getCreation_date() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryPrice);
            while (resultSet.next()) {
                ord.setPrice(resultSet.getFloat(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ord.setArticle(DBArticle.getArticleByIdFromDB(ord.getId_article()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            String queryUnit = "SELECT name_unit FROM nesti_unit WHERE id_unit='" + ord.getId_mesure() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryUnit);
            while (resultSet.next()) {
                ord.setName_mesure(resultSet.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            String queryUnit = "SELECT type_packaging, description_packaging FROM nesti_packaging WHERE id_packaging='" + ord.getId_package() + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(queryUnit);
            while (resultSet.next()) {
                ord.setKind_package(resultSet.getString(1));
                ord.setDescription_package(resultSet.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ord;
    }

    static public boolean addCommand(MOrder command) throws SQLException {
        boolean success = false;
        addOrder(command);
        InsertPrice(command);
        InsertPack(command);
        int lastOrder = GetLastOrder();
        InsertDetails(command, lastOrder);
        InsertBatch(command, lastOrder);
        return success;
    }

    static public boolean addOrder(MOrder command) throws SQLException {

        try {
            String query = "INSERT INTO nesti_order (status_order ,id_user) VALUES(?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, "En cours");
            smt.setInt(2, command.getId_user());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    static public int GetLastOrder() throws SQLException {
        int id = 0;
        try {
            String query = "SELECT MAX(id_order) FROM nesti_order";
            PreparedStatement smt = cnx.prepareStatement(query);
            ResultSet res = smt.executeQuery();
            while (res.next()) {
                id = res.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    static public boolean InsertPrice(MOrder command) throws SQLException {
        boolean success = false;
        try {
            String query = "INSERT INTO nesti_price (price,id_article) VALUES(?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setFloat(1, command.getPrice());
            smt.setInt(2, command.getArticle().getId());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public boolean InsertPack(MOrder command) throws SQLException {
        boolean success = false;
        try {
            String query_pack = "INSERT INTO pack (id_article,id_unit,id_packaging,quantity) VALUES(?,?,?,?)";
            PreparedStatement smt_pack = cnx.prepareStatement(query_pack);
            smt_pack.setInt(1, command.getArticle().getId());
            smt_pack.setInt(2, command.getId_mesure());
            smt_pack.setInt(3, command.getId_package());
            smt_pack.setFloat(4, command.getQuantity());
            smt_pack.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public boolean InsertDetails(MOrder command, int id_order) throws SQLException {
        boolean success = false;
        try {
            String query_order_details = "INSERT INTO order_detail (id_order,id_article,quantity_order,origin ) VALUES(?,?,?,?)";
            PreparedStatement smt_order_details = cnx.prepareStatement(query_order_details);
            smt_order_details.setInt(1, id_order);
            smt_order_details.setInt(2, command.getArticle().getId());
            smt_order_details.setFloat(3, command.getQuantity());
            smt_order_details.setString(4, command.getArticle().getOrigin());
            smt_order_details.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public boolean InsertBatch(MOrder command, int id_order) throws SQLException {
        boolean success = false;
        try {
            String query_batch = "INSERT INTO nesti_batch (id_article,ref_order,quantity,unit_cost) VALUES(?,?,?,?)";
            PreparedStatement smt_batch = cnx.prepareStatement(query_batch);
            smt_batch.setInt(1, command.getArticle().getId());
            smt_batch.setInt(2, id_order);
            smt_batch.setFloat(3, command.getQuantity());
            smt_batch.setFloat(4, command.getPrice());
            smt_batch.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public ArrayList<String> GetPackaging() throws SQLException {
        ArrayList<String> pack = new ArrayList<String>();
        try {

            String query = "SELECT id_packaging,type_packaging, description_packaging FROM nesti_packaging";
            PreparedStatement smt = cnx.prepareStatement(query);
            ResultSet res = smt.executeQuery(query);
            while (res.next()) {
                MOrder packaging = new MOrder();
                packaging.setId_package(res.getInt(1));
                packaging.setKind_package(res.getString(2));
                packaging.setDescription_package(res.getString(3));
                String toadd = packaging.toStringPack();
                pack.add(toadd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pack;
    }

    static public ArrayList<String> GetUnit() throws SQLException {
        ArrayList<String> unit = new ArrayList<String>();
        try {

            String query = "SELECT id_unit, name_unit FROM nesti_unit";
            PreparedStatement smt = cnx.prepareStatement(query);
            ResultSet res = smt.executeQuery(query);
            while (res.next()) {
                MOrder unity = new MOrder();
                unity.setId_mesure(res.getInt(1));
                unity.setName_mesure(res.getString(2));
                String toadd = unity.toStringUnit();
                unit.add(toadd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return unit;
    }

    static public boolean changeStatus(int id_order, String status) throws SQLException {
        String query = "UPDATE nesti_order SET status_order = ? WHERE id_order= ?";
        PreparedStatement smt_status = cnx.prepareStatement(query);
        smt_status.setString(1, status);
        smt_status.setInt(2, id_order);
        System.out.println("smt_status : "+smt_status);
        smt_status.executeUpdate();
        return false;
    }

    
     static public ArrayList searchCommand(String search) throws SQLException {
        ArrayList<MArticles> arr = new ArrayList<>();
        MArticles art = null;
        try {

            String query = "SELECT  id_order, status_order , creation_date , id_user FROM nesti_order WHERE name_article = '" + search +"'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                art = new MArticles();
                art.setId(resultSet.getInt(1));
                art.setName(resultSet.getString(2));
                art.setBrand(resultSet.getString(3));
                art.setProvider(resultSet.getString(4));
                art.setStatus_article(resultSet.getString(5));
                arr.add(art);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return arr;
        }

    }
}
