<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Karla:wght@200;300;400;500&display=swap"
	rel="stylesheet">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->

</head>
<body>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div
					class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->
					</div>
					<div class="card-body p-4 p-sm-5">
						<h5 class="card-title text-center mb-5 fw-light fs-5">Register</h5>
						<form action="UserLoginServlet" method="post">
							<h5 style="color: red">${message }</h5>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" name="username"
									id="floatingInputUsername" placeholder="myusername" required
									autofocus> <label for="floatingInputUsername">Username</label>
							</div>

							<div class="form-floating mb-3">
								<input type="email" name="email" class="form-control" id="floatingInputEmail"
									placeholder="name@example.com"> <label
									for="floatingInputEmail">Email address</label>
							</div>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" name="phone"
									id="floatingPasswordConfirm" placeholder="Confirm Password">
								<label for="floatingPasswordConfirm">Phone</label>
							</div>

							<div class="form-floating mb-3">
								<input type="password" name="password" class="form-control"
									id="floatingPassword" placeholder="Password"> <label
									for="floatingPassword">Password</label>
							</div>

							<div class="form-floating mb-3">
								<input type="password" class="form-control"
									id="floatingPasswordConfirm" placeholder="Confirm Password">
								<label for="floatingPasswordConfirm">Confirm Password</label>
							</div>

							<div class="d-grid mb-2">
							<input name="action" id="login" class="btn login-btn"
								type="submit" value="register">
			
							</div>

							<a class="d-block text-center mt-2 small" href="./login.jsp">Have
								an account? Sign In</a>

							<hr class="my-4">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<style>
body {
	background: #007bff;
	background: linear-gradient(to right, #0062E6, #33AEFF);
}

.card-img-left {
	width: 45%;
	/* Link to your background image using in the property below! */
	background: scroll center
		url('https://www.lagunalangco.com/wp-content/uploads/2016/07/Banyan-tree-lang-co-Seaview-hill-pool-villa-1.jpg');
	background-size: cover;
}

.btn-login {
	font-size: 0.9rem;
	letter-spacing: 0.05rem;
	padding: 0.75rem 1rem;
}

.btn-google {
	color: white !important;
	background-color: #ea4335;
}

.btn-facebook {
	color: white !important;
	background-color: #3b5998;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</body>
</html>