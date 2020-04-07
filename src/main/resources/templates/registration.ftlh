<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    <div class="mb-10"><h3>New user</h3></div>
    ${errorMessage!}
    <@l.loginForm "/registration" true/>
</@c.page>