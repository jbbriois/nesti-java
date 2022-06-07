
package FilRouge.Model;


public class MLogin {
    
    int id;
    String username;
    String password;
    boolean login;
    int id_role;

    
    public MLogin() {
    }
    

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", username=" + username + ", password=" + password + ", login=" + login + ", id_role=" + id_role + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    
}
