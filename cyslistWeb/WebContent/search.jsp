<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>cysList</title>
</head>
<body>
	<html:form action="/search" method="POST">
		<html:text name="SearchForm" property="value" />
		<html:select name="SearchForm" property="category">
			<html:option value="all">All</html:option>
			<html:option value="housing">Housing</html:option>
			<html:option value="books">Books</html:option>
			<html:option value="tickets">Tickets</html:option>
			<html:option value="furniture">Furniture</html:option>
			<html:option value="events">Events</html:option>
			<html:option value="clubs">Clubs</html:option>
			<html:option value="help/tutoring">Help/Tutoring</html:option>
			<html:option value="jobs">Jobs</html:option>
			<html:option value="engineering">Engineering</html:option>
			<html:option value="art/design">Art/Design</html:option>
			<html:option value="other">Other</html:option>			
		</html:select>
		<html:submit value="Search" />
	</html:form>
</body>
</html>