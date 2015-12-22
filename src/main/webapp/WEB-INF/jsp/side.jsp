<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 12/17/2015
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="sidebar">
    <div class="block clearfix">
        <h3 class="title">Tags</h3>
        <div class="separator"></div>
        <div class="tags-cloud">
            <c:forEach items="${tags}" var="tag">
                <div class="tag">
                    <a href="<c:url value="/?tagId=${tag.id}" />">${tag.tagName}</a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
