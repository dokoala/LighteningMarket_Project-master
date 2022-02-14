<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2021-01-03
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="../include/head.jsp" %>
<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <%@include file="../include/sidebar.jsp" %>
            <%-- col-lg-9 --%>
            <div class="col-lg-9">

<%--                버튼 처리 --%>
                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <button type="button" class="btn btn-danger" onClick="location.href='../mystore/products'"> 상품
                    </button>
                    <button type="button" class="btn btn-success" onClick="location.href='../mystore/favorites'">찜
                    </button>
                    <button type="button" class="btn btn-info" onClick="location.href='../mystore/storeQa'">상점문의
                    </button>
                    <button type="button" class="btn btn-light" onClick="location.href='../mystore/following'">팔로잉
                    </button>
                    <button type="button" class="btn btn-dark" onClick="location.href='../mystore/follower'">팔로워
                    </button>
                </div>

<%--                리스트 부분 --%>
                <div class="row">
                    <c:forEach items="${products}" var="products">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="${path}/product/detail/${products.proIdx}">
                                    <img class="card-img-top" src="../../../resources/upload/img/${products.productUrl}"alt="" height="180px" width="100px">
                                </a>

                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="${products.proIdx}">${products.title}</a>
                                    </h4>
                                    <h5>${products.price}</h5>
                                    <p class="card-text">${products.regDate}</p>
                                    <h5>${products.tradeArea}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>
<%@include file="../include/footer.jsp" %>
</html>