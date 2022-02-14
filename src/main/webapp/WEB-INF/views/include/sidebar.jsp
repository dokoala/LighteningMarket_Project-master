<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="col-lg-3">

    <h1 class="my-4">Shop Name</h1>
    <form id="categoryLink" name="categoryLink" method="POST">
    <div class="list-group">
        <a class="list-group-item main" class="list-group-item">옷
            <ul class="sub" style="display:none">
                </br>
                <li class="list-group-item test">
                    <input type="hidden" value="201" id="cateCode1" name="top">
                    상의
                </li>
                <li class="list-group-item test">
                    <input type="hidden" value="202" id="cateCode2" name="bottom">
                    하의
                </li>
                <li class="list-group-item test">
                    <input type="hidden" value="203" id="cateCode3" name="shoes">
                    신발
                </li>
            </ul>
        </a>
        <a href="../product/productList" class="list-group-item">동물</a>
        <a href="#" class="list-group-item">음식</a>
    </div>
    </form>

    <script>
        $(".main").click(function(){
            if($(".sub").is(":visible")){
                $(".sub").slideUp();
            }
            else{
                $(".sub").slideDown();
            }
        });

        $(document).ready(function(){
            $(".test").click(function(){
                document.categoryLink.action = "../product/productList";
                document.categoryLink.setAttribute("cateCode", $(this).attr("value"))
                document.categoryLink.submit();
            });
        });
    </script>

</div>
