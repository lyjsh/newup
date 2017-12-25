<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>

<style>
    html,body {
        margin: 0px;
        padding: 0px;
        background: #ddd
    }
    .login-content p {
        width: 90%;
        height: 30px;
        line-height: 30px;
        margin: 20px auto 10px auto;
        border-bottom:1px solid #ddd;
        font-size: 14px;
        font-family: '微软雅黑','文泉驿正黑','黑体';
    }
    li {
        list-style: none;
    }
    .login-content {
        text-align: center; /*让div内部文字居中*/
        width: 360px;
        height: 300px;
        margin: auto;
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: #FFFFFF;
        overflow: hidden;
    }
    .loginItem {
        margin: 10px auto;
        padding: 3px;
        width: 90%;
        height: 38px;
        border:1px solid #dedede;
        border-radius: 5px;
        box-sizing: border-box;

    }
    .loginItem span {
        font-size: 14px;
        font-family: '微软雅黑','文泉驿正黑','黑体';
    }
    .login_input {
        height: 30px;
        border: none;
        line-height: 30px;
        width: 240px;
        font-size: 14px;
        outline: none;
    }
    .loginSub input {
        margin-top: 15px;
        width: 140px;
        height: 30px;
        background: #90B549;
        color: #FFFFFF;
        font-size: 16px;
        font-family: '微软雅黑','文泉驿正黑','黑体';
        border: none;
        border-radius: 5px;
    }
    .loginSub input:hover {
        cursor: pointer;
    }
    .loginRemember {
        text-align: right;
        margin: 10px auto;
        height: 20px;
        line-height: 20px;
        width: 90%;

    }
    .loginRemember span:first-child {
        margin-top: 1px;
        display: inline-block;
        width: 15px;
        height: 15px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    .loginRemember span:first-child:hover {
        cursor: pointer;
    }
    .loginRemember span:last-child {
        font-family: '微软雅黑', '文泉驿正黑', '黑体';
        font-size: 14px;
        margin-right: 16px;
    }
    .rememChecked {
        margin-top: 1px;
        display: inline-block;
        text-align: center;
        width: 15px;
        height: 15px;
        line-height: 15px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    .rememChecked:hover {
        cursor: pointer;
    }
    .check-decorate {
        display: inline-block;
        width: 9px;
        height: 12px;
        border-bottom: 2px solid #45B549;
        border-right: 2px solid #45B549;
        transform:rotate(36deg);
        -ms-transform:rotate(36deg); 	/* IE 9 */
        -moz-transform:rotate(36deg); 	/* Firefox */
        -webkit-transform:rotate(36deg); /* Safari 和 Chrome */
        -o-transform:rotate(36deg); 	/* Opera */
    }

    .check-hidden {
        display: none;
    }

</style>
<body>
<div class="login-content">
    <p>管理员登陆</p>
    <form action="">
        <li class="loginItem">
            <span>用户名：</span>
            <input type="text" name="userName" placeholder="请输入用户名" class="login_input">
        </li>
        <li class="loginItem">
            <span>密&#12288码：</span>
            <input type="password" name="pwd" placeholder="密码长度为6到15位" class="login_input">
        </li>
        <li class="loginSub">
            <input type="submit" name="submit" value="登录">
            <input type="reset" name="reset" value="重置">
        </li>
        <li class="loginRemember">

            <div class="rememChecked" onclick="rememClick()">
                <div class="check-decorate"></div>
            </div>
            <span>记住我</span>
            <input type="hidden" name="rememberMe" value="0">
        </li>
    </form>
</div>

</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
    function rememClick() {
        var remember = $('input[name=rememberMe]').val();
        console.info(remember);
        if (0==remember) {
            $('.check-decorate').addClass("check-hidden");
        }else {
            $('.check-decorate').removeClass("check-hidden");
        }
        $('input[name=rememberMe]').val(1-remember);
    }
</script>
</html>