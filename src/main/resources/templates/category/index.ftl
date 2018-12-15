<html>
<head>
    <meta charset="UTF-8">
    <title>卖家管理系统</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
        <#include "../common/nav.ftl">
<#--主要内容content-->
    <div class="page-content-wrapper">
        <div class="container-fluit">

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h2 class="text-center text-info">
                        商品类目管理
                    </h2>
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>类目名字</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName) !""}" />
                        </div>
                        <div class="form-group">
                            <label>Type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(category.categoryType) !""}" />
                        </div>
                        </div>
                <input hidden type="text" name="categoryId" value="${(category.categoryId)!""}">
                <button type="submit" class="btn btn-default">提交信息</button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>

