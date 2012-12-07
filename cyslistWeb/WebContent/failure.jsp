<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <title>CysList</title>
<link href="./css/styles.css" rel="stylesheet" media="screen">
</head>
<body>
-	<div class="navbar navbar-inverse navbar-fixed-top">
-		<div class="navbar-inner">
-			<div class="container">
-				<a class="btn btn-navbar" data-toggle="collapse"
-					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
-					class="icon-bar"></span> <span class="icon-bar"></span>
-				</a> <a class="brand" href="/cyslistWeb">CysList</a>
-				<div class="nav-collapse collapse">
-					<ul class="nav">
-						<li class="active"><a href="/cyslistWeb">Home</a></li>
-						<li><html:link action="/UserPostPage">Create Post</html:link></li>
-						<li><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
-					</ul>
-				</div>
-				<!--/.nav-collapse -->
-			</div>
-		</div>
-	</div>
-	<div class="container">

        <div style="color:red">
            <h1>Invalid user name  <bean:write name="LoginForm" property="userName"></bean:write></h1>
        </div>
        </div>
    </body>
</html>
