# 🥖 Ohgoodfood
<a href="https://ohgoodfood.com/" >
<img src="https://github.com/user-attachments/assets/3a256130-789b-4b20-b158-7f429e61fd44">
</a>

<p align="center">이미지를 클릭하면 OhGoodFood 플랫폼으로 이동합니다.</p>

## 🔗 목차
- [프로젝트 소개](#프로젝트-소개)
- [팀 소개](#팀-소개)
- [화면 명세](#화면-명세)
- [기술 스택](#기술-스택)
- [파일 구조](#파일-구조)
- [시스템 구조](#시스템-구조)
- [ERD](#erd)
- [보안](#보안)
- [빌드 방법](#빌드-방법)
- [참고 자료](#참고-자료)
  
---

## 프로젝트 소개

### 📖 개요
> 📦**오굿푸드(OhGoodFood)** 프로젝트 소개
> 
> - Spring MVC 기반 **마감 식품 특가 플랫폼**  
> - 실시간 예약 & 결제 시스템  
> - 사장님-사용자 간 **남는 식품의 가치 있는 소비 연결**

### 🎯 주요 기능
| 👤 사용자   | 🏪 가게(사장님) | 👨‍💼 관리자   |
|:--------------:|:--------------:|:--------------:|
| 예약 가능한 상품 조회<br>필터 기능<br>예약 및 결제<br>주문 확인/취소<br>리뷰 작성<br>북마크 기능 | 오굿백 상품 등록/마감<br>예약 목록 확인 및 픽업 처리<br>리뷰 확인<br>매출 확인<br>가게 정보 수정 | 가게 등록 요청 승인/거절<br>전체 회원/상품 목록 조회<br>예약/픽업 상태 확인<br>알림 전송<br>통계/매출 관리 |

<a id="팀-소개"></a>
## 👥 팀 소개
| 5조은팀   | <img src="https://github.com/minsss0726.png" width="80"><br>[김민중](https://github.com/minsss0726)(팀장)        | <img src="https://github.com/parkeunhyo.png" width="80"><br>[박은효](https://github.com/parkeunhyo)        | <img src="https://github.com/window101.png" width="80"><br>[박화준](https://github.com/window101)        | <img src="https://github.com/gaaaani.png" width="80"><br>[서가은](https://github.com/gaaaani)        | <img src="https://github.com/sunJ0120.png" width="80"><br>[오선정](https://github.com/sunJ0120)        |
|----------|:----------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------:|
| **담당** | 관리자 / 사용자 페이지<br>DB 설계                                                                       | 사장님 페이지<br>UI/UX 설계                                                                          | 사장님 페이지<br>DB 설계                                                                            | 사용자 페이지<br>UI/UX 설계                                                                         | 사용자 페이지<br>DB 설계                                                                             |


<a id="화면-명세"></a>
## 🖼 화면 명세

- 사용자 화면

| 메인 | 메인지도 | 상품상세 | 주문내역 | 마이페이지 |
|:----:|:--------:|:--------:|:--------:|:----------:|
| <img src="https://github.com/user-attachments/assets/43aa6b17-9378-47b3-b098-2de6e8a4c2d6" alt="메인" width="180"/> | <img src="https://github.com/user-attachments/assets/f13ebd3b-6e22-45fe-a9cd-fe929e625b17" alt="메인지도" width="180"/> | <img src="https://github.com/user-attachments/assets/6656aa0c-602e-4da0-b403-122009ff9dd2" alt="상품상세" width="180"/> | <img src="https://github.com/user-attachments/assets/c2daa586-8c56-45ea-96e7-67598ce15a7d" alt="주문내역" width="180"/> | <img src="https://github.com/user-attachments/assets/cd7d4e25-2888-4b75-994f-b21195825806" alt="마이페이지" width="180"/> |

- 사장님 화면

| 메인(오픈) | 리뷰내역 | 주문내역 | 마이페이지 | 매출확인 |
|:----------:|:--------:|:--------:|:----------:|:--------:|
| <img src="https://github.com/user-attachments/assets/b1b91feb-a539-4a39-ad78-97061166c063" alt="메인" width="180"/> | <img src="https://github.com/user-attachments/assets/4432ca39-bb22-4ea6-97b5-11679abad75c" alt="리뷰내역" width="180"/> | <img src="https://github.com/user-attachments/assets/8b45886f-0bfa-49ec-8aca-243893ae0c9a" alt="주문내역" width="180"/> | <img src="https://github.com/user-attachments/assets/7853e635-3874-4cbd-90c6-1a020610c1b2" alt="마이페이지" width="180"/> | <img src="https://github.com/user-attachments/assets/b1ab4c36-164d-4c45-957c-8c67ebaeaa441" alt="매출확인" width="180"/> |


<a id="기술-스택"></a>
## 🔧 기술 스택

#### 📌 프론트엔드  
![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)
![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)

#### 🛠 백엔드  
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=apache&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-FF0000?style=for-the-badge&logo=lombok&logoColor=white)

#### 🌐 서버 / 배포  
![Apache Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
![AWS S3](https://img.shields.io/badge/Amazon_S3-569A31?style=for-the-badge&logo=amazonaws&logoColor=white)
![STS](https://img.shields.io/badge/STS-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

#### 🗄 데이터베이스  
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)

#### 🔌 외부 API 및 연동  
![Kakao Map](https://img.shields.io/badge/Kakao%20Map-FFCD00?style=for-the-badge&logo=kakaotalk&logoColor=000000)
![OAuth2](https://img.shields.io/badge/OAuth2-3C3C3C?style=for-the-badge&logo=openid&logoColor=white)
![Toss Payments](https://img.shields.io/badge/Toss%20Payments-1B64DA?style=for-the-badge&logo=toss&logoColor=white)
![Spring Scheduler](https://img.shields.io/badge/Scheduler-6DB33F?style=for-the-badge&logo=spring&logoColor=white)


<a id="파일-구조"></a>
## 📂 파일 구조
```plaintext
├─java
│  └─kr
│      └─co
│          └─ohgoodfood
│              ├─config              # ✅ Spring 설정 클래스 (MvcConfig, 파일 업로드 설정)
│              ├─controller          # ✅ 클라이언트 요청 처리 컨트롤러 계층
│              ├─dao                 # ✅ MyBatis Mapper 인터페이스 (DB 접근)
│              ├─dto                 # ✅ DTO/VO 클래스
│              ├─service             # ✅ 비즈니스 로직 처리 계층
│              └─util                # ✅ 공통 유틸 클래스 (인터셉터 등)
├─resources
│  └─kr─co─ohgoodfood
│              └─dao                # ✅ MyBatis 매퍼 XML 파일 위치 (SQL 정의)
└─webapp
    ├─css                           # ✅ 웹폰트 및 css 파일
    ├─img                           # ✅ 정적 이미지 파일 저장
    ├─popup                         # ✅ 팝업 전용 JSP (모달 등)
    ├─resources                     
    └─WEB-INF
        ├─spring
        │  └─appServlet             # ✅ Spring DispatcherServlet 설정 XML 위치
        └─views                     # ✅ JSP 뷰
```

<a id="시스템-구조"></a>
## 🧱 시스템 구조
![Web App Reference Architecture (4)](https://github.com/user-attachments/assets/80b0beb8-da97-40cc-8f59-39cdda950769)

<a id="erd"></a>
## 🧾 ERD
![스크린샷 2025-07-07 150317](https://github.com/user-attachments/assets/263012c9-a619-4776-83f9-20d20f1df6fc)

<a id="보안"></a>
## 🕶️ 보안
- **SQL Injection 방지** : MyBatis `#{}` 플레이스홀더(PreparedStatement) 사용  
- **XSS 방지** : 스크립트 필터링 기능을 적용해서 XSS 공격을 방지
- **파일 업로드 검증** : S3에 이미지 확장자 (.jpg, .jpeg, .png)만 업로드 할 수 있도록 필터링 적용하여 공격을 방지

<a id="빌드-방법"></a>
## 🚀 빌드 방법

[공식 가이드 - 빌드 방법 바로가기](https://ohgoodteam.github.io/OhGoodFood/#%EB%B9%8C%EB%93%9C-%EB%B0%A9%EB%B2%95)

<a id="참고-자료"></a>
## 📖 참고 자료

- [공식 가이드라인 문서](https://ohgoodteam.github.io/OhGoodFood/)
- [5조은 푸드 Figma](https://www.figma.com/design/f2ieVUQKNfVIqfFrbhewRq/1%EC%B0%A8%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5%EC%A1%B0%EC%9D%80%ED%91%B8%EB%93%9C-?node-id=1079-503&t=2tb5WPb0wNlATegH-1)
- [최종 발표 PPT](https://www.canva.com/design/DAGscPRea8Y/DAbihV2EW7xIso0zTB5fFw/view?utm_content=DAGscPRea8Y&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=h74728b40d1)
