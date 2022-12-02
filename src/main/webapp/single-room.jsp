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
	<style>
.img-custom {
	min-width: 100%;
	height: auto;
}
</style>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- bradcam_area_start -->
	<!-- bradcam_area_end -->

	<!--================Blog Area =================-->
	<section class="blog_area single-post-area section-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 posts-list">
					<div class="single-post">
						<div class="feature-img">
							<img class="img-custom" src="${hotel.image}" alt="">
						</div>
						<div class="blog_details">
							<h2>${hotel.content}</h2>
							<ul class="blog-info-link mt-3 mb-4">
								<li><i class="fa fa-user"></i>${hotel.hotelDetail.address }</li>

							</ul>
							<p class="excert">Diện tích: ${hotel.hotelDetail.area } m2</p>
							<p class="excert">Giá phòng: ${hotel.hotelDetail.price } VNĐ
							</p>
							<div class="quote-wrapper">
								<div class="quotes">${hotel.hotelDetail.description }</div>
							</div>

						</div>
					</div>
					<div class="navigation-top">
						<div class="d-sm-flex justify-content-between text-center">
							<p class="like-info">
								<span class="align-middle"><i class="fa fa-heart"></i></span>
								Lily and 4 people like this
							</p>
							<div class="col-sm-4 text-center my-2 my-sm-0">
								<!-- <p class="comment-count"><span class="align-middle"><i class="fa fa-comment"></i></span> 06 Comments</p> -->
							</div>
							<ul class="social-icons">
								<li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-behance"></i></a></li>
							</ul>
						</div>
						<div class="navigation-area">
							<div class="row">
								<div
									class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="img/post/preview.png" alt="">
										</a>
									</div>
									<div class="arrow">
										<a href="#"> <span class="lnr text-white ti-arrow-left"></span>
										</a>
									</div>
									<div class="detials">
										<p>Prev Post</p>
										<a href="#">
											<h4>Space The Final Frontier</h4>
										</a>
									</div>
								</div>
								<div
									class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
									<div class="detials">
										<p>Next Post</p>
										<a href="#">
											<h4>Telescopes 101</h4>
										</a>
									</div>
									<div class="arrow">
										<a href="#"> <span class="lnr text-white ti-arrow-right"></span>
										</a>
									</div>
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="img/post/next.png" alt="">
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="blog-author"></div>
					<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

					<div class="comments-area">
						<h4>05 Comments</h4>
						<c:forEach items="${hotel.comment}" var="comment">
							<div class="comment-list">
								<div class="single-comment justify-content-between d-flex">
									<div class="user justify-content-between d-flex">
										<div class="thumb">
											<img src="img/comment/comment_1.png" alt="">
										</div>
										<div class="desc">
											<p class="comment"
												style="color: black; font-weight: 500; font-size: 18px;">
												${comment.content }</p>
											<div class="d-flex justify-content-around">
												<div class="d-flex align-items-center">
													<h5>
														<a href="#"> ${comment.user.userLogin.username }</a>
													</h5>
													<fmt:formatDate value="${ comment.commentDate}"
														pattern="dd/MM/yyyy" var="newdatevar" />
													<p>
														<c:out value="${newdatevar}" />
													</p>
												</div>
												<div class="reply-btn">
													<a
														href="RoomServlet?id=${hotel.id}&comment=${comment.id}&action=delete-comment"
														class="btn-reply text-uppercase">DELETE</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<%@ page import="model.UserLogin"%>
					<%
					UserLogin userauth = (UserLogin) session.getAttribute("user");
					if (userauth == null) { %>
						<div class="comment-form"> 
							<h4>Hãy đăng nhập để viết bình luận <a href="./login.jsp">Login</a> </h4>
						</div>
					<% } else {
					%>
					<div class="comment-form">
						<h4>Leave a Reply</h4>
						<form class="form-contact comment_form"
							action="${pageContext.request.contextPath }/RoomServlet?id=${hotel.id}&action=create-comment"
							method="post" id="commentForm">
							<div class="row">
								<div class="col-12">
									<div class="form-group">
										<textarea class="form-control w-100" name="content"
											id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
									</div>
								</div>

							</div>
							<div class="form-group">
								<button type="submit"
									class="button button-contactForm btn_1 boxed-btn">Send
									Comment</button>
							</div>
						</form>
					</div>
				<%} %>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form action="#">
								<div class="form-group">
									<div class="input-group mb-3">
										<input type="text" name="content" class="form-control"
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


						<aside class="single_sidebar_widget instagram_feeds">
							<h4 class="widget_title">Instagram Feeds</h4>
							<ul class="instagram_row flex-wrap">
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_5.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_6.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_7.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_8.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_9.png" alt="">
								</a></li>
								<li><a href="#"> <img class="img-fluid"
										src="img/post/post_10.png" alt="">
								</a></li>
							</ul>
						</aside>
						<aside class="single_sidebar_widget newsletter_widget">
							<h4 class="widget_title">Newsletter</h4>
							<form action="#">
								<div class="form-group">
									<input type="email" class="form-control"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter email'"
										placeholder='Enter email' required>
								</div>
								<button
									class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
									type="submit">Subscribe</button>
							</form>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ Blog Area end =================-->

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