<#macro loginForm path isRegisterForm>
    <form method="post" action="${path}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="username">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" name="password">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-2">
                <button type="submit" class="btn btn-primary"><#if isRegisterForm>Sign Up<#else>Sign In</#if></button>
            </div>
        </div>
        <#if !isRegisterForm>
            <div class="form-group row">
                <div class="col-sm-2">
                    <a href="/registration" class="btn btn-primary" role="button">Sign Up</a>
                </div>
            </div>
        </#if>
    </form>
</#macro>

<#macro logout>
    <form method="post" action="/logout">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Sign Out</button>
    </form>
</#macro>