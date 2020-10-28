<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Главная">
    <div class="container" style="padding-top: 50px">
        <div class="container mt-5 pb-5">
            <h1 class="text-uppercase text-center font-weight-bold">JAVALAB</h1>
        </div>
        <div class="container" style="padding-top: 40px">
            <div class="row">
                <div class="offset-1 col-md-5 center">
                    <button class="btn" onclick="window.location='/login'">Вход</button>
                </div>
                <div class="col-md-6 center">
                    <button class="btn" onclick="window.location='/register'">Регистрация</button>
                </div>
            </div>
        </div>
    </div>
</@base.main>