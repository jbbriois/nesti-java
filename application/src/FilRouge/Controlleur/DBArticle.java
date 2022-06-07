package FilRouge.Controlleur;

import FilRouge.Model.MArticles;
import static FilRouge.Model.MArticles.addArticle;
import static FilRouge.Model.MArticles.chekIfToolOrIngredient;
import static FilRouge.Model.MArticles.deleteArticleByName;
import static FilRouge.Model.MArticles.deleteArticleFromIngredient;
import static FilRouge.Model.MArticles.deleteArticleFromTool;
import static FilRouge.Model.MArticles.getArticleById;
import static FilRouge.Model.MArticles.getArticleByName;
import static FilRouge.Model.MArticles.getArticleByNameDetails;
import static FilRouge.Model.MArticles.updateArticle;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBArticle {

    /**
     * request to get all article from DB     
     * @return an array of article
     * @throws SQLException sql 
     */
    static public ArrayList getArticlesFromDB() throws SQLException {
     
        MArticles art = new MArticles();
        ArrayList<MArticles> arr = new ArrayList<>();;
        arr = art.getArticles();
        return arr;
    }

    /**
     * request to get all article from DB where status is available
     *
     * @return an array of article
     * @throws SQLException  sql
     */
    static public ArrayList getArticlesForCommandFromDB() throws SQLException {
        MArticles art = new MArticles();
        ArrayList<MArticles> arr = new ArrayList<>();;
        arr = art.getArticlesForCommand();
        return arr;
    }

    /**
     * request to get all article for research
     *
     * @param search String
     * @return nothing
     * @throws SQLException sql
     */
    static public ArrayList searchArticlesFromDB(String search) throws SQLException {
        MArticles art = new MArticles();
        ArrayList<MArticles> arr = new ArrayList<>();;
        arr = art.searchArticles(search);
        return arr;

    }

    /**
     * request to get all article for research where status is available
     *
     * @param search string
     * @return array of articles
     * @throws SQLException sql
     */
    static public ArrayList searchArticlesForCcmmandFromDB(String search) throws SQLException {
        MArticles art = new MArticles();
        ArrayList<MArticles> arr = new ArrayList<>();;
        arr = art.searchArticlesForCommand(search);
        return arr;

    }

    /**
     * get an article by name with few information
     * @param article string
     * @return article 
     */
    static public MArticles getArticleByNameFromDB(String article) {
        MArticles art = new MArticles();
        art = getArticleByName(article);
        return art;
    }
    
    /**
     * get an article by name with all information
     * @param article string
     * @return article
     */

    static public MArticles getArticleByNameDetailsFromDB(String article) {
        MArticles art = new MArticles();
        art = getArticleByNameDetails(article);
        return art;

    }
    
    /**
     * get an article by id 
     * @param id int
     * @return article 
     */

    static public MArticles getArticleByIdFromDB(int id) throws SQLException {
        MArticles art = new MArticles();
        art = getArticleById(id);
        return art;

    }

    
    /**
     * delete an article by name 
     * @param article string
     * @return nothing
     */
    static public boolean deleteArticleByNameFromDB(String article) {
        boolean success = false;
        deleteArticleByName(article);
        return success;

    }
    
    /**
     * add article to DB
     * @param art object article
     * @param id_user int
     * @return nothing
     * @throws SQLException  sql
     */

    static public boolean addArticleToDB(MArticles art, int id_user) throws SQLException {
        boolean success = false;
        addArticle(art, id_user);
        return success;
    }
    
    /**
     * delete article from table tool
     * @param id_article int
     * @return nothing
     * @throws SQLException sql
     */

    static public boolean deleteArticleFromToolToDB(int id_article) throws SQLException {
        boolean success = false;
        deleteArticleFromTool(id_article);
        return success;
    }

    /**
     * delete article from table ingredient
     * @param id_article int 
     * @return nothing
     * @throws SQLException sql
     */
    static public boolean deleteArticleFromIngredientToDB(int id_article) throws SQLException {
        boolean success = false;
        deleteArticleFromIngredient(id_article);
        return success;
    }

    /**
     * update an article
     * @param art object article
     * @return nothing
     * @throws SQLException sql
     */
    static public boolean updateArticleToDB(MArticles art) throws SQLException {
        boolean success = false;
        updateArticle(art);
        return success;
    }

    /**
     * 0 if it's a tool, 1 for an ingredient
     * @param id int article
     * @return int 1 or 0
     */
    static public int chekIfToolOrIngredientFromDB(int id) {
        int success = chekIfToolOrIngredient(id);
        return success;
    }

    /**
     * get an article by name with all information
     * @param article string
     * @return article
     */
    static public MArticles getArticleByNameFullDetailsFromDB(String article) {
        MArticles art = new MArticles();
        art = MArticles.getArticleByNameFullDetails(article);
        return art;
    }
    
    /**
     * return a String of the origin of the article
     * @param id int
     * @return string origin
     */

    static public String getOriginByIdArticleFromDB(int id) {
        String origin = null;
        origin = MArticles.getOriginByIdArticle(id);
        return origin;
    }
}
