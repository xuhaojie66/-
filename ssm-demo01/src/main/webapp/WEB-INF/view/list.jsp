
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $( function checkAll() {
            var all=document.getElementById("#checkAll");//获取到点击全选的那个复选框的id
            var one=document.getElementsByClassName(".tid");//获取到复选框的名称
            if(all.checked==true){//因为获得的是数组，所以要循环 为每一个checked赋值
                for(var i=0;i<one.length;i++){
                    one[i].checked=true;
                }
            }else{
                for(var j=0;j<one.length;j++){
                    one[j].checked=false;
                }
            }
        });

    </script>
</head>
<body>
<div><input type="button" value="批量添加"  onclick="window.open('/insertTeas');"/></div>
<table>
    <th><input type="checkbox" onclick="checkAll()" id="checkAll"/></th>
    <th>教职工号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>修改</th>
    <th>删除</th>
    <a:forEach items="${teachers}" var="teacher">
        <tr>
            <td><input type="checkbox" class="tid" value="${teacher.tid}"></td>
            <td>${teacher.tno}</td>
            <td> <a href="/teacher/selectStuById?tid=${teacher.tid}"> ${teacher.tname} </a></td>
            <td> ${teacher.tsex}</td>
            <td> <a href="/teacher/selectOneById?tid=${teacher.tid}">修改</a></td>
            <td><a href="/teacher/deleteOne?tid=${teacher.tid}">删除</a></td>
        </tr>
    </a:forEach>
</table>

</body>
</html>
