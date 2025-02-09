# found_it_backend# 

Project Setup Guide

## Prerequisites

1. Install **PostgreSQL**

   - Download and install PostgreSQL from [here](https://www.postgresql.org/download/).
   - Ensure `pgAdmin` is installed as well.

2. Open **pgAdmin** and create a database named `foundit`.

3. To create the `users` table, use the following SQL query:

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

4. Install **IntelliJ IDEA Community Edition**

   - Download and install from [here](https://www.jetbrains.com/idea/download/).

5. Install **Oracle Java SDK 23**

   - Download and install from [here](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html).

## Project Setup

1. Clone the repository:

   ```sh
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Create a `.env` file in the project root and add the following parameters:

   ```ini
   SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/foundit
   SPRING_DATASOURCE_USERNAME=<DB User>
   SPRING_DATASOURCE_PASSWORD=<DB Password>

   JWT_SECRET_KEY=<64Bit or 256Bit JWT Secret key - Use a JWT key generator>

   SUPPORT_EMAIL=<Email service email>
   APP_PASSWORD=<16 character long app password>
   ```

## How to Generate an App Password

If your email provider requires an app password:

- For **Google accounts**:
  1. Go to [Google App Passwords](https://myaccount.google.com/apppasswords).
  2. Generate a new 16-character password.
  3. Use this password in the `.env` file under `APP_PASSWORD`.

For this your gmail account must need to have 2 factor authentication on.

Containerization Will be done later

