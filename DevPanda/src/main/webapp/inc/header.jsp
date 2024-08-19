<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEVPanda|개발자 거래플랫폼</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<!--  <link href="./css/mypage.css" rel="stylesheet"> -->
<style>
body {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
}


.header {
	width: 100%;
	height: 120px;
	background-color: #FFFEF7;
	box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.1);
}

.header_top .top_inner {
	display: flex;
	height: 22px;
	padding: 8px 40px 0;
}

.header_top .top_list {
	align-items: center;
	display: flex;
	margin-left: auto;
	list-style-type: none;
}

.header_top .top_item+.top_item {
	margin-left: 24px;
}

.header_top .top_link {
	align-items: center;
	color: rgba(34, 34, 34, .8);
	display: flex;
	font-size: 12px;
	letter-spacing: -.06px;
	text-decoration-line: none;
}

.main_inner {
	align-items: center;
	display: flex;
	height: 64px;
	justify-content: space-between;
	min-width: 320px;
	padding: 20px 40px;
}

.main_inner img{
margin:0;
padding:0;
height:100px;
	
}

.main_inner .center {
	align-items: center;
	display: flex;
	margin: 0 20px;
	max-width: 466px;
}

.main_inner .right {
	display: flex;
	flex-shrink: 0;
	justify-content: flex-end;
	min-width: 120px;
}

.gnb_area {
	margin-left: auto;
}

.gnb_area, .gnb_list {
	align-items: center;
	display: flex;
	list-style-type: none;
}

.gnb_item {
	margin-right: 40px;
}

.gnb_link {
	text-decoration-line: none;
	color: black;
}

.logo {
	text-decoration-line: none;
	color: black;
	margin:0
}

.search_btn_box {
	display: inline-flex
}

.search_btn_box .btn_search {
	display: inherit;
	text-decoration-line: none;
	color: black;
}
</style>
</head>
<body>
	<div class="header">
		<div class="header_top">
			<div class="top_inner">
				<ul class="top_list">
					<li class="top_item"><a class="top_link" href="/mypage">마이페이지</a>
					</li>
					<li class="top_item"><a class="top_link" href="/saved">관심</a>
					</li>
					<li class="top_item"><a class="top_link" href="#notifications">알림</a>
					</li>
					<li class="top_item"><a class="top_link" href="/">로그아웃</a></li>
				</ul>
			</div>
		</div>
		
		<div class="header_main">
			<div class="main_inner">
				<h1>
					<a class="logo" href="/" aria-label="홈">DevPanda</a>
				</h1>
				
				<div class="center"></div>
				<div class="right">
					<div class="gnb_area">
						<nav class="gnb" id="pcGnbContainer">
							<ul class="gnb_list" id="pcGnbList">
								<li class="gnb_item"><a class="gnb_link" href="/">HOME</a></li>
								<li class="gnb_item"><a class="gnb_link" href="/acution">AUCTION</a></li>
							</ul>
						</nav>
						<div class="search_btn_box">
							<a class="btn_search" href="#" aria-label="검색"> <svg
									xmlns="http://www.w3.org/2000/svg" height="24px"
									viewBox="0 -960 960 960" width="24px" fill="#5f6368">
									<path
										d="M784-120 532-372q-30 24-69 38t-83 14q-109 0-184.5-75.5T120-580q0-109 75.5-184.5T380-840q109 0 184.5 75.5T640-580q0 44-14 83t-38 69l252 252-56 56ZM380-400q75 0 127.5-52.5T560-580q0-75-52.5-127.5T380-760q-75 0-127.5 52.5T200-580q0 75 52.5 127.5T380-400Z" />
								</svg>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>