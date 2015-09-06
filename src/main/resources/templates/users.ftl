<#-- @ftlvariable name="users" type="java.util.List<com.openworld.domain.User>" -->
<#-- @ftlvariable name="currentUser" type="com.openworld.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/home.css" />
    <title>List of Users</title>
</head>
<body>
<nav role="navigation">
      <div id="cssmenu">
			<ul>
			     <li><a href="/">Home</a></li>
		         <#if currentUser?? && currentUser.role == "ADMIN">
		         <li><a href="/user/create">Add user</a></li>  
		    </#if>
		    </ul>
    	</div>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>E-mail</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td><a href="/user/${user.userId}">${user.email}</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>