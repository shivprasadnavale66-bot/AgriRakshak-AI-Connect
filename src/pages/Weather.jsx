import React from "react";
import MainLayout from "../layouts/MainLayout";

function Weather() {
  const weather = {
    location: "Aurangabad",
    temperature: "31°C",
    humidity: "62%",
    wind: "12 km/h",
    rainfall: "15%",
    condition: "Partly Cloudy",
  };

  return (
    <MainLayout>
      <h1 style={{ color: "#2e7d32", marginBottom: "20px" }}>
        🌤 Weather Forecast
      </h1>

      <div style={styles.card}>
        <h2>{weather.location}</h2>

        <p><strong>Temperature:</strong> {weather.temperature}</p>

        <p><strong>Humidity:</strong> {weather.humidity}</p>

        <p><strong>Wind:</strong> {weather.wind}</p>

        <p><strong>Rainfall:</strong> {weather.rainfall}</p>

        <p><strong>Condition:</strong> {weather.condition}</p>
      </div>
    </MainLayout>
  );
}

const styles = {
  card: {
    background: "#fff",
    padding: "25px",
    borderRadius: "10px",
    maxWidth: "500px",
    boxShadow: "0 5px 15px rgba(0,0,0,.1)",
    lineHeight: "2",
  },
};

export default Weather;