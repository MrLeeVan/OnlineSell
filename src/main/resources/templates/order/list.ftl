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
                           订单管理
                       </h2>
                       <table class="table table-condensed table-bordered">
                           <thead>
                           <tr>
                               <th>订单Id</th>
                               <th>姓名</th>
                               <th>用户电话</th>
                               <th>用户地址</th>
                               <th>金额</th>
                               <th>订单状态</th>
                               <th>支付状态</th>
                               <th>创建时间</th>
                               <th colspan="2">操作</th>
                           </tr>
                           </thead>

                           <tbody>
                 <#list orderDTOPage.content as orderDTO>
                 <tr>
                     <td>${orderDTO.orderId}</td>
                     <td>${orderDTO.buyerName}</td>
                     <td>${orderDTO.buyerPhone}</td>
                     <td>${orderDTO.buyerAddress}</td>
                     <td>${orderDTO.orderAmount}</td>
                     <td>${orderDTO.getOrderStatusEnum().message}</td>
                     <td>${orderDTO.getPayStatusEnum().message}</td>
                     <td>${orderDTO.createTime}</td>
                     <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                     <td><#if orderDTO.getOrderStatusEnum().message == "新订单">
                         <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                     </#if></td>
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
                 <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                </#if>
                <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage==index>
                    <li class ="disabled">
                        <a href="#"> ${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/order/list?page=${index}&size=${size}"> ${index}</a></li>
                    </#if>
                </#list>
                       <#--lte :语法小于等于-->
                <#if currentPage gte orderDTOPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                 <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                </#if>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
</div>
</body>
</html>

