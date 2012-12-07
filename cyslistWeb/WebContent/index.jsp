<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>CysList</title>
<!-- Bootstrap -->
<link href="./css/styles.css" rel="stylesheet" media="screen">
<script src="./js/bootstrap.min.js" type="text/javascript"></script>
<!-- jQuery -->
<script src="http://code.jquery.com/jquery-latest.js"
	type="text/javascript"></script>
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
		<!-- Main message -->
		<div class="hero-unit">
			<h1>Hello, world!</h1>
			<br />
			<p>CysList provides Ames local classifieds for jobs, study
				groups, housing, for sale, services, local community, and events.</p>
			<p><c:import url="search.jsp" /></p>
		</div>
		<div style="color: red">
			<html:errors />
		</div>
		<c:import url="loginlogout.jsp" />
		<br />
		<html:link action="/UserList">Delete Account</html:link>
		<br />
		
		<!-- Row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Sell/Buy</h2>
				<table>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="housing" />
								<html:submit value="Housing" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="books" />
								<html:submit value="Books" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="tickets" />
								<html:submit value="Tickets" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="furniture" />
								<html:submit value="Furniture" styleClass="linkbutton" />
							</html:form></td>
					</tr>
				</table>
			</div>
			<div class="span4">
				<h2>Study Groups</h2>
				<table>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="engineering" />
								<html:submit value="Engineering" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="art/design" />
								<html:submit value="Art/Design" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="other" />
								<html:submit value=Other" styleClass="linkbutton" />
							</html:form></td>
					</tr>
				</table>
			</div>
			<div class="span4">
				<h2>Social</h2>
				<table>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="events" />
								<html:submit value="Events" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="clubs" />
								<html:submit value="Clubs" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="help/tutoring" />
								<html:submit value="Help/Tutoring" styleClass="linkbutton" />
							</html:form></td>
					</tr>
					<tr>
						<td><html:form action="/TopicPosts">
								<html:hidden name="TopicPostsPageForm" property="topic"
									value="jobs" />
								<html:submit value="Jobs" styleClass="linkbutton" />
							</html:form></td>
					</tr>
				</table>
			</div>
		</div>
		<hr>
		<footer>
			<p>© CysList 2012</p>
		</footer>
	</div>
</body>
</html>
