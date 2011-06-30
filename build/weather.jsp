<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>betterweather</title>
	<style type="text/css">
		body {
			font-family:Arial,Helvetica,sans-serif;
		}
		.cells{
			background-color:#EDDFD1;
		}
		.oddcells{
			background-color:#d6b89a;
		}
		.top{
			background-color:#d6b89a;
		}
		.insertionsuccess{
			font-size: small;
			font-style:italic;
		}
		.mainform{
			text-shadow: 0px 1px 1px #4d4d4d;
			color: 222;
		}
	</style>
</head>
<body>
	<s:form action="getWeather" class="mainform">
		  <s:textfield key="parametersBean.zipCode" />
		  <s:textfield key="parametersBean.radius" /> 
		  <s:submit key= "submit"/>  	  
	</s:form>	

	<hr/>

	<%-- Renders the list from the database --%>
	
	<%-- After trying to put zip not found i think i realized that centerloc is not null??
	i dunno this is for debugging anyways, but i do need a zipcode not found on the site --%>
	
	<s:if test="centerLoc!=null">
		<p class="insertionsuccess">
			<s:property value="centerLoc.toString()" />
		</p>
	</s:if>

	<table>
		<s:iterator value="cityBeans" status="rowstatus">
			<tr>
				<s:if test="#rowstatus.even == true">
					<td class="cells" ><s:property value="city"/></td>
					<td class="cells" ><s:property value="state"/></td>
					<td class="cells" ><s:property value="latitude"/></td>
					<td class="cells" ><s:property value="longitude"/></td>
					<td class="cells" ><s:property value="distance"/></td>
					<!--<td class="cells" ><s:property value="distance"/></td>-->
				</s:if>
				<s:else>
					<td class="oddcells"><s:property value="city"/></td>
					<td class="oddcells"><s:property value="state"/></td>
					<td class="oddcells" ><s:property value="latitude"/></td>
					<td class="oddcells" ><s:property value="longitude"/></td>
					<td class="oddcells" ><s:property value="distance"/></td>
					<!--<td class="oddcells"><s:property value="distance"/></td>-->
				</s:else>
			</tr>
		</s:iterator>
	</table>
</body>
</html>

