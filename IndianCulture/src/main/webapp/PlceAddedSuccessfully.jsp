<%@page import="com.klef.ep.models.Admin"%>
<%@page import="com.klef.ep.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.klef.ep.services.AdminService"%>
<%@page import="javax.naming.InitialContext"%>

<%
Admin admin = (Admin) session.getAttribute("admin");

if(admin == null)
{
	response.sendRedirect("sessionexpired.html");
}
%>



<a href="logginedadminhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="#">View Places</a>&nbsp;&nbsp;&nbsp;
<a href="adminlogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
<br/><br/>
Welcome <%=admin.getUsername()%>


<center><h1><u>New Place Added SuccessFully</u></h1></center>