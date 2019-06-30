<html>
<head>
    <meta charset="UTF-8">
    <title>卖家管理系统</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="wrapper" class="toggled">
<#--主要内容content-->
    <div class="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h2 class="text-center text-info">
                        卖家管理系统登录界面
                    </h2>
                    <form role="form" method="post" action="/sell/seller/UI/login">
                    <div class="form-group">
                        <label>账号</label>
                        <input name="sellerId" type="text" class="form-control" value="${(sellerInfo.sellerId) !""}" />
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input name="password" type="password" class="form-control" value="${(sellerInfo.password) !""}" />
                    </div>
                </form>
                    <button type="submit" class="btn btn-success btn-lg btn-block">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

