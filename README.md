# E-Commerce Web API

This is an e-commerce web API built using Spring Boot and MySQL. It provides various endpoints for managing customers, products, orders, payments, shipping, categories, addresses, and admin users. The API also implements JWT (JSON Web Token) authentication and refresh token mechanism to secure the endpoints and ensure authorized access.

## Project Overview

The E-Commerce Web API is designed to facilitate the management of an e-commerce platform. It provides various endpoints for managing customers, products, orders, payments, shipping, categories, addresses, and admin users. The API also implements JWT (JSON Web Token) authentication and refresh token mechanism to secure the endpoints and ensure authorized access.

The JWT authentication mechanism allows users to obtain a token upon successful login, which they can then include in the `Authorization` header of subsequent requests to access protected endpoints. The token contains encoded information about the user's identity and privileges, and it is validated on the server side to ensure the authenticity and integrity of the requests.

In addition to JWT, the API also utilizes refresh tokens to provide a seamless and secure way to obtain new access tokens without requiring the user to re-authenticate. When an access token expires, the client can use the refresh token to obtain a new access token, thereby extending the session and maintaining a smooth user experience.

The combination of JWT authentication and refresh token mechanism enhances the security of the API by preventing unauthorized access and protecting sensitive user data.

The API is built using the Spring Boot framework, which provides a robust and scalable foundation for developing enterprise-grade applications. It leverages the power of MySQL as the underlying database management system to store and retrieve data efficiently.

## Key Features

- **Customer Management**: The API allows you to create, update, and retrieve customer information, including personal details, addresses, and order history.

- **Product Management**: You can manage product inventory, including adding new products, updating existing products, and retrieving product information.

- **Order Management**: The API enables you to place new orders, track order status, and manage order fulfillment.

- **Payment Processing**: It provides functionality for processing payments securely, including integration with popular payment gateways.

- **Shipping Logistics**: You can manage shipping details, including calculating shipping costs, generating shipping labels, and tracking shipments.

- **Category Management**: The API allows you to create and manage product categories, enabling better organization and navigation of products.

- **Admin User Management**: It provides features for managing admin users, including authentication, authorization, and role-based access control.

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository to your local machine.
2. Set up a MySQL database and update the database configuration in the application.yml file.
3. Build the project using Maven: `./mvnw clean install`.
4. Run the application: `./mvnw spring-boot:run`.
5. The API will be accessible at http://localhost:8080.

## Dependencies

The project uses the following dependencies:

- Spring Boot: Framework for creating Java applications.
- MySQL: Database management system.
- Spring Data JPA: Simplifies database access using the Java Persistence API (JPA).
- Spring Security: Provides authentication and authorization support.
- JSON Web Token (JWT): Used for implementing token-based authentication.

## Contributing

Contributions to this project are welcome. Feel free to open issues and submit pull requests to help improve the project.

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to customize the README file according to your project's specific details and requirements.
