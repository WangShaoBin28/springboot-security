<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有用户列表</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody>
    <#list page.list as user>
    <tr>
        <td> ${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.passWord}</td>
    </tr>
    </#list>
    </tbody>
</table>

<div id="test1">
</div>
<div id="test2"></div>
<script src="/layui/layui.js"></script>
<script>
    layui.use(['laypage','tree'], function () {
        var laypage = layui.laypage;
        var tree = layui.tree;

        //执行一个laypage实例
        laypage.render({
            elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
            , count: ${page.total} //数据总数，从服务端得到
            , limit: 2,
            curr:${page.pageNum},
            theme:"#1929cc"
            , jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数
                //首次不执行
                if (!first) {
                    //do something
                    window.location.href = "/user/list?pageNum=" + obj.curr + "&pageSize=" + obj.limit;
                }
            }
        });

        //渲染
        var inst1 = tree.render({
            elem: '#test2'  //绑定元素
            ,data: [{
                title: '江西' //一级菜单
                ,children: [{
                    title: '南昌' //二级菜单
                    ,children: [{
                        title: '高新区' //三级菜单
                        //…… //以此类推，可无限层级
                    }]
                }]
            },{
                title: '陕西' //一级菜单
                ,children: [{
                    title: '西安' //二级菜单
                }]
            }]
        });

    });
</script>
</body>
</html>