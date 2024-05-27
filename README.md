# 로그인 기능 구현

화면은 테스트를 위해 임시로 만들었으며,

프런트엔드와 통합시 restController로 변경하여 데이터를 json으로 주고 받을 예정

## /login : 로그인 창
![image](https://github.com/jimins5042/TEAM-1-BACK/assets/28335699/12e94719-a08d-418d-8585-3229785340ba)

- id와 password를 입력 받음
- 정확하게 입력했는지 검증

  -> 정확하게 입력 받았을 시 상품 리스트로 이동(추후 쿠키나 세션을 통해 로그인을 유지하도록 할 예정)

  -> 부정확할 경우 다시 로그인 창으로 이동

## /signUp : 회원가입 창

![image](https://github.com/jimins5042/TEAM-1-BACK/assets/28335699/39c4ae51-7c69-4fc5-96e0-0de4eebb09f8)


- id, 비밀번호, 고객이름, 고객 전화번호, 고객 주소를 입력 받은 후 저장
- 이미 있는 id를 저장하고자 할 경우, 다시 회원가입 창으로 이동

## DB 

### table 생성 정보
~~~
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    memberId VARCHAR(50) NOT NULL,
    memberPassword VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL
);
~~~

### 프로젝트 실행을 위한 db 정보 설정

![image](https://github.com/jimins5042/TEAM-1-BACK/assets/28335699/e9526054-c4fe-459c-8a5b-8c41b1e99e59)

application.properties 파일로 이동후, 아래 코드를 자신의 db 계정 정보에 맞게 고치기
~~~
spring.datasource.url=jdbc:mysql://localhost:3306/test_db
spring.datasource.username= 본인 mysql 계정 아이디
spring.datasource.password= 본인 mysql 계정 비밀번호
~~~
