# ReelInsight

A full-stack web application for AI-powered movie summaries, featuring a modern React frontend and a secure Spring Boot backend.

---

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Frontend Setup](#frontend-setup)
  - [Backend Setup](#backend-setup)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

**ReelInsight** provides users with AI-generated movie summaries, a cinematic and responsive UI, and secure authentication. The project is split into two main parts:
- **Frontend**: A React application for user interaction and presentation.
- **Backend**: A Spring Boot REST API for authentication, user management, and business logic.

---

## Features

### Frontend
- Responsive, cinematic UI with dark theme and animations
- User authentication (login/signup)
- Premium content for subscribed users
- User dashboard and profile management
- Pricing and subscription pages

### Backend
- RESTful API for authentication and user management
- JWT-based authentication and authorization
- Secure password hashing (BCrypt)
- MySQL database integration (JPA/Hibernate)
- CORS support for local development

---

## Tech Stack

- **Frontend:**
  - React 18
  - React Router DOM
  - Tailwind CSS & custom CSS
  - Local Storage

- **Backend:**
  - Java 17
  - Spring Boot 3
  - Spring Security (JWT)
  - Spring Data JPA (Hibernate)
  - MySQL
  - Lombok

---

## Project Structure

```
reelinsight/
├── frontend/                # React frontend
│   └── ...
└── reelinsight-backend/     # Spring Boot backend
    └── ...
```

---

## Getting Started

### Prerequisites
- Node.js & npm (for frontend)
- Java 17+ and Maven (for backend)
- MySQL (running locally, or update connection settings)

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```
4. Open [http://localhost:5173](http://localhost:5173) in your browser.

### Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd reelinsight-backend/reelinsight-backend
   ```
2. Configure your MySQL database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reelinsight
   spring.datasource.username=YOUR_DB_USER
   spring.datasource.password=YOUR_DB_PASSWORD
   ```
3. Build and run the backend:
   ```bash
   ./mvnw spring-boot:run
   # or on Windows
   mvnw.cmd spring-boot:run
   ```
4. The backend will start on [http://localhost:9090](http://localhost:9090)

---

## API Endpoints (Backend)

- `POST /api/auth/signup` — Register a new user
- `POST /api/auth/login` — Login and receive JWT token
- `GET /api/auth/users/{id}` — Get user details (authenticated)

---

## Contributing

1. Follow the established folder structure and naming conventions
2. Write clear, maintainable code and comments
3. Test your changes on multiple screen sizes (frontend)
4. Maintain security best practices (backend)
5. Submit pull requests with clear descriptions

---

## License

This project is licensed under the MIT License. 
