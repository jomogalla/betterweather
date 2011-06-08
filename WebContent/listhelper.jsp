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
		<td class="top">os</td><td class="top">os version</td><td class="top">notes</td>
		<s:iterator value="ideBeans" status="rowstatus">
			<tr>
				<s:if test="#rowstatus.even == true">
					<td class="cells" ><s:property value="os"/></td>
					<td class="cells" ><s:property value="os_version"/></td>
					<td class="cells" ><s:property value="notes"/></td>
				</s:if>
				<s:else>
					<td><s:property value="os"/></td>
					<td><s:property value="os_version"/></td>
					<td><s:property value="notes"/></td>
				</s:else>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

