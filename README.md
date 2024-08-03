# H2O Shop
Для запуска требуется
* gradle 8.7
* docker

Копируем проект

### `git clone https://github.com/dezzmol/h2o-shop.git`

Собираем проект:

### `./gradlew build`

Запускаем docker-compose

### `docker-compose up -d`

Swagger доступен по ссылке <http://localhost:8080/swagger-ui/index.html>
<br> H2 консоль доступна по ссылке <http://localhost:8080/h2-console>
<br> Логин и пароль для БД задаются в docker-compose.yml
