# 🚀 BIGS-BE-test
Bigs Back-End 개발자 실습 테스트
지원자 권유정


 ## 개발기간
 2024.05.14~2024.05.21 (일주일)

## 💻 기술 스택
- JAVA
- Spring Boot
- MySQL
- JPA

 ##📌 구현 API
 - 단기 예보를 DB에 저장하게 하는 API
   - API URL : /api/list
   - 메서드 : POST
   - 공공 API에서 의정부시 문충로 지역의 데이터를 받아와서, 로컬 DB에 해당 데이터를 저장하도록 구현하였습니다.
  
- 단기 예보를 조회하는 API
  - API URL : /api/list
  - 메서드 : GET
  - 앞서서 POST 요청 이후에, 로컬 DB에 저장된 데이터를 조회하도록 구현하였습니다.
