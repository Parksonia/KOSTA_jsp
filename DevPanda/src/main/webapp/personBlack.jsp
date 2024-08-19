<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PersonBlack</title>
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

.my_purchase {
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

/*블랙리스트 목록 시작 */
a {
	-webkit-tap-highlight-color: rgba(0, 0, 0, .1);
	color: inherit
}

/*sort head start*/
.purchase_head {
	align-items: center;
	border-bottom: 1px solid #ebebeb;
	display: flex;
	padding: 12px
}

.head_product {
	display: flex
}

.total-rows {
	color: rgba(34, 34, 34, .8);
	font-size: 13px;
	letter-spacing: -.07px
}

.head_status {
	align-items: center;
	display: flex;
	margin-left: auto;
	text-align: right
}

.head_status .status_box {
	margin-left: 20px;
	width: 184px;
}

.head_status .status_box.active_first {
	font-weight: 700
}

.bid.finished .head_status .status_box.field_date_purchased {
	display: block
}

.bid.finished .head_status .status_box.field_expires_at {
	display: block
}

.head_status .status_link {
	display: inline-block;
	font-size: 13px;
	letter-spacing: -.07px;
	line-height: 24px;
	padding-right: 16 px;
	position: relative;
}

.head_status .status_link:after {
	/*:after속성은 링크나 다른요소 뒤에 바로 붙을 수 있게함?  */
	background-image: url("./img/expand-up-down-fill.png");
	content: "";
	height: 24px;
	position: absolute;
	/* right: -4px; */
	top: 0;
	width: 24px;
}

.head_status .status_txt {
	display: inline-block;
	vertical-align: top
}
/*sort head end*/

/*list start */
li, ol, ul {
	list-style: none
}

.purchase_list_display_item {
	align-items: center;
	border-bottom: 1px solid #ebebeb;
	cursor: pointer;
	display: flex;
	padding: 12px;
}

.purchase_list_product {
	display: flex
}

.purchase_list_product .list_item_img_wrap {
	position: relative
}

.purchase_list_product .list_item_img_wrap .list_item_img {
	border-radius: 12px;
	height: 80px;
	-o-object-fit: cover;
	object-fit: cover;
	width: 80px;
}

.purchase_list_product .list_item_title_wrap {
	align-self: center;
	display: flex;
	flex-direction: column;
	margin-left: 16px;
	width: 100%;
}

.purchase_list_product .list_item_title_wrap .list_itme_div_user {
	color: #ebebeb;
	font-size: 16px;
	letter-spacing: -.27px;
	line-height: 1.2222222222
}

.purchase_list_product .list_item_title_wrap .list_item_title {
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	display: -webkit-box;
	font-size: 14px;
	font-weight: 700;
	line-height: 17px;
	overflow: hidden;
	text-overflow: ellipsis;
}

.purchase_list_product .list_item_title_wrap .list_item_description {
	-webkit-line-clamp: 1;
	-webkit-box-orient: vertical;
	color: #0c0c0c7d;
	display: -webkit-box;
	font-size: 13px;
	letter-spacing: -.21px;
	letter-spacing: -.5px;
	line-height: 19px;
	margin-top: 4px;
	overflow: hidden;
	text-overflow: ellipsis;
}

.list_item_status {
	align-items: center;
	display: flex;
	margin-left: auto;
	text-align: right
}

.list_item_status .list_item_column {
	margin-left: 10px;
	width: 184px;
}

.list_item_status .column_secondary {
	font-size: 13px;
	letter-spacing: -.07px
}

.list_item_status .column_last {
	align-self: center;
	display: flex;
	flex-direction: column;
	align-items: flex-end;
	flex-shrink: 0;
	margin-left: auto;
}

.list_item_status .column_last .btn {
	align-items: center;
	display: flex;
	font-size: 14px;
	letter-spacing: -.21px;
	margin-right: -6px;
	padding: 0 6px
}

.list_item_status .column_last .btn.btn_add {
	/* border: 1px solid #222; */
	border-radius: 10px;
	font-size: 12px;
	height: 34px;
	letter-spacing: -.06px;
	line-height: 32px;
	margin-right: 0;
	padding: 0 14px;
	background-color: #222;
	color: #fff;
	font-weight: 700;
}

/*list end  */

/*pagination  */
.pagination {
	padding: 28px 0
}

.pagination_box {
	font-size: 0;
	position: relative;
	text-align: center
}

.pagination_box.first .prev_btn_box, .pagination_box.last .next_btn_box
	{
	display: none
}

.page_bind {
	display: inline-block;
	vertical-align: top
}

.btn_page {
	color: rgba(34, 34, 34, .5);
	display: inline-block;
	font-size: 16px;
	padding: 0 8px
}

.btn_page+.btn_page {
	margin-left: 12px
}

.btn_page:hover {
	-webkit-text-decoration: underline;
	text-decoration: underline
}

.btn_page.active {
	color: #222;
	font-weight: 700
}

.next_btn_box, .prev_btn_box {
	display: inline-block;
	vertical-align: top
}

.next_btn_box .btn_arr, .prev_btn_box .btn_arr
	{
	height: 24px;
	padding: 3px;
	width: 24px
}

.next_btn_box .btn_arr+.btn_arr, .prev_btn_box .btn_arr+.btn_arr
	{
	margin-left: 5px
}

.prev_btn_box {
	margin-right: 25px
}

.next_btn_box {
	margin-left: 25px
}

[class*=arr-page-] {
	height: 22px;
	width: 18px
}
/*pagination end */

/* modal start */
.layer {
	display: none;
	bottom: 0;
	left: 0;
	position: fixed;
	right: 0;
	top: 0;
	z-index: 1010;
	bottom: 0;
}

.layer .layer-background {
	background-color: rgba(34, 34, 34, .5);
	bottom: 0;
	height: 100%;
	left: 0;
	position: absolute;
	right: 0;
	top: 0;
	width: 100%
}

.layer_delivery .layer_container {
	width: 520px;
}

.layer_container {
	background-color: #fff;
	border-radius: 16px;
	box-shadow: 0 4px 10px 0 rgba(0, 0, 0, .1);
	left: 50%;
	overflow: hidden;
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%);
	width: 448px
}

.btn_layer_close {
	cursor: pointer;
	position: absolute;
	right: 20px;
	top: 14px
}

.layer_header .title {
	background-color: #fff;
	color: #000;
	font-size: 18px;
	font-weight: 700;
	letter-spacing: -.27px;
	letter-spacing: -.15px;
	line-height: 22px;
	min-height: 44px;
	padding: 18px 50px;
	text-align: center
}

.layer_delivery .delivery_bind {
	padding: 0 32px 56px;
}

.order_detail_header_product {
	padding: 18px 0;
	border-bottom: 1px solid #ebebeb;
	border-top: 1px solid #ebebeb;
}

.order_detail_header_product .product_wrap {
	display: flex;
	position: relative;
	width: 100%
}

.product_wrap .product_img_flex_box {
	display: flex;
	flex-direction: column;
	justify-content: center
}

.product_wrap .product_img_flex_box .product_img_wrap {
	position: relative
}

.product_wrap .product_img_flex_box .product_img_wrap .product_img {
	border-radius: 12px;
	-o-object-fit: cover;
	object-fit: cover
}

.product_wrap .product_img {
	border-radius: 12px;
	height: 100px;
	-o-object-fit: cover;
	object-fit: cover;
	width: 100px
}

.product_wrap .product_info_wrap {
	display: flex;
	flex: 1;
	flex-direction: column;
	font-size: 14px;
	justify-content: center;
	padding: 0 12px;
	text-align: left;
	width: 100%
}

.product_wrap .product_info {
	height: -webkit-fit-content;
	height: -moz-fit-content;
	height: fit-content;
	position: relative
}

.product_wrap .product_info .div_user {
	color: #ebebeb;
	font-size: 16px;
	letter-spacing: -.27px;
	line-height: 1.2222222222;
}

.product_wrap .product_info .product_description {
	color: rgba(34, 34, 34, .5);
	font-size: 12px;
	line-height: 20px;
	margin: 0 0 2px;
}

.product_title {
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	display: -webkit-box;
	overflow: hidden;
	text-overflow: ellipsis;
	font-weight: bold;
}

.section_title {
	margin-top: 31px;
	border-bottom: 3px solid black;
}

.title {
	font-size: 16px;
	letter-spacing: -.16px;
	line-height: 20px;
	padding: 6px 0 7px;
}

.order_number {
	padding: 0 10px;
	letter-spacing: -.09px;
	line-height: 28px;
}

.dropdown_head {
	align-items: center;
	border-bottom: 1px solid #ebebeb;
	cursor: pointer;
	display: flex;
	padding: 17px 0 19px
}

.dropdown_head .sort {
	font-size: 14px;
	letter-spacing: -.21px;
	min-width: 68px;
	width: 68px
}

.dropdown_head .title_box {
	margin-right: 10px
}

.dropdown_head .title {
	font-size: 15px;
	letter-spacing: -.15px
}

.dropdown_content {
	background-color: #fafafa;
	border-bottom: 1px solid #ebebeb;
	display: block;
	font-size: 14px;
	padding: 30px 30px 28px
}

.dropdown_content .content {
	max-width: 640px;
	word-break: break-word
}

/* modal end */
</style>


</head>

<body>

	<!-- Header Start -->
	<%@ include file="./inc/header.jsp"%>
	<!-- Header End-->

	<div class="container my">
		<%@ include file="./inc/sideNav.jsp"%>

		<!-- personBlack Start  -->
		<div class="content_area my-page-content">
			<div class="my_purchase">

				<div class="content_title border">
					<div class="title">
						<h2>블랙리스트 관리</h2>
					</div>
				</div>


				<!---->
				<div class="purchase_list finished bid">

					<!--sort head start : 구매내역에서 가져옴-->
					<div class="purchase_head">
						<div class="head_product">
							<div class="total-rows">전체 3</div>
						</div>
						<div class="head_status">
							<div class="status_box field_date_purchased">
								<a href="#" class="status_link"><span class="status_txt">거래일</span></a>
							</div>

							<div class="status_box field_expires_at">
								<a href="#" class="status_link"><span class="status_txt">신고일</span></a>
							</div>

							<div class="status_box field_expires_at">
								<span class="status_txt"></span>
							</div>
						</div>
					</div>
					<!--sort head end-->

					<div class="modal_btn">
						<div>
							<div class="purchase_list_display_item" style="background-color: rgb(255, 255, 255);">

								<div class="purchase_list_product">
									<div class="list_item_img_wrap">
										<img alt="product_image" src="./img/woman.jpg" class="list_item_img">

									</div>
									<div class="list_item_title_wrap">
										<!---->
										<p class="list_itme_div_user">[개인회원]</p>
										<p class="list_item_title">kimjava</p>
										<p class="list_item_description">
											<span>제일좋아하는것은김자바</span>
										</p>
									</div>
								</div>

								<div class="list_item_status">
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_last">
										<button class="btn btn_add" type="button">해제하기</button>
										<!-- 버튼에 해제 처리해야함  -->
									</div>
								</div>
							</div>

						</div>
					</div>

					<div class="modal_btn">
						<div>
							<div class="purchase_list_display_item" style="background-color: rgb(255, 255, 255);">

								<div class="purchase_list_product">
									<div class="list_item_img_wrap">
										<img alt="product_image" src="./img/woman.jpg" class="list_item_img">

									</div>
									<div class="list_item_title_wrap">
										<!---->
										<p class="list_itme_div_user">[개인회원]</p>
										<p class="list_item_title">kimjava</p>
										<p class="list_item_description">
											<span>제일좋아하는것은김자바</span>
										</p>
									</div>
								</div>

								<div class="list_item_status">
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_last">
										<button class="btn btn_add" type="button">해제하기</button>
									</div>
								</div>
							</div>

						</div>
					</div>
					<div class="modal_btn">
						<div>
							<div class="purchase_list_display_item" style="background-color: rgb(255, 255, 255);">

								<div class="purchase_list_product">
									<div class="list_item_img_wrap">
										<img alt="product_image" src="./img/man.jpg" class="list_item_img">

									</div>
									<div class="list_item_title_wrap">
										<!---->
										<p class="list_itme_div_user">[개인회원]</p>
										<p class="list_item_title">developer</p>
										<p class="list_item_description">
											<span>제일좋아하는것은김자바</span>
										</p>
									</div>
								</div>

								<div class="list_item_status">
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_secondary">
										<p class="text-lookup secondary_title display_paragraph" style="color: rgb(34, 34, 34);">24/08/15</p>
									</div>
									<div class="list_item_column column_last">
										<button class="btn btn_add" type="button">해제하기</button>
									</div>
								</div>
							</div>

						</div>
					</div>

				</div>
				<!---->

				<!--pagination start  -->
				<div class="pagination">
					<div class="pagination_box first last">
						<div class="prev_btn_box">
							<a href="#" class="btn_arr">
									<svg xmlns="http://www.w3.org/2000/svg" class="arr-page-first icon sprite-icons">
									<use href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-first" xlink:href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-first"></use>
									</svg>
							</a>
							<a href="#" class="btn_arr">
								<svg xmlns="http://www.w3.org/2000/svg" class="arr-page-prev icon sprite-icons">
								<use href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-prev" xlink:href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-prev"></use>
								</svg>
							</a>
						</div>
						<div class="page_bind">
							<a href="#" class="btn_page active"> 1 </a>
						</div>
						<div class="next_btn_box">
							<a href="#" class="btn_arr">
								<svg xmlns="http://www.w3.org/2000/svg" class="arr-page-next icon sprite-icons">
									<use href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-next" xlink:href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-next"></use>
								</svg>
							</a>
							<a href="#" class="btn_arr">
								<svg xmlns="http://www.w3.org/2000/svg" class="arr-page-last icon sprite-icons">
									<use href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-last" xlink:href="/_nuxt/902a7eb5512d7d4f25543902cfd1ccdc.svg#i-arr-page-last"></use>
								</svg>
							</a>
						</div>
					</div>
				</div>
				<!--pagination end  -->

				<!-- modal start -->

				<div class="layer_delivery layer">
					<div class="layer-background"></div>
					<!---->
					<div class="layer_container">
						<a href="#" class="btn_layer_close"><div>
								<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="24" height="24" viewBox="0 0 24 24">
									<path d="M 20.496094 2.9921875 A 0.50005 0.50005 0 0 0 20.146484 3.1464844 L 12 11.292969 L 3.8535156 3.1464844 A 0.50005 0.50005 0 0 0 3.4941406 2.9941406 A 0.50005 0.50005 0 0 0 3.1464844 3.8535156 L 11.292969 12 L 3.1464844 20.146484 A 0.50005 0.50005 0 1 0 3.8535156 20.853516 L 12 12.707031 L 20.146484 20.853516 A 0.50005 0.50005 0 1 0 20.853516 20.146484 L 12.707031 12 L 20.853516 3.8535156 A 0.50005 0.50005 0 0 0 20.496094 2.9921875 z"></path>
								</svg>
							</div>
						</a>
						<div class="layer_header">
							<h2 class="title">차단 상세 내역</h2>
						</div>

						<div class="layer_content">
							<div class="delivery_bind">

								<div class="order_detail_header_product">
									<div class="product_wrap tag_top">
										<div class="product_img_flex_box">
											<div class="product_img_wrap">
												<img alt="product_image" src="./img/woman.jpg" class="product_img" style="background-color: rgb(244, 244, 244);">
												<!---->
											</div>
										</div>
										<div class="product_info_wrap">
											<div class="product_info">
												<div class="tag_wrap">
													<!---->
												</div>
												<p class="div_user">[개인회원]</p>
												<p class="product_title">김자바</p>
												<p class="product_description">kimjava@gmail.com</p>
												<!---->

											</div>
										</div>
									</div>
								</div>



								<div item="[object Object]">

									<div class="order_info_items_wrap empty_header">
										<div class="section_title">
											<div class="title_box">
												<h4 class="title">
													거래 번호 <em class="order_number">ABC123-CD456-90</em>
												</h4>
											</div>
											<!---->
										</div>

									</div>
									<!---->
								</div>
								<div item="[object Object]">

									<div class="shipping_address_wrap">
										<div class="section_title">
											<div class="title_box">
												<h4 class="title">신고내역</h4>
											</div>
											<!---->
										</div>

										<div class="dropdown">
											<div class="dropdown_head">
												<strong class="sort">제목</strong>
												<div class="title_box">
													<p class="title">갑질이 너무 심합니다.</p>
												</div>
											</div>
											<div class="dropdown_content">
												<div class="content">
													<p>
														<span>처음 거래하는데</span>
													</p>
													<p>
														<span>다시는 거래하고 싶지 않네요</span>
													</p>

												</div>
											</div>
										</div>

									</div>
									<!---->
								</div>

							</div>



							<!---->
						</div>
					</div>
				</div>
			</div>

			<!-- modal end  -->

			<script>
					/* 스크립트가 모달보다 밑에 있어야함 주의 Uncaught TypeError */
					const modal = document.querySelector('.layer');
					const modalOpen = document.querySelectorAll('.modal_btn');
					const modalClose = document.querySelector('.btn_layer_close');

				    // 열기 버튼들을 순회하며 각각에 클릭 이벤트를 등록
				    modalOpen.forEach(eachdiv => {
				    	eachdiv.addEventListener('click', function() {
				            // display 속성을 block으로 변경
				            modal.style.display = 'block';
				        });
				    });

				    // 닫기 버튼을 눌렀을 때 모달팝업이 닫힘
				    modalClose.addEventListener('click', function() {
				        // display 속성을 none으로 변경
				        modal.style.display = 'none';
				    });
					</script>
		</div>
	</div>
</body>
</html>