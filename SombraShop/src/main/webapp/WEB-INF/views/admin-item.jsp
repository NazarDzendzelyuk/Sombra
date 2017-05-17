<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
        <meta charset="utf-8">
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		  <title>Sombra</title>
		  <style>
   <%@include file="/css/bootstrap.min.css"%>
  
</style>
    </head>


<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
		<div class="col-md-4">
		</div>
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/commodity">Commodity</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li class="active"><a href="/admin/items">Items</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/">Головна</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-12"></div>

	<div class="col-md-10 col-xs-12">
		
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Item name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Phone number</h3></div>
			<div class="col-md-2 col-xs-2"><h3>User name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Total price</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Status</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${items}" var="item">
				<div class="row">
					<div class="col-md-2 col-xs-4">${item.itemName}</div>
					<div class="col-md-2 col-xs-4">${item.userName}</div>
					<div class="col-md-2 col-xs-4">${item.phone}</div>
					<div class="col-md-2 col-xs-4">${item.totalPrice}</div>
					<div class="col-md-2 col-xs-4">${item.status}</div>
					<div class="col-md-2 col-xs-4"><a class="btn btn-danger" href="/admin/item/delete/${item.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>