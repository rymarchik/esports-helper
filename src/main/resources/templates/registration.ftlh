<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    <h2>New user</h2>
    ${errorMessage!}
    <@l.login "/registration" "Sign up"/>
</@c.page>