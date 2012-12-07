<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:form action="/DeleteUser">
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Admin</th>
			<th>Delete</th>
		</tr>
		<logic:iterate id="userInfo" name="DeleteUserForm" property="userList">
			<html:hidden name="userInfo" property="user.userId" indexed="true" />
			<tr>
				<td><html:text name="userInfo" property="user.name" indexed="true" readonly="true" /></td>
				<td><html:text name="userInfo" property="user.email" indexed="true" readonly="true" /></td>
				<td><html:text name="userInfo" property="user.isAdmin" indexed="true" readonly="true" /></td>
				<td><html:checkbox property="delete" name="userInfo" indexed="true" /></td>
			</tr>
		</logic:iterate>
	</table>
	<html:submit>Commit</html:submit>
	<br />
	<html:link action="/cyslistWeb">Cyslist Home</html:link>
</html:form>