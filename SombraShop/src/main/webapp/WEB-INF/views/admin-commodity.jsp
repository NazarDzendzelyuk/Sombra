<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
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
					<li class="active"><a href="/admin/commodity">Commodity</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/item">Items</a></li>
					<li><a href="/">Головна</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-1 col-xs-12"></div>
	<div class="col-md-11 col-xs-12">
		<div class="row">
			<div class="col-md-10 col-xs-12">
				<form:form class="form-horizontal" action="/admin/commodity" method="POST" modelAttribute="commodity" enctype="multipart/form-data">
				<div class="form-group">
						<label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Commodity name</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					
  					<div class="form-group">
    					<label for="price" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="price" id="price"/>
    					</div>
  					</div>
  						
  					<div class="form-group">
    					<label for="category" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
      							<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="material" class="col-sm-2 control-label">Material</label>
    					<div class="col-sm-10">
      							<form:select class="form-control" path="material" id="material" items="${materials}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="country" class="col-sm-2 control-label">Country</label>
    					<div class="col-sm-10">
      							<form:select class="form-control" path="country" id="country" items="${countries}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div>
<!--   					<label for="name" class="col-sm-2 control-label">Name</label> -->
<!--     					<div class="col-sm-10"> -->
<!--       						<input name="file" type="file" id="name"> -->
<!--     					</div> -->
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Add</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
<!-- 			<div class="col-md-1 col-xs-2"><h4>Image </h4></div> -->
			<div class="col-md-2 col-xs-2"><h4>Commodity name</h4></div>
			<div class="col-md-1 col-xs-2"><h4>Price </h4></div>
			<div class="col-md-1 col-xs-2"><h4>Category </h4></div>
			<div class="col-md-1 col-xs-2"><h4>Material </h4></div>
			<div class="col-md-1 col-xs-2"><h4>Country </h4></div>
			<div class="col-md-1 col-xs-2"><h4>Update</h4></div>
			<div class="col-md-1 col-xs-2"><h4>Delete</h4></div>
		</div>
			<c:forEach items="${commodities}" var="commodity">
				<div class="row">
<%-- 					<div class="col-md-1 col-xs-2"><img src="/images/sombra/${commodity.id}.jpg?version=${commodity.version}"></div> --%>
					<div class="col-md-2 col-xs-2"><h5>${commodity.name}</h5></div>
					<div class="col-md-1 col-xs-2"><h5>${commodity.price}</h5></div>
					<div class="col-md-1 col-xs-2"><h5>${commodity.category.name}</h5></div>
					<div class="col-md-1 col-xs-2"><h5>${commodity.material.name}</h5></div>
					<div class="col-md-1 col-xs-2"><h5>${commodity.country.name}</h5></div>
					<div class="col-md-1 col-xs-2"><a class="btn btn-warning" href="/admin/commodity/update/${commodity.id}">update</a></div>
					<div class="col-md-1 col-xs-2"><a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-1 col-xs-12"></div>
</div>