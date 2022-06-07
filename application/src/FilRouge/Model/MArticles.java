package FilRouge.Model;

import static FilRouge.Controlleur.DBArticle.deleteArticleFromIngredientToDB;
import static FilRouge.Controlleur.DBArticle.deleteArticleFromToolToDB;
import static FilRouge.Controlleur.DBArticle.getArticleByNameFromDB;
import FilRouge.Controlleur.DBConnect;
import FilRouge.Controlleur.DBProvider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MArticles {

    static Connection cnx = DBConnect.connect();

    private int id;
    private int id_supplier;
    private String name;
    private String brand;
    private String provider;
    private String status_article;
    private String type;
    String origin;
    private int id_user;

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    private Date creation_date;

    public MArticles() {
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getOrigin() {
        return origin;
    }

    public MArticles(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus_article() {
        return status_article;
    }

    public void setStatus_article(String status_article) {
        this.status_article = status_article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "MArticles{" + "id=" + id + ", id_supplier=" + id_supplier + ", name=" + name + ", brand=" + brand + ", provider=" + provider + ", status_article=" + status_article + ", type=" + type + ", origin=" + origin + ", id_user=" + id_user + ", creation_date=" + creation_date + '}';
    }

    static public ArrayList getArticles() throws SQLException {
        ArrayList<MArticles> arr = new ArrayList<>();
        MArticles art = null;
        try {

            String query = "SELECT  id_article, name_article , brand , id_user, status_article FROM nesti_article";
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

    static public ArrayList getArticlesForCommand() throws SQLException {
        ArrayList<MArticles> arr = new ArrayList<>();
        MArticles art = null;
        try {

            String query = "SELECT  id_article, name_article , brand , id_user, status_article FROM nesti_article WHERE status_article = 'Disponible'";
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

    static public ArrayList searchArticles(String search) throws SQLException {
        ArrayList<MArticles> arr = new ArrayList<>();
        MArticles art = null;
        try {

            String query = "SELECT  id_article, name_article , brand , id_user, status_article FROM nesti_article WHERE name_article LIKE '" + search + "%'";
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

    static public ArrayList searchArticlesForCommand(String search) throws SQLException {
        ArrayList<MArticles> arr = new ArrayList<>();
        MArticles art = null;
        try {

            String query = "SELECT  id_article, name_article , brand , id_user, status_article FROM nesti_article WHERE name_article LIKE '" + search + "%' AND status_article ='Disponible' ";
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

    static public MArticles getArticleByName(String article) {
        MArticles art = new MArticles();

        try {
            String query = "SELECT  id_article, name_article , brand FROM nesti_article WHERE name_article ='" + article + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                art.setId(resultSet.getInt(1));
                art.setName(resultSet.getString(2));
                art.setBrand(resultSet.getString(3));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return art;
        }

    }

    static public MArticles getArticleByNameDetails(String article) {
        MArticles art = new MArticles();
        try {
            String query = "SELECT  id_article, name_article , brand, creation_date, status_article, id_user FROM nesti_article WHERE name_article ='" + article + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                art.setId(resultSet.getInt(1));
                art.setName(resultSet.getString(2));
                art.setBrand(resultSet.getString(3));
                art.setCreation_date(resultSet.getDate(4));
                art.setStatus_article(resultSet.getString(5));
                art.setId_user(resultSet.getInt(6));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return art;
        }
    }

    static public MArticles getArticleByNameFullDetails(String article) {
        MArticles art = new MArticles();
        try {
            String query = "SELECT  id_article, name_article , brand, creation_date, status_article, id_user FROM nesti_article WHERE name_article ='" + article + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                art.setId(resultSet.getInt(1));
                art.setName(resultSet.getString(2));
                art.setBrand(resultSet.getString(3));
                art.setCreation_date(resultSet.getDate(4));
                art.setStatus_article(resultSet.getString(5));
                art.setId_user(resultSet.getInt(6));
            }
            System.out.println("art.toString() 1  " + art.toString());
            String query_sold_by = "SELECT  id_supplier, origin FROM sold_by WHERE id_article =" + art.getId();
            Statement smt_sold_by = cnx.createStatement();
            ResultSet resultSet_sold_by = smt_sold_by.executeQuery(query_sold_by);
            while (resultSet_sold_by.next()) {
                art.setId_supplier(resultSet_sold_by.getInt(1));
                art.setOrigin(resultSet_sold_by.getString(2));
            }
            System.out.println("art.toString() 2  " + art.toString());
            MProvider pro = new MProvider();
            pro = MProvider.getAProviderById(art.getId_supplier());
            art.setProvider(pro.getProvider_name());
            System.out.println("art.toString() 3  " + art.toString());
            if (chekIfToolOrIngredient(art.getId()) == 0) {
                art.setType("Ustensile");
            } else {
                art.setType("Ingrédient");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("art.toString() 4  " + art.toString());
            return art;
        }

    }

    static public MArticles getArticleById(int id) throws SQLException {
        MArticles art = new MArticles();
       try {
            String query = "SELECT  id_article, name_article , brand, creation_date, status_article, id_user FROM nesti_article WHERE id_article ='" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                art.setId(resultSet.getInt(1));
                art.setName(resultSet.getString(2));
                art.setBrand(resultSet.getString(3));
                art.setCreation_date(resultSet.getDate(4));
                art.setStatus_article(resultSet.getString(5));
                art.setId_user(resultSet.getInt(6));
            }
            System.out.println("art.toString() 1  " + art.toString());
            String query_sold_by = "SELECT  id_supplier, origin FROM sold_by WHERE id_article =" + art.getId();
            Statement smt_sold_by = cnx.createStatement();
            ResultSet resultSet_sold_by = smt_sold_by.executeQuery(query_sold_by);
            while (resultSet_sold_by.next()) {
                art.setId_supplier(resultSet_sold_by.getInt(1));
                art.setOrigin(resultSet_sold_by.getString(2));
            }
            System.out.println("art.toString() 2  " + art.toString());
            MProvider pro = new MProvider();
            pro = MProvider.getAProviderById(art.getId_supplier());
            art.setProvider(pro.getProvider_name());
            System.out.println("art.toString() 3  " + art.toString());
            if (chekIfToolOrIngredient(art.getId()) == 0) {
                art.setType("Ustensile");
            } else {
                art.setType("Ingrédient");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("art.toString() 4  " + art.toString());
            return art;
        }

    }

    static public boolean deleteArticleByName(String article) {
        boolean success = false;
        MArticles art = getArticleByNameDetails(article);
        int tool_or_ingredient = chekIfToolOrIngredient(art.getId());
        try {
            String query = "DELETE FROM nesti_article WHERE name_article ='" + article + "'";
            Statement smt = cnx.createStatement();
            smt.executeUpdate(query);
            if (tool_or_ingredient == 0) {
                deleteArticleFromTool(art.getId());
            } else {
                deleteArticleFromIngredient(art.getId());
            }
            deleteArticleFromSoldBy(art.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return success;
        }

    }

    static public boolean addArticle(MArticles art, int id_user) throws SQLException {
        boolean success = false;
        try {
            String query = "INSERT INTO nesti_article (name_article,status_article,id_user,brand) VALUES(?,?,?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, art.getName());
            smt.setString(2, art.getStatus_article());
            smt.setInt(3, id_user);
            smt.setString(4, "Nesti");
            boolean executed = smt.executeUpdate() == 1;
            if (art.getType() == "Ustensile") {
                MArticles art_tool = getArticleByNameFromDB(art.getName());
                String query_tool = "INSERT INTO nesti_tool (id_article) VALUES(?)";
                PreparedStatement smt_tool = cnx.prepareStatement(query_tool);
                smt_tool.setInt(1, art_tool.getId());
                smt_tool.executeUpdate();
            } else {
                MArticles art_ingredient = getArticleByNameFromDB(art.getName());
                String query_ingredient = "INSERT INTO nesti_ingredient (id_article) VALUES(?)";
                PreparedStatement smt_ingredient = cnx.prepareStatement(query_ingredient);
                smt_ingredient.setInt(1, art_ingredient.getId());
                smt_ingredient.executeUpdate();
            }
            String query_sold_by = "INSERT INTO sold_by (id_article,id_supplier,origin) VALUES(?,?,?)";
            PreparedStatement smt_sold_by = cnx.prepareStatement(query_sold_by);
            MArticles sold_by_id_article = getArticleByNameFromDB(art.getName());
            smt_sold_by.setInt(1, sold_by_id_article.getId());
            smt_sold_by.setInt(2, DBProvider.getProvidersIdByNameFromDB(art.getProvider()));
            smt_sold_by.setString(3, art.getOrigin());
            smt_sold_by.executeUpdate();
            success = (executed);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return success;
    }

    static public boolean deleteArticleFromTool(int id_article) throws SQLException {

        try {
            String query = "DELETE FROM nesti_tool WHERE id_article=?";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setInt(1, id_article);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    static public boolean deleteArticleFromSoldBy(int id_article) throws SQLException {

        try {
            String query = "DELETE FROM sold_by WHERE id_article =?";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setInt(1, id_article);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    static public boolean deleteArticleFromIngredient(int id_article) throws SQLException {

        try {
            String query = "DELETE FROM nesti_ingredient WHERE id_article=?";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setInt(1, id_article);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    static public boolean updateArticle(MArticles art) throws SQLException {
        boolean success = false;
        int id_art = art.getId();
        System.out.println("id_art" + id_art);
        try {
            String query = "UPDATE nesti_article SET name_article = ?, status_article =  ? WHERE id_article= ?";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, art.getName());
            smt.setString(2, art.getStatus_article());
            smt.setInt(3, id_art);
            smt.executeUpdate();
            if (chekIfToolOrIngredient(id_art) == 1 && art.getType() == "Ustensile") {
                deleteArticleFromIngredientToDB(art.getId());
                MArticles art_tool = getArticleByNameFromDB(art.getName());
                String query_tool = "INSERT INTO nesti_tool (id_article) VALUES(?)";
                PreparedStatement smt_tool = cnx.prepareStatement(query_tool);
                smt_tool.setInt(1, art_tool.getId());
                smt_tool.executeUpdate();
            } else if (chekIfToolOrIngredient(id_art) == 0 && art.getType() == "Ingredient") {
                deleteArticleFromToolToDB(art.getId());
                MArticles art_ingredient = getArticleByNameFromDB(art.getName());
                String query_ingredient = "INSERT INTO nesti_ingredient (id_article) VALUES(?)";
                PreparedStatement smt_ingredient = cnx.prepareStatement(query_ingredient);
                smt_ingredient.setInt(1, art_ingredient.getId());
                smt_ingredient.executeUpdate();
            }
            String query_sold_by = "UPDATE sold_by SET id_supplier = ?,  origin = ? WHERE id_article= ?";
            PreparedStatement smt_sold_by = cnx.prepareStatement(query_sold_by);
            smt_sold_by.setInt(1, DBProvider.getProvidersIdByNameFromDB(art.getProvider()));
            smt_sold_by.setString(2, art.getOrigin());
            smt_sold_by.setInt(3, art.getId());
            smt_sold_by.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return success;
    }

    static public int chekIfToolOrIngredient(int id) {
        int success = 0;
        try {
            String query = "SELECT COUNT(*) FROM nesti_ingredient WHERE id_article ='" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                success = (resultSet.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (success == 0) {
                System.out.println("c'est un ustensile");
            } else {
                System.out.println("c'est un ingrédient");
            }
            return success;
        }
    }

    static public String getOriginByIdArticle(int id) {
        String origin = null;
        try {
            String query = "SELECT origin FROM sold_by WHERE id_article = '" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                origin = resultSet.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return origin;
        }
    }
}
