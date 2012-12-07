<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>cysList</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
</head>
<body>
	<c:if test="${sessionScope.postResultsSize == 0}">
		<h1>No results</h1>
	</c:if>
	<c:if test="${sessionScope.postResultsSize > 0}">
		<h1>
			<c:out value="Displaying ${sessionScope.postResultsSize} of ${sessionScope.postResultsSize} results." />
		</h1>
		<c:set var="counter" value="1" />
		<table border="0">
			<c:forEach var="cur" items="${sessionScope.postResults}">
				<tr>
					<td><fmt:formatDate type="date" value="${cur.date}" /></td>
					<td>-</td>
					<td><html:form action="/ViewPostPage">
							<html:hidden property="postNum" name="ViewPostForm"
								value="${counter}" />
							<html:submit value="${cur.title}" styleClass="linkbutton" />
						</html:form></td>
					<td>-</td>
					<td><c:out value="${cur.topic}" /></td>
					<c:set var="counter" value="${counter + 1}" />
				</tr>
				<br />
			</c:forEach>
		</table>
	</c:if>
</body>
</html>