<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    ${message!}
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <@l.loginForm "/login" false/>
</@c.page>