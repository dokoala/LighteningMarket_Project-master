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
                <div class="row">
                    <c:forEach var="products" items="${list}">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">

                                <a href="${path}/product/detail/${products.productIdx}">
                                    <!--700 x 400 -->
                                    <img class="card-img-top" src="../../../resources/upload/img/${products.productUrl}" alt="" height="180px" width="100px">
                                </a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="${path}/product/detail/${products.productIdx}">${products.productTitle}</a>
                                    </h4>
                                    <h5>${products.productPrice}</h5>
                                    <p class="card-text">${products.regDate}</p>
                                    <h5>${products.tradeArea}</h5>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
</section>

<%@include file="../include/footer.jsp"%>