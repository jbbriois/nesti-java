package FilRouge.Controlleur;

import FilRouge.Model.MProvider;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBProvider {


    static public ArrayList getProvidersFromDB() {
        ArrayList<MProvider> arr = new ArrayList<>();
        arr = MProvider.getProviders();
        return arr;
    }

    static public MProvider getAProviderByIdFromDB(int id) {
        MProvider pro = new MProvider();
        pro = MProvider.getAProviderById(id);
        return pro;
    }

    static public MProvider getProviderByNameFromDB(String name) {
        MProvider pro = new MProvider();
        pro = MProvider.getProviderByName(name);
        return pro;
    }

    static public ArrayList getProvidersArrayListFromDB() {
        ArrayList<String> provider_table = new ArrayList<>();
        provider_table = MProvider.getProvidersArrayList();
        return provider_table;

    }

    static public String getProvidersByIdFromDB(int id) {
        String provider = null;
        provider = MProvider.getProvidersNameById(id);
        return provider;
    }

    static public int getProvidersIdByNameFromDB(String name) {
        int provider = 0;
        provider = MProvider.getProvidersIdByName(name);
        return provider;
    }

    static public int getProvidersIdByIdArticleFromDB(int id) {
        int provider = 0;
        provider = MProvider.getProvidersIdByIdArticle(id);
        return provider;

    }

    static public boolean addProviderToDB(MProvider pro) throws SQLException {
        boolean success = false;
        MProvider.addProvider(pro);
        return success;
    }

    static public boolean updateProvider(MProvider pro) throws SQLException {
        boolean success = false;
        MProvider.updateProvider(pro);
        return success;
    }

    static public boolean deleteProviderByIdToDB(int id_provider) {
        boolean success = false;
        MProvider.deleteProviderById(id_provider);
        return success;
    }

}
