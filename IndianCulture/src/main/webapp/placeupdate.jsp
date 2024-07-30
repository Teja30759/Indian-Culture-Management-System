<%@page import="com.klef.ep.models.Places"%>
<%@page import="com.klef.ep.services.PlacesService"%>
<%@page import="javax.naming.InitialContext"%>

<% 
String name = request.getParameter("name");
String location = request.getParameter("loc");
String desc = request.getParameter("des");
String history = request.getParameter("his");
String time = request.getParameter("tim");

InitialContext context = new InitialContext();

PlacesService placeSer = (PlacesService) context.lookup("java:global/IndianCulture/PlacesServiceIMPL!com.klef.ep.services.PlacesService");

Places p = placeSer.viewplacebyname(name);

if(p!=null)
{
    //System.out.println("ID Found");
    Places emp = new  Places();
    
    emp.setName(name);
    emp.setState(location);
    emp.setDes(desc);
    emp.setHistoricalsig(history);
    emp.setBesttimetovisit(time);
    
    
    Places pla =  placeSer.viewplacebyname(name);
    
    session.setAttribute("place", pla);
    
    out.println("Employee Profile Updated Successfully");
}
else
{
  out.println("Employee ID Not Found");
}
%>