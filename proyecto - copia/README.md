# API meteorologica

***

## Tabla de Contenido

- [Introducción](#Introduccion)
- [Tecnologias](#Tecnologias)
- [EndPointS](#EndPointS)

***

## Introduccion

Esta API obtiene y entrega datos meteorologicos que mediante el consumo de la API externa de OpenWeatherMap para hacer sus solicitudes
de acuerdo a la ciudad que se quiera consultar.

Puede Consultar
- Clima actual de la ciudad
- El pronostico del tiempo de 5 dias de la ciudad
- La contaminacion del aire de la ciudad

***

## Tecnologias

- JDK  8
- Maven
- Spring Boot 

***

## Dependencias del Proyecto

A continuación se detallan las dependencias principales utilizadas en este proyecto:

- Spring Boot Starter Data JPA: Proporciona soporte para la integración de Spring Data JPA en aplicaciones Spring Boot.
- Spring Boot Starter Security: Ofrece herramientas para la configuración de seguridad en aplicaciones Spring Boot. Version 3.2.2
- Spring Security Crypto: Biblioteca para operaciones criptográficas utilizadas en Spring Security.
- Spring Boot Starter Web: Incluye herramientas para el desarrollo de aplicaciones web utilizando Spring Boot.
- Spring Boot DevTools: Herramientas de desarrollo para aumentar la productividad del desarrollador en el ciclo de desarrollo.
- MySQL Connector/J: Conector JDBC para MySQL, necesario para la integración con bases de datos MySQL. Version 8.0.33
- Spring Boot Starter Validation: Proporciona soporte para la validación de datos en aplicaciones Spring Boot.
- Lombok: Biblioteca que agiliza el desarrollo eliminando la necesidad de escribir código repetitivo.
- JUnit y Spring Test: Utilizados para escribir y ejecutar pruebas unitarias y de integración en la aplicación.
- Caffeine: Biblioteca para la gestión de caché en memoria. Version 3.1.4
- JJWT: Librería para la creación y validación de tokens JWT (JSON Web Tokens). Version 0.11.2
- Log4j2: Implementación de logging utilizada en la aplicación.
- Commons Lang: Proporciona clases de utilidad para la manipulación de cadenas, arrays, números, etc. Version 3.9
- Nimbus JOSE JWT: Biblioteca para la manipulación de tokens JWT según la especificación JOSE (JSON Object Signing and Encryption). Version 9.0.1

Además de estas dependencias, se utiliza Swagger para documentar la API del proyecto. Para más detalles sobre la configuración específica de cada dependencia, consulta el archivo pom.xml.

***

## EndPointS

- Registro Usuario

Permite registrar un nuevo usuario en la base de datos.

```
POST /api/register
```

```json
Body:
{
  "nombre": "Nombre del Usuario",
  "nombreUsuario": "Nombre de Usuario",
  "email": "correo@ejemplo.com",
  "password": "contraseña",
  "roles": ["user", "admin"]
}
```
EJEMPLO:

```json
Body:
{
  "nombre": "Juan",
  "nombreUsuario": "Juan1234",
  "email": "correo@ejemplo.com",
  "password": "123",
  "roles": ["ROLE_USER"]
}
```
> Si no se asigna un rol especifico, por defecto se creara con 'ROLE_USER'

RESPUESTA ESPERADA

```json
Code: 201
Response Body:
{
  "mensaje": "Usuario registrado con éxito"
}
```

- Autenticación de Usuario
 
Permite comprobar si el usuario existe en la base de dato. Si la respuesat es correcta devolvera un `token` de autenticacion.

```
POST /api/login
```

```json
Body:
{
  "nombreUsuario": "Nombre de Usuario",
  "password": "contraseña"
}
```

EJEMPLO

```json
{
    "nombreUsuario": "Juan1234",
    "password": "123",
}
```

RESPUESTA ESPERADA

```json
Code 201
Response Body:
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcnVlYmExMjMiLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzA3OTQ0Nzc4LCJleHAiOjE3MDgyMzI3Nzh9.sr0SkEyHaZG-cOkY83-8HYqZsy29FcFuNVM0yKP56nK3JvSsx0vPvULXMag9m3RRoFKvOF0fNyOijoh1geFVeA"
}
```
> El token se actualiza cada vez que se autentica el usuario

- Obtener Clima Actual por ciudad

Permite obtener el clima actual de una ciudad. El nombre de la ciudad se pasara como parametro

```
GET /api/weather?cityName=NombreCiudad
```

EJEMPLO

```
GET /api/weather?cityName=Canada
```

RESPUESTA ESPERADA

```json
Code 200
Response Body:
{"coord":{"lon":-0.8141,"lat":38.6767},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"base":"stations","main":{"temp":281.65,"feels_like":281.65,"temp_min":280.7,"temp_max":285.93,"pressure":1020,"humidity":65,"sea_level":1020,"grnd_level":954},"visibility":10000,"wind":{"speed":0.32,"deg":54,"gust":0.49},"clouds":{"all":100},"dt":1707971751,"sys":{"type":2,"id":2085591,"country":"ES","sunrise":1707980115,"sunset":1708018789},"timezone":3600,"id":6355428,"name":"Cañada","cod":200}
```

- Obtener pronostico del tiempo por ciudad

Permite obtener el pronostico del tiempo de una ciudad a lo largo de 5 dias. El nombre de la ciudad se pasara como parametro

```
GET /api/forecast?cityName=NombreCiudad
```

EJEMPLO

```
GET /api/forecast?cityName=Londres
```

RESPUESTA ESPERADA

```JSON
Code 200
Response Body:
{"cod":"200","message":0,"cnt":40,"list":[{"dt":1707976800,"main":{"temp":285.77,"feels_like":285.57,"temp_min":285.12,"temp_max":285.77,"pressure":1010,"sea_level":1010,"grnd_level":1008,"humidity":95,"temp_kf":0.65},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":3.77,"deg":205,"gust":12.98},"visibility":10000,"pop":0.92,"rain":{"3h":0.32},"sys":{"pod":"n"},"dt_txt":"2024-02-15 06:00:00"},{"dt":1707987600,"main":{"temp":285.58,"feels_like":285.25,"temp_min":285.21,"temp_max":285.58,"pressure":1010,"sea_level":1010,"grnd_level":1008,"humidity":91,"temp_kf":0.37},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":100},"wind":{"speed":3.7,"deg":190,"gust":11.77},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-15 09:00:00"},{"dt":1707998400,"main":{"temp":286.77,"feels_like":286.35,"temp_min":286.77,"temp_max":287.27,"pressure":1010,"sea_level":1010,"grnd_level":1007,"humidity":83,"temp_kf":-0.5},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":3.89,"deg":187,"gust":10.64},"visibility":10000,"pop":0.22,"rain":{"3h":0.24},"sys":{"pod":"d"},"dt_txt":"2024-02-15 12:00:00"},{"dt":1708009200,"main":{"temp":287.42,"feels_like":286.78,"temp_min":287.42,"temp_max":287.42,"pressure":1007,"sea_level":1007,"grnd_level":1004,"humidity":72,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":3.99,"deg":179,"gust":10.28},"visibility":10000,"pop":0.24,"rain":{"3h":0.12},"sys":{"pod":"d"},"dt_txt":"2024-02-15 15:00:00"},{"dt":1708020000,"main":{"temp":285.07,"feels_like":284.43,"temp_min":285.07,"temp_max":285.07,"pressure":1007,"sea_level":1007,"grnd_level":1004,"humidity":81,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":100},"wind":{"speed":3.09,"deg":185,"gust":9.26},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-15 18:00:00"},{"dt":1708030800,"main":{"temp":284.55,"feels_like":284.02,"temp_min":284.55,"temp_max":284.55,"pressure":1007,"sea_level":1007,"grnd_level":1004,"humidity":87,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":99},"wind":{"speed":2.62,"deg":191,"gust":10.39},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-15 21:00:00"},{"dt":1708041600,"main":{"temp":284.58,"feels_like":284.18,"temp_min":284.58,"temp_max":284.58,"pressure":1006,"sea_level":1006,"grnd_level":1003,"humidity":92,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":99},"wind":{"speed":2.41,"deg":204,"gust":9.72},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-16 00:00:00"},{"dt":1708052400,"main":{"temp":284.59,"feels_like":284.22,"temp_min":284.59,"temp_max":284.59,"pressure":1007,"sea_level":1007,"grnd_level":1004,"humidity":93,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":4.32,"deg":258,"gust":9.46},"visibility":10000,"pop":0.39,"rain":{"3h":0.1},"sys":{"pod":"n"},"dt_txt":"2024-02-16 03:00:00"},{"dt":1708063200,"main":{"temp":283.49,"feels_like":282.93,"temp_min":283.49,"temp_max":283.49,"pressure":1011,"sea_level":1011,"grnd_level":1007,"humidity":90,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":4,"deg":259,"gust":10.34},"visibility":10000,"pop":0.65,"rain":{"3h":0.77},"sys":{"pod":"n"},"dt_txt":"2024-02-16 06:00:00"},{"dt":1708074000,"main":{"temp":282.6,"feels_like":280.41,"temp_min":282.6,"temp_max":282.6,"pressure":1015,"sea_level":1015,"grnd_level":1011,"humidity":84,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":51},"wind":{"speed":4.15,"deg":258,"gust":10.4},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-16 09:00:00"},{"dt":1708084800,"main":{"temp":283.7,"feels_like":282.74,"temp_min":283.7,"temp_max":283.7,"pressure":1017,"sea_level":1017,"grnd_level":1014,"humidity":74,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":61},"wind":{"speed":5.23,"deg":265,"gust":9.71},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-16 12:00:00"},{"dt":1708095600,"main":{"temp":285.8,"feels_like":284.92,"temp_min":285.8,"temp_max":285.8,"pressure":1018,"sea_level":1018,"grnd_level":1015,"humidity":69,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":52},"wind":{"speed":5.1,"deg":264,"gust":9.28},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-16 15:00:00"},{"dt":1708106400,"main":{"temp":284.24,"feels_like":283.34,"temp_min":284.24,"temp_max":284.24,"pressure":1021,"sea_level":1021,"grnd_level":1018,"humidity":74,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":47},"wind":{"speed":4.3,"deg":254,"gust":9.24},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-16 18:00:00"},{"dt":1708117200,"main":{"temp":283.35,"feels_like":282.51,"temp_min":283.35,"temp_max":283.35,"pressure":1023,"sea_level":1023,"grnd_level":1020,"humidity":80,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"clouds":{"all":70},"wind":{"speed":3.85,"deg":260,"gust":9.4},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-16 21:00:00"},{"dt":1708128000,"main":{"temp":281.69,"feels_like":279.85,"temp_min":281.69,"temp_max":281.69,"pressure":1025,"sea_level":1025,"grnd_level":1022,"humidity":89,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":37},"wind":{"speed":3.09,"deg":263,"gust":8.63},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-17 00:00:00"},{"dt":1708138800,"main":{"temp":280.83,"feels_like":279.94,"temp_min":280.83,"temp_max":280.83,"pressure":1027,"sea_level":1027,"grnd_level":1023,"humidity":94,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":3},"wind":{"speed":1.69,"deg":253,"gust":4.95},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-17 03:00:00"},{"dt":1708149600,"main":{"temp":281.55,"feels_like":280.88,"temp_min":281.55,"temp_max":281.55,"pressure":1028,"sea_level":1028,"grnd_level":1025,"humidity":94,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":34},"wind":{"speed":1.59,"deg":230,"gust":3.6},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-17 06:00:00"},{"dt":1708160400,"main":{"temp":282.56,"feels_like":281.9,"temp_min":282.56,"temp_max":282.56,"pressure":1029,"sea_level":1029,"grnd_level":1026,"humidity":90,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":64},"wind":{"speed":1.72,"deg":206,"gust":4.25},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-17 09:00:00"},{"dt":1708171200,"main":{"temp":283.92,"feels_like":283.3,"temp_min":283.92,"temp_max":283.92,"pressure":1030,"sea_level":1030,"grnd_level":1027,"humidity":86,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":82},"wind":{"speed":2.24,"deg":198,"gust":7.68},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-17 12:00:00"},{"dt":1708182000,"main":{"temp":286.06,"feels_like":285.47,"temp_min":286.06,"temp_max":286.06,"pressure":1029,"sea_level":1029,"grnd_level":1026,"humidity":79,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":100},"wind":{"speed":4,"deg":218,"gust":10.2},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-17 15:00:00"},{"dt":1708192800,"main":{"temp":284.33,"feels_like":283.38,"temp_min":284.33,"temp_max":284.33,"pressure":1029,"sea_level":1029,"grnd_level":1026,"humidity":72,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":100},"wind":{"speed":4.26,"deg":205,"gust":12.2},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-17 18:00:00"},{"dt":1708203600,"main":{"temp":284.08,"feels_like":283.32,"temp_min":284.08,"temp_max":284.08,"pressure":1028,"sea_level":1028,"grnd_level":1025,"humidity":80,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":5.22,"deg":201,"gust":13.13},"visibility":10000,"pop":0.23,"rain":{"3h":0.16},"sys":{"pod":"n"},"dt_txt":"2024-02-17 21:00:00"},{"dt":1708214400,"main":{"temp":283.62,"feels_like":282.94,"temp_min":283.62,"temp_max":283.62,"pressure":1026,"sea_level":1026,"grnd_level":1022,"humidity":85,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":6.22,"deg":208,"gust":13.99},"visibility":10000,"pop":0.74,"rain":{"3h":0.8},"sys":{"pod":"n"},"dt_txt":"2024-02-18 00:00:00"},{"dt":1708225200,"main":{"temp":282.93,"feels_like":280.42,"temp_min":282.93,"temp_max":282.93,"pressure":1024,"sea_level":1024,"grnd_level":1021,"humidity":92,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":5.11,"deg":213,"gust":11.99},"visibility":7072,"pop":1,"rain":{"3h":3.8},"sys":{"pod":"n"},"dt_txt":"2024-02-18 03:00:00"},{"dt":1708236000,"main":{"temp":282.95,"feels_like":281.28,"temp_min":282.95,"temp_max":282.95,"pressure":1023,"sea_level":1023,"grnd_level":1020,"humidity":96,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":3.25,"deg":206,"gust":8.03},"visibility":8537,"pop":1,"rain":{"3h":5.53},"sys":{"pod":"n"},"dt_txt":"2024-02-18 06:00:00"},{"dt":1708246800,"main":{"temp":283.54,"feels_like":283.19,"temp_min":283.54,"temp_max":283.54,"pressure":1024,"sea_level":1024,"grnd_level":1020,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":2.8,"deg":262,"gust":7.99},"visibility":10000,"pop":1,"rain":{"3h":0.78},"sys":{"pod":"d"},"dt_txt":"2024-02-18 09:00:00"},{"dt":1708257600,"main":{"temp":283.81,"feels_like":283.44,"temp_min":283.81,"temp_max":283.81,"pressure":1025,"sea_level":1025,"grnd_level":1021,"humidity":96,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":2.62,"deg":267,"gust":7.99},"visibility":10000,"pop":1,"rain":{"3h":1.69},"sys":{"pod":"d"},"dt_txt":"2024-02-18 12:00:00"},{"dt":1708268400,"main":{"temp":286.07,"feels_like":285.48,"temp_min":286.07,"temp_max":286.07,"pressure":1025,"sea_level":1025,"grnd_level":1022,"humidity":79,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":86},"wind":{"speed":4.03,"deg":291,"gust":7.24},"visibility":10000,"pop":0.84,"rain":{"3h":0.54},"sys":{"pod":"d"},"dt_txt":"2024-02-18 15:00:00"},{"dt":1708279200,"main":{"temp":283.61,"feels_like":283.01,"temp_min":283.61,"temp_max":283.61,"pressure":1027,"sea_level":1027,"grnd_level":1023,"humidity":88,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"clouds":{"all":57},"wind":{"speed":2.18,"deg":278,"gust":6.16},"visibility":10000,"pop":0.36,"sys":{"pod":"n"},"dt_txt":"2024-02-18 18:00:00"},{"dt":1708290000,"main":{"temp":282.49,"feels_like":281.34,"temp_min":282.49,"temp_max":282.49,"pressure":1028,"sea_level":1028,"grnd_level":1025,"humidity":91,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":2.3,"deg":265,"gust":7.37},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-18 21:00:00"},{"dt":1708300800,"main":{"temp":281.63,"feels_like":280.07,"temp_min":281.63,"temp_max":281.63,"pressure":1029,"sea_level":1029,"grnd_level":1026,"humidity":92,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":3},"wind":{"speed":2.64,"deg":261,"gust":7.84},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-19 00:00:00"},{"dt":1708311600,"main":{"temp":280.98,"feels_like":279.73,"temp_min":280.98,"temp_max":280.98,"pressure":1029,"sea_level":1029,"grnd_level":1025,"humidity":94,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":86},"wind":{"speed":2.1,"deg":236,"gust":5.67},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-19 03:00:00"},{"dt":1708322400,"main":{"temp":280.76,"feels_like":278.47,"temp_min":280.76,"temp_max":280.76,"pressure":1028,"sea_level":1028,"grnd_level":1024,"humidity":92,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":91},"wind":{"speed":3.52,"deg":245,"gust":10.5},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-19 06:00:00"},{"dt":1708333200,"main":{"temp":281.44,"feels_like":279.4,"temp_min":281.44,"temp_max":281.44,"pressure":1027,"sea_level":1027,"grnd_level":1024,"humidity":89,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":100},"wind":{"speed":3.35,"deg":262,"gust":9.64},"visibility":10000,"pop":0,"sys":{"pod":"d"},"dt_txt":"2024-02-19 09:00:00"},{"dt":1708344000,"main":{"temp":282.98,"feels_like":281.48,"temp_min":282.98,"temp_max":282.98,"pressure":1028,"sea_level":1028,"grnd_level":1024,"humidity":81,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":2.97,"deg":291,"gust":7.67},"visibility":10000,"pop":0.2,"rain":{"3h":0.22},"sys":{"pod":"d"},"dt_txt":"2024-02-19 12:00:00"},{"dt":1708354800,"main":{"temp":284.62,"feels_like":283.65,"temp_min":284.62,"temp_max":284.62,"pressure":1027,"sea_level":1027,"grnd_level":1024,"humidity":70,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":86},"wind":{"speed":4.33,"deg":309,"gust":8.71},"visibility":10000,"pop":0.6,"rain":{"3h":0.58},"sys":{"pod":"d"},"dt_txt":"2024-02-19 15:00:00"},{"dt":1708365600,"main":{"temp":282.4,"feels_like":280.19,"temp_min":282.4,"temp_max":282.4,"pressure":1029,"sea_level":1029,"grnd_level":1026,"humidity":75,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":43},"wind":{"speed":4.09,"deg":317,"gust":10.23},"visibility":10000,"pop":0.5,"rain":{"3h":0.12},"sys":{"pod":"n"},"dt_txt":"2024-02-19 18:00:00"},{"dt":1708376400,"main":{"temp":280.68,"feels_like":278.42,"temp_min":280.68,"temp_max":280.68,"pressure":1031,"sea_level":1031,"grnd_level":1028,"humidity":77,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":7},"wind":{"speed":3.45,"deg":311,"gust":9.69},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-19 21:00:00"},{"dt":1708387200,"main":{"temp":279.48,"feels_like":278.07,"temp_min":279.48,"temp_max":279.48,"pressure":1031,"sea_level":1031,"grnd_level":1028,"humidity":83,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02n"}],"clouds":{"all":14},"wind":{"speed":2,"deg":299,"gust":6.66},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-20 00:00:00"},{"dt":1708398000,"main":{"temp":278.82,"feels_like":277.43,"temp_min":278.82,"temp_max":278.82,"pressure":1030,"sea_level":1030,"grnd_level":1027,"humidity":89,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":94},"wind":{"speed":1.87,"deg":251,"gust":4.49},"visibility":10000,"pop":0,"sys":{"pod":"n"},"dt_txt":"2024-02-20 03:00:00"}],"city":{"id":2643743,"name":"London","coord":{"lat":51.5085,"lon":-0.1257},"country":"GB","population":1000000,"timezone":0,"sunrise":1707981352,"sunset":1708017222}}
```

- Obtener contaminacion del aire por ciudad

Permite obtener los datos del aire de una ciudad. El nombre de la ciudad se pasara como parametro

```
GET /api/airpolution?cityName=NombreCiudad
```

EJEMPLO

```
GET /api/airpolution?cityName=Rusia
```

RESPUESTA ESPERADA

```
Code 200
Response Body:
{"coord":{"lon":6.5,"lat":10.9},"list":[{"main":{"aqi":3},"components":{"co":333.79,"no":0,"no2":1.05,"o3":57.94,"so2":0.78,"pm2_5":41.5,"pm10":99.28,"nh3":2.85},"dt":1707944400},{"main":{"aqi":3},"components":{"co":357.15,"no":0,"no2":1.24,"o3":64.37,"so2":0.91,"pm2_5":40.9,"pm10":99.61,"nh3":3.26},"dt":1707948000},{"main":{"aqi":3},"components":{"co":373.84,"no":0,"no2":1.39,"o3":65.8,"so2":0.97,"pm2_5":38.89,"pm10":95.61,"nh3":3.33},"dt":1707951600},{"main":{"aqi":3},"components":{"co":380.52,"no":0,"no2":1.5,"o3":64.37,"so2":0.98,"pm2_5":36.31,"pm10":91.17,"nh3":3.23},"dt":1707955200},{"main":{"aqi":3},"components":{"co":380.52,"no":0,"no2":1.52,"o3":62.23,"so2":0.95,"pm2_5":33.24,"pm10":87.63,"nh3":3.1},"dt":1707958800},{"main":{"aqi":3},"components":{"co":373.84,"no":0,"no2":1.52,"o3":60.8,"so2":0.89,"pm2_5":30.34,"pm10":84.78,"nh3":2.98},"dt":1707962400},{"main":{"aqi":3},"components":{"co":353.81,"no":0,"no2":1.44,"o3":59.37,"so2":0.8,"pm2_5":27.77,"pm10":85,"nh3":2.88},"dt":1707966000},{"main":{"aqi":4},"components":{"co":333.79,"no":0,"no2":1.27,"o3":58.65,"so2":0.69,"pm2_5":28.14,"pm10":100.16,"nh3":2.76},"dt":1707969600},{"main":{"aqi":4},"components":{"co":310.42,"no":0,"no2":1.11,"o3":57.22,"so2":0.6,"pm2_5":33.98,"pm10":145.47,"nh3":2.6},"dt":1707973200},{"main":{"aqi":5},"components":{"co":300.41,"no":0,"no2":1.03,"o3":55.79,"so2":0.54,"pm2_5":47.66,"pm10":242.68,"nh3":2.53},"dt":1707976800},{"main":{"aqi":5},"components":{"co":293.73,"no":0.02,"no2":0.98,"o3":52.21,"so2":0.51,"pm2_5":70.24,"pm10":393.82,"nh3":2.53},"dt":1707980400},{"main":{"aqi":5},"components":{"co":297.07,"no":0.09,"no2":0.75,"o3":50.78,"so2":0.51,"pm2_5":94.83,"pm10":549,"nh3":2.5},"dt":1707984000},{"main":{"aqi":5},"components":{"co":303.75,"no":0.1,"no2":0.55,"o3":52.93,"so2":0.52,"pm2_5":114.19,"pm10":654.12,"nh3":2.34},"dt":1707987600},{"main":{"aqi":5},"components":{"co":287.06,"no":0.07,"no2":0.4,"o3":62.23,"so2":0.5,"pm2_5":130.58,"pm10":744.85,"nh3":2.09},"dt":1707991200},{"main":{"aqi":5},"components":{"co":283.72,"no":0.07,"no2":0.37,"o3":70.81,"so2":0.49,"pm2_5":131.91,"pm10":723.76,"nh3":1.95},"dt":1707994800},{"main":{"aqi":5},"components":{"co":283.72,"no":0.06,"no2":0.38,"o3":78.68,"so2":0.48,"pm2_5":127.6,"pm10":674.84,"nh3":1.82},"dt":1707998400},{"main":{"aqi":5},"components":{"co":263.69,"no":0.05,"no2":0.31,"o3":82.97,"so2":0.37,"pm2_5":102.11,"pm10":518.46,"nh3":1.43},"dt":1708002000},{"main":{"aqi":5},"components":{"co":247,"no":0.04,"no2":0.25,"o3":82.97,"so2":0.28,"pm2_5":72.54,"pm10":357.9,"nh3":1.08},"dt":1708005600},{"main":{"aqi":5},"components":{"co":240.33,"no":0.04,"no2":0.25,"o3":81.54,"so2":0.25,"pm2_5":59.51,"pm10":288.8,"nh3":0.99},"dt":1708009200},{"main":{"aqi":5},"components":{"co":250.34,"no":0.03,"no2":0.31,"o3":78.68,"so2":0.28,"pm2_5":61.5,"pm10":289.23,"nh3":1.11},"dt":1708012800},{"main":{"aqi":5},"components":{"co":270.37,"no":0.02,"no2":0.45,"o3":74.39,"so2":0.39,"pm2_5":75.76,"pm10":335.97,"nh3":1.44},"dt":1708016400},{"main":{"aqi":5},"components":{"co":297.07,"no":0,"no2":0.64,"o3":72.24,"so2":0.54,"pm2_5":91.72,"pm10":375.27,"nh3":1.9},"dt":1708020000},{"main":{"aqi":5},"components":{"co":320.44,"no":0,"no2":0.83,"o3":72.96,"so2":0.7,"pm2_5":100.77,"pm10":377.69,"nh3":2.41},"dt":1708023600},{"main":{"aqi":5},"components":{"co":333.79,"no":0,"no2":0.96,"o3":72.96,"so2":0.82,"pm2_5":100.78,"pm10":348.6,"nh3":2.85},"dt":1708027200},{"main":{"aqi":5},"components":{"co":350.48,"no":0,"no2":1.11,"o3":74.39,"so2":0.91,"pm2_5":97.38,"pm10":327.04,"nh3":3.23},"dt":1708030800},{"main":{"aqi":5},"components":{"co":353.81,"no":0,"no2":1.24,"o3":77.25,"so2":0.92,"pm2_5":94.93,"pm10":328.33,"nh3":3.42},"dt":1708034400},{"main":{"aqi":5},"components":{"co":357.15,"no":0,"no2":1.33,"o3":74.39,"so2":0.92,"pm2_5":93.59,"pm10":326.71,"nh3":3.36},"dt":1708038000},{"main":{"aqi":5},"components":{"co":367.17,"no":0,"no2":1.39,"o3":70.1,"so2":0.94,"pm2_5":92.71,"pm10":323.81,"nh3":3.33},"dt":1708041600},{"main":{"aqi":5},"components":{"co":377.18,"no":0,"no2":1.48,"o3":65.8,"so2":0.98,"pm2_5":92.64,"pm10":320.09,"nh3":3.39},"dt":1708045200},{"main":{"aqi":5},"components":{"co":383.85,"no":0,"no2":1.5,"o3":63.66,"so2":1.03,"pm2_5":92.4,"pm10":319.88,"nh3":3.42},"dt":1708048800},{"main":{"aqi":5},"components":{"co":380.52,"no":0,"no2":1.48,"o3":62.94,"so2":1.03,"pm2_5":91.71,"pm10":322.86,"nh3":3.36},"dt":1708052400},{"main":{"aqi":5},"components":{"co":373.84,"no":0,"no2":1.41,"o3":63.66,"so2":1.01,"pm2_5":92.34,"pm10":347.58,"nh3":3.33},"dt":1708056000},{"main":{"aqi":5},"components":{"co":380.52,"no":0,"no2":1.41,"o3":63.66,"so2":1.06,"pm2_5":99.57,"pm10":399.73,"nh3":3.45},"dt":1708059600},{"main":{"aqi":5},"components":{"co":393.87,"no":0,"no2":1.5,"o3":63.66,"so2":1.16,"pm2_5":113.24,"pm10":480.77,"nh3":3.67},"dt":1708063200},{"main":{"aqi":5},"components":{"co":417.23,"no":0.02,"no2":1.71,"o3":63.66,"so2":1.36,"pm2_5":129.45,"pm10":568.23,"nh3":3.86},"dt":1708066800},{"main":{"aqi":5},"components":{"co":427.25,"no":0.11,"no2":1.44,"o3":64.37,"so2":1.48,"pm2_5":143.71,"pm10":642.68,"nh3":3.9},"dt":1708070400},{"main":{"aqi":5},"components":{"co":433.92,"no":0.11,"no2":0.92,"o3":68.67,"so2":1.49,"pm2_5":153.52,"pm10":682.94,"nh3":3.77},"dt":1708074000},{"main":{"aqi":5},"components":{"co":400.54,"no":0.09,"no2":0.63,"o3":74.39,"so2":1.24,"pm2_5":161.6,"pm10":727.8,"nh3":3.17},"dt":1708077600},{"main":{"aqi":5},"components":{"co":363.83,"no":0.09,"no2":0.59,"o3":81.54,"so2":1.01,"pm2_5":167.71,"pm10":763.6,"nh3":2.85},"dt":1708081200},{"main":{"aqi":5},"components":{"co":350.48,"no":0.09,"no2":0.64,"o3":88.69,"so2":0.92,"pm2_5":172.97,"pm10":784.09,"nh3":2.79},"dt":1708084800},{"main":{"aqi":5},"components":{"co":307.08,"no":0.07,"no2":0.49,"o3":90.84,"so2":0.63,"pm2_5":142.21,"pm10":632.03,"nh3":2},"dt":1708088400},{"main":{"aqi":5},"components":{"co":280.38,"no":0.05,"no2":0.38,"o3":88.69,"so2":0.45,"pm2_5":117.42,"pm10":512.6,"nh3":1.49},"dt":1708092000},{"main":{"aqi":5},"components":{"co":270.37,"no":0.04,"no2":0.35,"o3":87.26,"so2":0.39,"pm2_5":107.68,"pm10":465.21,"nh3":1.36},"dt":1708095600},{"main":{"aqi":5},"components":{"co":273.71,"no":0.03,"no2":0.39,"o3":72.96,"so2":0.37,"pm2_5":104.59,"pm10":432.63,"nh3":1.35},"dt":1708099200},{"main":{"aqi":5},"components":{"co":287.06,"no":0.02,"no2":0.48,"o3":57.94,"so2":0.4,"pm2_5":106.91,"pm10":417.25,"nh3":1.5},"dt":1708102800},{"main":{"aqi":5},"components":{"co":310.42,"no":0,"no2":0.69,"o3":52.21,"so2":0.48,"pm2_5":114.95,"pm10":426.59,"nh3":1.85},"dt":1708106400},{"main":{"aqi":5},"components":{"co":340.46,"no":0,"no2":0.95,"o3":54.36,"so2":0.64,"pm2_5":135.26,"pm10":467.11,"nh3":2.34},"dt":1708110000},{"main":{"aqi":5},"components":{"co":383.85,"no":0,"no2":1.18,"o3":57.22,"so2":0.89,"pm2_5":157.65,"pm10":501.62,"nh3":2.82},"dt":1708113600},{"main":{"aqi":5},"components":{"co":427.25,"no":0,"no2":1.39,"o3":62.94,"so2":1.27,"pm2_5":176.3,"pm10":546.45,"nh3":3.55},"dt":1708117200},{"main":{"aqi":5},"components":{"co":460.63,"no":0,"no2":1.65,"o3":77.96,"so2":1.76,"pm2_5":203.05,"pm10":711.05,"nh3":4.94},"dt":1708120800},{"main":{"aqi":5},"components":{"co":473.98,"no":0,"no2":1.69,"o3":80.82,"so2":1.94,"pm2_5":221.19,"pm10":803.14,"nh3":5.32},"dt":1708124400},{"main":{"aqi":5},"components":{"co":460.63,"no":0,"no2":1.56,"o3":77.96,"so2":1.82,"pm2_5":228.01,"pm10":846.4,"nh3":5},"dt":1708128000},{"main":{"aqi":5},"components":{"co":440.6,"no":0,"no2":1.48,"o3":72.96,"so2":1.68,"pm2_5":232.04,"pm10":887.27,"nh3":4.56},"dt":1708131600},{"main":{"aqi":5},"components":{"co":447.27,"no":0,"no2":1.61,"o3":68.67,"so2":1.79,"pm2_5":233.47,"pm10":911.57,"nh3":4.56},"dt":1708135200},{"main":{"aqi":5},"components":{"co":480.65,"no":0,"no2":1.97,"o3":63.66,"so2":2.03,"pm2_5":230.97,"pm10":880.55,"nh3":4.88},"dt":1708138800},{"main":{"aqi":5},"components":{"co":527.38,"no":0,"no2":2.4,"o3":59.37,"so2":2.21,"pm2_5":215.75,"pm10":769.86,"nh3":5.26},"dt":1708142400},{"main":{"aqi":5},"components":{"co":574.11,"no":0,"no2":2.74,"o3":56.51,"so2":2.21,"pm2_5":195.86,"pm10":627.62,"nh3":5.38},"dt":1708146000},{"main":{"aqi":5},"components":{"co":594.14,"no":0,"no2":2.83,"o3":55.79,"so2":2.03,"pm2_5":172.46,"pm10":499.9,"nh3":5.26},"dt":1708149600},{"main":{"aqi":5},"components":{"co":554.09,"no":0.02,"no2":2.51,"o3":56.51,"so2":1.64,"pm2_5":143.54,"pm10":386.23,"nh3":4.62},"dt":1708153200},{"main":{"aqi":5},"components":{"co":480.65,"no":0.12,"no2":1.65,"o3":60.08,"so2":1.22,"pm2_5":115.65,"pm10":299.32,"nh3":3.9},"dt":1708156800},{"main":{"aqi":5},"components":{"co":427.25,"no":0.12,"no2":0.92,"o3":65.09,"so2":0.95,"pm2_5":96.51,"pm10":245.67,"nh3":3.36},"dt":1708160400},{"main":{"aqi":5},"components":{"co":373.84,"no":0.09,"no2":0.58,"o3":72.96,"so2":0.71,"pm2_5":81.16,"pm10":224.91,"nh3":2.66},"dt":1708164000},{"main":{"aqi":5},"components":{"co":333.79,"no":0.08,"no2":0.52,"o3":81.54,"so2":0.63,"pm2_5":75.23,"pm10":238.85,"nh3":2.34},"dt":1708167600},{"main":{"aqi":5},"components":{"co":327.11,"no":0.08,"no2":0.53,"o3":87.98,"so2":0.65,"pm2_5":77.7,"pm10":267.3,"nh3":2.34},"dt":1708171200},{"main":{"aqi":5},"components":{"co":303.75,"no":0.06,"no2":0.39,"o3":88.69,"so2":0.54,"pm2_5":83.24,"pm10":308.88,"nh3":1.85},"dt":1708174800},{"main":{"aqi":5},"components":{"co":290.39,"no":0.04,"no2":0.31,"o3":85.83,"so2":0.46,"pm2_5":84.19,"pm10":314.81,"nh3":1.57},"dt":1708178400},{"main":{"aqi":5},"components":{"co":287.06,"no":0.03,"no2":0.28,"o3":83.69,"so2":0.43,"pm2_5":84.17,"pm10":312.8,"nh3":1.47},"dt":1708182000},{"main":{"aqi":5},"components":{"co":290.39,"no":0.03,"no2":0.34,"o3":80.82,"so2":0.46,"pm2_5":84.89,"pm10":306.54,"nh3":1.92},"dt":1708185600},{"main":{"aqi":5},"components":{"co":307.08,"no":0.01,"no2":0.43,"o3":77.96,"so2":0.57,"pm2_5":86.25,"pm10":295.79,"nh3":2.82},"dt":1708189200},{"main":{"aqi":5},"components":{"co":327.11,"no":0,"no2":0.59,"o3":74.39,"so2":0.69,"pm2_5":87.74,"pm10":289.01,"nh3":3.83},"dt":1708192800},{"main":{"aqi":5},"components":{"co":347.14,"no":0,"no2":0.79,"o3":66.52,"so2":0.81,"pm2_5":90.09,"pm10":287.05,"nh3":4.69},"dt":1708196400},{"main":{"aqi":5},"components":{"co":360.49,"no":0,"no2":0.96,"o3":50.78,"so2":0.84,"pm2_5":92.08,"pm10":286.42,"nh3":4.94},"dt":1708200000},{"main":{"aqi":5},"components":{"co":367.17,"no":0,"no2":1.09,"o3":36.12,"so2":0.8,"pm2_5":95.28,"pm10":286.25,"nh3":4.43},"dt":1708203600},{"main":{"aqi":5},"components":{"co":373.84,"no":0,"no2":1.18,"o3":49.35,"so2":0.89,"pm2_5":129.74,"pm10":432.07,"nh3":3.42},"dt":1708207200},{"main":{"aqi":5},"components":{"co":413.9,"no":0,"no2":1.35,"o3":67.23,"so2":1.3,"pm2_5":166.82,"pm10":543.72,"nh3":3.86},"dt":1708210800},{"main":{"aqi":5},"components":{"co":440.6,"no":0,"no2":1.31,"o3":75.82,"so2":1.61,"pm2_5":183.87,"pm10":586.41,"nh3":4.24},"dt":1708214400},{"main":{"aqi":5},"components":{"co":447.27,"no":0,"no2":1.22,"o3":75.82,"so2":1.71,"pm2_5":190.34,"pm10":592.48,"nh3":4.24},"dt":1708218000},{"main":{"aqi":5},"components":{"co":433.92,"no":0,"no2":1.19,"o3":72.96,"so2":1.64,"pm2_5":190.73,"pm10":585.19,"nh3":3.93},"dt":1708221600},{"main":{"aqi":5},"components":{"co":423.91,"no":0,"no2":1.21,"o3":70.1,"so2":1.59,"pm2_5":191.47,"pm10":585.88,"nh3":3.67},"dt":1708225200},{"main":{"aqi":5},"components":{"co":423.91,"no":0,"no2":1.32,"o3":70.1,"so2":1.73,"pm2_5":194.71,"pm10":608.05,"nh3":3.77},"dt":1708228800},{"main":{"aqi":5},"components":{"co":440.6,"no":0,"no2":1.46,"o3":70.81,"so2":1.94,"pm2_5":189.02,"pm10":587.75,"nh3":4.02},"dt":1708232400},{"main":{"aqi":5},"components":{"co":453.95,"no":0,"no2":1.59,"o3":69.38,"so2":1.91,"pm2_5":166.52,"pm10":494.41,"nh3":4.05},"dt":1708236000},{"main":{"aqi":5},"components":{"co":473.98,"no":0.01,"no2":1.69,"o3":65.8,"so2":1.67,"pm2_5":139.4,"pm10":385.04,"nh3":3.77},"dt":1708239600},{"main":{"aqi":5},"components":{"co":487.33,"no":0.09,"no2":1.35,"o3":63.66,"so2":1.45,"pm2_5":119.64,"pm10":318.8,"nh3":3.39},"dt":1708243200},{"main":{"aqi":5},"components":{"co":487.33,"no":0.11,"no2":0.92,"o3":66.52,"so2":1.3,"pm2_5":108.69,"pm10":282.32,"nh3":3.17},"dt":1708246800},{"main":{"aqi":5},"components":{"co":473.98,"no":0.1,"no2":0.74,"o3":70.1,"so2":1.16,"pm2_5":102.47,"pm10":263.54,"nh3":3.01},"dt":1708250400},{"main":{"aqi":5},"components":{"co":433.92,"no":0.09,"no2":0.61,"o3":75.1,"so2":0.97,"pm2_5":94.51,"pm10":254.93,"nh3":2.66},"dt":1708254000},{"main":{"aqi":5},"components":{"co":387.19,"no":0.08,"no2":0.52,"o3":80.11,"so2":0.8,"pm2_5":89.2,"pm10":257.87,"nh3":2.31},"dt":1708257600},{"main":{"aqi":5},"components":{"co":327.11,"no":0.05,"no2":0.34,"o3":82.25,"so2":0.54,"pm2_5":86.77,"pm10":273.8,"nh3":1.68},"dt":1708261200},{"main":{"aqi":5},"components":{"co":307.08,"no":0.04,"no2":0.25,"o3":78.68,"so2":0.43,"pm2_5":84.07,"pm10":266.72,"nh3":1.44},"dt":1708264800},{"main":{"aqi":5},"components":{"co":303.75,"no":0.03,"no2":0.22,"o3":75.82,"so2":0.4,"pm2_5":83.15,"pm10":260.09,"nh3":1.38},"dt":1708268400},{"main":{"aqi":5},"components":{"co":307.08,"no":0.02,"no2":0.24,"o3":61.51,"so2":0.38,"pm2_5":83.26,"pm10":253.18,"nh3":1.43},"dt":1708272000},{"main":{"aqi":5},"components":{"co":317.1,"no":0.01,"no2":0.31,"o3":44.35,"so2":0.39,"pm2_5":84.4,"pm10":243.95,"nh3":1.57},"dt":1708275600},{"main":{"aqi":5},"components":{"co":327.11,"no":0,"no2":0.44,"o3":32.9,"so2":0.45,"pm2_5":85.7,"pm10":236.98,"nh3":1.85},"dt":1708279200},{"main":{"aqi":5},"components":{"co":343.8,"no":0,"no2":0.62,"o3":26.11,"so2":0.53,"pm2_5":86.61,"pm10":229.73,"nh3":2.19},"dt":1708282800},{"main":{"aqi":5},"components":{"co":357.15,"no":0,"no2":0.78,"o3":20.56,"so2":0.59,"pm2_5":85.67,"pm10":214.63,"nh3":2.31},"dt":1708286400}]}
```
