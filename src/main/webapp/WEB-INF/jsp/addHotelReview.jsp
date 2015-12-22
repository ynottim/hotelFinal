<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class=" js no-touch csstransitions">

<body class="wide">
<div class="scrollToTop" style="display: none;"><i class="icon-up-open-big"></i></div>
<div class="page-wrapper">
    <jsp:include page="header.jsp" />
<!-- header end -->
<!-- main-container start -->
<!-- ================ -->
<section class="main-container" style="margin-top: 0px;">
    <div class="container">
        <div class="row">
            <!-- main start -->
            <!-- ================ -->
            <div class="main col-md-8">
                <!-- Forms start -->
                <!-- ============================================================================== -->
                <h2>Add Hotel Entry</h2>
                <form role="form" action="<c:url value="/secure/addHotelReview" />" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="hotelTitle">Hotel Review</label>
                        <input type="text" class="form-control" id="hotelTitle" name="title" placeholder="Hotel Name">
                    </div>
                    <div class="form-group">
                        <label for="entry">Review</label>
                        <textarea class="form-control" rows="3" id="entry" name="entry" placeholder="Hotel Review"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="image">Hotel Images:</label>
                        <input type="file" id="image" name="image"><br />
                        <input type="file" name="image"><br />
                        <input type="file" name="image"><br />
                        <input type="file" name="image"><br />
                        <input type="file" name="image"><br />
                    </div>
                    <div class="form-group">
                        <label for="tags">Tags (separated with comma)</label>
                        <input type="text" class="form-control" id="tags" name="tags" placeholder="Tags">
                    </div>
                    <input type="hidden" name="csrfToken" value="${csrfToken}" />
                    <button type="submit" class="btn btn-default">Add Entry</button>
                </form>

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
<jsp:include page="footer.jsp" />
</body>
</html>