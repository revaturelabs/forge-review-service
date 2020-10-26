# Forge Review Service

This service is used to view and give feedback on portfolios that have been submitted.
Admin Review team utilized Swagger to visually render our documentation and for future sprints to interact with accordingly. 

## Swagger Homepage

[Swagger](http://localhost:8200/swagger-ui.html#/)

![image](https://user-images.githubusercontent.com/63929368/97196108-76b9af80-1782-11eb-8913-483f5a1f4de0.png)

The different methods we used to communicate with the backend and populate the frontend.
![image](https://user-images.githubusercontent.com/63929368/97195628-f2ffc300-1781-11eb-9860-28d4a9d13e4a.png)

## Email

Leveraged mailtrap.io to simulate a fake SMTP to test emails sent from the development phrase without spamming real people's emails.
Configurations are in the application.properties file under resources. If you are going to use mailtrap also, I suggest changing port, username, and password.
```email configurations
spring.mail.protocol=smtp
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=9195adabe8cd38
spring.mail.password=938b45b0385774
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Testing

- JUnit 5
- Mockito
