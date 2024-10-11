# SPRING PLUS주차 과제

## 설명
- Spring PLUS 주차 개인과제에 대한 풀이 서술

## 해설
### 1. 코드 개선 퀴즈 - @Transactional의 이해
![image](https://github.com/user-attachments/assets/e194efb5-cc60-420c-a4fb-fdff413a6fa1)
- 메서드에 @Transactional 애노테이션 추가
  - Class에 @Transactional(readOnly = true)설정이 되어있음
  - DB에 데이터가 추가, 수정, 삭제되는 메서드를 구현할때 @Transactional을 재입력해줘야 영속성 컨텍스트에 반영되어 의도대로 작동
 
### 2. 코드 추가 퀴즈 - JWT의 이해
- 관련 코드에 nickname 필드를 추가
  - JWT토큰에 nickname값이 포함되도록 수정
  - ArgumentResolver에 nickname값이 포함되도록 수정
  - 회원가입과 관련된 로직에 nickname필드 추가

### 3. 코드 개선 퀴즈 - AOP의 이해
![image](https://github.com/user-attachments/assets/30de268a-cdbe-45de-a431-51cdb020b947)
- 애노테이션 @Before로 수정

### 4. 테스트 코드 퀴즈 - 컨트롤러 테스트의 이해
![image](https://github.com/user-attachments/assets/a640821f-7a19-4f43-8c50-98e045abcecc)
- status code를 실제 로직에 맞게 수정

### 5. 코드 개선 퀴즈 -  JPA의 이해
![image](https://github.com/user-attachments/assets/f4025668-528f-4e99-8bc1-224dbad100a7)
- service단에서 여러개의 if를 사용하기에는 코드 로직이 직관적이지 않는 개인적인 불만족이 있었음
- 최대한 @Query 자체 내에서 해결하려는 방법으로 구현

### 6. JPA Cascade
![image](https://github.com/user-attachments/assets/868d0a0d-f68f-4e76-95ef-4c07158c3e63)
- PERSIST 추가
- 문제 요구사항인 '할 일을 새로 저장할 시, 할 일을 생성한 유저는 담당자로 자동 등록되어야 합니다'은 PERSIST 추가 없이도 이미 잘 작동하고 있음
  - 안정적인 영속성 전이 보장을 위해 PERSIST를 추가하라는 문제의도로 해석
 
### 7. N+1
![image](https://github.com/user-attachments/assets/3423b00e-8612-4215-bc77-4c0e7d0739d7)
- fetch join 사용

### 8. QueryDSL
![image](https://github.com/user-attachments/assets/0224bbb7-12ec-4ed3-a7b9-10ed2b9ba7fe)
- N+1문제 발생 방지를 위해 마찬가지로 fetch join 사용

### 9. Spring  Security
- config패키지 수정

### 10. QueryDSL 을 사용하여 검색 기능 만들기
![image](https://github.com/user-attachments/assets/edc241a3-3b55-45fe-be58-ec1028b614a3)
- builder 사용으로 동적 검색조건 생성
  
![image](https://github.com/user-attachments/assets/2c9edf60-7782-4841-a78e-c6a12db0525c)
- 문제 요구사항대로 구현(페이징처리, Projection을 사용한 응답내용)

 ### 11. Transaction 심화
![image](https://github.com/user-attachments/assets/16bb832e-88e6-458b-94ae-2d1e9ab99924)
 - Propagation.REQUIRES_NEW 사용
   
![image](https://github.com/user-attachments/assets/91459927-d033-4ba3-9d4b-4eaca0ca6de3)
- ManagerService에 로그 트랜잭션관련 소스 추가




