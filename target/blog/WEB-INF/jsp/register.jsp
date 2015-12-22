<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="main object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="300">
                <div class="form-block center-block">
                    <h2 class="title">Sign Up</h2>
                    <hr>
                    <c:if test="${param.error}">
                        <span>Please fill all fields</span>
                    </c:if>
                    <form action="<c:url value="/register" />" method="post" class="form-horizontal" role="form">
                        <div class="form-group has-feedback">
                            <label for="inputName" class="col-sm-3 control-label">First Name <span class="text-danger small">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputName" name="firstName" placeholder="First Name" required="">
                                <i class="fa fa-pencil form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="inputLastName" class="col-sm-3 control-label">Last Name <span class="text-danger small">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Last Name" required="">
                                <i class="fa fa-pencil form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="inputUserName" class="col-sm-3 control-label">User Name <span class="text-danger small">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputUserName" name="username" placeholder="User Name" required="">
                                <i class="fa fa-user form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="inputEmail" class="col-sm-3 control-label">Email <span class="text-danger small">*</span></label>
                            <div class="col-sm-8">
                                <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email" required="">
                                <i class="fa fa-envelope form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="inputPassword" class="col-sm-3 control-label">Password <span class="text-danger small">*</span></label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password" required="">
                                <i class="fa fa-lock form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-8">
                                <button type="submit" class="btn btn-default">Sign Up</button>
                            </div>
                        </div>
                    </form>
                </div>
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