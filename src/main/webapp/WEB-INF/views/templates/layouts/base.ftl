<#ftl encoding="UTF-8"/>
<#macro main title css=[] scripts=[]>
    <!DOCTYPE html>
    <html lang="ru" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
        <#list css as style>
            <link rel="stylesheet" type="text/css" href="/static/css/${style}">
        </#list>
    </head>
    <body class="masthead">
    <#include "header.ftl">
    <#nested>
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script src="/static/js/bootstrap.bundle.js"></script>
    <#list scripts as script>
        <script src="/views/js/${script}"></script>
    </#list>
    </body>
    </html>
</#macro>