<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>personAuctionSuc</title>
<style>
.container.my .content_area {
	min-height: 380px;
	overflow: hidden;
}

.content_area {
	overflow: hidden;
}

.my-page-content {
	flex: 1;
}

.my_profile {
	padding: 0 24px 80px;
}

.content_title {
	display: flex;
}

.content_title.border {
	border-bottom: 3px solid #222;
	padding-bottom: 16px;
}

.title {
	font-size: 24px;
	letter-spacing: -.36px
}

.title>h3 {
	font-size: inherit;
	line-height: 29px
}
/*personAuctionSuc Start  */
*, :after, :before {
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	box-sizing: border-box
}

img, video {
	-webkit-user-drag: none;
	-webkit-touch-callout: none;
	border: 0;
	-moz-user-select: none !important;
	user-select: none !important;
	-webkit-user-select: none;
	vertical-align: top;
}

.container.my.sell {
	/* background-color: #f4f4f4; 백그라운드 색상 뺌*/
	padding: 0 24px 80px;
	height: 100%;

}

/*.content[data-v-38472c0b] {
    margin: 0 auto;
     max-width: 780px;  두명 집어넣어야함 
    padding: 20px 40px 160px
}
*/ 

.product_info_area[data-v-0277b678] {
	padding: 32px;
	min-height: 30%;
	align-items: center;
	display: flex;
	background-color: rgb(244 244 244 / 53%);
	margin: 20px 50px 20px 50px;
}

.product_info[data-v-0277b678] {
	align-items: center;
	background-color: #fff;
	display: flex;
	width: 100%;
	flex-direction: column;
}

.product_info_area .product_info[data-v-0277b678] {
	padding :24px;
	line-height: 26px;
	flex: 1;
	text-align: center;
	background: transparent;
}

.product_info+.product_info[data-v-0277b678] {
	position: relative;
}

.product_info+.product_info[data-v-0277b678]:before {
	background-color: #ebebeb;
	content: "";
	height: 100%;
	left: 0;
	position: absolute;
	top: 1px;
	width: 1px;
}

.product_info[data-v-0277b678] .product {
	border-radius: 10px;
	flex-shrink: 0;
	height: 80px;
	padding-top: 0;
	width: 80px
}

.product[data-v-16369cf2] {
	border-radius: 8px;
	overflow: hidden;
	padding-top: 100%;
	position: relative
}

.product_info[data-v-0277b678] .product .product_img {
	width: 100%
}

.image[data-v-82b93d2c] {
	image-rendering: auto;
	-o-object-fit: cover;
	object-fit: cover
}

.image.full_width[data-v-82b93d2c] {
	height: 100%;
	width: 100%
}

.product_detail[data-v-0277b678] {
	flex: 1;
	overflow: hidden;
	padding-left: 16px
}

li, ol, ul {
	list-style: none
}

.price_list[data-v-638c1354] {
	align-items: center;
	border-top: 1px solid #ebebeb;
	display: flex;
	padding-bottom: 22px;
	padding-top: 28px
}

.price_list .list_item[data-v-638c1354] {
	flex: 1;
	text-align: center;
}

.price_list .list_item+.list_item[data-v-638c1354]:before {
	background-color: #ebebeb;
	content: "";
	height: 40px;
	left: 0;
	position: absolute;
	top: 1px;
	width: 1px
}

.price_list .list_item+.list_item[data-v-638c1354] {
	position: relative
}
</style>
</head>
<body>
	<!-- Header Start -->
	<%@ include file="./inc/header.jsp"%>
	<!-- Header End-->

	<!-- side+contents container  -->
	<div class="container my">

		<%@ include file="./inc/sideNav.jsp"%>

		<!--personAuctionSuc Start  -->
		<div class="content_area my-page-content">
			<div class="container my sell">

				<!---->
				 <div data-v-38472c0b="" class="content"> 
					
					<div class="content_title border">
					<div class="title">
						<h3>거래상세내역</h3>
						<!---->
					</div>
					<!---->
				</div>
				
			
					<div data-v-0277b678="" data-v-6f7b867e="" class="product_info_area" style="border-radius: 10px;">
						<div data-v-0277b678="" class=" product_info">
							<div data-v-16369cf2="" data-v-0277b678="" class="product">

								<picture data-v-82b93d2c="" data-v-16369cf2="" class="picture product_img"> <img data-v-82b93d2c="" alt="상품 이미지" src="./img/man.jpg" class="image full_width"></picture>
								<!---->
								<!---->
								<!---->
							</div>
							<div data-v-0277b678="" class="product_detail">
								<strong data-v-0277b678="" class="model_number"> <!---->developer
								</strong>
								<p data-v-0277b678="" class="model_title">Apple Airpods Pro 2nd Gen with MagSafe Charging Case USB C Type (Korean Ver.)</p>
								<p data-v-0277b678="" class="model_ko">애플 에어팟 프로 2세대 맥세이프 호환 USB C 타입 (국내 정식 발매 제품)</p>
								<div data-v-0277b678="" class="model_desc">
									<p data-v-0277b678="" class="size_txt">ONE SIZE</p>
									<!---->
								</div>
							</div>
						</div>


						<div data-v-0277b678="" class="product_info">
							<div data-v-16369cf2="" data-v-0277b678="" class="product">

								<picture data-v-82b93d2c="" data-v-16369cf2="" class="picture product_img"> <img data-v-82b93d2c="" alt="상품 이미지" src="./img/woman.jpg" class="image full_width"></picture>
								<!---->
								<!---->
								<!---->
							</div>
							<div data-v-0277b678="" class="product_detail">
								<strong data-v-0277b678="" class="model_number"> <!---->kimjava
								</strong>
								<p data-v-0277b678="" class="model_title">Apple Airpods Pro 2nd Gen with MagSafe Charging Case USB C Type (Korean Ver.)</p>
								<p data-v-0277b678="" class="model_ko">애플 에어팟 프로 2세대 맥세이프 호환 USB C 타입 (국내 정식 발매 제품)</p>
								<div data-v-0277b678="" class="model_desc">
									<p data-v-0277b678="" class="size_txt">ONE SIZE</p>
									<!---->
								</div>
							</div>
						</div>


					</div>
					<div data-v-f9ba945e="" data-v-6f7b867e="" class="base-divider"></div>
					<div data-v-787dae80="" data-v-6f7b867e="" class="price_descision_box">
						<ul data-v-638c1354="" data-v-787dae80="" class="price_list">
							<li data-v-638c1354="" class="list_item"><p data-v-638c1354="" class="title">판매자 희망 금액</p> <span data-v-638c1354="" class="price">274,000</span><span data-v-638c1354="" class="unit">원</span></li>
							<li data-v-638c1354="" class="list_item"><p data-v-638c1354="" class="title">최종 낙찰 금액</p> <span data-v-638c1354="" class="price">270,000</span><span data-v-638c1354="" class="unit">원</span></li>
						</ul>
						<div data-v-787dae80="" class="instant_group">
							<div data-v-b6b2883e="" data-v-787dae80="" class="tab_area buy_tab">
								<ul data-v-b6b2883e="" role="tablist" class="tab_list">
									<li data-v-b6b2883e="" role="tab" aria-selected="false" aria-controls="panel1" class="item"><a data-v-b6b2883e="" href="#" class="item_link">판매 입찰</a></li>
									<li data-v-b6b2883e="" role="tab" aria-selected="true" aria-controls="panel2" class="item on"><a data-v-b6b2883e="" href="#" class="item_link">즉시 판매</a></li>
								</ul>
								<!---->
								<!---->
							</div>
							<div data-v-4a7acd23="" data-v-787dae80="" class="price_now">
								<dl data-v-4a7acd23="" class="price_now_box">
									<dt data-v-4a7acd23="" class="price_now_title">즉시 판매가</dt>
									<dd data-v-4a7acd23="" class="price">
										<span data-v-4a7acd23="" class="amount">270,000</span><span data-v-4a7acd23="" class="unit">원</span>
									</dd>
								</dl>
								<div data-v-4a7acd23="" class="price_warning" style="display: none;">
									<!---->
								</div>
							</div>
							<div data-v-787dae80="" class="price_bind">
								<dl data-v-3a2a7b6b="" data-v-787dae80="" class="price_addition">
									<dt data-v-3a2a7b6b="" class="price_title">
										<span data-v-3a2a7b6b="">검수비</span>
										<!---->
									</dt>
									<dd data-v-3a2a7b6b="" class="price_text">무료</dd>
								</dl>
								<dl data-v-3a2a7b6b="" data-v-787dae80="" class="price_addition">
									<dt data-v-3a2a7b6b="" class="price_title">
										<span data-v-3a2a7b6b="">수수료</span>
										<button data-v-3a2a7b6b="" class="btn_title">
											<svg data-v-3a2a7b6b="" xmlns="http://www.w3.org/2000/svg" class="icon sprite-icons info-circle-white">
													<use data-v-3a2a7b6b="" href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-info-circle-white" xlink:href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-info-circle-white"></use></svg>
										</button>
									</dt>
									<dd data-v-3a2a7b6b="" class="price_text">-8,600원</dd>
								</dl>
								<dl data-v-3a2a7b6b="" data-v-787dae80="" class="price_addition">
									<dt data-v-3a2a7b6b="" class="price_title">
										<span data-v-3a2a7b6b="">배송비</span>
										<!---->
									</dt>
									<dd data-v-3a2a7b6b="" class="price_text">선불 ・ 판매자 부담</dd>
								</dl>
							</div>
						</div>
					</div>
					<!---->
					<div data-v-16e14710="" data-v-6f7b867e="" class="buy_total_confirm" is-instant="true">
						<div data-v-679d7250="" data-v-16e14710="" class="price_total">
							<dl data-v-679d7250="" class="price_box">
								<dt data-v-679d7250="" class="price_title">정산금액</dt>
								<dd data-v-679d7250="" class="price">
									<span data-v-679d7250="" class="amount">261,400</span><span data-v-679d7250="" class="unit">원</span>
								</dd>
							</dl>
							<span data-v-679d7250="" class="price_warning" style="display: none;"><em data-v-679d7250="">주의! </em></span>
						</div>
						<div data-v-16e14710="" class="btn_confirm">
							<a data-v-16e14710="" href="#" class="blind full solid false"> 계속하기 </a>
							<button data-v-420a5cda="" data-v-16e14710="" type="button" class="btn full solid false">즉시 판매 계속</button>
						</div>
					</div>
				
				<!---->
				<!---->
				<!---->
			</div>
			<!---->
			<!---->
			
			</div> 
		</div>
	</div>
</body>
</html>