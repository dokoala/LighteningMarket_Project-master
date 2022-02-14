<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2021-01-03
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file ="../include/headtest.jsp" %>
<style>
    .fileDrop {
        width:600px;
        height: 200px;
        border: 1px dotted blue;
    }

    small {
        margin-left: 3px;
        font-weight: bold;
        color: gray;
    }
</style>
</head>
<section>
    <%@include file ="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <%@include file="../include/sidebar.jsp"%>
            <!-- /.col-lg-3 -->
            <div class="col-lg-9">

                <br/>
                <table class="table table-bordered">
                    <tr>
                        <td align="center">
                            <img src="../../../resources/upload/img/${vo.productUrl}" width="340" height="300">
                        </td>
                        <td>
                            <table class="table table-bordered">
                                <tr align="center">
                                    <td>상품명</td>
                                    <td>${vo.productTitle}</td>
                                </tr>
                                <tr align="center">
                                    <td>가격</td>
                                    <td><fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/></td>
                                </tr>
                                <tr align="center">
                                    <td>상품소개</td>
                                    <td>${vo.description}</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
</section>

<%@include file="../include/footer.jsp"%>