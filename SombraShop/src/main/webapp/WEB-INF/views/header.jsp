<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <meta charset="utf-8">
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		  <title>Sombra</title>
		  <style>
   <%@include file="/css/index.css" %>
   <%@include file="/css/commoditycss.css" %>
   <%@include file="/css/bootstrap.min.css"%>
  
</style>
    </head>
     
    <div class="clear-fix">
        <div class="logo">
            <a href="/">Sombra</a>
        </div>
       
        <div class="rightheader">
        <sec:authorize access="!isAuthenticated()">
            <a href="/registration">Реєстрація</a>
            <a href="/login">Логін</a>
            </sec:authorize>
                 <sec:authorize access="isAuthenticated()">
                 <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/admin/commodity">Адмін</a>
            </sec:authorize>
            <a href="/cart"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Корзина</a>
            <form:form action="/logout" method="POST">
            		<button type="submit" class="btn btn-danger logout">Logout</button>
            </form:form>
            </sec:authorize>

        </div>
        </div>