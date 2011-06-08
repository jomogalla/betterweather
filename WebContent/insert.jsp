<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>insert</title>

	<style type="text/css">
		body {
			font-family:Arial,Helvetica,sans-serif;
		}
	</style>
</head>
<body>
	{insert}
	<a href="<s:url action='list'/>" >list</a>

	<hr/>

	<%-- Insert form, inserts an Ide object into the DB --%>
	<s:form action="insert">
		  <s:textfield key="ideBean.os" />
		  <s:textfield key="ideBean.os_version" />
		  <s:textarea key="ideBean.notes" />  
		  
		  <s:submit key= "submit"/>  	  
	</s:form>	
</body>
</html>
