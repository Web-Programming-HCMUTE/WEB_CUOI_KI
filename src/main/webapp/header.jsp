<!-- header-start -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<header>
	<div class="header-area bg-black">
		<div id="sticky-header" class="main-header-area">
			<div class="container-fluid p-0">
				<div class="row align-items-center no-gutters">
					<div class="col">
						<div class="main-menu d-none d-lg-block">
							<nav>
								<ul id="navigation" class="d-flex-header">
									<li><a class="active" href="HomeServlet">home</a></li>
									<li><a href="RoomServlet">rooms</a></li>
									<li><a href="contact.jsp">Contact</a></li>
								</ul>
							</nav>
						</div>
					</div>
					<div class="col d-none d-lg-block">
						<div class="book_room">
							<div class="socail_links">

								<jsp:include page="./component/search.jsp"></jsp:include>

							</div>
							<div class="book_btn d-none d-lg-block">
								<a class="popup-with-form" href="#test-form">Đặt phòng</a>
							</div>
							<div>
								<%
								String username = (String) session.getAttribute("user");
								if (username != null) {
								%>
								<a href="HotelAdminServlet" style="height: 42px" class="mx-2 btn btn-primary btn-lg rounded-0"
									role="button" aria-disabled="true">
									<i class="bi bi-person-circle mx-1"></i>${ username}</a>

								<%
								} else {
								%>
								<a href="./login.jsp" style="height: 42px" class="mx-2 btn btn-primary btn-lg rounded-0"
									role="button" aria-disabled="true">Login</a>

								<%
								}
								%>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<style>
.btn-custom {
	
}
</style>
</header>
<!-- header-end -->