# :books: bookCafe_BE
* 노션 : https://www.notion.so/56c39e3254f2440b9152488e39535158#0d4cd2115ff14625a9542f9b094d10db  
* 프론트엔드 Github : https://github.com/oagree0123/FE_BookCafe  


##  프로젝트 소개 
여러 사람들과 책을 같이 읽고 토론 하고 싶을 때 모임을 만들어봐요.  
  
모임 마감 일자, 모임 인원을 설정할 수 있어요.  
  
마이페이지에서는 내가 참여한 모임을 확인 할 수 있어요.   
  
<img src="https://user-images.githubusercontent.com/44867889/154411660-b66cd51f-a6a9-496d-98fa-dddc51a68415.png" width="70%" height="70%">   
   
      

## :page_facing_up: 와이어 프레임   

<img src="https://user-images.githubusercontent.com/44867889/154413471-61d58794-aae8-4d2d-ac3a-8da587f2a6dd.png" width="70%" height="70%">

## :movie_camera: 시연 영상 
https://www.youtube.com/watch?v=2-U77XR8JBM

## :scroll:  ERD 설계 

<img src="https://user-images.githubusercontent.com/44867889/154412134-2955330e-cc68-42d9-80ee-d5f57f46517b.png" width="80%" height="80%">


## :whale: API 테이블  

<details> 
    <summary>여기를 눌러주세요</summary>   
  
![image](https://user-images.githubusercontent.com/44867889/154416182-57c81828-dc0a-45b6-a189-8a0485f2f530.png)  
![image](https://user-images.githubusercontent.com/44867889/154416295-d01d95bd-fb18-4b12-97d3-7c4c25dd4417.png)  
![image](https://user-images.githubusercontent.com/44867889/154416385-6ca9fa04-575e-4f6e-8c28-b29a2be1124d.png)
![image](https://user-images.githubusercontent.com/44867889/154416417-a7bbe513-bbef-45dd-8b10-300b06659292.png)    
   
</details>  

## :sweat_drops: 개발 기간 및 개인 역할   
**기간 : 2022.02.11 ~ 2022.02.17 (6일)**   
* 나경운 : JWT 로그인, 회원가입, 아이디 및 닉네임 중복검사, 비밀번호 일치 확인    
* 박정희 : 댓글 수정, 삭제, 생성, 조회 
* 박유선 : 모임 수정, 삭제, 생성, 조회 / 모임 참가, 취소/ 데이터베이스 연관관계 설정    
  
  
## :notes: 기술 스택   
Back-end

* Java 8
* SpringBoot 2.5.3
* Spring Security
* Gradle
* JPA
* MySQL
* JWT
* CORS


DevOps

* AWS EC2
* AWS RDS(MySQL)
* FileZilla

Tool

* Git
* GitHub  


## :dancer: 우리팀이 해결한 문제 
1. get 요청시 request body로 유저의 닉네임을 받아오도록  api를 설계하였으나 axios는 get 요청시  requestbody의 값을 받는 것이 불가능했다.    
    => pathvariable로 값을 받아오도록 api를 변경하였다. 닉네임 중에는 한글이 있어 pathvariable로 요청할때 utf8로 변경하여 요청하였다.  
2. 로그인 후 토큰을 생성하여 토큰 값을 헤더에 넣어서 프론트 엔드로 보내주었으나 프론트에서 읽지 못하는 오류가 있었다.     
    => 백엔드 cors 설정에 
    .allowedHeaders(" * ") .exposedHeaders(HttpHeaders.AUTHORIZATION)
    을 추가하여 프론트에서 헤더에 접근이 가능하도록 하였다. 
3. many to many  양방향 연결이 필요한 테이블이 있었다. 
    =>  중간에 연결 테이블을 추가하여 문제를 해결하였다.   
4. 양방향 연결관계의 테이블 삭제 시 외래 키로 인한 오류가 발생하였다. 
    => orphanRemoval = true 설정을 주인이 아닌 테이블에 추가하여 해결하였다. 
    
    
