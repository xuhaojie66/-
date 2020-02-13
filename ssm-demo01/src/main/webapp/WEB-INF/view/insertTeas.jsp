<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>批量添加</title>
    <script src="../../js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            var tbody = $("#tbody01");
            trNode = tbody.clone(true);
            tbody.on("click", " .teaAdd", function () {
                $(".tab").append(trNode.clone(true));
            });

            tbody.on("click",".teaRem",function () {
                var num = $("tr",tbody).length;
                if( num === 1){
                    alert("最后一行不能删除");
                    return false;
                }
                $(this).parent().parent().remove();
            });
        });
        /*数组*/
        $("#addAll").click(function(){
            var teachers = [];
            $("#tbody01 tr").each(function (i,obj) {
                teachers.push(
                    {
                        tname:$("input[name=tname]",obj).val(),
                        tsex:$("select[name=tsex]",obj).val(),
                    }
                );
            });
            console.log(teachers);
            $.post({
                url:"${pageContext.request.contextPath}/teacher/addTeas",
                contentType:"application/json;charset=utf-8",
                data:{"teachers":JSON.stringify(teachers)}
            });
        });
    </script>
    <style type="text/css">
        body {
            text-align: center;
        }

        table tr{
            height: 30px;
        }
        table {

            border-collapse: collapse;
            margin: auto;
        }

    </style>
</head>
<body>

<table class="tab">
    <thead>
    <tr>
        <th>姓名</th><th>性别</th><th>添加</th><th>移除</th>
    </tr>
    </thead>
    <tbody id="tbody01">
    <tr>
        <td><input type="text" name="tname"/></td>
        <td>
            <select name="tsex">
                <option>请选择</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </td>
        <td><input type="button" value="+" class="teaAdd"/></td>
        <td><input type="button" value="-" class="teaRem"/></td>
    </tr>

    </tbody>
</table>
<input type="button" id="addAll" value="批量添加" style="display: block;width: 100px;height: 40px; margin: 0 auto" />
</body>

</html>