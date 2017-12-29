<style>
    .sider-container {
        display: inline-block;
        width: 60px;
        height: 24px;
        border: 1px solid #DEDEDE;
        border-radius: 20px;
        text-align: left;
        box-sizing: border-box;
        padding: 2px 0px;
    }

    .sider-bal {
        display: inline-block;
        width: 16px;
        height: 16px;
        border: 1px solid #DEDEDE;
        border-radius: 16px;
        margin-left: 10px;
        margin-right: 10px;
        background: #E9E9E9;
    }
    .form_div {
        width: 460px;
        margin: auto;
        min-height: 300px;
        box-sizing: border-box;
        padding: 10px;
        position: absolute;
        top: 0; left: 0; bottom: 0; right: 0;
    }
    .form_label {
        display: inline-block;
        height: 25px;
        line-height: 25px;
        width: 130px;
        vertical-align: top;
        text-align: right;
    }
    .form_content {
        display: inline-block;
        height: 30px;
        width: 300px;
        text-align: left;
        vertical-align: middle;
    }
    .form_content input {
        width: 180px;
        height: 21px;
    }
    .form-content-div {
        position: absolute;
        width: 460px;
        min-height: 300px;
        left:50%;
        top:50%;
        margin-left: -230px;
        margin-top:-150px;
    }
</style>
<div id="content" class="content">
    <div class="right_m">
        <!--会议列表-->
        <div class="hy_list">
            <div class="box_t">
                <span class="name">部门管理</span>
                <!--当前位置-->
                <div class="position">
                    <a href=""><img src="../../Assets/images/icon5.png" alt=""/></a>
                    <a href="">首页</a>
                    <span><img src="../../Assets/images/icon3.png" alt=""/></span>
                    <a href="">系统管理</a>
                    <span><img src="../../Assets/images/icon3.png" alt=""/></span>
                    <a href="">部门管理</a>
                </div>
                <!--当前位置-->
            </div>
            <!--查询-->
            <div class="search">
                <a href="/organization/index" class="btn">返回</a>
            </div>
            <div class="space_hx">&nbsp;</div>
            <div class="data_body">
                <div class="table_div">
                    <div class="form_div">
                        <div class="form-content-div">
                            <form id="orgAddForm" method="post" action="/organization/save">
                                <ul class="hypz">
                                    <li class="clearfix">
                                        <span class="form_label">部门名称：</span>
                                        <div class="form_content">
                                            <input name="name" type="text">
                                            <i style="color: red">*</i>
                                        </div>
                                    </li>
                                    <li class="clearfix">
                                        <input type="hidden" name="status">
                                        <span class="form_label">状态：</span>
                                        <div class="form_content">
                                            <div class="sider-container">
                                                <div class="sider-bal">

                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="clearfix">
                                        <a href="" class="btn">确认</a>
                                        <a href="" class="btn">取消</a>
                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <!--会议列表-->
            </div>
        </div>
        <script type="text/javascript">
            $(function () {
                /**
                 * form表单效果
                 */
                $(".sider-container").click(function () {
                    var currentPos = $(this).css("text-align");
                    if ('left' == currentPos) {
                        $('.sider-container').css({"text-align": "right", "background-color": "#98FB98"});
                        $('.sider-bal').css({"background-color": "#FFF"});
                        $('input[name="status"]').val(1);
                    } else if ('right' == currentPos) {
                        $('.sider-container').css({"text-align": "left", "background-color": "#FFF"});
                        $('.sider-bal').css({"background-color": "#E9E9E9"});
                        $('input[name="status"]').val(0);
                    }
                });

                /**
                 * form提交
                 */
            });
        </script>