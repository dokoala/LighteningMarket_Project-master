<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/head.jsp" %>

<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="login_container">
        <div class="login_row">
            <form action="${path}/login/pwCheck" method="post">
                <div class="login_title_row">
                    <h1 class="login_title"><i aria-hidden="true"></i> 비밀번호 찾기</h1>
                </div>
                <br/><br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    <input type="text" name="id" class="form-control" placeholder="아이디"/>
                </div>
                <br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-key icon"></i></span>
                    <input type="text" name="email" class="form-control" aria-hidden="true"
                           placeholder="이메일"/>
                </div>

                <br/>

                <button type="submit" class="d-grid col-12 btn btn-primary"><span
                        class="glyphicon glyphicon-off"></span> 인증번호 받기
                </button>

                <br/>
            </form>
        </div>
        <div class="login_footer">
            ID를 모르면 <a href="/login/idSearch">ID 찾기</a>를 누르세요!
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>
<%@include file="../include/loginFooter.jsp" %>

</html>