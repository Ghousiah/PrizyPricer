<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>View Product</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${mode=='MODE_VIEW'}">
				<div class="container">

					<h2>Product Details</h2>
					<div>
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">Product Name:</label>
								<div class="col-sm-10">
									<input class="form-control-static" value="${product.name}"
										readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Description:</label>
								<div class="col-sm-10">
									<input class="form-control-static"
										value="${product.description}" readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Price:</label>
								<div class="col-sm-10">
									<input class="form-control-static" value="${product.price}"
										readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Average Price:</label>
								<div class="col-sm-10">
									<input class="form-control-static" value="${product.avgPrice}"
										readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Lowest Price:</label>
								<div class="col-sm-10">
									<input class="form-control-static"
										value="${product.lowestPrice}" readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Highest Price:</label>
								<div class="col-sm-10">
									<input class="form-control-static"
										value="${product.highestPrice}" readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Ideal Price:</label>
								<div class="col-sm-10">
									<input class="form-control-static"
										value="${product.idealPrice}" readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Count:</label>
								<div class="col-sm-10">
									<input class="form-control-static"
										value="${product.priceCollectCount}" readonly />
								</div>
							</div>
						</form>
						<div>
							<a href="/products/all">Back</a>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>