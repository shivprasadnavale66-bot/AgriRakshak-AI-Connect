# Upgrade Plan: AgriRakshak-AI-Connect (20260620130607)

- **Generated**: 2026-06-20 13:06:07
- **HEAD Branch**: N/A
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 17.0.18: C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot\bin (current project JDK, baseline)
- JDK 21.0.10: C:\Users\shivp\AppData\Local\jdks\jdk-21.0.10\bin (required by step 4)

**Build Tools**
- Maven Wrapper: 3.9.14 (sufficient for Java 21)

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260620130607
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java runtime target from 17 to 21

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- |
| Java | 17 | 21 | User requested latest LTS target |
| Spring Boot | 3.5.4 | 3.5.4 | Compatible with Java 21 |
| Maven Wrapper | 3.9.14 | 3.9.14 | Compatible with Java 21 |
| maven-compiler-plugin | managed | 3.11.0 | Recommended for Java 21 support |
| JWT (jjwt) | 0.12.6 | 0.12.6 | No direct compatibility issue |
| dotenv-java | 3.2.0 | 3.2.0 | No direct compatibility issue |

## Derived Upgrades

- `maven-compiler-plugin` should be updated to 3.11.0 or newer to align with Java 21 support recommendations.
- `java.version` property and `<release>` compiler setting must be updated to 21.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| backend/pom.xml | `<java.version>` | 17 | upgrade | 21 | Upgrade Java source/target level to latest LTS |
| backend/pom.xml | `maven-compiler-plugin` release | 17 | upgrade | 21 | Align Maven compiler output with Java 21 |
| backend/pom.xml | `maven-compiler-plugin` version | managed | add | 3.11.0 | Recommended plugin version for Java 21 support |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| backend/pom.xml | `<properties>` | `<java.version>17</java.version>` | Change to `21` | Upgrade build and compiler target |
| backend/pom.xml | `<release>17</release>` | `17` | Change to `21` | Upgrade compiled bytecode to Java 21 |

### Configuration Changes

None identified beyond Maven build settings.

### CI/CD Changes

None identified in repository root; no pipeline or Dockerfiles present in backend module.

### Risks & Warnings

- `Spring Boot 3.5.4` is compatible with Java 21, but any dependencies with native Java 17 assumptions could surface at runtime. Mitigation: run full test suite and fix compilation/runtime failures.
- Build is not version-controlled in this workspace because git is unavailable. All changes will be made without repository commits.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Ensure JDK 21 is available for upgrade verification and JDK 17 is available for baseline comparison.
  - **Changes to Make**: Confirm installed JDK paths and Maven wrapper readiness.
  - **Verification**: Use JDK 21 with Maven wrapper to run `./mvnw -q -version` or equivalent; expected success.

- Step 2: Setup Baseline
  - **Rationale**: Capture current compilation/test health on Java 17 before changing the runtime target.
  - **Changes to Make**: Run current build and tests with JDK 17.
  - **Verification**: `./mvnw clean test-compile -q && ./mvnw clean test -q`; expected pass if current baseline is healthy.

- Step 3: Upgrade Java target to 21
  - **Rationale**: Apply the requested Java runtime upgrade with minimal build changes.
  - **Changes to Make**: Update `java.version` property and compiler release to 21; pin `maven-compiler-plugin` to 3.11.0.
  - **Verification**: `./mvnw clean test-compile -q -DskipTests=false` using JDK 21; expected compile success.

- Step 4: Final Validation
  - **Rationale**: Verify the upgraded project compiles and all tests pass under Java 21.
  - **Changes to Make**: Resolve any Java 21 compatibility issues discovered during compilation or test execution.
  - **Verification**: `./mvnw clean test -q` using JDK 21; expected 100% pass rate.
