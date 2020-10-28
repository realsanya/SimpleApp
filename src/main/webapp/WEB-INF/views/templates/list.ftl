<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Список">
    <#if users??>
        <#list users as user>
            <div style="padding-top: 30px; padding-left: 30px">
                <h4>${user.getFirstName()} ${user.getLastName()} ${user.getAge()}</h4>
            </div>
        </#list>
    <#else>
        <h1>Пусто :(</h1>
    </#if>
</@base.main>