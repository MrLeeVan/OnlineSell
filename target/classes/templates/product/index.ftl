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
        <div class="container">

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h2 class="text-center text-info">
                        商品信息管理
                    </h2>
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>商品名称</label>
                            <input name="productName" type="text" class="form-control" value="${(productInfo.productName) !""}" />
                        </div>
                        <div class="form-group">
                            <label>商品价格</label>
                            <input name="productPrice" type="text" class="form-control" value="${(productInfo.productPrice) !""}" />
                        </div>
                        <div class="form-group">
                            <label>商品库存</label>
                            <input name="productStock" type="number" class="form-control" value="${(productInfo.productStock) !""}" />
                        </div>
                        <div class="form-group">
                            <label>商品描述</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription) !""}" />
                        </div>
                        <div class="form-group">
                            <label>商品图片</label>
                            <img height="200" width="280" src="${(productInfo.productIcon) !""}" alt="">
                            <input name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon) !""}" />
                        </div>
                        <div class="form-group">
                            <label>商品类目</label>
                            <select name="categoryType" class="form-control">
                            <#list categoryList as category>
                                <option value="${category.categoryType}"
                                   <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType> selected </#if>
                                >${category.categoryName}
                                </option>
                            </#list>
                            </select>
                        </div>
                        </div>
                <input hidden type="text" name="productId" value="${(productInfo.productId)!""}">
                <button type="submit" class="btn btn-default">提交信息</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

