<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.openworld.domain.UserCreateForm" -->
<#-- @ftlvariable name="currentUser" type="com.openworld.domain.CurrentUser" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/home.css" />
     <link rel="stylesheet" type="text/css" href="/css/registration.css" />
    <title>Create a new user</title>
</head>
<body>
<nav role="navigation">
	<div id="cssmenu">
	    <ul>
	        <li><a href="/">Home</a></li>
	    </ul>
	 </div>
</nav>

 <div id="cssmenu">
	<ul>
		<li><a href="/users">All users</a></li> 
	</ul>
</div>

<div id="wrapper">
<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<fieldset>
		<h1>Registration</h1>
	    <div>
	        <input type="email" name="email" id="email" value="${form.email}" placeholder="Email*" required autofocus/>
	    </div>
	    <div>
	        <input type="text" name="login" id="login" value="${form.login}" placeholder="Login*" required/>
	    </div>
	    <div>
	        <input type="text" name="firstName" id="firstName" value="${form.firstName}" placeholder="First Name"/>
	    </div>
	    <div>
	        <input type="text" name="lastName" id="lastName" value="${form.lastName}" placeholder="Last Name"/>
	    </div>
	    <div>
	        <input type="password" name="password" id="password" placeholder="Password" required/>
	    </div>
	    <div>
	        <input type="password" name="passwordRepeated" id="passwordRepeated" placeholder="Repeat password" required/>
	    </div>
	    <#if currentUser?? && currentUser.role == "ADMIN"> 
	    <div>
	        <label for="role">Role*</label>
	        <select name="role" id="role" required>
	            <option <#if form.role == 'USER'>selected</#if>>USER</option>
	            <option <#if form.role == 'ADMIN'>selected</#if>>ADMIN</option>
	        </select>
	    </div>
	    </#if>
	    <button type="submit">Save</button>
    </fieldset>
</form>
</div>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>