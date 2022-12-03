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

								<jsp:include page="./search.jsp"></jsp:include>

							</div>
							<div class="book_btn d-none d-lg-block">
								<jsp:include page="booking.jsp"></jsp:include>
							</div>
							<div>
							<%@ page import="model.UserLogin" %>
								<%
								UserLogin user = (UserLogin) session.getAttribute("user");
								if (user != null) {
								%>
								<a href="HotelAdminServlet" style="height: 42px" class="mx-2 btn btn-primary btn-lg rounded-0"
									role="button" aria-disabled="true">
									<i class="bi bi-person-circle mx-1"></i><% out.println(user.getUsername()); %></a>

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
	
	<!-- form itself end-->
	<form id="test-form" class="white-popup-block mfp-hide">
		<div class="popup_box">
			<div class="popup_inner">
				<h4 class="mb-4">Đặt lịch hẹn</h4>
				<form action="${pageContext.request.contextPath }/AppointmentServlet?action=create" >
					<div class="row">
						<div class="col-xl-12">
							<input id="datepicker" placeholder="Check in date" name="date" />
						</div>
						<div class="col-xl-12">
							<label>Mục đích</label> <input type="text" name="purpose" id="price"
								class="form-control" required>
						</div>
						<div class="col-xl-12">
							<label>Nội dung</label> <textarea type="text" name="content" id="price"
								class="form-control" required ></textarea>
						</div>
						<div class="col-xl-12  mt-3">
							<button type="submit" class="boxed-btn3">
								Đặt hẹn</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</form>
	<!-- form itself end -->
	
	<style>
.btn-custom {
	
}
</style>
</header>
<!-- header-end -->