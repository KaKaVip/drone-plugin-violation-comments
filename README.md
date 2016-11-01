Use this plugin for violation comments to GitHub or Bitbucket.

Link Docker Hub [fdplugins/violation-comments](https://hub.docker.com/r/fdplugins/violation-comments/)

# Environment:

- `ENABLE` - true is enable, false is disable
- `COMMENT_ONLY_CHANGED_CONTENT` - Create one comment per violation
- `CREATE_SINGLE_FILE_COMMENTS` - Comment only changed part of files
- `CREATE_COMMENT_WITH_ALL_SINGLE_FILE_COMMENTS` - Create one big comment with all violations
- `GITHUB_TOKEN` - (`Optional`) This GitHub token. `*` `**`
- `GITHUB_USERNAME` - (`Optional`) This GitHub user. `*`
- `GITHUB_PASSWORD` - (`Optional`) This GitHub user. `*`
- `VIOLATION_{FORMAT}` - (`Optional`) See example in below.

`*` Use **Drone Secret** . More detail at http://readme.drone.io/usage/secrets/

`**` Github service Authentication can be done by supplying username/password or OAuth2Token in the builder.
 Easy to create a GitHub OAuth2 token.

 ```CMD
 curl -u 'your github user' -d '{
  "scopes": [
    "repo",
    "public_repo",
    "repo_deployment",
    "repo:status"
  ],
  "note": "Framgia CI/CD comments to github"
}' https://api.github.com/authorizations
 ```

# Example

The following is a sample configuration in your .drone.yml file:

```YML
build:
  violationcomments:
    image: fdplugins/violation-comments:latest
    environment:
      - ENABLE=true
      - GITHUB_TOKEN=$$GITHUB_TOKEN
      - CREATE_SINGLE_FILE_COMMENTS=true
      - CREATE_COMMENT_WITH_ALL_SINGLE_FILE_COMMENTS=false
      - COMMENT_ONLY_CHANGED_CONTENT=true
      - VIOLATION_CHECKSTYLE=.*/reports/checkstyle/.*\\.xml$
      - VIOLATION_CSSLINT=.*/reports/csslint/.*\\.xml$
      - VIOLATION_LINT=.*/reports/lint/.*\\.xml$
      - VIOLATION_FINDBUGS=.*/reports/findbugs/.*\\.xml$
      - VIOLATION_JSHINT=.*/reports/jshint/.*\\.xml$
      - VIOLATION_PMD=.*/reports/pmd/.*\\.xml$
      - VIOLATION_CPPCHECK=.*/reports/cppcheck/.*\\.xml$
      - VIOLATION_RESHARPER=.*/reports/reshaprper/.*\\.xml$
      - VIOLATION_FLAKE8=.*/reports/flake8/.*\\.xml$
      - VIOLATION_CPPLINT=.*/reports/cpplint/.*\\.xml$
      - VIOLATION_XMLLINT=.*/reports/xmllint/.*\\.xml$
      - VIOLATION_PERLCRITIC=.*/reports/perlcritic/.*\\.xml$
      - VIOLATION_PITEST=.*/reports/pitest/.*\\.xml$
      - VIOLATION_ANDROIDLINT=.*/reports/androidlint/.*\\.xml$
    commands:
      - violationcomments
```

For only checkstyle:

```YML
build:
  violationcomments:
    image: fdplugins/violation-comments:latest
    environment:
      - ENABLE=true
      - GITHUB_TOKEN=$$GITHUB_TOKEN
      - CREATE_SINGLE_FILE_COMMENTS=true
      - CREATE_COMMENT_WITH_ALL_SINGLE_FILE_COMMENTS=false
      - COMMENT_ONLY_CHANGED_CONTENT=true
      - VIOLATION_CHECKSTYLE=.*/reports/checkstyle/.*\\.xml$
    commands:
    - violationcomments
```
