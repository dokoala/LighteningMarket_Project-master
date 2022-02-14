<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/head.jsp" %>

<section>
    <%@include file="../include/headbar.jsp" %>
    <!-- Page Content -->
    <div class="login_container">
        <div class="login_row">
            <form action="${path}/login/idSearch" method="post">
                <div class="login_title_row">
                    <h1 class="login_title"><i aria-hidden="true"></i> 아이디 찾기</h1>
                </div>
                <br/><br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    <input type="text" name="name" class="form-control" placeholder="이름"/>
                </div>
                <br/>

                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-key icon"></i></span>
                    <input type="text" name="email" class="form-control" aria-hidden="true"
                           placeholder="이메일"/>
                </div>
                <br/>
                <button type="submit" class="d-grid col-12 btn btn-primary"><span
                        class="glyphicon glyphicon-off"></span> 아이디 찾기
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
    var msg = "${map.msg}";
    var id = "${map.id}";
    if (msg === "IDSEARCH") {
        alert("아이디는 " + id + " 입니다.");
        self.location = "/login/login";
    } else if (msg === "NOID") {
        alert("이메일을 확인해주세요.");
        self.location = "/login/idSearch";
    }
</script>


</html>