<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情页</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
<#--        订单总金额-->
        <div class="col-md-4 column">
            <table class="table table-hover table-bordered" >
                <thead>
                <tr>
                    <th>订单id</th>
                    <th>订单总金额</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${orderDTO.orderId }</td>
                    <td>${orderDTO.orderAmount}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <#--订单详情表数据-->
        <div class="col-md-12 column">
            <table class="table table-hover table-bordered" >
                <thead>
                <tr>
                    <th>商品id</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>总金额</th>
                </tr>
                </thead>
                <tbody>
                <#list orderDTO.orderDetailList as orderDtail>
                <tr>
                    <td>${orderDtail.orderId}</td>
                    <td>${orderDtail.productName}</td>
                    <td>${orderDtail.productPrice}</td>
                    <td>${orderDtail.productQuantity}</td>
                    <td>${orderDtail.productQuantity * orderDtail.productPrice}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>