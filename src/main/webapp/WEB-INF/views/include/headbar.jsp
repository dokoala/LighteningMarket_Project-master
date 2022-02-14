<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="${path}/">번개 장터</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <form id="search" name="search" enctype="multipart/form-data" method="get">
                        <li class="nav-item">
                            <div class="input-group rounded" align="center">
                                <input type="text" name = "searchData" id = "searchData" class="form-control rounded" placeholder="Search" aria-label="Search"
                                       onkeypress="if( keyCode == 13 ){searchData();}" />
                                <button class="input-group-text border-0" id="search-addon">
                                        <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </li>
                    </form>
                    <li class="nav-item">
                        <c:if test="${not empty login}">
                            <a class="nav-link" href="../product/productRegister">상품 등록</a>
                        </c:if>
                        <c:if test="${empty login}">
                            <a class="nav-link" href="../login/login">상품 등록</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${not empty login}">
                            <a class="nav-link" href="../mystore/products">내 상점</a>
                        </c:if>
                        <c:if test="${empty login}">
                            <a class="nav-link" href="../login/login">내 상점</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${not empty login}">
                            <a class="nav-link" href="../login/logout">로그아웃</a>
                        </c:if>
                        <c:if test="${empty login}">
                            <a class="nav-link" href="../login/login">로그인</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<script>
    $(document).ready(function(){
        // 상품 등록 유효성검사
        $("#search-addon").click(function(){
            document.search.action = "${path}/search.do";
            document.search.submit();
        });
    });
</script>