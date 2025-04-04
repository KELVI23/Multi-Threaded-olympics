# Multi-Threaded Olympics Simulation

This Java project simulates the men's 100m final race from the 2016 Rio Olympics using multi-threading to represent each athlete's performance concurrently.

## Features

- **Multi-Threaded Simulation**: Each athlete is simulated in a separate thread, allowing for concurrent race progression.
- **Realistic Athlete Data**: Utilizes real-world data from the `athletes.txt` file to model athlete performance.
- **Logging**: Implements logging to track race events and outcomes.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK is installed on your system.
- **Log4j Library**: Required for logging functionalities.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/KELVI23/Multi-Threaded-olympics.git
   ```

2. **Build and Run the Application**:
   - Open the project in your preferred Java IDE.
   - Add the Log4j libraries (`log4j-api-2.5.jar` and `log4j-core-2.5.jar`) to the project's build path.
   - Run the `Main` class to start the simulation.

## Usage

- **Simulation Start**: Upon running the application, the race simulation begins, with each athlete represented by a separate thread.
- **Logging**: Race events and results are logged, providing insights into the simulation's progression and outcomes.

## Project Structure

- **Source Code**: Located in the `src/a01085867/` directory.
- **Libraries**: External libraries are stored in the root directory, including:
  - `log4j-api-2.5.jar`
  - `log4j-core-2.5.jar`
- **Resources**: Data files and configuration files are in the root directory, including:
  - `athletes.txt`: Contains athlete data.
  - `log4j2.xml`: Configuration file for Log4j.

## Dependencies

- **Log4j 2.5**: Ensure both `log4j-api-2.5.jar` and `log4j-core-2.5.jar` are included in the project's build path.

## Notes

- The `athletes.txt` file should be formatted correctly to ensure accurate simulation.
- Log configurations are managed via the `log4j2.xml` file.

## License

This project is open-source. Feel free to modify and use it according to your needs.

---

*For any issues or contributions, please refer to the repository on [GitHub](https://github.com/KELVI23/Multi-Threaded-olympics).* 
