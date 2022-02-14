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

                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div>
                    <h2>AJAX File Upload</h2>
                    <!-- 파일을 업로드할 영역 -->
                    <div class="fileDrop"></div>
                    <!-- 업로드된 파일 목록 -->
                    <div class="uploadedList"></div>
                </div>

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
        $(".fileDrop").on("dragenter dragover", function(event){
            event.preventDefault(); // 기본효과를 막음
        });
        // event : jQuery의 이벤트
        // originalEvent : javascript의 이벤트
        $(".fileDrop").on("drop", function(event){
            event.preventDefault(); // 기본효과를 막음
            // 드래그된 파일의 정보
            var files = event.originalEvent.dataTransfer.files;
            // 첫번째 파일
            var file = files[0];
            // 콘솔에서 파일정보 확인
            console.log(file);

            // ajax로 전달할 폼 객체
            var formData = new FormData();
            // 폼 객체에 파일추가, append("변수명", 값)
            formData.append("file", file);


            $.ajax({
                type: "post",
                url: "${path}/product/uploadAjax",
                data: formData,
                // processData: true=> get방식, false => post방식
                dataType: "text",
                // contentType: true => application/x-www-form-urlencoded,
                //                false => multipart/form-data
                processData: false,
                contentType: false,
                // 업로드 성공하면
                success: function(data) {
                    var str = "";
                    // 이미지 파일이면 썸네일 이미지 출력
                    if(checkImageType(data)){
                        str = "<div><a href='${path}/upload/displayFile?fileName="+getImageLink(data)+"'>";
                        str += "<img src='${path}/upload/displayFile?fileName="+data+"'></a>";
                        // 일반파일이면 다운로드링크
                    } else {
                        str = "<div><a href='${path}/upload/displayFile?fileName="+data+"'>"+getOriginalName(data)+"</a>";
                    }
                    // 삭제 버튼
                    str += "<span data-src="+data+">[삭제]</span></div>";
                    $(".uploadedList").append(str);
                }
            });
        });
    });

    // 원본파일이름을 목록에 출력하기 위해
    function getOriginalName(fileName) {
        // 이미지 파일이면
        if(checkImageType(fileName)) {
            return; // 함수종료
        }
        // uuid를 제외한 원래 파일 이름을 리턴
        var idx = fileName.indexOf("_")+1;
        return fileName.substr(idx);
    }

    // 이미지파일 링크 - 클릭하면 원본 이미지를 출력해주기 위해
    function getImageLink(fileName) {
        // 이미지파일이 아니면
        if(!checkImageType(fileName)) {
            return; // 함수 종료
        }
        // 이미지 파일이면(썸네일이 아닌 원본이미지를 가져오기 위해)
        // 썸네일 이미지 파일명 - 파일경로+파일명 /2017/03/09/s_43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
        var front = fileName.substr(0, 12); // 년원일 경로 추출
        var end = fileName.substr(14); // 년원일 경로와 s_를 제거한 원본 파일명을 추출
        console.log(front); // /2017/03/09/
        console.log(end); // 43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
        // 원본 파일명 - /2017/03/09/43fc37cc-021b-4eec-8322-bc5c8162863d_spring001.png
        return front+end; // 디렉토리를 포함한 원본파일명을 리턴
    }

    // 이미지파일 형식을 체크하기 위해
    function checkImageType(fileName) {
        // i : ignore case(대소문자 무관)
        var pattern = /jpg|gif|png|jpeg/i; // 정규표현식
        return fileName.match(pattern); // 규칙이 맞으면 true
    }

    $(".uploadedList").on("click", "small", function (event) {
        var that = $(this);
        $.ajax({
            url: "/delete",
            type: "post",
            data: {fileName:$(this).attr("data-src")},
            dataType: "text",
            success: function (result) {
                if (result == "DELETED") {
                    alert("삭제되었습니다.");
                    that.parent("div").remove();
                }

            }
        });
    })
</script>
<%@include file="../include/footer.jsp"%>