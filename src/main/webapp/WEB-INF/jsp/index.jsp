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
                <h1 class="page-title">Sebastian Hotel Guide</h1>
                <div class="separator-2"></div>
                <p class="lead">All you need to know right here. If you don't see the hotel your thinking about then send us an email and we will get to adding it</p>
                <!-- page-title end -->
                <!-- masonry grid start -->
                <div class="masonry-grid row" style="position: relative; height: 2641.16px;">

                    <c:forEach items="${entries}" var="entry">
                        <!-- masonry grid item start -->
                        <div class="masonry-grid-item col-sm-6" style="position: absolute; left: 0px; top: 0px;">
                            <!-- blogpost start -->
                            <article class="clearfix blogpost">
                                <div class="overlay-container">
                                    <img src="<c:url value="${entry.imagePath}" />" alt="">
                                    <div class="overlay">
                                        <div class="overlay-links">
                                            <a href="<c:url value="/readPost?id=${entry.id}" />"><i class="fa fa-link"></i></a>
                                            <a href="<c:url value="${entry.imagePath}" />" class="popup-img-single hoverZoomLink" title="image title"><i class="fa fa-search-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="blogpost-body">
                                    <div class="post-info">
                                        <span class="day"><fmt:formatDate pattern="dd" value="${entry.createDate}" /></span>
                                        <span class="month"><fmt:formatDate pattern="MMM yyyy" value="${entry.createDate}" /></span>
                                    </div>
                                    <div class="blogpost-content">
                                        <header>
                                            <h2 class="title"><a href="#">${entry.title}</a></h2>
                                            <div class="submitted"><i class="fa fa-user pr-5"></i> by <a href="#">${entry.author.firstName} ${entry.author.lastName}</a></div>
                                        </header>
                                        <p>${fn:substring(entry.entry, 0, 100)}</p>
                                    </div>
                                </div>
                                <%--<footer class="clearfix">--%>
                                    <%--<ul class="links pull-left">--%>
                                        <%--<li><i class="fa fa-comment-o pr-5"></i> <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">22 comments</a> |</li>--%>
                                        <%--<li><i class="fa fa-tags pr-5"></i> <a href="./iDea _ Blog_files/blog-masonry-sidebar.html">tag 1</a></li>--%>
                                    <%--</ul>--%>
                                    <%--<a class="pull-right link" href="<c:url value="/readHotelReview?id=${entry.id}" />"><span>Read more</span></a>--%>
                                <%--</footer>--%>
                            </article>
                            <!-- blogpost end -->
                        </div>
                        <!-- masonry grid item end -->
                    </c:forEach>
                </div>
                <!-- masonry grid end -->
            </div>
            <!-- main end -->
            <!-- sidebar start -->
            <aside class="col-md-3 col-md-offset-1">
                <jsp:include page="side.jsp" />
            </aside>
            <!-- sidebar end -->
        </div>
    </div>
</section>
<!-- main-container end -->
</div>
<!-- page-wrapper end -->
<!-- JavaScript files placed at the end of the document so the pages load faster
   ================================================== -->
<jsp:include page="footer.jsp" />
</body>
</html>