<header>
    <span class="logo">Blog Master</span>
    <nav>
      <a href="/php/">Главная</a>
      <a href="/php/contacts.php">Контакты</a>
      <?php if(isset($_COOKIE['log'])): ?>
        <a href="/php/add-article.php">Добавить статью</a>
        <a href="/php/login.php" class="btn">Кабинет пользователя</a>
      <?php else: ?>
        <a href="/php/login.php" class="btn">Войти</a>
        <a href="/php/register.php" class="btn">Регистрация</a>
      <?php endif; ?>
    </nav>
</header>