/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-10-27 02:01:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/layout/header.jsp", Long.valueOf(1666835166857L));
  }

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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- common CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/common/css/common.css\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("       <title>board</title>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).on('click', '#btnSave', function(e){\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("\r\n");
      out.write("        $(\"#form\").submit();\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(document).on('click', '#btnList', function(e){\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("            location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/board/getBoardList\";\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<article>\r\n");
      out.write("    <div class=\"container\" role=\"main\">\r\n");
      out.write("        <h2>board Form</h2>\r\n");
      out.write("\r\n");
      out.write("        <form name=\"form\" id=\"form\" role=\"form\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/board/saveBoard\">\r\n");
      out.write("            <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"title\">제목</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"title\" id=\"title\" placeholder=\"제목을 입력해 주세요\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"reg_id\">작성자</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"reg_id\" id=\"reg_id\" placeholder=\"이름을 입력해 주세요\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"content\">내용</label>\r\n");
      out.write("                <textarea class=\"form-control\" rows=\"5\" name=\"content\" id=\"content\" placeholder=\"내용을 입력해 주세요\" ></textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"mb-3\">\r\n");
      out.write("                <label for=\"tag\">TAG</label>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"tag\" id=\"tag\" placeholder=\"태그를 입력해 주세요\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        <div >\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-sm btn-primary\" id=\"btnSave\">저장</button>\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-sm btn-primary\" id=\"btnList\">목록</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</article>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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