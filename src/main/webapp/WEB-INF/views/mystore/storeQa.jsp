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

                <%--                버튼 처리--%>
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

                <%--                    상점문의 댓글 쓰기--%>
                    <form class="form" action="${path}/mystore/storeQaInsert" method="post">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">상점 문의</h3>
                                    </div>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <input type="text" size="100%" name="storeQaDes" id="_label-storeQaDes"
                                                   class="input-text" placeholder="상점문의 입력" required>
                                        </div>
                                        <div class="fa-pull-right">
                                            <input type="checkbox" name="unknownChecked"/>익명
                                            <input type="hidden" name="unknownCheck" id="_label-unknownCheck"/>
                                            <button type="submit" id="storeQaInsert" class="btn btn-primary">
                                                <i class="fa fa-pen-square"></i> 등록
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <%--                    상점문의 댓글 목록 및 삭제--%>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="box box-primary">
                                <c:forEach items="${storeQa}" var="storeQa">
                                <form class="form" action="${path}/mystore/storeQaDelete" onsubmit="return removeCheck()"
                                      method="post">
                                    <div class="box-header with-border">
                                        <input type="hidden" name="storeQaIdx" id="_label-storeQaIdx"
                                               class="input-text" value="${storeQa.storeQaIdx}"/>
                                        <c:if test="${storeQa.unknownCheck eq 'Y'}">
                                        <h5 class="box-title">익명</h5>
                                        </c:if>
                                        <c:if test="${storeQa.unknownCheck eq 'N'}">
                                        <h5 class="box-title">${storeQa.nickname}</h5>
                                        </c:if>
                                        <h5 class="box-title">${storeQa.storeQaDes}</h5>
                                        <button type="submit" id="storeQaDelete" class="btn btn-danger">
                                            <i class="fa fa-eraser"></i> 삭제
                                        </button>
                                        <hr>
                                </form>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
    </div>
    <!-- /.container -->
</section>
<%@include file="../include/footer.jsp" %>

<script>
    <%--    등록 버튼 이벤트 처리--%>
    $("#storeQaInsert").click(function () {
        if ($('input[name=unknownChecked]').is(":checked")) {
            $('input[name=unknownCheck]').val('Y');
        } else {
            $('input[name=unknownCheck]').val('N');
        }
    });
    // 댓글 삭제 버튼 이벤트 처리
    function removeCheck() {
        if (confirm("삭제하시겠습니까?") == true) {    //확인
            alert('삭제되었습니다.');
            return true;
        } else {   //취소
            return false;
        }
    }
</script>
</html>