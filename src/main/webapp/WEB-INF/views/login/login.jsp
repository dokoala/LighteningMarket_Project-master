<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/head.jsp" %>

<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="login_container">
        <div class="login_row">
            <form action="${path}/login/loginPost" method="post">
                <div class="login_title_row">
                    <h1 class="login_title"><i class="fa fa-lock" aria-hidden="true"></i> 로그인</h1>
                </div>
                <br/><br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    <input type="text" name="id" class="form-control" placeholder="아이디"/>
                </div>
                <br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-key icon"></i></span>
                    <input type="Password" name="password" class="form-control" aria-hidden="true"
                           placeholder="비밀번호"/>
                </div>
                <br/>
                <div class="checkbox">
                    <label><input type="checkbox" name="useCookie"/> 로그인 유지 </label>
                </div>
                <br/>
                <button type="submit" class="d-grid col-12 btn btn-primary"><span
                        class="glyphicon glyphicon-off"></span> 로그인
                </button>
                <br/>
            </form>
            <center>
                <div style="border:1px solid black;height:1px;width:295px;"></div>
            </center>
            <br/>
            <div class="login_footer">
                <a href="${path}/login/idSearch">ID 찾기</a> |
                <a href="${path}/login/pwSearch">비밀번호 찾기</a> |
                <a href="${path}/user/signup">회원가입</a>
            </div>

        </div>
        <!-- /.row -->
    </div>

    <!-- /.container -->
</section>
<%@include file="../include/loginFooter.jsp" %>

<script>

    var msg = "${msg}";
    if (msg === "SIGNEDUP") {
        alert("회원가입이 완료되었습니다. 로그인 해주세요!")
    } else if (msg === "UPDATEPW") {
        alert("비밀번호가 변경되었습니다. 로그인 해주세요!")
    }
</script>

</html>