<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>CysList</title>
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
</style>
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
	<br />
	<div class="container">
		<!-- Main message -->
		<div class="hero-unit">
			<h1>Hello, world!</h1>
			<br />
			<p>CysList provides Ames local classifieds for jobs, study
				groups, housing, for sale, services, local community, and events.</p>
		</div>
		<div style="color: red">
			<html:errors />
		</div>
		<jsp:include page="loginlogout.jsp" />
		<br />
		<html:link action="/DeleteUserAccount">Delete Account by Name</html:link><br />

		<!-- Row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Sell/Buy</h2>
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
			</div>
			<div class="span4">
				<h2>Study Groups</h2>
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
			</div>
			<div class="span4">
				<h2>Social</h2>
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
			</div>
		</div>
		<hr>
		<footer>
			<p>© CysList 2012</p>
		</footer>
	</div>
</body>
</html>
