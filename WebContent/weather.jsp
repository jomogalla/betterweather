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
		.top{
			background-color:#d6b89a;
		}
		.insertionsuccess{
			font-size: small;
			font-style:italic;
		}
	</style>
</head>
<body>
	<s:form action="getWeather" >
		  <s:textfield key="parametersBean.zipCode" />
		  <s:textfield key="parametersBean.radius" /> 
		  
		  <s:submit key= "go"/>  	  
	</s:form>	

	<hr/>

	<%-- Renders the list from the database --%>	
	<s:action name="populatelist" executeResult="true" />
</body>
</html>

