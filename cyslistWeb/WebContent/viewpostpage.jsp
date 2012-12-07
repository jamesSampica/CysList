<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String currentURL = request.getRequestURL().toString();
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>CysList</title>
 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./css/styles.css"  type="text/css"/>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/cyslistWeb">CysList</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="/cyslistWeb">Home</a></li>
						<li><html:link action="/UserPostPage">Create Post</html:link></li>
						<li><html:link action="/ManagePostQueryPage">Manage Post</html:link></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	
	<div class="container">
	<!-- Facebook JavaScript SDK -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=455177151207645";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<h1>${post.title}</h1>
	<a href="/cyslistWeb/" id="home">home</a>
	<br /><br />
	<div class="fb-like" data-href="<%= currentURL %>" data-send="false" data-width="450" data-show-faces="true"></div>
	<div>
		<table border="1" bordercolor="#000000" style="background-color:#FFFFFF" width="30%" cellpadding="5" cellspacing="1">
			<tr>
    			<td>Date : ${post.date}</td>
    		</tr>
    		<tr>
    			<td>Email : <a href="mailto:${post.email}">${post.email}</a></td>
    		</tr>	
    		<tr>
    			<td>${post.content}</td>
    		</tr>
    		<c:if test="${post.imageExt!='.'}">
    		<tr>
    			<td><img class="imageSizeScale" alt="No image uploaded" src="images/${fn:substring(post.postKey, 12,-1)}${post.imageExt}" /></td>
    		</tr>
    		</c:if>
		</table>
		<br />
		<div class="fb-comments" data-href="<%= currentURL %>" data-width="470" data-num-posts="5"></div>
	</div>
	</div>
</body>
</html>
