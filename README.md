# SmartDeliverySystem

## Overview
SmartDeliverySystem is a Java-based application designed to simulate the delivery of packages to various buildings within a city. The system calculates the best route for a delivery driver to take, optimizing for distance and gasoline cost. The application features a graphical user interface (GUI) to visualize the delivery process and provides detailed information about each delivery.

## Features
- **Phase 1 and Phase 2 Simulation**: Users can run simulations in two phases, with Phase 2 building upon the results of Phase 1.
- **Graphical Visualization**: The GUI displays buildings, streets, and the delivery vehicle's route.
- **Package Information**: Detailed information about each package and its delivery status.
- **Performance Metrics**: Calculates and displays total distance, gasoline cost, and time taken for deliveries.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- JavaFX library


### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/SmartDeliverySystem.git
   ```
2. Navigate to the project directory:
   ```sh
   cd SmartDeliverySystem
   ```
3. Ensure that JavaFX is properly set up in your development environment.

### Running the Application
1. Compile the Java files:
   ```sh
   javac -cp /path/to/javafx-sdk/lib/*:. *.java
   ```
2. Run the application:
   ```sh
   java -cp /path/to/javafx-sdk/lib/*:. FirstPage
   ```

## Usage
1. Launch the application.
2. Select "Phase 1" to start the first phase of the simulation.
3. After completing Phase 1, you can proceed to "Phase 2" to see the optimized route and performance improvements.
4. Use the GUI to visualize the delivery process and view detailed information about each package.

## Project Structure
- **MainProgram.java**: Initializes the objects and manages the main logic of the application.
- **MainGUISimulation.java**: Handles the GUI components and user interactions.
- **DeliveryDriver.java**: Contains the logic for calculating routes and managing deliveries.
- **Customer.java**: Represents a customer with an assigned building and packages.
- **Building.java**: Represents a building with a location and assigned package.
- **Intersection.java**: Represents an intersection in the city with coordinates and distance calculations.
- **Normal.java**: Represents a normal package.
- **Reachable.java**: Interface for objects that can be reached via a phone number.
- **CustomerWithContact.java**: Extends Customer to include contact information.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.



