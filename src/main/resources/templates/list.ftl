<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有用户列表</title>
</head>
<body>
<#list userList as user>
    ${user.userName}
</#list>
</body>
</html>