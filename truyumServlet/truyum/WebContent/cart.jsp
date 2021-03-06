<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truyum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="http://localhost:8082/truyum/ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="page-title">Cart</div>

	<table class="body-content-color">
		<c:if test="${deleteCartStatus}">
			<div class="success-message">Items removed from Cart
				successfully</div>
		</c:if>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th class="currency">Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td class=" currency">Rs.<fmt:formatNumber
						value="${menuItem.price}" pattern="#,##,##,##,###.00" />
				</td>
				<td>${menuItem.category}</td>
				<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td class="total">Total</td>
			<td class="total">Rs.<fmt:formatNumber value="${cart.total}"
					pattern="#,##,##,##,###.00" />
			</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>