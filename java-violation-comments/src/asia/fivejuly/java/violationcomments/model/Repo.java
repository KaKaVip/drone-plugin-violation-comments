package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Repo implements Serializable {
    private String owner;
    private String name;
    private String full_name;
    private String link_url;
    private String clone_url;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }
}
