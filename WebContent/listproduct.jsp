<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>STOU 99420</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />

<link
	href="https://fonts.googleapis.com/css2?family=Prompt&display=swap"
	rel="stylesheet">
<style type="text/css">
html * {
	font-family: 'Prompt', sans-serif;
}
</style>
</head>
<body>
	<nav class="py-2 bg-light border-bottom">
		<div class="container d-flex flex-wrap">
			<ul class="nav me-auto">
				<li class="nav-item"><a href="index.jsp"
					class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
				<li class="nav-item"><a href="index.jsp"
					class="nav-link link-dark px-2">Product</a></li>

			</ul>

			<%-- <%
				if (session.getAttribute("username") != null) {
			%>
			<p class="mt-2 mb-0">
				Welcome
				<%=session.getAttribute("username")%></p>
			

			<%
				} else {
			%>
			<ul class="nav">
				<li class="nav-item"><a href="login.jsp"
					class="nav-link link-dark px-2">Login</a></li>
				<li class="nav-item"><a href="register.jsp"
					class="nav-link link-dark px-2">Sign up</a></li>
			</ul>
			<%
				}
			%>
 --%>

		</div>
	</nav>
	<header class="py-3 mb-4 border-bottom">
		<div class="container d-flex flex-wrap justify-content-center">
			<a href="index.jsp"
				class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
				<img src="https://www.stou.ac.th/main/images/index/STOU_r.png"
				height="80"> <span class="fs-4 ms-5"> 99420
					การโปรแกรมเว็บ <br>โดย นายก่อเกียรติ ทันเขิม 6396006394
			</span>
			</a>

		</div>
	</header>

	<main class="flex-shrink-0">
	<div class="container">
		<h1 class="mt-5">Top 4 Smartwatches : 2022-2023</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">id</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Image</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<th scope="row"><c:out value="${product.id}" /></th>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.desc}" /></td>
						<td><c:out value="${product.price}" /></td>
						<td><img
							src="<c:url value='/ImageServlet?id=${product.id}'/>" height="80"
							alt="Product Image">
							</td>


						<td><a href="ProductController?action=edit&id=${product.id}"
							class="btn btn-warning"><i class="fa fa-edit"></i> Update</a> 
							<a href="ProductController?action=delete&id=${product.id}" class="btn btn-danger"><i
								class="fa fa-trash-alt"></i> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="ProductController?action=insert" class="btn btn-success"><i class="fa fa-plus"></i> Add
			New Smartwatch </a>

	</div>
	</main>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>