<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en" class=" js no-touch csstransitions">

<body class="wide">
<div class="scrollToTop" style="display: none;"><i class="icon-up-open-big"></i></div>
<div class="page-wrapper">
    <jsp:include page="header.jsp" />
<!-- main-container start -->
<!-- ================ -->
<section class="main-container" style="margin-top: 0px;">
    <div class="container">
        <div class="row">
            <!-- main start -->
            <!-- ================ -->
            <div class="main col-md-8">

                <!-- page-title start -->
                <!-- ================ -->
                <h1 class="page-title">${entry.title}</h1>
                <!-- page-title end -->

                <!-- blogpost start -->
                <article class="clearfix blogpost full">
                    <div class="blogpost-body">
                        <div class="side">
                            <div class="post-info">
                                <span class="day"><fmt:formatDate pattern="dd" value="${entry.createDate}" /></span>
                                <span class="month"><fmt:formatDate pattern="MMM yyyy" value="${entry.createDate}" /></span>
                            </div>
                        </div>
                        <div class="blogpost-content">
                            <header>
                                <div class="submitted"><i class="fa fa-user pr-5"></i> by ${entry.author.firstName} ${entry.author.lastName}</div>
                            </header>
                            <img src="<c:url value="${entry.imagePath}" />" alt="">
                            <p>${entry.entry}</p>
                            <div>
                                ${entry.map}
                            </div>
                        </div>
                    </div>
                    <footer class="clearfix">
                        <ul class="links pull-left">
                            <li><i class="fa fa-tags pr-5"></i>
                                <c:forEach items="${tags}" var="tag">
                                    <a href="<c:url value="/?tagId=${tag.id}" />">${tag.tagName}</a>
                                </c:forEach>
                            </li>
                        </ul>
                    </footer>
                </article>
                <!-- blogpost end -->

                <!-- comments start -->
                <%--<div class="comments">--%>
                    <%--<h2 class="title">There are 3 comments</h2>--%>

                    <%--<!-- comment start -->--%>
                    <%--<div class="comment clearfix">--%>
                        <%--<div class="comment-avatar">--%>
                            <%--<img src="./iDea _ Blogpost_files/avatar.jpg" alt="avatar">--%>
                        <%--</div>--%>
                        <%--<div class="comment-content">--%>
                            <%--<h3>Comment title</h3>--%>
                            <%--<div class="comment-meta">By <a href="http://htmlcoder.me/preview/idea/v.1.3/html/blog-post.html#">admin</a> | Today, 12:31</div>--%>
                            <%--<div class="comment-body clearfix">--%>
                                <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo </p>--%>
                                <%--<a href="./iDea _ Blogpost_files/iDea _ Blogpost.html" class="btn btn-gray more pull-right"><i class="fa fa-reply"></i> Reply</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%----%>
                <!-- comments form end -->

            </div>
            <!-- main end -->
        </div>
    </div>
</section>
<!-- main-container end -->
</div>
<!-- page-wrapper end -->
<!-- JavaScript files placed at the end of the document so the pages load faster
   ================================================== -->
<!-- Jquery and Bootstap core js files -->
<jsp:include page="footer.jsp" />
</body>
</html>