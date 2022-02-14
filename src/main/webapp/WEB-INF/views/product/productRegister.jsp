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
<%@include file ="../include/head.jsp" %>

<section>
    <%@include file ="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <%@include file="../include/sidebar.jsp"%>
            <!-- /.col-lg-3 -->

            <div class="col-lg-9">

                </br>

                <br/>
                <form id="form1" name="form1" enctype="multipart/form-data" method="post">
                    <table class="table table-bordered">
                        <tr>
                            <td colspan="2">상품 제목</td>
                            <td colspan="4"><input type="text" name="productTitle" id="productTitle"></td>
                        </tr>
                        <tr>
                            <td colspan="2">가격</td>
                            <td colspan="4"><input type="text" name="productPrice" id="productPrice"></td>
                        </tr>
                        <tr>
                            <td colspan="2">거래지역</td>
                            <td colspan="1">
                                <select name="tradeArea" id="tradeArea">
                                    <option value="서울">서울</option>
                                    <option value="대구">대구</option>
                                    <option value="대전">대전</option>
                                    <option value="부산">부산</option>
                                    <option value="경기도">경기도</option>
                                    <option value="울산">울산</option>
                                </select>
                            </td>
                            <td colspan="2">상품상태</td>
                            <td colspan="1">
                                <select name="statement" id="statement">
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                    <option value="C">C</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">수량</td>
                            <td colspan="1"><input type="text" name="count" id="count"></td>
                            <td colspan="2">교환 가능 여부</td>
                            <td colspan="1">
                                <select name="exchange" id="exchange">
                                    <option value="O">가능</option>
                                    <option value="X">불가능</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">상품설명</td>
                            <td colspan="4">
                                <textarea rows="5" cols="97" name="description" id="description">
                                </textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">상품이미지</td>
                            <td colspan="4">
                                <div class="inputArea">
                                    <input type="file" name="productPhoto" id="productPhoto">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6">
                                <div class="select_img"><img src="" /></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6" align="center">
                                <input type="button" value="등록" id="addBtn">
                                <input type="button" value="목록" id="listBtn">
                            </td>
                        </tr>
                    </table>
                </form>


                </br>

                <script>
                    $("#productPhoto").change(function(){
                        if(this.files && this.files[0]) {
                            var reader = new FileReader;
                            reader.onload = function(data) {
                                $(".select_img img").attr("src", data.target.result).width(350);
                            }
                            reader.readAsDataURL(this.files[0]);
                        }
                    });
                </script>

<%--                여기는 타임--%>
<%--                <div>--%>
<%--                    <!-- enctype="multipart/form-data" 파일업로드 필수 옵션 -->--%>
<%--                    <!-- application/x-www-form-urlencoded 기본옵션 -->--%>
<%--                    <form action="/saveImage" enctype="multipart/form-data" method="post">--%>
<%--                        <input type="file" name="imgFile" />--%>
<%--                        <input type="submit" value="이미지저장"/>--%>
<%--                    </form>--%>
<%--                    <!-- form data가 이곳으로 이동 -->--%>

<%--                    <!-- img태그의 src 경로는 byte이미지 가져오는 컨트롤러 호출(/getByteImage) -->--%>
<%--                    <img class = "image_box" alt="" src="/getByteImage" />--%>
<%--                </div>--%>

                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
</section>
<script>
    $(document).ready(function(){
        // 상품 등록 유효성검사
        $("#addBtn").click(function(){
            var productTitle = $("#productTitle").val();
            var tradeArea = $("#tradeArea").val();
            var statement = $("#statement").val();
            var exchange = $("#exchange").val();
            var productPrice = $("#productPrice").val();
            var description = $("#description").val();
            var count = $("#count").val();
            var productPhoto = $("#productPhoto").val();

            if (productTitle == "") {
                alert("상품 제목을 입력해주세요");
                productTitle.focus();
            } else if (tradeArea == "") {
                alert("거래 지역을 입력해주세요");
                tradeArea.focus();
            } else if (statement == "") {
                alert("상품 상태를 입력해주세요");
                statement.focus();
            } else if (exchange == "") {
                alert("교환 가능 여부를 입력해주세요");
                exchange.focus();
            } else if (description == "") {
                alert("상품 설명을 입력해주세요");
                description.focus();
            } else if (productPrice == "") {
                alert("상품 가격을 입력해주세요");
                productPrice.focus();
            } else if (count == "") {
                alert("상품 개수를 입력해주세요");
                count.focus();
            } else if (productPhoto == "") {
                alert("이미지를 업로드 해주세요");
                productPhoto.focus();
            }
            // 상품 정보 전송
            document.form1.action = "${path}/product/insert.do";
            document.form1.submit();
        });
        // 상품 목록이동
        $("#listBtn").click(function(){
            location.href='${path}/product/list.do';
        });
    });
</script>
<%@include file="../include/footer.jsp"%>