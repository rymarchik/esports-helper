<#macro loginForm path isRegisterForm>
    <form method="post" action="${path}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-5">
                <input type="text" name="username" class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       value="<#if user??>${user.username!}</#if>">
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid', '')}">
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Confirm password</label>
                <div class="col-sm-5">
                    <input type="password" name="confirmPassword"
                           class="form-control ${(confirmPasswordError??)?string('is-invalid', '')}">
                    <#if confirmPasswordError??>
                        <div class="invalid-feedback">
                            ${confirmPasswordError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-5">
                    <input type="email" name="email" class="form-control ${(emailError??)?string('is-invalid', '')}"
                           value="<#if user??>${user.email!}</#if>">
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
        </#if>

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