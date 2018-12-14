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
                           商品管理
                       </h2>
                       <table class="table table-condensed table-bordered">
                           <thead>
                           <tr>
                               <th>商品Id</th>
                               <th>商品名称</th>
                               <th>商品状态</th>
                               <th>商品图片</th>
                               <th>商品单价</th>
                               <th>库存</th>
                               <th>描述</th>
                               <th>类目</th>
                               <th>创建时间</th>
                               <th>修改时间</th>
                               <th colspan="2">操作</th>
                           </tr>
                           </thead>
                           <tbody>
                 <#list productInfoPage.content as productInfo>
                 <tr>
                     <td>${productInfo.productId}</td>
                     <td>${productInfo.productName}</td>
                     <td>${productInfo.getProductStatusEnum().message}</td>
                     <td><img height="100" width="120" src="${productInfo.productIcon}"></td>
                     <td>${productInfo.productPrice}</td>
                     <td>${productInfo.productStock}</td>
                     <td>${productInfo.productDescription}</td>
                     <td>${productInfo.categoryType}</td>
                     <td>${productInfo.createTime}</td>
                     <td>${productInfo.updateTime}</td>
                     <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                     <td>
                     <#if productInfo.getProductStatusEnum().message == "在架">
                         <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                         <#else>
                         <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>

                     </#if>
                     </td>
                 </tr>
                 </#list>
                           </tbody>
                       </table>
                   </div>

               <#--   分页-->
                   <div class="col-md-12 column">
                       <ul class="pagination pull-right" >
                <#if currentPage lte 1>
                <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                 <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                </#if>
                <#list 1..productInfoPage.getTotalPages() as index>
                    <#if currentPage==index>
                    <li class ="disabled">
                        <a href="#"> ${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${index}&size=${size}"> ${index}</a></li>
                    </#if>
                </#list>
                       <#--lte :语法小于等于-->
                <#if currentPage gte productInfoPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                 <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                </#if>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
</div>
</body>
</html>

