# Upgrade Plan: AgriRakshak-AI-Connect backend (20260620100516)

- **Generated**: 2026-06-20 10:12:00
- **HEAD Branch**: N/A
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 21.0.10: C:\Users\shivp\AppData\Local\jdks\jdk-21.0.10\bin (current target JDK, required by Step 1 and Final Validation)
- JDK 17: not available (baseline will be skipped)

**Build Tools**
- Maven Wrapper 3.9.14: .mvn/wrapper/maven-wrapper.properties (available, used by all Maven commands)
- System Maven: not available

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260620100516
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade project Java runtime target from 17 to 21

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- | 
| Java | 17 | 21 | User requested latest LTS runtime |
| Spring Boot | 3.5.4 | 3.5.4 | Current project is already on a Java-21-compatible Spring Boot line |
| Maven Wrapper | 3.9.14 | 3.9.0 | Supports Java 21 and is available in project wrapper |
| spring-boot-starter-web | 3.5.4 | 3.5.4 | Compatible with Spring Boot 3.5.x and Java 21 |
| spring-boot-starter-data-jpa | 3.5.4 | 3.5.4 | Compatible with current Spring Boot parent and Java 21 |
| spring-boot-starter-security | 3.5.4 | 3.5.4 | Compatible with current Spring Boot parent and Java 21 |
| spring-boot-starter-test | 3.5.4 | 3.5.4 | Compatible with current Spring Boot parent and Java 21 |

## Derived Upgrades

- Java runtime upgrade to 21 is sufficient; no Spring Boot upgrade is required because the current parent 3.5.4 already supports Java 21.
- Maven Wrapper 3.9.14 is sufficient for Java 21 and requires no upgrade.
- No Kotlin upgrade is required; the project does not use Kotlin.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| pom.xml | java.version | 17 | upgrade | 21 | User requested latest LTS runtime |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| None identified | N/A | N/A | N/A | The current Spring Boot 3.5.4 codebase is already compatible with Java 21; only the Java runtime target property needs updating. |

### Configuration Changes

| File | Property/Setting | Current | Required Change | Reason |
|------|------------------|---------|-----------------|--------|
| None identified | N/A | N/A | N/A | No application config changes explicitly required for Java 21 runtime upgrade. |

### CI/CD Changes

| File | Location | Current | Required Change |
|------|----------|---------|-----------------|
| None identified in backend module | N/A | N/A | N/A |

### Risks & Warnings

- **Baseline JDK 17 unavailable**: The current project target is Java 17, but the acquired system JDK is only Java 21. Baseline compilation/test evaluation on JDK 17 is skipped. Mitigation: use the Maven wrapper and run full tests on Java 21 after the upgrade.
- **JDK 21 runtime-only behavior changes**: Strong encapsulation or removed JDK internals may surface only at runtime. Mitigation: perform full `mvn clean test` and fix any compatibility issues immediately.
- **No git repository**: Version control is unavailable, so changes will not be committed via git. Document the affected files and the final result carefully.

## Upgrade Steps

- Step 1: Setup Environment
  - Rationale: Confirm the target JDK and Maven wrapper are available before making changes.
  - Changes to Make: No repository edits; verify environment using the Maven wrapper and JDK 21.
  - Verification: `./mvnw.cmd -version` and `java -version` on Java 21, expected to succeed.

- Step 2: Update Java runtime target to 21
  - Rationale: The core upgrade is changing the Maven project runtime from Java 17 to Java 21.
  - Changes to Make: Apply the Dependency Change to `pom.xml` (`java.version` 17 → 21).
  - Verification: `./mvnw.cmd clean test-compile -q` using the Maven wrapper.

- Step 3: CVE Validation & Fix
  - Rationale: Ensure direct dependencies are not known to have critical vulnerabilities after the runtime upgrade.
  - Changes to Make: Run CVE validation on direct dependencies. If any CVEs are found, upgrade affected dependencies minimally and verify compilation.
  - Verification: `mvn -DskipTests dependency:list -DexcludeTransitive=true` or wrapper equivalent, then CVE scan and `./mvnw.cmd clean test-compile -q`.

- Step 4: Final Validation
  - Rationale: Confirm the Java 21 upgrade is stable by running the full test suite.
  - Changes to Make: No additional source changes initially; fix any test or compilation failures uncovered by validation.
  - Verification: `./mvnw.cmd clean test` on Java 21, expected to pass 100%.
