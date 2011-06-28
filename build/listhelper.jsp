<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body>
<%-- 	The following code generates a two column table from the value 
		of ideBeans off the stack. The class cells has a single style
		which makes the background that nice brown					--%>
		
			
	<table>
		<s:iterator value="cityBeans" status="rowstatus">
			<tr>
				<s:if test="#rowstatus.even == true">
					<td class="cells" ><s:property value="city"/></td>
					<td class="cells" ><s:property value="state"/></td>
					<td class="cells" ><s:property value="distance"/></td>
				</s:if>
				<s:else>
					<td class="oddcells"><s:property value="city"/></td>
					<td class="oddcells"><s:property value="state"/></td>
					<td class="oddcells"><s:property value="distance"/></td>
				</s:else>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

