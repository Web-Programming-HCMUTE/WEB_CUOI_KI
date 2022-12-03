<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Nhóm 12</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
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
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<jsp:include page="./component/header.jsp"></jsp:include>

	<!-- bradcam_area_start -->
	<div class="bradcam_area breadcam_bg">
		<h3>Search</h3>
	</div>
	<!-- bradcam_area_end -->

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!--================Blog Area =================-->
	<section class="blog_area section-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
						<c:forEach items="${hotels}" var="hotel">
							<article class="blog_item">
								<div class="blog_item_img">
									<img class="card-img rounded-0" src="${hotel[0].image }" alt=""
										height="250" style="object-fit: cover"> <a href="#"
										class="blog_item_date">
										<h3>${hotel[0].createDate.day }</h3>
										<p>/${hotel[0].createDate.month }</p>
									</a>
								</div>

								<div class="blog_details">
									<a class="d-inline-block" href="RoomServlet?id=${hotel[0].id }">
										<h2>${hotel[0].content }</h2>
									</a>
								<ul class="blog-info-link">
                                    <li><a href="#"><i class="fa fa-user"></i> Số phòng: ${hotel[1].numberRoom }</a></li>
                                    <li><a href="#"><i class="fa fa-comments"></i>Giá: ${hotel[1].price } VNĐ</a></li>
                                </ul>
								
								</div>
							</article>

						</c:forEach>

						<nav class="blog-pagination justify-content-center d-flex">
							<ul class="pagination">
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Previous"> <i class="ti-angle-left"></i>
								</a></li>
								<li class="page-item"><a href="#" class="page-link">1</a></li>
								<li class="page-item active"><a href="#" class="page-link">2</a>
								</li>
								<li class="page-item"><a href="#" class="page-link"
									aria-label="Next"> <i class="ti-angle-right"></i>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form action="#">
								<div class="form-group">
									<div class="input-group mb-3">
										<input type="text" class="form-control"
											placeholder='Search Keyword' onfocus="this.placeholder = ''"
											onblur="this.placeholder = 'Search Keyword'">
										<div class="input-group-append">
											<button class="btn" type="button">
												<i class="ti-search"></i>
											</button>
										</div>
									</div>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
									type="submit">Search</button>
							</form>
						</aside>

						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Số Phòng</h4>
							<ul class="list cat-list">
								<li><a href="SearchServlet?${pageContext.request.queryString}&room=1" class="d-flex">
										<p>1-2 Phòng</p>
								
								</a></li>
								<li><a href="SearchServlet?${pageContext.request.queryString}&room=3" class="d-flex">
										<p>2-3 Phòng</p>
										
								</a></li>
								<li><a href="SearchServlet?${pageContext.request.queryString}&room=5" class="d-flex">
										<p> 3-5 Phòng</p>
										
							</ul>
						</aside>
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Giá</h4>
							<ul class="list cat-list">
								<li><a href="SearchServlet?${pageContext.request.queryString}&price=2000000" class="d-flex">
										<p>0 - 2000000 VNĐ</p>
								
								</a></li>
								<li><a href="SearchServlet?${pageContext.request.queryString}&price=4000000" class="d-flex">
										<p>2000000 - 4000000 VNĐ</p>
										
								</a></li>
								<li><a href="SearchServlet?${pageContext.request.queryString}&price=6000000" class="d-flex">
										<p>6000000 VNĐ</p>
										
							</ul>
						</aside>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Blog Area =================-->

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
	<script src="js/vendor/modernizr-3.5.0.min.js"></script>
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<script src="js/scrollIt.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/nice-select.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/gijgo.min.js"></script>

	<!--contact js-->
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>

	<script src="js/main.js"></script>
	<script>
		$('#datepicker').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}
		});
		$('#datepicker2').datepicker({
			iconsLibrary : 'fontawesome',
			icons : {
				rightIcon : '<span class="fa fa-caret-down"></span>'
			}

		});
	</script>



</body>
</html>