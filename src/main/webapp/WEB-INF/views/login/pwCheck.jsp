<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/head.jsp" %>

<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="login_container">
        <div class="login_row">
            <!-- 인증번호 비교 form -->
            <form action="${path}/login/pwChange" method="post">
                <input type="hidden" name="id" value="${id}">
                <input type="hidden" name="email" value="${email}">
                <input type="hidden" name="dice" value="${dice}">

                <div class="login_title_row">
                    <h1 class="login_title"><i aria-hidden="true"></i> 비밀번호 찾기</h1>
                </div>
                <br/><br/>

                <div class="input-group">

                    <span class="input-group-text"><i class="fa fa-key icon"></i></span>
                    <input type="text" name="requestdice" class="form-control" aria-hidden="true"
                           placeholder="인증번호를 입력하세요."/>
                </div>

                <br/>

                <button type="submit" class="d-grid col-12 btn btn-primary"><span
                        class="glyphicon glyphicon-off"></span> 다음
                </button>
            </form>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>
<%@include file="../include/loginFooter.jsp" %>

<script>

    var dice = "${dice}";
    var email = "${email}";
    console.log(dice);
    console.log(email);

    if (dice !== "NOEMAIL") {
        alert("인증번호를 입력해주세요.");
    } else if (dice === "NOEMAIL") {
        alert("이메일을 확인해주세요.");
        self.location = "/login/pwSearch";
    }
</script>

</html>


