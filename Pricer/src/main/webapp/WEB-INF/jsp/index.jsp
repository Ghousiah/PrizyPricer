<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Prizy Pricer</title>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/products/">Home</a>
				<ul class="nav navbar-nav list-inline">
					<li class="nav-item list-inline-item"><a href="/products/all">Products</a></li>
					<li class="nav-item list-inline-item"><a href="/products/new">Create
							Product</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="home">
				<div class="jumbotron text-center">
					<h1>Welcome to Prizy Pricer</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_TASKS' }">

			<div id="productsView" class="container-fluid table-responsive">
				<h3>Product Viewer</h3>
				<table class="table table-hover table-striped table-bordered ">
					<thead class="thead-dark">
						<tr>
							<th>Barcode</th>
							<th>Name</th>
							<th>Price</th>
							<th>Lowest Price</th>
							<th>Highest Price</th>
							<th>Average Price</th>
							<th>Ideal Price</th>
							<th>Price Collection Count</th>
							<th>Description</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">
							<tr>
								<td><c:out value="${product.barcode}" /></td>
								<td><c:out value="${product.name}" /></td>
								<td><c:out value="${product.price}" /></td>
								<td><c:out value="${product.lowestPrice}" /></td>
								<td><c:out value="${product.highestPrice}" /></td>
								<td><c:out value="${product.avgPrice}" /></td>
								<td><c:out value="${product.idealPrice}" /></td>
								<td><c:out value="${product.priceCollectCount}" /></td>
								<td><c:out value="${product.description}" /></td>
								<td><a href="edit?id=${product.barcode}"><span
										class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a href="delete?id=${product.barcode}"><span
										class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW'}">
			<div class="container text-center">
				<h3>Add Product Price</h3>
				<form id="productForm" class="form-horizontal" method="post"
					action="/products/add">
					<input type="hidden" name="id" value="${product.barcode}">
					<div class="form-group">
						<label class="control-label col-md-4">Name:</label>
						<div class="col-md-8">
							<input name="name" value="${product.name} ">
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
							<input name="description" value="${product.description} ">
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary"
							value="upload product" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>