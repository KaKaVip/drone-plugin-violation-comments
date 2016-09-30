package asia.fivejuly.java.violationcomments.model;

import java.io.Serializable;

/**
 * Created by pham.quy.hai on 9/30/16.
 */
public class Violations implements Serializable{
    private String checkstyle;
    private String findbugs;
    private String pmd;
    private String androidlint;
    private String csslint;
    private String jshint;
    private String lint;
    private String cppcheck;
    private String reshaprper;
    private String flake8;
    private String cpplint;
    private String xmllint;
    private String perlcritic;
    private String pitest;

    public String getCheckstyle() {
        return checkstyle;
    }

    public void setCheckstyle(String checkstyle) {
        this.checkstyle = checkstyle;
    }

    public String getFindbugs() {
        return findbugs;
    }

    public void setFindbugs(String findbugs) {
        this.findbugs = findbugs;
    }

    public String getPmd() {
        return pmd;
    }

    public void setPmd(String pmd) {
        this.pmd = pmd;
    }

    public String getAndroidlint() {
        return androidlint;
    }

    public void setAndroidlint(String androidlint) {
        this.androidlint = androidlint;
    }

    public String getCsslint() {
        return csslint;
    }

    public void setCsslint(String csslint) {
        this.csslint = csslint;
    }

    public String getJshint() {
        return jshint;
    }

    public void setJshint(String jshint) {
        this.jshint = jshint;
    }

    public String getLint() {
        return lint;
    }

    public void setLint(String lint) {
        this.lint = lint;
    }

    public String getCppcheck() {
        return cppcheck;
    }

    public void setCppcheck(String cppcheck) {
        this.cppcheck = cppcheck;
    }

    public String getReshaprper() {
        return reshaprper;
    }

    public void setReshaprper(String reshaprper) {
        this.reshaprper = reshaprper;
    }

    public String getFlake8() {
        return flake8;
    }

    public void setFlake8(String flake8) {
        this.flake8 = flake8;
    }

    public String getCpplint() {
        return cpplint;
    }

    public void setCpplint(String cpplint) {
        this.cpplint = cpplint;
    }

    public String getXmllint() {
        return xmllint;
    }

    public void setXmllint(String xmllint) {
        this.xmllint = xmllint;
    }

    public String getPerlcritic() {
        return perlcritic;
    }

    public void setPerlcritic(String perlcritic) {
        this.perlcritic = perlcritic;
    }

    public String getPitest() {
        return pitest;
    }

    public void setPitest(String pitest) {
        this.pitest = pitest;
    }
}
