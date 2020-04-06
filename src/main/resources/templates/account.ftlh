<#import "components/common.ftlh" as c>

<@c.page>
    <h2>Account settings</h2>
    <form method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="userId" value="${user.id}">

        <#if user.avatar??>
            <img src="/img/${user.avatar}">
        <#else>
            <img src="/img/default.jpg">
        </#if>
        <input type="file" name="avatar">

        <div>
            <label>
                Username:
                <input type="text" name="username">
            </label>
        </div>

        <div>
            <label>
                Password:
                <input type="password" name="password">
            </label>
        </div>

        <button type="submit">Save</button>
    </form>
</@c.page>