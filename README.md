# JPASpringBoot

SpringBoot를 JPA를 사용하여 개발



1. Rest API로 구현했습니다.

 - GET, POST, PUT/PATCH, DELETE
 
2. JPA & LOMBOK

LOMBOK
 - @Data : Getter, Setter를 자동으로 생성하며
 - @All,NoArgsConstructor : 생성자를 자동으로 생성한다
JPA(Java Persistent API)
 - ORM(Object Relational Mapping)으로 RDB 데이터베이스의 정보를 객체지향으로 손쉽게 활용할 수 있도록 도와주는 도구
 - Object(자바객체)와 Relation(관계형 데이터베이스) 둘 간의 맵핑을 통해서 보다 손쉽게 적용할 수 있는 기술을 제공
 - 쿼리에 집중하기 보다는 객체에 집중함으로써 조금 더 프로그래밍 적으로 많이 활용될 수 있다.
 
3.Entity

 - Camel Case : 단어를 표기할 때 첫 문자는 소문자로 시작하며 띄어쓰기 대신 대문자로 단어를 구분 
                Java의 변수를 선언할 때 camelCase로 선언한다.
                ex)honeNumbe, createdAt, updateAt
 - Snake Case : 단어를 표기할 때 모두 소문자로 표기하며, 띄어쓰기 대신 _로 표기
                DB 컬럼에 사용
                ex)phone_number, created_at, updated_at
                               
API를 정의하기에 따라 다르지만주로 api 통신 규격 구간에서는 Snake Case를 많이 사용한다.