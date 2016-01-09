//package com.bau.hotel;
//
//import org.junit.internal.Throwables;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.imageio.metadata.IIOMetadataNode;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Tim on 1/5/2016.
// */
//@Controller
//class ErrorController {
//
//    @RequestMapping("error")
//    public String error(HttpServletRequest, HttpServletResponse response, Model model) {
//        // retrieve some useful information from the request
//        IIOMetadataNode request;
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//        // String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
//        String exceptionMessage = getExceptionMessage(throwable, statusCode);
//        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
//        if (requestUri == null) {
//            requestUri = "Unknown";
//
//        }
//    }
//
//    private String getExceptionMessage(Throwable throwable, Integer statusCode) {
//        if (throwable != null) {
//            return Throwables.getRootCause(throwable).getMessage();
//        }
//        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
//        return httpStatus.getReasonPhrase();
//    }
//}