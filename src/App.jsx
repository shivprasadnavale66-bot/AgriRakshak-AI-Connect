import React from "react";
import { Routes, Route } from "react-router-dom";

// Components
import Login from "./components/Login";
import Register from "./components/Register";

// Pages
import Dashboard from "./pages/Dashboard";
import Weather from "./pages/Weather";
import CropDisease from "./pages/CropDisease";
import AIChat from "./pages/AIChat";
import MarketPrices from "./pages/MarketPrices";
import GovernmentSchemes from "./pages/GovernmentSchemes";
import Profile from "./pages/Profile";

function App() {
  return (
    <Routes>
      {/* Authentication */}
      <Route path="/" element={<Login />} />
      <Route path="/register" element={<Register />} />

      {/* Dashboard */}
      <Route path="/dashboard" element={<Dashboard />} />

      {/* Feature Pages */}
      <Route path="/weather" element={<Weather />} />
      <Route path="/crop-disease" element={<CropDisease />} />
      <Route path="/ai-chat" element={<AIChat />} />
      <Route path="/market-prices" element={<MarketPrices />} />
      <Route
        path="/government-schemes"
        element={<GovernmentSchemes />}
      />
      <Route path="/profile" element={<Profile />} />
    </Routes>
  );
}

export default App;