package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Drone implements Serializable {
    private System system;
    private Repo repo;
    private Build build;
    private Workspace workspace;
    private Vargs vargs;

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Vargs getVargs() {
        return vargs;
    }

    public void setVargs(Vargs vargs) {
        this.vargs = vargs;
    }
}
