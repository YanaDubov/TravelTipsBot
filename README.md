# TravelTipsBot
Telegram Bot with tips for travelers

Before starting run `src/main/resources/database.sql` in your Postres database. 
Set/Change username, password and url( if requires) in `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/travel
spring.datasource.username=
spring.datasource.password=
```

Telegram token for this bot:
```
   bot.name=@travel_tips_123_bot
   bot.token=1677843639:AAGUdgnbiVY9USH7drhIyJ2792r3OuvPDKk
```
 - `POST http://localhost:8080/city/info` - create new city with description
 - `PUT http://localhost:8080/city/info` - update city information
 - `DELETE http://localhost:8080/city/info/${cityName}` - delete city information
 - `GET http://localhost:8080/city/info/${cityName}` - get city information

For POST and PUT endpoints we should use `Content-Type: application/json` header and the following body:
```
{
    "name": "city_name",
    "description": "description"
}
```
