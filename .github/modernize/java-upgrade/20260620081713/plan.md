# Upgrade Plan: AgriRakshak-AI-Connect Backend (20260620081713)

- **Generated**: 2026-06-20 08:17:13
- **HEAD Branch**: N/A (git not available)
- **HEAD Commit ID**: N/A (git not available)

## Available Tools

**JDKs**
- JDK 17.0.18: C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot\bin (current project JDK, used by baseline)
- JDK 21: **<TO_BE_INSTALLED>** (target version, required by steps 3-5)

**Build Tools**
- Maven Wrapper: 3.9.14 (already compatible with Java 21)

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260620081713
- Run tests before and after the upgrade: true

## Upgrade Goals

- **Java**: 17 → 21 (latest LTS)

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
|----------------------|---------|-----------------|------------------|
| Java                 | 17      | 21              | User requested |
| Spring Boot          | 3.5.4   | 3.5.4           | Full Java 21 support available in 3.5.x |
| Maven (wrapper)      | 3.9.14  | 3.9.14          | Already compatible with Java 21 |
| Spring Framework     | 6.1.x   | 6.1.x           | Full Java 21 support |
| Spring Security      | 6.3.x   | 6.3.x           | Compatible |
| Hibernate            | 6.4.x   | 6.4.x           | Compatible |

## Derived Upgrades

- **Direct upgrade possible**: Spring Boot 3.5.4 already fully supports Java 21; no intermediate versions needed.
- **No additional deps required**: All existing dependencies (Spring Web, Spring Data JPA, Spring Security, MySQL, Lombok, Validation) are fully compatible with Java 21 via Spring Boot 3.5.4 BOM.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|-----------|---------|--------|--------|--------|
| pom.xml | java.version | 17 | upgrade | 21 | User requested upgrade to latest LTS |

### Source Code Changes

No source code changes required. Spring Boot 3.5.4 is fully compatible with Java 21, and no deprecated/removed APIs are in use.

### Configuration Changes

No configuration changes required. Spring Boot 3.5.4 maintains all existing configurations in Java 21.

### CI/CD Changes

No CI/CD files detected in the project root. If Docker or pipeline files exist, verify they reference an appropriate JDK 21 image.

### Risks & Warnings

- **Reflection usage check**: No reflection into JDK internals detected; no risk from module system changes.
- **Deprecated API check**: No deprecated-then-removed APIs detected in use.
- **Transitive dependency compatibility**: All transitive dependencies managed by Spring Boot 3.5.4 BOM are compatible with Java 21.

## Upgrade Steps

- **Step 1: Setup Environment**
  - **Rationale**: Install JDK 21 to enable Java 21 compilation and testing.
  - **Changes to Make**: Install JDK 21 from Eclipse Adoptium or Oracle.
  - **Verification**: `appmod-list-jdks(version=21)` returns JDK 21 path. Expected: JDK 21 available.

- **Step 2: Setup Baseline**
  - **Rationale**: Establish baseline test pass rate with Java 17 before upgrade, ensuring all tests pass before making changes.
  - **Changes to Make**: Compile and run tests with current JDK 17 (C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot\bin).
  - **Verification**: Command: `mvnw clean compile test-compile -q && mvnw clean test -q`. Expected: All tests pass with Java 17.

- **Step 3: Upgrade to Java 21**
  - **Rationale**: Update java.version property to 21 and verify compilation with the new JDK.
  - **Changes to Make**: Update `pom.xml` property `<java.version>17</java.version>` → `<java.version>21</java.version>`.
  - **Verification**: Command: `mvnw clean test-compile -q` using JDK 21. Expected: Compilation SUCCESS (tests deferred to final step).

- **Step 4: Verify Compatibility**
  - **Rationale**: Ensure all code compiles and runs correctly with Java 21 without breaking changes.
  - **Changes to Make**: No additional changes; verify the compilation from Step 3.
  - **Verification**: Command: `mvnw clean test-compile -q` using JDK 21. Expected: Compilation SUCCESS.

- **Step 5: Final Validation**
  - **Rationale**: Run full test suite with Java 21, fix any failures, and validate all upgrade success criteria are met.
  - **Changes to Make**: Fix any test failures that arise during Java 21 execution.
  - **Verification**: Command: `mvnw clean test -q` using JDK 21. Expected: **100% test pass rate** (match or exceed baseline from Step 2).

## Notes

- **Version Control**: Git is not available in this workspace. Changes will not be committed. All file edits will remain uncommitted in the working directory.
- **Direct Upgrade**: No intermediate Java versions required; direct upgrade from Java 17 to Java 21 is safe with Spring Boot 3.5.4.
- **Spring Boot Stability**: Spring Boot 3.5.4 is a stable release with full Java 21 support, reducing upgrade risk.
