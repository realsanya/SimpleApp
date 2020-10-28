<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Авторизация">
    <div class="container" style="padding-top: 50px">
        <form class="form-signin" method="post" action="/login">
            <div class="row">
                <div class="card offset-3 col-md-6" style="border-radius: 20px">
                    <div class="card-body text-center">
                        <div>
                            <label for="inputEmail"></label>
                            <input type="email" id="inputEmail" class="form-control"
                                   placeholder="Почта" required name="email">
                        </div>
                        <div>
                            <label for="inputPassword"></label>
                            <input type="password" id="inputPassword" class="form-control"
                                   placeholder="Пароль" required name="password">
                        </div>

                        <div style="padding-top: 10px">
                            <div class="auth-checkbox">
                                <div class="checkbox mb-3">
                                    <label class="checkbox_text">
                                        <input type="checkbox" value="remember-me" name="remember"> запомнить меня
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="padding-top: 30px">
                <button class="offset-4 col-md-4 btn" type="submit">Войти</button>
            </div>
        </form>
    </div>
</@base.main>