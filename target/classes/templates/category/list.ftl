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
                           类目管理
                       </h2>
                       <table class="table table-condensed table-bordered">
                           <thead>
                           <tr>
                               <th>类目Id</th>
                               <th>名字</th>
                               <th>Type</th>
                               <th>创建时间</th>
                               <th>修改时间</th>
                               <th>操作</th>
                           </tr>
                           </thead>

                           <tbody>
                 <#list categoryList as category>
                 <tr>
                     <td>${category.categoryId}</td>
                     <td>${category.categoryName}</td>
                     <td>${category.categoryType}</td>
                     <td>${category.createTime}</td>
                     <td>${category.updateTime}</td>
                     <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                 </tr>
                 </#list>
                           </tbody>
                       </table>
                   </div>
               </div>
           </div>
       </div>
</div>
</body>
</html>

