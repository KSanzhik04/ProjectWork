<!DOCTYPE html>
<html lang="en">
<?php
  $website_title= "Регистрация"; 
  require "blocks/head.php"
   ?>
<body>
  <?php require "blocks/header.php" ?>
  <main>
    <h1>Регистрация</h1>
    <form>
        <label for="username">Ваше имя</label>
        <input type="text" name="username" id="username">

        <label for="email">Email</label>
        <input type="email" name="email" id="email">

        <label for="login">Логин</label>
        <input type="text" name="login" id="login">

        <label for="password">Пароль</label>
        <input type="password" name="password" id="password">

        <div class="error-mess" id="error-block"></div>

        <button type="button" id="reg_user">Зарегистрироваться</button>

    </form>
  </main>
  <?php require "blocks/aside.php" ?>
  <?php require "blocks/footer.php" ?>
  <script>
    $('#reg_user').click(function(){
        let name = $('#username').val();
        let email = $('#email').val();
        let login = $('#login').val();
        let pass = $('#password').val();

        $.ajax({
            url:'/php/ajax/reg.php',
            type: 'POST',
            cache:false,
            data:{'username': name, 'email': email, 'login': login, 'password':pass},
            dataType: 'html',
            success:function(data) {
                if(data === "Done"){
                    $("#reg_user").text("Все готово");
                    $("#error-block").hide();
                } else {
                    $("#error-block").show();
                    $("#error-block").text(data);
                }
            }
        });
    });
  </script>
</body>

</html>