<#import "components/common.ftlh" as c>
<#import "components/login.ftlh" as l>

<@c.page>
    <@l.logout/>

    <div>
        <form method="post" action="/main">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="text" name="name" placeholder="Введите название команды">
            <input type="number" name="rank" placeholder="Введите ранк команды">
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>
        <div>Список команд:</div>

        <div>
            <form method="get" action="/main">
                <input type="text" name="filter" value="${filter}">
                <button type="submit">Найти</button>
            </form>
        </div>

        <ul>
            <#list teams as team>
                <li>${team.name}</li>
                <ul>
                    <#list team.players as player>
                        <li>${player.nickname}</li>
                    <#else>
                        No players yet.
                    </#list>
                </ul>
            <#else>
                No teams yet.
            </#list>
        </ul>

    </div>
</@c.page>