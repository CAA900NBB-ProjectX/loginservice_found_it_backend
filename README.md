# Login Service

# Setup Guide

## Install PostgreSQL
1. Download and install PostgreSQL from [official website](https://www.postgresql.org/download/).
2. Open pgAdmin and create a database named **foundit**.

## Create Users Table
Run the following SQL command to create the `users` table:

```sql
CREATE TABLE users(  
    id int NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    verification_code VARCHAR(100),
    verification_code_expiry TIMESTAMP
);
```

## Install IntelliJ IDEA Community Edition
Download and install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).

## Install Oracle Java SDK 23
Download and install Oracle Java SDK 23 from [Oracle's official website](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html).

## Checkout the Code
Clone the repository using Git:
```sh
git clone <repository-url>
cd <repository-folder>
```

## Configure Environment Variables
Create a `.env` file in the project root and add the following parameters:
```sh
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/foundit
SPRING_DATASOURCE_USERNAME=<DB User>
SPRING_DATASOURCE_PASSWORD=<DB Password>

JWT_SECRET_KEY=<64Bit or 256 bit JWT Secret key - Use a JWT key generator>

SUPPORT_EMAIL=<Email service email>
APP_PASSWORD=<16 character long app password - see instructions below>
```

## Generate App Password
If you are using Gmail, follow these steps to generate a 16-character app password:
1. Go to [Google Account Security](https://myaccount.google.com/security).
2. Enable 2-Step Verification if not already enabled.
3. Click on **App passwords** under the "Signing in to Google" section.
4. Generate a new password and copy it to use in `APP_PASSWORD`.

## Install Postman
Download and install [Postman](https://www.postman.com/downloads/).

### Learn How to Setup Requests in Postman
Watch a tutorial video on how to create and test API requests in Postman: [Postman Tutorial](https://www.youtube.com/watch?v=VywxIQ2ZXw4).

Containerization Will be done later

