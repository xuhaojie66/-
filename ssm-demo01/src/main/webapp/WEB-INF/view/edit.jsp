
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/teacher/modify" method="post">
    <input type="hidden" name="tid" value="${teacher.tid}"/>
      tno:<input type="text" name="tno" value="${teacher.tno}"/> <br/>
    tname:<input type="text" name="tname" value="${teacher.tname}"/> <br/>
     tsex:<input type="text" name="tsex" value="${teacher.tsex}"/> <br/>
    <input type="submit" value="修改"/> <br/>
</form>

</body>
</html>
