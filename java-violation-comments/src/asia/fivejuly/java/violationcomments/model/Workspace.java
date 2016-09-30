package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Workspace implements Serializable {
    private String root;
    private String path;
    private Keys keys;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Keys getKeys() {
        return keys;
    }

    public void setKeys(Keys keys) {
        this.keys = keys;
    }
}
