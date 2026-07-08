DynamicPriceEngine

	A Spring Boot REST API project that calculates product prices dynamically using different pricing strategies such as Demand Pricing and Discount Pricing.The project demonstrates the use of the Strategy Design Pattern, DTOs, Validation, Exception Handling, Swagger, Actuator, Auditing, Versioning, and Spring Data JPA.

	Project Overview
	The Dynamic Pricing Engine allows users to:
•	Manage Products
•	Manage Pricing Rules
•	Calculate Dynamic Prices
•	Store calculated prices
•	Apply different pricing strategies based on rule type
•	Monitor application health using Spring Boot Actuator

	 Technologies Used
•	Java 25
•	Spring Boot 4.1.0
•	Spring Data JPA
•	Hibernate
•	MySQL
•	Maven
•	Lombok
•	Swagger OpenAPI
•	Spring Boot Actuator
•	Jakarta Validation

	Design Pattern Used
	Strategy Design Pattern
	Pricing calculation is implemented using the Strategy Pattern.

	Current Strategies:
•	DEMAND Pricing
•	DISCOUNT Pricing
	Example:
	Base Price = 50000

	DEMAND
	Rule Value = 1000
	Final Price = 51000
	DISCOUNT
	Discount = 10%
	Final Price = 45000

	 Project Structure

src/main/java
com.dynamicpricing
│
├── audit
│ └── BaseEntity
│
├── control
│ ├── ProductController
│ ├── PricingRuleController
│ └── DynamicPriceController
│
├── dto
│ ├── request
│ └── response
│
├── exception
│ ├── ResourceNotFoundException
│ ├── DuplicateResourceException
│ └── GlobalExceptionHandler
│
├── mapper
│ ├── ProductMapper
│ ├── PricingRuleMapper
│ └── DynamicPriceMapper
│
├── model
│ ├── Product
│ ├── PricingRule
│ └── DynamicPrice
│
├── repository
│ ├── ProductRepository
│ ├── PricingRuleRepository
│ └── DynamicPriceRepository
│
├── service
│ ├── interf
│ └── impl
│
├── strategy
│ ├── PricingStrategy
│ ├── DemandPricingStrategy
│ ├── DiscountPricingStrategy
│ └── PricingStrategyFactory
│
└── DynamicPricingEngineApplication

	Features

Product CRUD
Pricing Rule CRUD
Dynamic Price Calculation
Strategy Pattern
Validation
Global Exception Handling
•	DTO Pattern
•	Mapper Pattern
•	Auditing
•	Optimistic Locking (@Version)
•	Swagger Documentation
•	Spring Boot Actuator

	Database
	Database Name
•	dynamic_pricing_db

	Tables
•	products
•	pricing_rules
•	dynamic_prices

	REST API Endpoints
	Product
	POST
	/product/add
	GET
	/product/all
	GET
	/product/{id}
	PUT
	/product/update/{id}
	DELETE
	/product/delete/{id}
	Pricing Rule
	POST
	/pricingrule/add
	GET
	/pricingrule/all
	GET
	/pricingrule/{id}
	DELETE
	/pricingrule/{id}

Swagger UI
http://localhost:8080/swagger-ui/index.html

Actuator Endpoints
http://localhost:8080/actuator
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info


	Dynamic Price
	POST
	/dynamicprice/calculate
	GET
	/dynamicprice/all
	GET
	/dynamicprice/product/{productId}

	Design Patterns Used
	Strategy Design Pattern
	Dependency Injection
	Repository Pattern
	DTO Pattern

	Exception Handling
	Global exception handling is implemented using custom exceptions.
	ResourceNotFoundException
	DuplicateResourceException

	How to Run
	Clone the project.
	Create the MySQL database:
	dynamic_pricing_db
	Update database credentials in application.properties.
	Run the project as a Spring Boot application.
	Open Postman.
	Test all REST APIs.

	Tools Used
	Spring Tool Suite (STS)
	MySQL Workbench
	Postman
	GitHub

	Future Enhancements
	User Authentication using Spring Security
	JWT Authentication
	Swagger/OpenAPI Documentation
	Redis Cache
	Kafka Integration
	Machine Learning-based Dynamic Pricing



