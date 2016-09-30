package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/30/16.
 */
public class Bitbucket implements Serializable {
    private String username;
    private String password;
    private String projectkey;

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

    public String getProjectkey() {
        return projectkey;
    }

    public void setProjectkey(String projectkey) {
        this.projectkey = projectkey;
    }
}
