const API_URL = "https://agrirakshak-backend.onrender.com/api/weather/";

async function getWeather() {

    const city = document.getElementById("city").value.trim();

    if (city === "") {
        alert("Please enter a city name.");
        return;
    }

    try {

        const response = await fetch(API_URL + encodeURIComponent(city));

        if (!response.ok) {
            throw new Error("City not found");
        }

        const data = await response.json();

        document.getElementById("cityName").textContent = data.city;
        document.getElementById("temperature").textContent = data.temperature;
        document.getElementById("humidity").textContent = data.humidity;
        document.getElementById("windSpeed").textContent = data.windSpeed;
        document.getElementById("pressure").textContent = data.pressure;
        document.getElementById("description").textContent = data.description;

        document.getElementById("weatherResult").style.display = "block";

    } catch (error) {

        alert("Unable to fetch weather. Please check the city name.");

        document.getElementById("weatherResult").style.display = "none";

        console.error(error);
    }
}

// Press Enter to search
document.getElementById("city").addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
        getWeather();
    }
});

