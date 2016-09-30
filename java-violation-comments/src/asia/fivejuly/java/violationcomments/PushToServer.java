package asia.fivejuly.java.violationcomments;

import se.bjurr.violations.comments.bitbucketserver.lib.ViolationCommentsToBitbucketServerApi;
import se.bjurr.violations.comments.github.lib.ViolationCommentsToGitHubApi;
import se.bjurr.violations.lib.ViolationsReporterApi;
import se.bjurr.violations.lib.model.Violation;
import se.bjurr.violations.lib.reports.Reporter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class PushToServer {

    enum MODE {
        GITHUB,
        BITBUCKET
    }

    private ViolationCommentsToGitHubApi violationCommentsToGitHubApi;
    private ViolationCommentsToBitbucketServerApi violationCommentsToBitbucketServerApi;
    private List<Violation> allParsedViolations = new ArrayList();
    private MODE mode;

    PushToServer(MODE mode) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi = ViolationCommentsToGitHubApi.violationCommentsToGitHubApi();
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi
                    = ViolationCommentsToBitbucketServerApi.violationCommentsToBitbucketServerApi();
        }
    }

    public static PushToServer withGithub(String userName,
                                          String passWord,
                                          String oAuth2Token,
                                          String repositoryOwner,
                                          String repositoryName,
                                          int pullRequestId) {
        return new PushToServer(MODE.GITHUB)
                .withUsername(userName)
                .withPassword(passWord)
                .usingOAuth2Token(oAuth2Token)
                .withRepositoryName(repositoryName)
                .withRepositoryOwner(repositoryOwner)
                .withPullRequestId(pullRequestId);
    }

    public static PushToServer withBitbucket(String userName,
                                            String passWord,
                                            String projectKey,
                                            String repoSlug,
                                            int pullRequestId) {
        return new PushToServer(MODE.BITBUCKET)
                .withUsername(userName)
                .withPassword(passWord)
                .withProjectKey(projectKey)
                .withRepoSlug(repoSlug)
                .withPullRequestId(pullRequestId);
    }

    public PushToServer withUsername(String username) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi.withUsername(username);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withUsername(username);
        }
        return this;
    }

    public PushToServer withPassword(String password) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi.withPassword(password);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withPassword(password);
        }
        return this;
    }

    public PushToServer usingOAuth2Token(String token) {
        if (mode.equals(MODE.GITHUB) && token != null && !token.isEmpty()) {
            violationCommentsToGitHubApi.withoAuth2Token(token);
        }
        return this;
    }

    public PushToServer withRepositoryOwner(String repositoryOwner) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi.withRepositoryOwner(repositoryOwner);
        }
        return this;
    }

    public PushToServer withRepositoryName(String repositoryName) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi.withRepositoryName(repositoryName);
        }
        return this;
    }

    public PushToServer withProjectKey(String projectKey) {
        if (mode.equals(MODE.BITBUCKET)) {
            violationCommentsToBitbucketServerApi.withProjectKey(projectKey);
        }
        return this;
    }

    public PushToServer withRepoSlug(String repoSlug) {
        if (mode.equals(MODE.BITBUCKET)) {
            violationCommentsToBitbucketServerApi.withRepoSlug(repoSlug);
        }
        return this;
    }

    public PushToServer withPullRequestId(int pullRequestId) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi .withPullRequestId(pullRequestId);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withPullRequestId(pullRequestId);
        }
        return this;
    }

    public PushToServer withCreateSingleFileComments(boolean createSingleFileComments) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi .withCreateSingleFileComments(createSingleFileComments);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withCreateSingleFileComments(createSingleFileComments);
        }
        return this;
    }

    public PushToServer withCommentOnlyChangedContent(boolean commentOnlyChangedContent) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi .withCommentOnlyChangedContent(commentOnlyChangedContent);
        }
        return this;
    }

    public PushToServer withCreateCommentWithAllSingleFileComments(boolean createCommentWithAllSingleFileComments) {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi .withCreateCommentWithAllSingleFileComments(createCommentWithAllSingleFileComments);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withCreateCommentWithAllSingleFileComments(createCommentWithAllSingleFileComments);
        }
        return this;
    }

    public PushToServer withViolations(String pattern, Reporter reporter, String rootFolder) {
        List<Violation> violationList = ViolationsReporterApi
                .violationsReporterApi()
                .withPattern(pattern)
                .findAll(reporter).inFolder(rootFolder)
                .violations();
        allParsedViolations.addAll(violationList);
        return this;
    }

    public void toPullRequest() {
        if (mode.equals(MODE.GITHUB)) {
            violationCommentsToGitHubApi.withViolations(allParsedViolations);
        } else if (mode.equals(MODE.BITBUCKET)){
            violationCommentsToBitbucketServerApi.withViolations(allParsedViolations);
        }
    }

}
