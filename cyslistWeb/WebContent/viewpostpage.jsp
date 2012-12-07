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
	
	<html:form action="/flagUserPost">
		<html:hidden name="UserFlagForm" property="postKey" value="${post.postKey} "/>
		<html:submit value="flag" styleClass="linkbutton" />
	</html:form>
	
	
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
<!-- 		Email seller -->
		--> Interested?</br>
<!-- 		<a href="mailto:homer@example.com?subject=From cysList!"> Click here to email this seller</a> -->
		<a href= "mailto:${post.email}?subject=From cysList!">Email this seller</a>
		
		</br>
		</br>
	<html:form action="/rateSeller">
		<html:hidden name="UserRatingForm" property="email" value="${post.email} "/>
		-->Rate this seller (boundary: between 1 and 5): </br>
		<html:text name="UserRatingForm" property="rating"/>
		
		<html:submit value="rate this seller" styleClass="button" />
	</html:form>
		
		</br></br></br>
		<div class="fb-comments" data-href="<%= currentURL %>" data-width="470" data-num-posts="5"></div>
	</div>
	
	
</body>
</html>
