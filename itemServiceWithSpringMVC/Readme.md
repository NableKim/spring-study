### Introduction
인프런 '스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술'을 수강하며 배운 내용을 바탕으로 간단하게 상품 관리 페이지를 개발하였습니다.
이 코드는 수업 마지막에 있는 실습 코드를 보고 따라 작성한 코드입니다. 

### 시스템 요구사항
1. 본 시스템은 상품 정보를 관리한다.
2. 상품의 정보는 상품ID, 상품명, 상품가격, 상품수량 데이터를 가진다.
3. 사용자는 시스템에 등록된 전체 상품 정보를 조회할 수 있다.
4. 사용자는 특정 상품을 선택하여 한 상품에 대한 정보를 조회할 수 있다.
5. 사용자는 특정 상품의 정보를 수정할 수 있다.

> 참고) Spring MVC를 배우고 Controller를 활용하는데 의미가 있는 활동으로서
> 데이터 저장은 DB가 아닌 HashMap을 이용해 Memory에 저장하는 방식으로 구현하였습니다.


### 시스템 흐름도
- 시스템은 크게 4개의 페이지로 구성되어 있다. 
각 페이지에서 버튼을 눌러 새로운 상품 정보 등록 페이지로 이동하거나, 정보 등록하거나, 정보 수정하거나 등의 행위를 할 수 있다.
Controller에서 HTTP 요청 처리 로직을 수행한 이후 Thymeleaf 템플릿 뷰 엔진을 사용해 응답할 HTML을 동적으로 생성하였다.
추가로 상품 정보 등록, 상품 정보 수정의 경우 Post 요청 이후 새로고침이 반복될 때마다 똑같은 Post 요청이 전송되는 것을 방지하기 위해 PRG 방식을 적용하였다.
![systemflow](./readme_img/systemflow.png)


### 페이지별 이미지

#### All Item Info Page
- 시스템에 등록된 모든 상품 정보를 확인할 수 있다.
![mainpage](./readme_img/mainpage.png)


#### Page for Item Info Registration
- 시스템에 등록된 모든 상품 정보를 확인할 수 있다.
![registrationpage](./readme_img/registrationpage.png)


#### Specific Item Info Page
- 선택한 특정 상품의 정보를 확인할 수 있다.
![detailpage](./readme_img/detailpage.png)


#### Page for Item Info Modification
- 선택한 특정 상품의 정보를 수정할 수 있다.
![modifypage](./readme_img/modifypage.png)
