

# User Authentication with OTP Verification

A Spring Boot backend project for user authentication using mobile number and OTP verification. It supports:

- User registration with email, password, and mobile number
- OTP generation and verification
- Secure password hashing using BCrypt
- PostgreSQL for user and OTP storage
- Spring Security configuration
- JSON-based API responses

---

## 🔧 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven

---

## 📂 Project Structure

```
src/
└── main/
├── JAVA/
    ├── controllers/ │
        └── AuthController.java │
    ├── services/ │
        └── AuthService.java │
    ├── dto/ │
        ├── UserDTO.java │
        └── OtpDTO.java │
    ├── model/ │
        ├── User.java │
        └── Otp.java │
    └── repository/
        └── UserRepository.java
```

