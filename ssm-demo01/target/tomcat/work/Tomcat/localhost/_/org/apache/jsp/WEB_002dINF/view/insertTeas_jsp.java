/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-02-11 09:00:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertTeas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>批量添加</title>\r\n");
      out.write("    <script src=\"../../js/jquery-3.4.1.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("            var tbody = $(\"#tbody01\");\r\n");
      out.write("            trNode = tbody.clone(true);\r\n");
      out.write("            tbody.on(\"click\", \" .teaAdd\", function () {\r\n");
      out.write("                $(\".tab\").append(trNode.clone(true));\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            tbody.on(\"click\",\".teaRem\",function () {\r\n");
      out.write("                var num = $(\"tr\",tbody).length;\r\n");
      out.write("                if( num === 1){\r\n");
      out.write("                    alert(\"最后一行不能删除\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                $(this).parent().parent().remove();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        /*数组*/\r\n");
      out.write("        $(\"#addAll\").click(function(){\r\n");
      out.write("            var teachers = [];\r\n");
      out.write("            $(\"#tbody01 tr\").each(function (i,obj) {\r\n");
      out.write("                teachers.push(\r\n");
      out.write("                    {\r\n");
      out.write("                        tname:$(\"input[name=tname]\",obj).val(),\r\n");
      out.write("                        tsex:$(\"select[name=tsex]\",obj).val(),\r\n");
      out.write("                    }\r\n");
      out.write("                );\r\n");
      out.write("            });\r\n");
      out.write("            console.log(teachers);\r\n");
      out.write("            $.post({\r\n");
      out.write("                url:\"${pageContext.request.contextPath}/teacher/addTeas\",\r\n");
      out.write("                contentType:\"application/json;charset=utf-8\",\r\n");
      out.write("                data:{\"teachers\":JSON.stringify(teachers)}\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        body {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        table tr{\r\n");
      out.write("            height: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        table {\r\n");
      out.write("\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            margin: auto;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table class=\"tab\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>姓名</th><th>性别</th><th>添加</th><th>移除</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody id=\"tbody01\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td><input type=\"text\" name=\"tname\"/></td>\r\n");
      out.write("        <td>\r\n");
      out.write("            <select name=\"tsex\">\r\n");
      out.write("                <option>请选择</option>\r\n");
      out.write("                <option value=\"男\">男</option>\r\n");
      out.write("                <option value=\"女\">女</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td><input type=\"button\" value=\"+\" class=\"teaAdd\"/></td>\r\n");
      out.write("        <td><input type=\"button\" value=\"-\" class=\"teaRem\"/></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"button\" id=\"addAll\" value=\"批量添加\" style=\"display: block;width: 100px;height: 40px; margin: 0 auto\" />\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
