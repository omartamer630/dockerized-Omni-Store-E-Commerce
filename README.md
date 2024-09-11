# Dockerized Omni Store Project

## Overview
My first ever E-Commerce site, featuring a full-featured shopping experience with user authentication, product listings, shopping cart, wishlist, and responsive design.

## Features
- **User Authentication**
  - Secure user registration and login using JWT.

- **Product Listing**
  - Display a list of products with details such as name, description, price, and specifications.

- **Shopping Cart**
  - Add products to the cart and manage them.

- **Filters**
  - Filter products by various criteria to refine search results.

- **Wishlist**
  - Add products to a wishlist for future reference.

- **Responsive Design**
  - Optimized for desktop, tablet, and mobile devices to provide a seamless user experience.

## Building

### Prerequisites

- Docker

### Steps

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Khemu1/Omni-Store-E-Commerce
    ```

2. **Navigate to the project directory**:
    ```bash
    cd dockerized-Omni-Store-E-Commerce
    ```
3. **Create a `.env` file in the root directory** and add the following environment variables:
    ```env
    MONGODB_URI=your_mongodb_uri
    JWT_ACCESS_SECRET=your_jwt_secret
    JWT_REFRESH_TOKEN=your_jwt_secret

    ```
4. **Build image**:
    ```bash
    docker compose build
    ```
    
5. **Start the Container**:
    ```bash
    docker compose up -d
    ```
    
6. **Access the application**:
   Open your browser and navigate to `http://localhost:80`.

## Technologies Used

### Docker:
- **Docker container:** An isolated, lightweight environment where applications can run consistently across different computing environments. It packages the application along with its dependencies.
- **Dockerfile:** A text file that contains a series of instructions on how to build a Docker image. It specifies the base image, application code, dependencies, and commands needed to set up the environment.
- **Docker compose:** A tool for defining and running multi-container Docker applications. It uses a YAML file to configure application services, networks, and volumes.
- **Docker images:** Read-only templates used to create Docker containers. They contain the application code, runtime, libraries, and environment settings.
- 
### Frontend:
- **React:** A JavaScript library for building user interfaces.
- **TypeScript:** A typed superset of JavaScript that compiles to plain JavaScript.
- **Vite:** A fast build tool and development server for modern web projects.
- **Tailwind CSS:** A utility-first CSS framework for rapidly building custom user interfaces.

### Backend:
- **Node.js:** A JavaScript runtime built on Chrome's V8 JavaScript engine.
- **Express:** A minimal and flexible Node.js web application framework.
- **MongoDB:** A NoSQL database for modern applications.
- **Mongoose:** An ODM (Object Data Modeling) library for MongoDB and Node.js.

### Other:
- **JWT (JSON Web Tokens):** Used for secure user authentication.
- **Redux:** A predictable state container for JavaScript apps.
- **Axios:** A promise-based HTTP client for making requests to the server.
