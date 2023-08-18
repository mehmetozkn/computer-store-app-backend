# Market API

---

### Spring Boot Application

- This project provides to add comment to basket for existing users.

### Summary

- A user must have a basket.
- More than one product can be added to a basket.

---

The application has 4 services

- ProductService
- BasketService
- UserService
- BasketProductService

---

#### ProductService:

- It performs the operations of product creation, product deletion, product update and product listing.

#### BasketService:

- It performs the operations of creating baskets, deleting baskets and listing the comment in the basket.

#### UserService:

- It performs the operations of user creation, user deletion, user update and user listing.

#### BasketProductService:

- It provides adding comment into the basket.
- It has a method called addProductToBasket that takes a request called addProductRequest. This request includes user_id, product_id, basket_id and quantity.
- It finds the registered user with user_id, finds the product with product_id, finds the basket with basket_id and adds the number of comment to the relevant user's basket.

---

### Tech Stack

- Java 17
- Spring Boot 3.1.2
- Spring Data JPA
- Restful API
- H2 In memory database

---

### Prerequisites

- Maven

---

### File Structure

- config
- controller
- dto
- exception
- model
- repository
- service

---

### Layered Architecture

<img width="565" alt="layeredstructure" src="https://github.com/mehmetozkn/spring-market-app/assets/75026832/5266f139-672b-4ca0-8f57-4852794d9d28">
