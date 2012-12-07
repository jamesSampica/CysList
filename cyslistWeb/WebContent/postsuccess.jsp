<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
	</head>
    <body>
        <h1>Post Success!</h1>
        <div>
			Here is your key: <%= session.getAttribute("postkey") %>
			<br />
			Please save your key for future reference.
		</div>
		<p><a href="/cyslistWeb/">Go To Home</a></p>
    </body>
</html>
