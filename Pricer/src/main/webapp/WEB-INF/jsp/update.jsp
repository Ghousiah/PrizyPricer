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

<title>Update</title>
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${mode=='MODE_UPDATE'}">
				<div class="container text-center">
					<h3>Update Product Price</h3>
					<form class="form-horizontal" method="post"
						action="/products/edit-view">
						<input type="hidden" name="id" value="${product.barcode}">
						<div class="form-group">
							<label class="control-label col-md-4">Name:</label>
							<div class="col-md-8">
								<input name="name" value="${product.name} " readonly />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Price:</label>
							<div class="col-md-8">
								<input name="price" value="${product.price} ">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">Description:</label>
							<div class="col-md-8">
								<input name="description" value="${product.description} "
									readonly />
							</div>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary"
								value="update product" />
						</div>
					</form>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>