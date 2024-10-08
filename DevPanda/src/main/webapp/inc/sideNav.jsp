<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEVPanda|개발자 거래플랫폼</title>
<style>

body, button, dd, div, dl, dt, fieldset, figcaption, figure, form, h1,
	h2, h3, h4, h5, h6, input, legend, li, ol, p, select, table, td,
	textarea, th, ul {
	margin: 0;
	padding: 0;
	font-family: "Nanum Gothic", sans-serif;
	font-style: normal;
	color:#222;
}
a,a:active,a:focus,a:hover {
    -webkit-text-decoration: none;
    text-decoration: none
}


/*꽉 채워서*/
 .container.my {
	display: flex;
	margin-left: auto;
	margin-right: auto;
	padding: 40px 40px 160px 5px; 
	border-bottom: 0;
} 
/*중앙에배치*/
/* .container.my{
    display: flex;
    margin-left: auto;
    margin-right: auto;
    max-width: 1280px;
    padding: 40px 40px 160px;
}
 */

.container.my .snb_area {
	margin-right: 40px;
	width: 180px;
	height:1280px;
	background-color: #f9f9f9;
}

.container.my .snb_main_title {
	font-size: 24px;
	font-weight: 700;
	letter-spacing: -.36px;
	letter-spacing: -.15px;
	line-height: 29px;
	padding-bottom: 30px;
}

.snb_title {
	display: flex;
	font-size: 18px;
	font-weight: 700;
	letter-spacing: -.27px;
	line-height: 22px;
	margin-bottom: 12px;
	vertical-align: top;
	align-items: center;
}

.cart_icon {
	margin-right: 5px;
}

.snb_area+div {
	flex: 1;
}

.menu_item {
	list-style-type: none;
	padding: 3px 0px 3px 0;
}

.menu_link {
	color: black;
	font-size: 13px;
	letter-spacing: -.15px;
	line-height: 18px
}

.snb_list+.snb_list {
	margin-top: 40px
}
</style>

</head>
<body>

	<div class="snb_area">
		<a href="/mypage"><h2 class="snb_main_title">마이 페이지</h2></a>
		<nav class="snb">
			<div class="snb_list">
				<strong class="snb_title"> <svg class="cart_icon" xmlns="http://www.w3.org/2000/svg" height="21px" viewBox="0 -960 960 960" width="21px" fill="#5f6368">
							<path d="M280-80q-33 0-56.5-23.5T200-160q0-33 23.5-56.5T280-240q33 0 56.5 23.5T360-160q0 33-23.5 56.5T280-80Zm400 0q-33 0-56.5-23.5T600-160q0-33 23.5-56.5T680-240q33 0 56.5 23.5T760-160q0 33-23.5 56.5T680-80ZM246-720l96 200h280l110-200H246Zm-38-80h590q23 0 35 20.5t1 41.5L692-482q-11 20-29.5 31T622-440H324l-44 80h480v80H280q-45 0-68-39.5t-2-78.5l54-98-144-304H40v-80h130l38 80Zm134 280h280-280Z" /></svg> 구매내역조회
				</strong>
				<ul class="snb_menu">
					<li class="menu_item"><a href="${pageContext.request.contextPath}/personBidList.jsp" class="menu_link">입찰내역조회</a></li>
					<li class="menu_item"><a href="/personBidSucList.jsp" class="menu_link">낙찰내역조회</a></li>
				</ul>
			</div>
			<div class="snb_list">
				<strong class="snb_title"><svg class="cart_icon" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#5f6368">
								<path d="M856-390 570-104q-12 12-27 18t-30 6q-15 0-30-6t-27-18L103-457q-11-11-17-25.5T80-513v-287q0-33 23.5-56.5T160-880h287q16 0 31 6.5t26 17.5l352 353q12 12 17.5 27t5.5 30q0 15-5.5 29.5T856-390ZM513-160l286-286-353-354H160v286l353 354ZM260-640q25 0 42.5-17.5T320-700q0-25-17.5-42.5T260-760q-25 0-42.5 17.5T200-700q0 25 17.5 42.5T260-640Zm220 160Z" /></svg> 판매내역조회 </strong>
				<ul class="snb_menu">
					<li class="menu_item"><a href="/personBidList.jsp" class="menu_link">입찰내역조회</a></li>
					<li class="menu_item"><a href="/personBidSucList.jsp" class="menu_link">낙찰내역조회</a></li>
				</ul>
			</div>
			<div class="snb_list">
				<strong class="snb_title"> <a> <svg class="cart_icon" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#5f6368">
								<path d="M791-55 686-160H160v-112q0-34 17.5-62.5T224-378q45-23 91.5-37t94.5-21L55-791l57-57 736 736-57 57ZM240-240h366L486-360h-6q-56 0-111 13.5T260-306q-9 5-14.5 14t-5.5 20v32Zm496-138q29 14 46 42.5t18 61.5L666-408q18 7 35.5 14t34.5 16ZM568-506l-59-59q23-9 37-29.5t14-45.5q0-33-23.5-56.5T480-720q-25 0-45.5 14T405-669l-59-59q23-34 58-53t76-19q66 0 113 47t47 113q0 41-19 76t-53 58Zm38 266H240h366ZM457-617Z" /></svg>
				</a> 블랙리스트관리
				</strong>
				<ul class="snb_menu">
					<li class="menu_item"><a href="/personBlack.jsp" class="menu_link">판매자 블랙리스트</a></li>
					<li class="menu_item"><a href="/personBlack.jsp" class="menu_link">구매자 블랙리스트</a></li>
				</ul>
			</div>
			<div class="snb_list">
				<strong class="snb_title"> <a> <svg class="cart_icon" xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#5f6368">
								<path d="M0 0h24v24H0z" fill="none" />
								<path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z" /></svg>
				</a> 내정보
				</strong>
				<ul class="snb_menu">
					<li class="menu_item"><a href="/personInfo.jsp" class="menu_link">정보수정</a></li>
				</ul>
			</div>
		</nav>
	</div>

</body>
</html>