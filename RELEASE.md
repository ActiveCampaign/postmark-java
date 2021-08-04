<a href="https://postmarkapp.com">
    <img src="postmark.png" alt="Postmark Logo" title="Postmark" width="120" height="120" align="right">
</a>

# Release process

When releasing a new version of the library, make sure to follow these steps:

Pre-release recommendations:

* Make sure to check if there are any styling or code errors

Release steps:

1. Make sure the tests pass for your branch in CI 
1. Merge your branch to master
1. Determine the next version of the library by following the [SemVer](https://semver.org/) guidelines
1. Update version pom.xml
1. Compile the latest version
1. Make sure the tests pass locally
1. Update CHANGELOG.md with the latest release details
1. Push the changes to Github and wait for tests to pass in CI
1. Push the changes to maven repository and release 
1. Update any related content in the [Github wiki](https://github.com/wildbit/postmark-java/wiki)
1. Add release version in the [Github releases](https://github.com/wildbit/postmark-java/releases) so it has a tag.
