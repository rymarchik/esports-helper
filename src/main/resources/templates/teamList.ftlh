<#include "components/security.ftlh">
<#import "components/common.ftlh" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter!}" placeholder="Search team">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <#if isAdmin>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Add new team
        </a>
        <div class="collapse <#if team??>show</#if>" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <div class="form-group">
                        <input type="text" name="name" class="form-control ${(nameError??)?string('is-invalid', '')}"
                               value="<#if team??>${team.name!}</#if>" placeholder="Enter team name">
                        <#if nameError??>
                            <div class="invalid-feedback">
                                ${nameError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <input type="number" name="rank" class="form-control ${(rankError??)?string('is-invalid', '')}"
                               value="<#if team??>${team.rank!}</#if>" placeholder="Enter team rank">
                        <#if rankError??>
                            <div class="invalid-feedback">
                                ${rankError}
                            </div>
                        </#if>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </#if>

    <#list teams as team>
        <div class="card my-2">
            <div class="card-body">
                <span>#${team.rank}</span>
                <span>${team.name}</span>
            </div>
        </div>
    <#else>
        No such teams.
    </#list>

</@c.page>