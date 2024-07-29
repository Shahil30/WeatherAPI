Here's a comprehensive README file for your GitHub repository:

```markdown
**# Creative Weather App**

A stylish and creative weather application that fetches real-time weather data. The app displays weather information in a beautiful, dark-themed interface with a looping background video. The application is built with Spring Boot for the backend and plain HTML, CSS, and JavaScript for the frontend.

**## Features**

- Fetch real-time weather data by location
- Display summary weather details including temperature, humidity, and condition
- Display detailed weather information with additional parameters
- Stylish dark theme with a polished navy blue and black color scheme
- Creative and interactive design
- Looping background video for a modern look

**## Technologies Used**

- Spring Boot
- HTML
- CSS
- JavaScript

**## Getting Started**

**### Prerequisites**

- Java 8 or higher
- Maven
- Spring Boot

**### API Key**

This project uses the WeatherAPI service. You need to sign up and get your own API key from [WeatherAPI](https://www.weatherapi.com/).

**### Setup**

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/creative-weather-app.git
   cd creative-weather-app
   ```

2. Update the API key:
   - Open `ApiClient.java` located in `src/main/java/com/weather/app/util/`.
   - Replace the `API_KEY` variable with your own API key from WeatherAPI.

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Open your browser and go to `http://localhost:8080`.

## Project Structure

- `src/main/java/com/weather/app/`
  - `controller/WeatherController.java`: Handles API requests and responses.
  - `model/WeatherResponse.java`: Models the structure of the weather data.
  - `service/WeatherService.java`: Fetches data from the WeatherAPI.
  - `util/ApiClient.java`: Makes HTTP requests to the WeatherAPI.
- `src/main/resources/static/`
  - `index.html`: The main HTML file.
  - `styles.css`: The CSS file for styling.
  - `script.js`: The JavaScript file for fetching data and updating the UI.

## API Endpoints

- `/weather/{location}`: Fetch detailed weather data for a specific location.
- `/weather/summary/{location}`: Fetch summary weather data for a specific location.

## Frontend

The frontend is built with plain HTML, CSS, and JavaScript. The UI includes a form for entering the location and selecting the type of weather data (summary or detailed). The results are displayed dynamically below the form.

### index.html

The main HTML file with a form to input the location and buttons to fetch weather data.

### styles.css

The CSS file for styling the application. It includes styles for the dark theme, button hover effects, and layout adjustments.

### script.js

The JavaScript file for handling form submission, fetching data from the backend, and updating the UI with the fetched weather data.


## Acknowledgements

- [WeatherAPI](https://www.weatherapi.com/) for providing the weather data API.
- [Pexels](https://www.pexels.com/) for the looping background video.

## Contact

For any inquiries, please contact [shahilmahato32@gmail.com].

---

Feel free to contribute to this project by opening issues and submitting pull requests. Your feedback and suggestions are highly appreciated!
