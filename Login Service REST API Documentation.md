# Authentication and User Controller Endpoints

## Overview
The `AuthenticationController` handles user registration, login, verification, and messaging via RabbitMQ, while `UserController` manages user-related data retrieval.

---

# AuthenticationController

## 1. User Registration

**Endpoint:** `POST /auth/signup`

**Description:**
Registers a new user.

**Request Body:**
```json
{
  "username": "string",
  "email": "string",
  "password": "string"
}
```

**Response:**
- `200 OK`: Returns the registered user.
- `400 BAD REQUEST`: If registration fails.

---

## 2. User Login

**Endpoint:** `POST /auth/login`

**Description:**
Authenticates a user and returns a JWT token.

**Request Body:**
```json
{
  "email": "string",
  "password": "string"
}
```

**Response:**
- `200 OK`: Returns JWT token.
- `400 BAD REQUEST`: If authentication fails.

---

## 3. Verify User

**Endpoint:** `POST /auth/verify`

**Description:**
Verifies a user using OTP.

**Request Body:**
```json
{
  "email": "string",
  "otp": "string"
}
```

**Response:**
- `200 OK`: Account verified.
- `400 BAD REQUEST`: If verification fails.

---

## 4. Resend Verification Code

**Endpoint:** `POST /auth/resend`

**Description:**
Resends the OTP to the user's email.

**Request Body:**
```json
{
  "email": "string"
}
```

**Response:**
- `200 OK`: Code resent.
- `400 BAD REQUEST`: If resending fails.

---

## 5. RabbitMQ Message Producer

**Endpoint:** `POST /auth/send`

**Description:**
Sends a message to RabbitMQ.

**Query Parameter:**
- `message` (string): The message to send.

**Response:**
- `200 OK`: Message sent.

---

# UserController

## 1. Get Authenticated User

**Endpoint:** `GET /user/me`

**Description:**
Returns the currently authenticated user.

**Response:**
- `200 OK`: Returns user details.

---

## 2. Get All Users

**Endpoint:** `GET /user/`

**Description:**
Returns a list of all users.

**Response:**
- `200 OK`: Returns user list.

---

## Error Handling
- `400 BAD REQUEST`: For bad input or failed operations.
- `500 INTERNAL SERVER ERROR`: Returned for unexpected server errors.

---



