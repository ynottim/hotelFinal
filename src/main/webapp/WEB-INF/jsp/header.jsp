<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 12/17/2015
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class=" js no-touch csstransitions">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>Tim | Hotel Reviews</title>
  <link href=<c:url value="/resources/css/webfonts.css" /> rel="stylesheet" type="text/css">
  <link href=<c:url value="/resources/css/bootstrap.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/font-awesome.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/fontello.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/magnific-popup.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/animations.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/owl.carousel.css" /> rel="stylesheet">
  <link href=<c:url value="/resources/css/style.css" /> rel="stylesheet">
</head>
  <header class="header fixed clearfix">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <!-- header-left start -->
          <!-- ================ -->
          <div class="header-left clearfix">
            <!-- logo -->
            <div class="logo">
              <a href="<c:url value="/" />"><img id="logo" src=<c:url value="/resources/img/seb_logo.png" /> alt="Sebastian"></a>
            </div>
            <%--<!-- name-and-slogan -->--%>
            <%--<div class="site-slogan">--%>
            <%--Clean &amp; Powerful Bootstrap Theme--%>
            <%--</div>--%>
          </div>
          <!-- header-left end -->
        </div>
        <div class="col-md-9">
          <!-- header-right start -->
          <!-- ================ -->
          <div class="header-right clearfix">
            <!-- main-navigation start -->
            <!-- ================ -->
            <div class="main-navigation animated">
              <!-- navbar start -->
              <!-- ================ -->
              <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                  <!-- Toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                  </div>
                  <!-- Collect the nav links, forms, and other content for toggling -->
                  <div class="collapse navbar-collapse" id="navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                      <c:if test="${sessionScope.user != null}">
                        <li>
                          <span>Welcome ${sessionScope.user.firstName} ${sessionScope.user.lastName}</span>
                        </li>
                        <li>
                          <a href="<c:url value="/secure/addHotelReview" />">Add Blog Post</a>
                        </li>
                        <li>
                          <a href="<c:url value="/exit" />">Logout</a>
                        </li>
                      </c:if>
                      <c:if test="${sessionScope.user == null}">
                        <li>
                          <a href="<c:url value="/register" />">Sign Up</a>
                        </li>
                        <li class="active">
                          <a href="<c:url value="/login" />">Sign In</a>
                        </li>
                      </c:if>
                    </ul>
                  </div>
                </div>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- header end -->
</html>
