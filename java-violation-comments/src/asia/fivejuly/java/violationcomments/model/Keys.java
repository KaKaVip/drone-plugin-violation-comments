package asia.fivejuly.java.violationcomments.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Keys implements Serializable {
    @SerializedName("private")
    private String private_key;

    public String getPrivate() {
        return private_key;
    }

    public void setPrivate(String private_key) {
        this.private_key = private_key;
    }
}
