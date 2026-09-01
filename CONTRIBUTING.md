# Contribution Guidelines

<!-- Links -->
[fork]: https://github.com/NeoTamia/kotlin-template/fork
[pr]: https://github.com/NeoTamia/kotlin-template/compare
[issues]: https://github.com/NeoTamia/kotlin-template/issues
[fork-pr-process]: https://gist.github.com/Chaser324/ce0505fbed06b947d962
[table-of-contents]: #table-of-contents
[code-of-conduct]: CODE_OF_CONDUCT.md
[releases]: https://github.com/NeoTamia/kotlin-template/releases

First off, thanks for taking the time to contribute! ❤️

Welcome! We love receiving contributions from our community, so thanks for stopping by! </br>
There are many ways to contribute, see the [Table of Contents][table-of-contents] for different ways to help and details about how this project handles them. </br>

Please make sure to read the relevant section before making your contribution. It will make it a lot easier for us maintainers and smooth out the experience for all involved. The community looks forward to your contributions. 🎉

This document describes our development process. Following these guidelines shows that you respect the time and effort of the developers managing this project. In return, you will be shown respect in addressing your issue, reviewing your changes, and incorporating your contributions.

## Table of Contents

1. [Code of Conduct](#code-of-conduct)
2. [Questions](#questions)
3. [Feature Requests](#feature-requests)
4. [Improving Documentation](#improving-documentation)
5. [Reporting Bugs](#reporting-bugs)
6. [Contributing Code](#contributing-code)
    1. [Legal Notice](#legal-notice)
    2. [Getting Started](#getting-started)
    3. [Finding an Issue!](#finding-an-issue)
    4. [Development Process](#development-process)
       1. [Branches Usage](#branches-usage)
       2. [CLI Commands](#cli-commands)
    5. [Building the Project](#building-the-project)
    6. [Testing](#testing)
    7. [Style Guidelines](#style-guidelines)
       1. [Code Formatting Rules](#code-formatting)
       2. [AI Agent Guidelines](#ai-agent-guidelines)
       3. [Branch Names](#branch-names)
       4. [Whitespace Cleanup](#whitespace-cleanup)
       5. [Git Commit Guidelines](#git-commit-guidelines)
7. [Pull Request Guidelines](#pull-request-process)
    1. [Addressing Feedback](#addressing-feedback)

## Code of Conduct

By participating in this project, you agree to abide by our [Code of Conduct][code-of-conduct]. We expect all contributors to follow the [Code of Conduct][code-of-conduct] and to treat fellow humans with respect.

## Questions

> If you want to ask a question please, read the **documentation** first.

Before asking a question, search among the [issues] already existing, some could help you. </br>
If you have found a suitable issue and still need clarification, you can write your question in this issue. </br>
It is also advisable to search for answers on the Internet first.

If you then still feel the need to ask a question and need clarification, we recommend the following:

- Open an [Issue][issues] using the question template.
- Provide as much context as you can about what you're running into.
- Provide project and platform versions (IDE, compiler, operating system), depending on what seems relevant.

We will then take care of the [issue][issues] as soon as possible.

## Feature Requests

Please create a new [GitHub issue][issues] for any major changes and enhancements that you wish to make.
Please provide the feature you would like to see, why you need it, and how it will work.
Discuss your ideas transparently and get community feedback before proceeding.

If you want to add a feature, feel free to create the [issue][issues] before and then link it to your [Pull Request][pr].

Major Changes that you wish to contribute to the project should be discussed first in a [GitHub issue][issues] that clearly outlines the changes and benefits of the feature.

Small Changes can directly be crafted and submitted to the GitHub Repository as a [Pull Request][pr]. See the section about [Pull Request Submission Guidelines](#pull-request-process), and for detailed information the core development documentation.

> **Note**
> Please use the issue template when submitting an issue.

## Reporting Bugs

**If you find a security vulnerability, do NOT open an issue. Email `security@neotamia.re` instead.**

Before you submit your issue, please [search the issue archive][issues] - maybe your question or issue has already been identified or addressed.

If you find a bug in the source code, you can help us by [submitting an issue to our GitHub issue tracker][issues]. Even better, you can submit a [Pull Request][pr] with a fix.

> **Note**
> Please use the issue template when submitting an issue.

## Improving Documentation

Should you have a suggestion for the documentation, you can open an [issue][issues] and outline the problem or improvement you have - however, creating the doc fix yourself is much better!

If you want to help improve the docs, it's a good idea to let others know what you're working on to minimize duplication of effort.
Create a new [issue][issues] (or comment on a related existing one) to let others know what you're working on.
If you're making a small change (typo, phrasing), don't worry about filing an issue first.

## Contributing Code

### Legal Notice
When contributing to this project, you must agree that you have authored 100% of the content, that you have the necessary rights to the content and that the content you contribute may be provided under the project license.

### Getting Started

Install these dependencies:

- JDK 21 or higher
- Git

You will need to [fork] the main repository to work on your changes.
Navigate to our GitHub page and click the "[Fork][fork]" button at the top.
Once you've forked the repository, you can clone your new repository and start making edits.

In git, it is best to isolate each topic or feature into a "topic branch".
While individual commits allow you to control over how small individual changes are made to the code, branches are a great way to group a set of commits all related to one feature together, or to isolate different efforts when you might be working on multiple topics at the same time.

While it takes some experience to get the right feel about how to break up commits, a topic branch should be limited in scope to a single issue

```bash
# Checkout the dev branch - you want your new branch to come from dev
git checkout dev

# Create a new branch named newfeature (give your branch its own simple informative name)
git branch feature/newfeature

# Switch to your new branch
git checkout feature/newfeature
```

For more information on the **GitHub fork** and **pull-request processes**, [please see this helpful guide][fork-pr-process].

### Finding an Issue

The list of outstanding feature requests and bugs can be found on our [GitHub issue tracker][issues].
Pick an unassigned issue that you think you can accomplish and add a comment that you are attempting to do it.

- `🐛 bug` labeled issues are bugs that need to be fixed
- `📚 documentation` labeled issues must only touch documentation
- `❓ question` labeled issues are questions that need to be answered
- `🆘 help wanted` labeled issues may be more difficult and may include new feature development
- `🚫 wontfix` labeled issues are issues that will not be fixed
- `✔️ good first issue` labeled issues are issues that are good for first time contributors
- `✨ feature` labeled issues are feature requests that need to be implemented
- `✨ potential feature` labeled issues are feature requests that may be implemented
- `➕ added` labeled issues are issues that have been added to the project
- `🔃 duplicate` labeled issues are duplicates of other issues
- `🚧 W.I.P` labeled issues are issues that are currently being worked on
- `🚫 invalid` labeled issues are issues that are invalid

### Development Process

This project follows the [git flow](http://nvie.com/posts/a-successful-git-branching-model/) branching model of product development.

> **Note**
> While we follow git flow for branching, releases and changelog generation are automated using **release-please**.

- Main: **main** (Latest stable release)
- Dev: **dev** (Latest development version)
- Feature: **feature/feature-name** (Used to develop a new feature)
- HotFix: **hotfix/fix-name** (Used to fix an issue from the main branch)
- Release: **release/release-name** (Used for a new release, managed by release-please)
- BugFix: **bugfix/fix-name** (Used to fix an issue)
- Experimental: **experimental/exp-name** (Should be used for testing something)

You should be using the **main** branch for the most stable release; please review [release notes][releases] regularly.
If you want to keep up with the latest changes, we work in the `dev` branch.

More information about the git flow can be found [here](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)

#### Branches usage

- **main** branch is used for the latest stable release
- **dev** branch is used for the latest development version
- **feature/feature-name**:
  - Used to develop a new feature from the dev branch
  - Always merge into the dev branch never into the main branch
- **hotfix/fix-name**:
  - Used to fix an issue from the main branch
  - When the fix is ready, merge it into the main branch and the dev branch
- **release/release-name**:
  - Used to prepare a new release version from the dev branch.
  - Releases are typically automated via **release-please**. When a release PR is merged into the main branch, a new release is created.
- **bugfix/fix-name**:
  - Used to fix an issue from the dev branch
  - When the fix is ready, merge it into the dev branch
- **experimental/exp-name** branch is used for testing something from the dev branch

#### CLI Commands

Using the [git flow extension](https://github.com/nvie/gitflow/wiki/Installation)

```bash
# Feature

## Start
git flow feature start feature_branch
## Finish
git flow feature finish feature_branch

# Release

## Start
git flow release start 0.1.0
## Finish
git flow release finish "0.1.0"

# Hotfix

## Start
git flow hotfix start hotfix_branch
## Finish
git flow hotfix finish hotfix_branch

# Bugfix

## Start
git flow bugfix start bugfix_branch
## Finish
git flow bugfix finish bugfix_branch
```

Using git

```bash
# Feature

## Start
git checkout dev
git checkout -b feature/feature-name
## Finish
git checkout dev
git merge feature/feature-name

# Release

## Start
git checkout dev
git checkout -b release/0.1.0
## Finish
git checkout main
git merge release/0.1.0
git checkout dev
git merge release/0.1.0
git branch -D release/0.1.0

# Hotfix

## Start
git checkout main
git checkout -b hotfix/fix-name
## Finish
git checkout main
git merge hotfix/fix-name
git checkout dev
git merge hotfix/fix-name
git branch -D hotfix/fix-name

# Bugfix

## Start
git checkout dev
git checkout -b bugfix/fix-name
## Finish
git checkout dev
git merge bugfix/fix-name

# Experimental

## Start
git checkout dev
git checkout -b experimental/exp-name
## Finish
git checkout dev
git merge experimental/exp-name
```

### Building the Project

The project uses a multi-module structure. All modules are located in the `modules/` directory.

If you want to build the project, clone the **main** or **dev** branch

```bash
./gradlew build
```

The artifacts will be available in the `build/libs` and `modules/*/build/libs` directories.

#### Local JAR Repository

The project allows modules to opt-in to copying their built JARs to a common local repository (at the root `build/repo` directory).
This is useful for testing modules in other projects locally or to export built artifacts without publishing them to a remote repository.

To enable this for a module, add the following to its `build.gradle.kts`:

```kotlin
extra["localJarRepo"] = true
```

When enabled, running `./gradlew build` will automatically copy the module's JAR to the root `build/repo` directory.

### Publishing

The project supports publishing to a Maven repository. To enable publishing for a module, add the following to its `build.gradle.kts`:

```kotlin
extra["publish"] = true
```

When enabled, you can run the `publish` task:

```bash
./gradlew publish -Drepository.name=snapshots
```

#### Publishing Configuration

- **`repository.name`**: (Optional) The name of the target repository (e.g., `releases`, `snapshots`, `private`). Defaults to `snapshots`.
- **Credentials**: The publishing task requires credentials for the `neotamia` repository. These can be provided via:
    - Gradle properties: `neotamia<RepositoryName>Username` and `neotamia<RepositoryName>Password` (e.g., `neotamiaSnapshotsUsername`).
    - Environment variables: `MAVEN_USERNAME` and `MAVEN_PASSWORD`.

### Testing

If you add code you need to add tests! We’ve learned the hard way that code without tests is undependable.
If your pull request reduces our test coverage because it lacks tests then it will be rejected.

#### Run tests
```bash
./gradlew test # To run the tests
```

### Style Guidelines

#### Code Formatting Rules

Please follow the **Kotlin Official Convention** and **Spotless** (which uses **ktlint**). </br>
You can run it with: 

```bash
./gradlew spotlessCheck # To run the linter
./gradlew spotlessApply # To run the linter and fix the errors
```

You can also skip the enforce check of spotless (not recommended) with:
```bash
./gradlew build -Pspotless.enforceCheck=false
```

#### AI Agent Guidelines

If you are an AI agent working on this project, please refer to the [AGENTS.md](AGENTS.md) file for specific rules and technical context.

#### Branch Names

As said in [Development Process](#development-process), you should use the following branch names:
- Main: **main** (Latest stable release)
- Dev: **dev** (Latest development version)
- Feature: **feature/feature-name** (Used to develop a new feature)
- HotFix: **hotfix/fix-name** (Used to fix an issue from the main branch)
- Release: **release/release-name** (Used for a new release, managed by release-please)
- BugFix: **bugfix/fix-name** (Used to fix an issue)
- Experimental: **experimental/exp-name** (Should be used for testing something)

Examples:
```md
feature/auth
bugfix/issue-1
bugfix/tickets
experimental/oauth2
experimental/2fa
```

#### Whitespace Cleanup

Don’t mix code changes with whitespace cleanup! If you are fixing whitespace, include those changes separately from your code changes.
If your request is unreadable due to whitespace changes, it will be rejected.

> Please submit whitespace cleanups in a separate pull request.

#### Git Commit Guidelines

You should follow [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/#summary). </br>
This project uses **release-please** to automate releases and changelog generation. Following conventional commits is mandatory for the release process to work correctly.

Each commit message consists of a header, a body and a footer. The header has a special format that includes a type, a scope and a subject:

```md
<type>(<scope>?): <subject>
<BLANK LINE> # Only if body is present
<body> # Body can be empty, detailed, or like the first line
<BLANK LINE> # Only if footer is present
<footer> # Optional
```

- The first line of the commit should be a short description (100 chars or fewer) of the change.
- The other lines can be as detailed as you want and should include more detailed explanations, links to issues, etc.

Examples:
```md
chore: Update dependencies
ci: Update CI
docs: Update README.md
feat: Add new feature
fix: Fix issue
perf: Improve performance
refactor: Refactor code
revert: Revert commit
style: Update style
test: Add tests
chore(ci): Update CI
```
Breaking change
```md
fix(build)!: Fix build # Breaking change

# or

fix: Fix build

BREAKING CHANGE: Fixing build issue break backward compatibility
```

## Pull Request Guidelines

When you are ready to generate a pull request, either for preliminary review, or for consideration of merging into the project you must first push your local topic branch back up to GitHub:

> **Note**
> If you are working on a fork, you will need to push your branch to your fork on GitHub. 
> Please follow the [Branch names](#branch-names) section.

```bash
git push origin feature/newfeature
```

Once you've committed and pushed all of your changes to GitHub, go to the page for your fork on GitHub, select your development branch, and click the pull request button.
If you need to make any adjustments to your pull request, just push the updates to your branch.
Your pull request will automatically track the changes on your development branch and update.

1. Ensure any install or build dependencies are removed before the end of the layer when doing a build.
2. Make sure the tests pass on your machine
3. Update any relevant documentation.
4. The versioning scheme we use is [SemVer](http://semver.org/).
5. Pat your self on the back and wait for your pull request to be reviewed and merged.
6. For a Pull Request to be merged:
   - CI workflow must succeed
   - A project member must review and approve it

### Addressing Feedback

Once a PR has been submitted, your changes will be reviewed and constructive feedback may be provided. Feedback isn't meant as an attack, but to help make sure the highest-quality code makes it into our project. Changes will be approved once required feedback has been addressed.

If a maintainer asks you to "rebase" your PR, they're saying that a lot of code has changed, and that you need to update your fork, so it's easier to merge.

To update your forked repository, follow these steps:

```bash
# Fetch upstream main and merge with your repo's main branch
git fetch upstream
git checkout main
git merge upstream/main

# If there were any new commits, rebase your development branch
git checkout feature/newfeature
git rebase main
```

If too much code has changed for git to automatically apply your branches changes to the new **main**, you will need to manually resolve the merge conflicts yourself.

Once your new branch has no conflicts and works correctly, you can override your old branch using this command:

```bash
git push -f
```

> **Warning**
> Note that this will overwrite the old branch on the server, so make sure you are happy with your changes first!

---

By contributing, you agree that your contributions will be licensed under the project's [LICENSE](LICENSE).
