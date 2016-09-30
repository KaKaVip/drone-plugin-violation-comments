package asia.fivejuly.java.violationcomments;

import asia.fivejuly.java.violationcomments.model.Drone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import se.bjurr.violations.lib.reports.Reporter;

/**
 * Created by pham.quy.hai on 9/29/16.
 */
public class Main {

    public void main(String[] args) {
        System.out.println("--- Start Violation Comments ---");
        if (args != null && args.length > 0) {
            System.out.println("--- Parser Drone Json ---");

            Gson gson = new GsonBuilder().serializeNulls().create();

            try {
                Drone drone = gson.fromJson(args[0],Drone.class);
                if (drone.getVargs().isEnable()) {
                    pushAction(drone);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("--- Index = 0 ---");
        }
        int index;

        for (index = 0; index < args.length; ++index)
        {
            System.out.println("args[" + index + "]: " + args[index]);
        }
        System.out.println("--- End Violation Comments ---");
    }

    private void pushAction(Drone drone) {
        PushToServer pushToServer = null;
        if (drone.getVargs().getGithub() != null) {
            pushToServer = PushToServer.withGithub(
                    drone.getVargs().getGithub().getUsername(),
                    drone.getVargs().getGithub().getPassword(),
                    drone.getVargs().getGithub().getToken(),
                    drone.getRepo().getOwner(),
                    drone.getRepo().getName(),
                    0
            );
        } else if (drone.getVargs().getBitbucket() != null) {
           // Next version
        }

        if (pushToServer != null) {
            pushToServer
                    .withCreateCommentWithAllSingleFileComments(drone.getVargs().isCreateCommentWithAllSingleFileComments())
                    .withCreateSingleFileComments(drone.getVargs().isCreatesinglefilecomments())
                    .withCommentOnlyChangedContent(drone.getVargs().isCommentOnlyChangedContent())
                    .withViolations(drone.getVargs().getViolations().getCheckstyle(), Reporter.CHECKSTYLE,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getFindbugs(), Reporter.FINDBUGS,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getPmd(), Reporter.PMD,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getAndroidlint(), Reporter.ANDROIDLINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getCsslint(), Reporter.CSSLINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getJshint(), Reporter.JSHINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getLint(), Reporter.LINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getCppcheck(), Reporter.CPPCHECK,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getReshaprper(), Reporter.RESHARPER,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getFlake8(), Reporter.FLAKE8,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getCpplint(), Reporter.CPPLINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getXmllint(), Reporter.XMLLINT,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getPerlcritic(), Reporter.PERLCRITIC,drone.getWorkspace().getPath())
                    .withViolations(drone.getVargs().getViolations().getPitest(), Reporter.PITEST,drone.getWorkspace().getPath())
                    .toPullRequest();
        }
    }
}
