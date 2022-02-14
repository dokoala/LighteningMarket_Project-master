<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/head.jsp" %>

<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="login_container">
        <div class="login_row">
            <form action="${path}/login/login" method="post">
                <div class="login_title_row">
                    <h1 class="login_title"><i aria-hidden="true"></i> 비밀번호 변경</h1>
                </div>
                <br/><br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="email" value="${email}">
                    <input type="text" name="password" class="form-control" placeholder="비밀번호 변경"/>
                </div>
                <br/>

                <button type="submit" class="d-grid col-12 btn btn-primary"><span
                        class="glyphicon glyphicon-off"></span> 변경
                </button>
                <br/>
            </form>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>
<%@include file="../include/loginFooter.jsp" %>

<script>
    let result = "${result}";

    if (result === "SAMEDICE") {
        alert("인증번호가 일치합니다.");
    } else if (result === "DIFFERENTDICE") {
        alert("인증번호가 틀렸습니다. 인증번호를 다시 입력해주세요.");
        history.go(-1);
    }
</script>


</html>