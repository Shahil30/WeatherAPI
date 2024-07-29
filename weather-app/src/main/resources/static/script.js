document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("weather-form");
    const locationInput = document.getElementById("location");
    const weatherTypeSelect = document.getElementById("weather-type"); // Make sure this element exists
    const weatherDetails = document.getElementById("weather-details");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();
        const location = locationInput.value;
        const weatherType = weatherTypeSelect.value;
        let url = "";

        if (weatherType === "detailed") {
            url = `/weather/${location}`;
        } else if (weatherType === "summary") {
            url = `/weather/summary/${location}`;
        }

        try {
            const response = await fetch(url);
            const data = await response.json();
            displayWeatherData(data, weatherType);
        } catch (error) {
            console.error("Error fetching weather data:", error);
            weatherDetails.innerHTML = `<p>Error fetching weather data. Please try again later.</p>`;
        }
    });

    function displayWeatherData(data, weatherType) {
        weatherDetails.innerHTML = "";
        if (weatherType === "detailed") {
            weatherDetails.innerHTML = `
                <p>Location: ${data.location}</p>
                <p>Temperature: ${data.tempC} °C / ${data.tempF} °F</p>
                <p>Humidity: ${data.humidity}%</p>
                <p>Condition: ${data.condition}</p>
                <p>Wind Speed: ${data.windKph} kph</p>
                <p>Pressure: ${data.pressureMb} mb</p>
                <p>Precipitation: ${data.precipMm} mm</p>
                <p>Feels Like: ${data.feelslikeC} °C</p>
                <p>Visibility: ${data.visibilityKm} km</p>
                <p>UV Index: ${data.uv}</p>
            `;
        } else if (weatherType === "summary") {
            weatherDetails.innerHTML = `
                <p>Temperature: ${data.tempC} °C / ${data.tempF} °F</p>
                <p>Humidity: ${data.humidity}%</p>
                <p>Condition: ${data.condition}</p>
            `;
        }
    }
});
