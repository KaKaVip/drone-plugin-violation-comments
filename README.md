Use this plugin for violation comments to GitHub or Bitbucket.

# Parameters:

- `enable` - true is enable, false is disable
- `createsinglefilecomments` - Create one comment per violation
- `createcommentwithallsinglefilecomments` - Create one big comment with all violations
- `github` - if using for Github service
  * `username` - (`Optional`) This GitHub user. `*`
  * `password` - (`Optional`) This GitHub password. `*`
  * `token` - (`Optional`) This GitHub token. `*` `**`
- `bitbucket` - if using for Bitbucket service
  * `username` - This Bitbucket user. `*`
  * `password` - This Bitbucket password. `*`
  * `projectkey` - This Bitbucket project key. `*`


`*` Use **Drone Secret** . More detail at http://readme.drone.io/usage/secrets/

`**` Github service Authentication can be done by supplying username/password or OAuth2Token in the builder.
 Easy to create a GitHub OAuth2 token.

 ```CMD
 curl -u 'yourgithubuser' -d '{"note":"Violation comments"}' https://api.github.com/authorizations
 ```

# Example

The following is a sample configuration in your .drone.yml file:

```YML
notify:
  violationcomments:
    image: kakavip/drone-violation-comments
    enable: true
    createsinglefilecomments: true
    createCommentWithAllSingleFileComments: true
    commentOnlyChangedContent: true
    github:
      username: $$GITHUB_USERNAME
      password: $$GITHUB_PASSWORD
      token: $$GITHUB_TOKEN
    bitbucket:
      username: $$BITBUCKET_USERNAME
      password: $$BITBUCKET_PASSWORD
      projectkey: $$BITBUCKET_PROJECTKEY
    violations:
      checkstyle: .*/checkstyle/.*\\.xml$
      findbugs: .*/findbugs/.*\\.xml$
      pmd: .*/pmd/.*\\.xml$
      androidlint: .*/androidlint/.*\\.xml$
      csslint: .*/csslint/.*\\.xml$
      jshint: .*/jshint/.*\\.xml$
      lint: .*/lint/.*\\.xml$
      cppcheck: .*/cppcheck/.*\\.xml$
      reshaprper: .*/reshaprper/.*\\.xml$
      flake8: .*/flake8/.*\\.xml$
      cpplint: .*/cpplint/.*\\.xml$
      xmllint: .*/xmllint/.*\\.xml$
      perlcritic: .*/perlcritic/.*\\.xml$
      pitest: .*/pitest/.*\\.xml$
```
