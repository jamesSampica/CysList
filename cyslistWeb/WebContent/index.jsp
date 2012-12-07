<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cysList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
<body>
	<h1>cysList</h1>
	<c:import url="search.jsp" />


	<h4>
	<c:if test="${active_user.isAdmin==true}">
			<html:link action="/ViewFlag">View Flags</html:link>
	</c:if>
	</h4>
		
		
		
		
<%-- 	<c:if test="${active_user.isAdmin==true}">	 --%>
<c:choose>
<c:when test="${active_user !=null}">

		<html:form action="/ViewProfile">
			<html:hidden name="ViewProfileForm" property="name" value="${active_user.name} "/>
			<html:submit value="viewProfile" styleClass="linkbutton" />
		</html:form>	
<%-- 	</c:if> --%>
</c:when>
</c:choose>	
	
	
	<h4>
		<html:link action="/UserPostPage">post</html:link>
	</h4>
	<h4>
		<html:link action="/ManagePostQueryPage">manage posts</html:link>
	</h4>
	<div style="color: red">
		<html:errors />
	</div>
	<c:import url="loginlogout.jsp" />
	<br />
	<html:link action="/UserList">Delete Account</html:link>
	<h4>Sell/Buy</h4>
	<table>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="housing" />
					<html:submit value="housing" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="books" />
					<html:submit value="books" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="tickets" />
					<html:submit value="tickets" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="furniture" />
					<html:submit value="furniture" styleClass="linkbutton" />
				</html:form></td>
		</tr>
	</table>
	<h4>Study Groups</h4>
	<table>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="engineering" />
					<html:submit value="engineering" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="art/design" />
					<html:submit value="art/design" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="other" />
					<html:submit value="other" styleClass="linkbutton" />
				</html:form></td>
		</tr>
	</table>
	<h4>Social</h4>
	<table>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="events" />
					<html:submit value="events" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="clubs" />
					<html:submit value="clubs" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="help/tutoring" />
					<html:submit value="help/tutoring" styleClass="linkbutton" />
				</html:form></td>
		</tr>
		<tr>
			<td><html:form action="/TopicPosts">
					<html:hidden name="TopicPostsPageForm" property="topic"
						value="jobs" />
					<html:submit value="jobs" styleClass="linkbutton" />
				</html:form></td>
		</tr>
	</table>
</body>
</html>
