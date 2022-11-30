<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>NHÓM 12</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.png" />
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<link rel="stylesheet" href="./css/owl.carousel.min.css" />
<link rel="stylesheet" href="./css/magnific-popup.css" />
<link rel="stylesheet" href="./css/font-awesome.min.css" />
<link rel="stylesheet" href="./css/themify-icons.css" />
<link rel="stylesheet" href="./css/nice-select.css" />
<link rel="stylesheet" href="./css/flaticon.css" />
<link rel="stylesheet" href="./css/gijgo.css" />
<link rel="stylesheet" href="./css/animate.css" />
<link rel="stylesheet" href="./css/slicknav.css" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./_style.css" />
<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- slider_area_start -->
	<div class="slider_area">
		<div class="slider_active owl-carousel">
			<div
				class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center">
								<h3>Tìm nhà trọ</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="single_slider d-flex align-items-center justify-content-center slider_bg_2">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center">
								<h3>Thương Tâm</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider_area_end -->

	<!-- about_area_start -->
	<div class="about_area">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5">
					<div class="about_info">
						<div class="section_title mb-20px">
							<span>About Us</span>
							<h3>Giới thiệu</h3>
						</div>
						<p>Website này giúp các chủ nhà trọ đăng tin cho thuê phòng
							của mình và giúp khách hàng phòng tìm kiếm phòng trọ phù hợp với
							nhu cầu bản thân.</p>
						<a href="#" class="line-button">Learn More</a>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7">
					<div class="about_thumb d-flex">
						<div class="img_1">
							<img src="./img/home/aboutus1.jpg" alt="" />
						</div>
						<div class="img_2">
							<img src="./img/home/aboutus2.jpg" alt="" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- about_area_end -->

	<!-- offers_area_start -->
	<div class="offers_area pb-0">
		<div class="container">
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			<div class="row">
				<c:forEach items="${hotels}" begin="1" end="3" step="1"
					var="hotel">
					<a href="RoomServlet?id=${hotel.id }">
						<div class="col-xl-4 col-md-4 my-3">
							<div class="single_offers">
								<div class="about_thumb">
									<img src="${hotel.image }" height="255.5" alt="" />
								</div>
								<h4 class="p-3 font-weight-bold" style="height: 70px;">${hotel.content }</h4>
								<h4>Số phòng: ${hotel.hotelDetail.numberRoom }</h4>
								<p>Giá: ${hotel.hotelDetail.price } VNĐ</p>
								<p style="height: 200px; display: block; text-align: justify;">
									${hotel.hotelDetail.description }</p>
								<a href="#" class="book_now">Đặt ngay</a>
							</div>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- offers_area_end -->

	<!-- features_room_startt -->
	<div class="features_room">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="section_title text-center my-5">
						<span>Phòng nổi bật</span>
						<h3>Chọn phòng tốt theo nhu cầu</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="rooms_here">
			<div class="single_rooms">
				<div class="room_thumb">
					<img src="./img/home/feature_room1.jpg" width="634" height="396"
						alt="" />
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>Chỉ từ 2.500.000VND/Tháng</span>
							<h3>Phòng cao cấp</h3>
						</div>
						<a href="#" class="line-button">Đặt ngay</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img src="./img/home/feature_room2.jpg" width="634" height="396"
						alt="" />
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>Chỉ từ 2.500.000VND/Tháng</span>
							<h3>Phòng sang trọng</h3>
						</div>
						<a href="#" class="line-button">Đặt ngay</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img src="./img/home/feature_room3.jpg" width="634" height="396"
						alt="" />
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>Chỉ từ 1.500.000VND/Tháng</span>
							<h3>Phòng đơn</h3>
						</div>
						<a href="#" class="line-button">Đặt ngay</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img src="./img/home/feature_room4.jpg" width="634" height="396"
						alt="" />
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>Chỉ từ 2.000.000/Tháng</span>
							<h3>Phòng đôi</h3>
						</div>
						<a href="#" class="line-button">Đặt ngay</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- features_room_end -->

	<!-- forQuery_start -->
	<div class="forQuery">
		<div class="container">
			<div class="row">
				<div class="col-xl-10 offset-xl-1 col-md-12">
					<div class="Query_border">
						<div class="row align-items-center justify-content-center">
							<div class="col-xl-6 col-md-6">
								<div class="Query_text">
									<p>Đặt phòng hoặc thắc mắc?</p>
								</div>
							</div>
							<div class="col-xl-6 col-md-6">
								<div class="phone_num">
									<a href="#" class="mobile_no">+84 377 019 134</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- forQuery_end-->

	<!-- instragram_area_start -->
	<div class="instragram_area">
		<div class="single_instagram">
			<img src="./img/home/instragram0.jpg" width="253.44" height="252.76"
				alt="" />
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img src="./img/home/instragram1.jpg" width="253.44" height="252.76"
				alt="" />
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img src="./img/home/instragram2.jpg" width="253.44" height="252.76"
				alt="" />
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img src="./img/home/instragram3.jpg" width="253.44" height="252.76"
				alt="" />
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img src="./img/home/instragram4.jpg" width="253.44" height="252.76"
				alt="" />
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
	</div>
	<!-- instragram_area_end -->

	<!-- footer -->
	<footer class="footer">
		<div class="footer_top">
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">address</h3>
							<p class="footer_text">
								Số 1, Võ Văn Ngân, Linh Chiểu<br /> Thành Phố Thủ Đức, Việt Nam
							</p>
							<a href="#" class="line-button">Get Direction</a>
						</div>
					</div>
					<div class="col-xl-3 col-md-6 col-lg-3">
						<div class="footer_widget">
							<h3 class="footer_title">Reservation</h3>
							<p class="footer_text">
								+84 377 019 134 <br /> thuongmap@gmail.com
							</p>
						</div>
					</div>
					<div class="col-xl-2 col-md-6 col-lg-2">
						<div class="footer_widget">
							<h3 class="footer_title">Navigation</h3>
							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">Rooms</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">News</a></li>
							</ul>
						</div>
					</div>
					<div class="col-xl-4 col-md-6 col-lg-4">
						<div class="footer_widget">
							<h3 class="footer_title">Newsletter</h3>
							<form action="#" class="newsletter_form">
								<input type="text" placeholder="Enter your mail" />
								<button type="submit">Sign Up</button>
							</form>
							<p class="newsletter_text">Subscribe newsletter to get
								updates</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copy-right_text">
			<div class="container">
				<div class="footer_border"></div>
				<div class="row">
					<div class="col-xl-8 col-md-7 col-lg-9">
						<p class="copy_right">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>

					<div class="col-xl-4 col-md-5 col-lg-3">
						<div class="socail_links">
							<ul>
								<li><a href="#"> <i class="fa fa-facebook-square"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-twitter"></i>
								</a></li>
								<li><a href="#"> <i class="fa fa-instagram"></i>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- link that opens popup -->

	<!-- form itself end-->
	<form id="test-form" class="white-popup-block mfp-hide">
		<div class="popup_box">
			<div class="popup_inner">
				<h3>Check Availability</h3>
				<form action="#">
					<div class="row">
						<div class="col-xl-6">
							<input id="datepicker" placeholder="Check in date" />
						</div>
						<div class="col-xl-6">
							<input id="datepicker2" placeholder="Check out date" />
						</div>
						<div class="col-xl-6">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Adult">1</option>
								<option value="1">2</option>
								<option value="2">3</option>
								<option value="3">4</option>
							</select>
						</div>
						<div class="col-xl-6">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Children">1</option>
								<option value="1">2</option>
								<option value="2">3</option>
								<option value="3">4</option>
							</select>
						</div>
						<div class="col-xl-12">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Room type">Room type</option>
								<option value="1">Laxaries Rooms</option>
								<option value="2">Deluxe Room</option>
								<option value="3">Signature Room</option>
								<option value="4">Couple Room</option>
							</select>
						</div>
						<div class="col-xl-12">
							<button type="submit" class="boxed-btn3">Check
								Availability</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</form>
	<!-- form itself end -->

	<!-- JS here -->
	<script src="./js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="./js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/owl.carousel.min.js"></script>
	<script src="./js/isotope.pkgd.min.js"></script>
	<script src="./js/ajax-form.js"></script>
	<script src="./js/waypoints.min.js"></script>
	<script src="./js/jquery.counterup.min.js"></script>
	<script src="./js/imagesloaded.pkgd.min.js"></script>
	<script src="./js/scrollIt.js"></script>
	<script src="./js/jquery.scrollUp.min.js"></script>
	<script src="./js/wow.min.js"></script>
	<script src="./js/nice-select.min.js"></script>
	<script src="./js/jquery.slicknav.min.js"></script>
	<script src="./js/jquery.magnific-popup.min.js"></script>
	<script src="./js/plugins.js"></script>
	<script src="./js/gijgo.min.js"></script>

	<!--contact js-->
	<script src="./js/contact.js"></script>
	<script src="./js/jquery.ajaxchimp.min.js"></script>
	<script src="./js/jquery.form.js"></script>
	<script src="./js/jquery.validate.min.js"></script>
	<script src="./js/mail-script.js"></script>

	<script src="./js/main.js"></script>
	<script>
		$("#datepicker").datepicker({
			iconsLibrary : "fontawesome",
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>',
			},
		});
		$("#datepicker2").datepicker({
			iconsLibrary : "fontawesome",
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>',
			},
		});
	</script>
</body>
</html>
