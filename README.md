![Travel Bus in scenic mountainous landscape](https://images.unsplash.com/photo-1544620347-c4fd4a3d5957?q=80&w=1469&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D)

# Bus Management System

This project is a simple Bus Management System written in Java using Spring Boot.

The app uses a simple Layered Architecture, following the Controller-Service-Repository Pattern.


## Important Architectural Decisions

- When building our models, we decided to create an `Identifiable` interface. This ensures all entities are accessed consistently by their ID and allows us to use Java Generics across the application.

- For ease of development and collaboration, we decided to build one Service and one Controller for each data type. This adherese to the Single Responsibility Principle and ensure that each controller is concerned with traffic from exactly one domain.

- Each Repository, Service, and Controller inherits from a generic base class (`InMemoryRepository`, `BaseService`, `BaseController`), which encapsulates the common CRUD methods.

- As a temporary storage solution, the repositories utilise HashMaps to store and manage entitiy instances in memory.

## Model Expansions
To meet the assignment requirements, we expanded three core UML models with additional attributes:
* **Staff:** Added `salary` to manage payroll.
* **Driver:** Added `decorations` to track cabin flair and keep each driver's personality in mind
* **Bus:** Added a boolean `hasAC` and a custom Enum `FuelType` to better define the vehicle's hardware specifications.
  **Design Justification:** We deliberately kept `decorations` as an attribute of the `Driver` rather than the `Bus`. In our domain model, items like family photos or dashboard figures are personal belongings that a driver brings to their shift. When the driver's shift ends and they change vehicles, their decorations leave with them. Therefore, this represents a property of the employee's personal workspace, not the hardware of the vehicle itself.

## Authors

- [Dan Bărăian](https://www.github.com/CodingGoose)
- [Andrei Foltiș](https://www.github.com/andrei-foltis)

