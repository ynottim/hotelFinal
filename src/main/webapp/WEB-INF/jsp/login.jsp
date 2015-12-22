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
                    <h2 class="title">Login</h2>
                    <hr>
                    <form action="<c:url value="/login" />" method="post" class="form-horizontal">
                        <div class="form-group has-feedback">
                            <label for="inputUserName" class="col-sm-3 control-label">User Name</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="inputUserName" name="username" placeholder="User Name" required="">
                                <i class="fa fa-user form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="inputPassword" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password" required="">
                                <i class="fa fa-lock form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-8">
                                <button type="submit" class="btn btn-group btn-default btn-sm">Log In</button>
                                <ul>
                                    <li><a href="http://htmlcoder.me/preview/idea/v.1.3/html/page-login.html#">Forgot your password?</a></li>
                                </ul>
                            </div>
                        </div>
                    </form>
                </div>
                <p class="text-center space-top">Don't have an account yet? <a href="<c:url value="/register" />">Sign up</a> now.</p>
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