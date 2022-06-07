package FilRouge.Model;


import FilRouge.Controlleur.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MProvider {

        static Connection cnx = DBConnect.connect();

    int provider_id;
    int provider_id_contact;
    String provider_name;
    String provider_adress;

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public int getProvider_id_contact() {
        return provider_id_contact;
    }

    public void setProvider_id_contact(int provider_id_contact) {
        this.provider_id_contact = provider_id_contact;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_adress() {
        return provider_adress;
    }

    public void setProvider_adress(String provider_adress) {
        this.provider_adress = provider_adress;
    }

    @Override
    public String toString() {
        return "MProvider{" + "provider_id=" + provider_id + ", provider_id_contact=" + provider_id_contact + ", provider_name=" + provider_name + ", provider_adress=" + provider_adress + '}';
    }

    public MProvider() {
    }

    static public ArrayList getProviders() {
        ArrayList<MProvider> arr = new ArrayList<>();
        MProvider pro = null;
        try {
            String query = "SELECT  id_supplier, address_supplier , name_supplier, id_contact FROM nesti_supplier";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                pro = new MProvider();
                pro.setProvider_id(resultSet.getInt(1));
                pro.setProvider_adress(resultSet.getString(2));
                pro.setProvider_name(resultSet.getString(3));
                pro.setProvider_id_contact(resultSet.getInt(4));
                arr.add(pro);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return arr;
        }
    }

    static public MProvider getAProviderById(int id) {
        MProvider pro = new MProvider();
        try {
            String query = "SELECT  id_supplier, address_supplier , name_supplier, id_contact FROM nesti_supplier WHERE id_supplier ='" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                pro.setProvider_id(resultSet.getInt(1));
                pro.setProvider_adress(resultSet.getString(2));
                pro.setProvider_name(resultSet.getString(3));
                pro.setProvider_id_contact(resultSet.getInt(4));
            }
            System.out.println(pro.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return pro;
        }

    }

    static public MProvider getProviderByName(String name) {
        MProvider pro = new MProvider();
        try {
            String query = "SELECT  id_supplier, address_supplier , name_supplier, id_contact FROM nesti_supplier WHERE name_supplier ='" + name + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                pro.setProvider_id(resultSet.getInt(1));
                pro.setProvider_adress(resultSet.getString(2));
                pro.setProvider_name(resultSet.getString(3));
                pro.setProvider_id_contact(resultSet.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return pro;
        }

    }

    static public ArrayList getProvidersArrayList() {
        ArrayList<String> provider_table = new ArrayList<>();
        try {
            String query = "SELECT  name_supplier FROM nesti_supplier";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                provider_table.add(resultSet.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return provider_table;
        }

    }

    static public String getProvidersNameById(int id) {
        String provider = null;
        try {
            String query = "SELECT name_supplier  FROM nesti_supplier WHERE id_supplier = '" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                provider = resultSet.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return provider;
        }
    }

    static public int getProvidersIdByName(String name) {
        int provider = 0;
        try {
            String query = "SELECT  id_supplier  FROM nesti_supplier WHERE name_supplier= '" + name + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                provider = resultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return provider;
        }
    }

    static public int getProvidersIdByIdArticle(int id) {
        int provider = 0;
        try {
            String query = "SELECT id_supplier FROM sold_by WHERE id_article = '" + id + "'";
            Statement smt = cnx.createStatement();
            ResultSet resultSet = smt.executeQuery(query);
            while (resultSet.next()) {
                provider = resultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return provider;
        }
    }

    static public boolean addProvider(MProvider pro) throws SQLException {
        boolean success = false;
        try {
            String query = "INSERT INTO nesti_supplier (address_supplier,name_supplier,id_contact) VALUES(?,?,?)";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, pro.getProvider_adress());
            smt.setString(2, pro.getProvider_name());
            smt.setInt(3, pro.getProvider_id_contact());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    static public boolean updateProvider(MProvider pro) throws SQLException {
        boolean success = false;
        try {
            String query = "UPDATE nesti_supplier SET name_supplier = ?, address_supplier =  ?, id_contact = ? WHERE id_supplier= ?";
            PreparedStatement smt = cnx.prepareStatement(query);
            smt.setString(1, pro.getProvider_name());
            smt.setString(2, pro.getProvider_adress());
            smt.setInt(3, pro.getProvider_id_contact());
            smt.setInt(4, pro.getProvider_id());
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return success;
    }

    static public boolean deleteProviderById(int id_provider) {
        boolean success = false;
        try {
            String query = "DELETE FROM nesti_supplier WHERE id_supplier ='" + id_provider + "'";
            Statement smt = cnx.createStatement();
            smt.executeUpdate(query);            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return success;
        }
    }
    
}
