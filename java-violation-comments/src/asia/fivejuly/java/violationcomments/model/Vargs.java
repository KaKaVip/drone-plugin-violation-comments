package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Vargs implements Serializable {
    private boolean enable;
    private boolean createsinglefilecomments;
    private boolean createCommentWithAllSingleFileComments;
    private boolean commentOnlyChangedContent;
    private Github github;
    private Bitbucket bitbucket;
    private Violations violations;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isCreatesinglefilecomments() {
        return createsinglefilecomments;
    }

    public void setCreatesinglefilecomments(boolean createsinglefilecomments) {
        this.createsinglefilecomments = createsinglefilecomments;
    }

    public boolean isCreateCommentWithAllSingleFileComments() {
        return createCommentWithAllSingleFileComments;
    }

    public void setCreateCommentWithAllSingleFileComments(boolean createCommentWithAllSingleFileComments) {
        this.createCommentWithAllSingleFileComments = createCommentWithAllSingleFileComments;
    }

    public boolean isCommentOnlyChangedContent() {
        return commentOnlyChangedContent;
    }

    public void setCommentOnlyChangedContent(boolean commentOnlyChangedContent) {
        this.commentOnlyChangedContent = commentOnlyChangedContent;
    }

    public Github getGithub() {
        return github;
    }

    public void setGithub(Github github) {
        this.github = github;
    }

    public Bitbucket getBitbucket() {
        return bitbucket;
    }

    public void setBitbucket(Bitbucket bitbucket) {
        this.bitbucket = bitbucket;
    }

    public Violations getViolations() {
        return violations;
    }

    public void setViolations(Violations violations) {
        this.violations = violations;
    }
}
