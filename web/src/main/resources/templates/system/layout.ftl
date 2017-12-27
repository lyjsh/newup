<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/thems.css">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
</head>
<style>
    html, body {
        padding: 0px;
        margin: 0px;
        font-family: "微软雅黑";
        text-align: center;
        font-size: 12px;
        color: #656565;
        background: #E9E9E9;
        overflow: hidden;
    }

    header {
        width: 100%;
        height: 50px;
    }

    aside {
        position: absolute;
        top: 50px;
        width: 14%;
        height: 100%;
        background: #F9F9F9;
    }

    .content {
        position: absolute;
        width: 85%;
        top: 50px;
        left: 225px;
        height: 100%;
    }

    .data_body {
        width: 100%;
        height: 100%;
    }

    .tree_div {
        width: 16%;
        min-height: 500px;
        background: #FFF;
        float: left;
    }

    .table_div {
        width: 100%;
        min-height: 500px;
        display: inline-block;
        background: #FFF;
        float: right;
        box-sizing: border-box;
    }

    .data_table {
        width: 100%;
    }

    .edit_btn {
        text-align: center;
        width: 30px;
        height: 30px;
        line-height: 30px;
        vertical-align: middle;
        border: 0px;
    }

    .edit_btn img {
        width: 28px;
        height: 28px;
        vertical-align: middle;
    }

    /*.edit_btn span {
        font-family: 微软雅黑;
        font-size: 14px;
    }*/
    .edit_btn:hover {
        cursor: pointer;
    }
</style>
<body>

<!--引入头部 -->
<#include "/layout/header.ftl">

<!--引入左边导航栏 -->
<#include "/layout/siderbar.ftl">

<!--引入内容栏-->
<#include "${view}">

</body>
<script type="text/javascript">

    $(document).ready(function () {
        $('.nav_m').click(function () {
            var nav_m = $(this);
            $(this).parent().find(".erji").slideToggle(function () {
                if (($(this).is(':hidden'))) {
                    nav_m.find("i").css({
                        "background": "url(/static/Assets/images/icon3.png) no-repeat"
                    });
                } else {
                    nav_m.find("i").css({
                        "background": "url(/static/Assets/images/icon2.png) no-repeat"
                    });
                }
            });
        });
        $(".menu-item").click(function () {
            $(this).parent().find('.subMenu-item').slideToggle();
        });

    });
</script>
</html>