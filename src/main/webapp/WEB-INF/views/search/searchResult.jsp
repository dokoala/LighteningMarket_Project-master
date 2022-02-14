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
                    <c:if test = "${not empty list}">
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
                    </c:if>
                    <c:if test = "${empty list}">
                        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active" style="size: ">
                                    <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide"
                                    value = "검색된 항목이 없습니다.">
                                </div>
                            </div>
                        </div>
                    </c:if>
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