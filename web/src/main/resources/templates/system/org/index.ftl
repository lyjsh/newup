<div id="content" class="content">
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
                <a href="/organization/view/add" class="btn">新增</a>
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
                                <th scope="col" width="180px">
                                    <div>修改时间<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                                </th>
                                <th scope="col" width="140px">部门人数</th>
                                <th class="zt" scope="col">
                                    <div>状态<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                                </th>
                                <th scope="col" width="140px">
                                    <div>操作</div>
                                </th>
                            </tr>
                        <#list pageInfo.list as org>
                            <tr ng-repeat="org in orgList">
                                <td class="xz"><input name="" type="checkbox" value="${org.id}"></td>
                                <td>${org.name}</td>
                                <td>${org.createTime}</td>
                                <td>${org.updateTime}</td>
                                <td>${org.userTotal}</td>
                                <td>
                                    <div>
                                        <#if org.status==1>
                                            <span>启用</span>
                                        <#else>
                                            <span>禁用</span>
                                        </#if>
                                        <input type="hidden" value="${org.status}">
                                    </div>
                                </td>
                                <td style="text-align: left">
                                    <a class="edit_btn">
                                        <img src="/static/images/edit_btn.png">
                                        <!-- <span>编辑</span>-->
                                    </a>
                                </td>
                            </tr>
                        </#list>
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