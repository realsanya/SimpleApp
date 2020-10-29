<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Профиль">
    <#if user??>
        <div class="container" style="padding-top: 50px">
            <div class="container mt-5 pb-5">
                <h1 class="text-uppercase text-center font-weight-bold">HELLO! </h1>
            </div>
        </div>
    </#if>
</@base.main>