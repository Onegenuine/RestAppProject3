# Приложение, которое получает данные с сенсора(метеорологического датчика) и сохраняет их в БД для возможного дальнейшего анализа.
Это REST API сервис, где использованны следующие технологии: Spring Framework, Maven, Java 11, PostgreSQL, Postman, GitHub

**Описание:**
Сенсор имеет доступ в интернет, поэтому может отправлять HTTP запросы к нашему серверу
Каждый раз, когда он будет производить измерение, он будет слать HTTP запрос с данными в формате JSON на наш сервер - для этого в реальной жизни 
мы бы указали устройству IP адрес того компьютера, где мы запускаем Spring REST API приложение. 
После этого, на нашем компьютере мы сможем принимать запросы от сенсора.

Все запросы можно проверить в программе Postman 

**Примеры основных запросов:**

**Запрос POST для регистрации сенсора в БД:**
POST /sensors/registration
Jonson:
{
"name": "Sensor name"
}

**Запрос POST для регистрации измерений:**
POST/measurements/add
Jonson:
{
"value": 24.6,
"raining": false,
"sensor": {
            "name": "Sensor name"
       }
}

**Запрос GET который возвращает все измерения:**
GET/measurements

**Запрос GET который возвращает количество дождливых дней из БД:**
GET/measurements/rainyDaysCount