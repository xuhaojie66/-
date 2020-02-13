
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
<p>${teacher.tname}</p>
<table>
    <th><input type="checkbox" onclick="checkAll()" id="checkAll"/></th>
    <th>学工号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>删除</th>
    <a:forEach items="${teacher.students}" var="student">
        <tr>
            <td><input type="checkbox" class="sid" value="${student.sid}"></td>
            <td>${student.sno}</td>
            <td>${student.sname} </a></td>
            <td> ${student.ssex}</td>
            <td><a href="/student/deleteOne?sid=${student.sid}">删除</a></td>
        </tr>
    </a:forEach>
</table>
</body>
</html>
