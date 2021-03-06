<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
        <head>
        <meta charset="utf-8">
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		  <title>Commodity</title>
		  <style>
   <%@include file="/css/commoditycss.css" %>
   <%@include file="/css/bootstrap.min.css"%>
  
  
</style>
    </head>
     <body>
       	      <%@include file="/WEB-INF/views/header.jsp" %>

        
        <div class="container-fluid mainpart">
        <div class="row">
        <div class="col-md-2"></div>
        
        <div class="col-md-4">
         <c:forEach items="${commodities }" var="commodity">
             <div class="img"> 
             <c:choose>
			<c:when test="${commodity.id=='1' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage6.static.itmages.ru/i/17/0506/h_1494090223_6638226_1a4382ee21.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='2' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage7.static.itmages.ru/i/17/0506/h_1494090171_6352525_1e03c08f8c.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='3' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage1.static.itmages.ru/i/17/0506/h_1494090175_4628428_89645c8ece.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='4' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage8.static.itmages.ru/i/17/0506/h_1494090172_7759996_45062f2beb.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='5' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage3.static.itmages.ru/i/17/0506/h_1494090179_4548448_56d6406b32.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='6' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage2.static.itmages.ru/i/17/0506/h_1494090177_7514046_4f0b02b6fc.jpg" class="round"></a>
					</c:when>
					<c:when test="${commodity.id=='7' }">
			<a href="/commodity/${commodity.id}"><img src="http://storage9.static.itmages.ru/i/17/0506/h_1494090174_4089358_02b3600f35.jpg" class="round"></a>
             
					</c:when>
					<c:when test="${commodity.id=='8' }">
			<a href="/commodity/${commodity.id}"><img src=http://storage9.static.itmages.ru/i/17/0506/h_1494090174_1583394_c9b4a1fcab.jpg class="round"></a>
             
					</c:when>
					<c:otherwise>
						<a href="/commodity/${commodity.id}"><img src=http://storage6.static.itmages.ru/i/17/0506/h_1494094226_5602968_db2f9834f6.jpg class="round"></a>
					</c:otherwise>
					</c:choose>
                
                </div>
                </c:forEach>
        </div>
        <div class="col-md-2 details">
        <p>Назва: ${commodity.name }</p>
        <p>Ціна: ${commodity.price } грн. </p>
        <p>Країна: ${commodity.country.name } </p>
        <p>Матеріал: ${commodity.material.name }</p>
        <sec:authorize access="isAuthenticated()">
        <a  class="btn btn-primary btn" href="/user/details/save/${commodity.id }">Додати в корзину</a>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
			<a class="btn btn-danger" href="/login">Додати в корзину</a>
		</sec:authorize>
        </div>
        <div class="col-md-4"></div>
        </div>
        </div>