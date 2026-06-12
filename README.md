# miniLMS

JSP, Servlet, JDBC를 사용해 만든 간단한 학사 관리 실습 프로젝트입니다. 학생, 강의, 수강 신청 정보를 화면에서 입력하고 H2 데이터베이스에 저장하는 흐름을 연습했습니다.

## 주요 기능

- 학생 정보 입력 및 조회
- 강의 정보 입력 및 조회
- 수강 신청 정보 입력 및 조회
- JSP 화면과 Servlet Controller 연결
- DAO를 통한 H2 데이터베이스 접근

## 기술 스택

- Java
- JSP
- Servlet
- JDBC
- H2 Database
- Maven
- Apache Tomcat

## 프로젝트 구조

```text
src/main/java/ch
├── Course.java
├── CourseController.java
├── CourseDAO.java
├── EnrollController.java
├── EnrollDAO.java
├── Enrollment.java
├── Student.java
├── StudentController.java
└── StudentDAO.java

src/main/webapp
├── index.jsp
└── ch
```

## 실행 참고

이 프로젝트는 H2 TCP 서버와 Tomcat 실행 환경이 필요합니다. DAO 코드의 JDBC URL은 다음 형태를 사용합니다.

```text
jdbc:h2:tcp://localhost/~/jwbookdb
```

실행 전 H2 서버를 켜고 `jwbookdb` 데이터베이스를 준비해야 합니다.

## 한계 및 개선할 점

- 현재 DB 연결 정보가 DAO 코드에 직접 들어가 있습니다.
- 테이블 생성 SQL과 실행 순서를 README에 더 구체적으로 남기면 재현성이 좋아집니다.
- 입력값 검증, 예외 처리, 테스트 코드가 부족합니다.
