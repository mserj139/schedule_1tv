<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
Add new user

    ${message?ifExists}

<@l.login "/registrarion" />
</@c.page>



<#--<form action= method="post">-->
    <#--<div><label> Username: <input type="text" name="username"/> </label></div>-->
    <#--<div><label> Password: <input type="password" name="password"/> </label></div>-->
    <#--<input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
    <#--<div><input type="submit" value="Sign In"/></div>-->
<#--</form>-->