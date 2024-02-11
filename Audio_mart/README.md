# 오디오 스토어 웹 Ring Ding with Spring Boot
스프링 부트 이용한 오디오스토어 웹입니다.

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
회원
- 고객 : 회원가입, 로그인, 회원정보 수정, 회원 탈퇴
- 관리자 : 회원 목록 조회

상품
- 고객 : 상품 조회
- 관리자 : 고객기능 + 상품 등록, 수정, 삭제, 조회
 
장바구니
- 여러 상품과 각 수량을 선택하여 장바구니 담기, 각 상품 삭제

주문
- 장바구니 전체 주문 (배송지, 배송메시지, 결제방법)

### 화면 흐름도
![img](https://github.com/gwidding/sts4_SpringBoot/assets/135992700/446e4eaa-9786-45a4-9b01-2893dca6f88d)

## 화면별 기능
#### 고객
홈페이지
<img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/71a8ac81-5bd0-4d39-a985-7291f556ef6b" alt="HOME" width="60%"/>

<table style="border-spacing: 10px;">
 <tr>
  <td>로그인</td>
  <td>회원가입</td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/64b45a4e-2595-43b7-81ac-056330cb32e4"/></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/42ae96d3-dd5c-4c64-a61a-57a30d209106" alt="LOGIN-signUp" /></td>
 </tr>
  
 <tr>
  <td>상품</td>
  <td>상품-상세</td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/d88dfe0a-3bcf-4776-ac76-2586c8f63635" alt="PRODUCT-category" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/8f912415-93a2-4f50-8899-58bca1372997" alt="PRODUCT-Detail" /></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/b9b183db-2c54-4662-be82-db2be98c239e" alt="PRODUCT-logout" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/7b312755-3786-42d5-b419-c1e039487255" alt="ORDER" /></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/b93906dc-0de2-4bab-bea3-757172d99341" alt="MYPAGE-account" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/8365f7bb-acaa-4749-8cd4-146ecbcd3976" alt="MYPAGE-order" /></td>
 </tr>

</table>

#### 관리자
![ADMIN](https://github.com/gwidding/sts4_SpringBoot/assets/135992700/2961ef53-00d6-4e7b-bf36-c3f3a65cd9d9)


### 테스트
<table>
 <tr>
  <td>
   <img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/71a8ac81-5bd0-4d39-a985-7291f556ef6b" alt="HOME" />
  </td>
  <td width="350px">
   <img src="https://github.com/gwidding/STM/assets/135992700/d6c61142-578b-4f58-a421-083214cf85fd" alt="HOME" />
  </td>
 </tr>

 <tr>
 <td>
  <img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/64b45a4e-2595-43b7-81ac-056330cb32e4"/>
 </td>
  <td>
   <img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/2077bba8-a7b3-4451-bca9-342720faa55a" alt="LOGIN-login"/>
  </td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/42ae96d3-dd5c-4c64-a61a-57a30d209106" alt="LOGIN-signUp" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/eb5d577c-6fde-4659-81bf-604d70db853d" alt="LOGIN-signup-script"/></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/d88dfe0a-3bcf-4776-ac76-2586c8f63635" alt="PRODUCT-category"/></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/97b349e5-a51e-4c1f-ba7d-679f242d68b3" alt="PRODUCT-category-script"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/8f912415-93a2-4f50-8899-58bca1372997" alt="PRODUCT-Detail"/></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/dffa6b55-9e19-45b4-8338-35da84045d6d" alt="PRODUCT-Detail-script"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/b9b183db-2c54-4662-be82-db2be98c239e" alt="PRODUCT-logout" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/24d371fd-c402-4c57-b71b-71a4690b9b83" alt="PRODUCT-logout-script"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/7b312755-3786-42d5-b419-c1e039487255" alt="ORDER" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/561b0417-ba38-4644-b969-10309ab5ee21" alt="ORDER-script"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/b93906dc-0de2-4bab-bea3-757172d99341" alt="MYPAGE-account" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/c024a9b2-101e-4177-afca-1f8c1b2ae5f9" alt="MYPAGE-account-script"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/8365f7bb-acaa-4749-8cd4-146ecbcd3976" alt="MYPAGE-order" /></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/f6a25451-2446-40d3-b8e0-8f8226aad875" alt="MYPAGE-order-scrpit"></td>
 </tr>

 <tr>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/2961ef53-00d6-4e7b-bf36-c3f3a65cd9d9" alt="ADMIN"/></td>
  <td><img src="https://github.com/gwidding/sts4_SpringBoot/assets/135992700/d1bf0afb-11ff-475a-8c2a-8df8d1928279" alt="ADMIN-script"></td>
 </tr>

 
</table>

