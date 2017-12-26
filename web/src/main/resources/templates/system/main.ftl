<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/static/Assets/css/thems.css">
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
<body ng-app="orgApp">

<!--引入头部 -->
<#include "/layout/header.ftl">

<!--引入左边导航栏 -->
<#include "/layout/siderbar.ftl">

<div id="content" class="content" ng-controller="orgContentController">
    <div class="right_m">
        <!--会议列表-->
        <div class="hy_list">
            <div class="box_t">
                <span class="name">部门管理</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="/static/Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="/static/Assets/images/icon3.png" alt=""/></span>
                    <a href="">系统管理</a>
                    <span><img src="/static/Assets/images/icon3.png" alt=""/></span>
                    <a href="">部门管理</a>
                </div>
                <!--当前位置-->
            </div>
            <!--查询-->
            <div class="search">
                <span>按部门名称查询：</span>
                <div class="s_text"><input name="" type="text"></div>
                <a href="" class="btn">查询</a>
                <a href="" class="btn">新增</a>
            </div>
            <!--查询-->
            <div class="space_hx">&nbsp;</div>
            <div class="data_body">
                <!-- <div class="tree_div">

                 </div>-->
                <div class="table_div">
                    <!--列表-->
                    <div style="data_table">
                        <table cellpadding="0" cellspacing="0" class="list_hy">
                            <tr>
                                <th class="xz" scope="col">选择</th>
                                <th scope="col">
                                    部门名称
                                </th>
                                <th scope="col" width="180px">
                                    <div>成立时间<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                                </th>
                                <th scope="col" width="140px">部门人数</th>
                                <th class="zt" scope="col">
                                    <div>状态<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                                </th>
                                <th scope="col" width="140px">
                                    <div>操作</div>
                                </th>
                            </tr>
                            <tr ng-repeat="org in orgList">
                                <td class="xz"><input name="" type="checkbox" value=""></td>
                                <td>{{org.name}}</td>
                                <td>{{org.createTime}}</td>
                                <td>{{org.userTotal}}</td>
                                <td>{{org.status}}</td>
                                <td style="text-align: left">
                                    <a class="edit_btn">
                                        <img src="/static/images/edit_btn.png">
                                        <!-- <span>编辑</span>-->
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <!--列表-->
                    <!--右边底部-->
                    <div class="r_foot">
                        <div class="r_foot_m">
            	<span>
                	<input name="" type="checkbox" value="">
                    <em>全部选中</em>
                </span>
                            <a href="" class="btn">删除</a>
                            <a href="" class="btn">刷新</a>

                            <!--分页-->
                            <div class="page">
                                <a href="" class="prev"><img src="/static/Assets/images/icon7.png" alt=""/></a>
                                <a class="now">1</a>
                                <a href="">2</a>
                                <a href="">3</a>
                                <a href="">4</a>
                                <a href="">5</a>
                                <a href="">6</a>
                                <a href="" class="next"><img src="/static/Assets/images/icon8.png" alt=""/></a>
                            </div>
                            <!--分页-->
                        </div>
                    </div>
                </div>
            </div>
            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
    //angularjs
    var app = angular.module('orgApp', []);
    app.controller('orgContentController', function($scope) {
        $scope.orgList = [
            {id:1,name:'软件部',pId:0,createTime:0,updateTime:0,createUid:1,updateUid:1,status:1,userTotal:0,order:1},
            {id:1,name:'软件部',pId:0,createTime:0,updateTime:0,createUid:1,updateUid:1,status:1,userTotal:0,order:1},
            {id:1,name:'软件部',pId:0,createTime:0,updateTime:0,createUid:1,updateUid:1,status:1,userTotal:0,order:1},
            {id:1,name:'软件部',pId:0,createTime:0,updateTime:0,createUid:1,updateUid:1,status:1,userTotal:0,order:1}
        ];
        $scope.lastName = "Doe";
    });
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