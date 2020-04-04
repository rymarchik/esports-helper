<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    <h2>Login page</h2>
    <@l.login "/login" "Sign in"/>
    <a href="/registration">Sign up</a>
</@c.page>