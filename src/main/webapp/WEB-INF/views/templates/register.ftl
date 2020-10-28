<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Регистрация">
    <div class="container" style="padding-top: 50px">
        <form class="form-signin" method="post" action="/register">
            <div class="row">
                <div class="card offset-3 col-md-6" style="border-radius: 20px">
                    <div class="card-body text-center">

                        <div>
                            <label for="inputFirstName"></label>
                            <input type="text" name="inputFirstName" class="form-control"
                                   placeholder="Имя" required>
                        </div>

                        <div>
                            <label for="inputLastName"></label>
                            <input type="text" name="inputLastName" class="form-control"
                                   placeholder="Фамилия" required>
                        </div>

                        <div>
                            <label for="inputAge"></label>
                            <input type="number" name="inputAge" class="form-control"
                                   placeholder="Возраст" required>
                        </div>

                        <div>
                            <label for="inputEmail"></label>
                            <input type="email" name="inputEmail" class="form-control register-cont_input"
                                   placeholder="Почта" required>
                        </div>
                        <div>
                            <label for="inputPassword"></label>
                            <input type="password" name="inputPassword" class="form-control register-cont_input"
                                   placeholder="Пароль" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="padding-top: 30px">
                <button class="offset-4 col-md-4 btn" type="submit">Зарегистрироваться</button>
            </div>
        </form>
    </div>
</@base.main>