# 2026_kdt_practice

## 기술 스택

**언어 / 런타임**
- Java 17 (Gradle toolchain)

**프레임워크**
- Spring Boot 3.5.16
- Spring Boot Starter Web (REST API)
- Spring Boot Starter Validation

**빌드 도구**
- Gradle (war 패키징)

**영속성 / DB**
- MyBatis (`mybatis-spring-boot-starter` 3.0.5, XML 매퍼 기반)
- MySQL (`mysql-connector-j`)
- `map-underscore-to-camel-case=true` (snake_case ↔ camelCase 자동 매핑)

**기타 라이브러리**
- Lombok
- Spring Boot DevTools

**테스트**
- JUnit 5
- MyBatis Spring Boot Test Starter

**아키텍처**
- 계층형 구조: `controller` / `service` / `mapper` / `dto` (`com.example.practice.board`)
- 파일 업로드 기능 포함 (`uploads/` 디렉토리)
- 별도 프론트엔드 뷰 없이 REST API 서버로 동작 (`templates`, `static` 비어 있음)
