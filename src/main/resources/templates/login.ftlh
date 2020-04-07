<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    ${message!}
    <@l.loginForm "/login" false/>
</@c.page>