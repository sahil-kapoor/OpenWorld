<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.openworld.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/home.css" />
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <div id="panel">
    <#if !currentUser??>
		    	<div id="cssmenu">
		    	<ul>
			        <li><a href="/login">Log in</a></li>
			        <li><a href="/user/create">Registration</a></li> 
			     </ul>
		        </div>
		        <div id="cssmenu">
			        <ul>
			        	<li><a href="/users">All users</a></li> 
			        </ul>
		        </div>
    </#if>
    <#if currentUser??>
    	<div id="cssmenu">
    	<ul>
		        <li>
		            <form action="/logout" method="post">
		                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		                <button type="submit">Log out</button>
		            </form>
		        </li>
		        <li>
		       		<a href="/user/${currentUser.id}">My profile</a>
		        </li>
		</ul>
        </div>
        <div id="cssmenu">
        <ul>
	         	<li><a href="/users">All users</a></div></li>   
	    </ul>
    </#if>
    <#if currentUser?? && currentUser.role == "ADMIN">
         <div>
	         <ul>
	         	<li><a href="/user/create">Add user</a><li>
	         </ul>
         </div> 
    </#if>
    </div>
</nav>
</body>
</html>