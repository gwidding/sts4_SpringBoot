# 게시판 웹 Board with Spring Boot
스프링 부트 이용한 온라인 웹 게시판입니다.


## 개발 환경
<table>
 <tr>
  <td>언어</td>
  <td>Java, Html, JavaScript, CSS</td>
 </tr>

  <tr>
   <td>프레임워크</td>
   <td>Spring Boot, MyBatis, Bootstrap, Thymeleaf</td>
 </tr>

 <tr>
  <td>IDE & 빌드 도구</td>
  <td>STS4, Gradle</td>
 </tr>
 
 <tr>
  <td>Database</td>
  <td>MySql</td>
 </tr>
</table>


## 주요 기능
게시글
- 작성, 조회, 수정, 삭제

댓글
- 작성, 조회, 삭제

추가 기능
- 옵션별 검색, 페이징

## 상세 설명
- [STS와 DB 연결](https://silvow94.tistory.com/entry/sts-Java-and-Spring-Project)
- [MyBatis-CRUD 쿼리](https://silvow94.tistory.com/entry/sts4-Spring-Boot-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-CRUD)
- [게시글 Mapper Test](https://silvow94.tistory.com/entry/sts4-Spring-Boot-04-CRUD-Test-%EC%9E%91%EC%84%B1)
- [게시글 CRUD Service](https://silvow94.tistory.com/entry/sts4-Spring-Boot-05-Layout-%EC%9B%B9-%ED%8E%98%EC%9D%B4%EC%A7%80-%EA%BE%B8%EB%AF%B8%EA%B8%B0)
- [컨트롤러 테스트](https://silvow94.tistory.com/entry/sts4-Spring-Boot-06-Layout-Presentation-Layer-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-%EC%B2%98%EB%A6%AC)
- [게시글 등록 컨트롤러, HTML](https://silvow94.tistory.com/entry/sts4-Spring-Boot-07-Create-%EC%9B%B9%EC%97%90%EC%84%9C-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%93%B1%EB%A1%9D%ED%95%98%EA%B8%B0-%EA%B5%AC%ED%98%84)
- [게시글 목록](https://silvow94.tistory.com/entry/sts4-Spring-Boot-08-List-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EB%AA%A9%EB%A1%9D-%EB%B3%B4%EC%97%AC%EC%A3%BC%EA%B8%B0)
- [게시글 읽기, 수정](https://silvow94.tistory.com/entry/sts4-Spring-Boot-09-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%9D%BD%EA%B8%B0%EC%88%98%EC%A0%95%ED%95%98%EA%B8%B0)
- [게시글 삭제](https://silvow94.tistory.com/entry/sts4-Spring-Boot-10-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%82%AD%EC%A0%9C%ED%95%98%EA%B8%B0)
- [공통 컨트롤러 - alert, redirect](https://silvow94.tistory.com/entry/sts4-Spring-Boot-11-Alert-Message-%EB%A9%94%EC%8B%9C%EC%A7%80-%EC%A0%84%EB%8B%AC)
- [페이지 이동](https://silvow94.tistory.com/entry/sts4-Spring-Boot-12-Paging-%ED%8E%98%EC%9D%B4%EC%A7%80-%EB%B8%94%EB%A1%9D-%EB%B0%8F-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0)
- [이전 페이지 유지하기](https://silvow94.tistory.com/entry/sts4-Spring-Boot-14-%EC%9D%B4%EC%A0%84-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%A0%95%EB%B3%B4-%EC%9C%A0%EC%A7%80%ED%95%98%EA%B8%B0)
- [@ResponseBody 테스트](https://silvow94.tistory.com/entry/sts4-Spring-Boot-15-REST-API-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0)
- [댓글 CRUD Test](https://silvow94.tistory.com/entry/sts4-Spring-Boot-16-REST-%EB%B0%A9%EC%8B%9D%EC%9C%BC%EB%A1%9C-%EB%8C%93%EA%B8%80-CRUD)
- [댓글 CRUD - gson](https://silvow94.tistory.com/entry/sts4-Spring-Boot-17-REST-%EB%B0%A9%EC%8B%9D%EC%9D%98-%EB%8C%93%EA%B8%80-%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%9E%91%EC%84%B1-%EC%82%AD%EC%A0%9C)
- [게시글 조회수](https://silvow94.tistory.com/entry/sts4-Spring-Boot-18-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%A1%B0%ED%9A%8C%EC%88%98-%EA%B8%B0%EB%8A%A5-%EA%B5%AC%ED%98%84)
- [게시글 검색](https://silvow94.tistory.com/entry/Spring-Boot-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EA%B2%80%EC%83%89-%EA%B8%B0%EB%8A%A5)


## 화면별 기능
<table>
 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/35d24a8b-7ee3-4773-a3ad-62df0cf98282"></td>
  <td width="350px">
   <h3> 게시글 작성하기 </h3>
    <li>공지글 여부 선택
    <li>제목, 이름, 내용 작성
    <li>뒤로가기
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/09e070b4-89c9-4bf2-9e49-cadcda95fed3"></td>
  <td>
    <h3> 게시글 조회하기 </h3>
    <li> 조회 수 증가
    <li> 수정하기
    <li> 삭제하기
    <li> 뒤로가기
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/c7106b74-a84a-46c2-8a6f-260b3c096dcd"></td>
  <td>
   <h3> 게시글 수정하기 </h3>
    <li> 저장
    <li> 뒤로가기
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/dd9722c7-6e24-4344-bfc3-fb2710ce30ee"></td>
  <td>
    <h3> 댓글 기능 </h3>
    <li> 댓글 작성하기
    <li> 댓글 삭제하기
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/8bbb5e6f-56f8-4363-b8df-f06049a9c977"></td>
  <td>
    <h3> 페이징 기능 </h3>
    <li> 뒤로가기로 게시판 목록 이동 시 페이지 유지
    <li> 원하는 페이지로 이동
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/e423368b-2fef-4c64-95b2-1a509f0af21a"></td>
  <td>
    <h3> 검색 기능 </h3>
    <li> 유형(전체, 제목, 내용, 작성자)별 검색
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/404da8c4-8aaa-45a6-b178-b3f3a4deab79"></td>
  <td>
   <h3> 검색 결과 </h3>
  </td>
 </tr>
</table>

