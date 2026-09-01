# AI Agent Guidelines

All AI agents (Claude, Gemini, Codex, Junie, etc.) working on this project must follow these rules:

## Technical Context
- **Stack**: Kotlin 2.3, Gradle, Multi-module project.
- **Project Structure**: 
  - Modules are located in the `modules/` directory.
  - Core logic resides in `modules/core`.
  - Build logic and common configurations are in `buildSrc` (using the `neotamia-build` convention plugin).
- **Tooling**:
  - Uses Gradle toolchains for JDK 21.
  - Shadow plugin for fat JAR creation.
  - Spotless for code formatting and linting.

## Development Rules
1. **Code Style**: 
   - Strictly follow the styles enforced by Spotless (ktlint for Kotlin, Cleanthat for Java).
   - Always run `./gradlew spotlessApply` after any code modification.
   - Use Unix (LF) line endings.
2. **Kotlin Best Practices**:
   - Use `val` instead of `var` whenever possible.
   - Provide KDoc for all public APIs.
   - Use Type-safe project accessors when referencing modules.
3. **Testing**:
   - Use JUnit Platform for all tests.
   - Place tests in the appropriate `src/test/kotlin` or `src/test/java` directories.
   - Verify changes by running `./gradlew build` or `./gradlew test` before finalizing tasks.
4. **Project Integrity**:
   - Do not bypass Spotless checks unless explicitly instructed.
   - Ensure all new dependencies are added to `gradle/libs.versions.toml`.
