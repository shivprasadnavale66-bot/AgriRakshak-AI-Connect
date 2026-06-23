import React from "react";
import { useNavigate } from "react-router-dom";
import MainLayout from "../layouts/MainLayout";

function Dashboard() {
  const navigate = useNavigate();

  const cards = [
    {
      title: "Weather Forecast",
      emoji: "🌤",
      description: "View today's weather and rainfall prediction.",
      route: "/weather",
      color: "bg-blue-500",
    },
    {
      title: "Crop Disease",
      emoji: "🌾",
      description: "Detect crop diseases using AI.",
      route: "/crop-disease",
      color: "bg-green-600",
    },
    {
      title: "AI Assistant",
      emoji: "🤖",
      description: "Ask agriculture-related questions.",
      route: "/ai-chat",
      color: "bg-purple-600",
    },
    {
      title: "Market Prices",
      emoji: "💰",
      description: "Latest mandi prices.",
      route: "/market-prices",
      color: "bg-yellow-500",
    },
    {
      title: "Govt Schemes",
      emoji: "📢",
      description: "Government schemes for farmers.",
      route: "/government-schemes",
      color: "bg-red-500",
    },
    {
      title: "Profile",
      emoji: "👤",
      description: "Manage your account.",
      route: "/profile",
      color: "bg-indigo-600",
    },
  ];

  return (
    <MainLayout>
      <div className="p-6">

        <h1 className="text-4xl font-bold text-green-700">
          🌾 AgriRakshak AI Connect
        </h1>

        <p className="text-gray-600 mt-2 mb-8">
          Smart Farming Dashboard
        </p>

        {/* Statistics */}
        <div className="grid md:grid-cols-4 gap-6 mb-8">

          <div className="bg-white rounded-xl shadow-lg p-6">
            <h3 className="text-gray-500">Today's Weather</h3>

            <p className="text-3xl mt-2 font-bold">
              31°C
            </p>
          </div>

          <div className="bg-white rounded-xl shadow-lg p-6">
            <h3 className="text-gray-500">Humidity</h3>

            <p className="text-3xl mt-2 font-bold">
              62%
            </p>
          </div>

          <div className="bg-white rounded-xl shadow-lg p-6">
            <h3 className="text-gray-500">Market Updates</h3>

            <p className="text-3xl mt-2 font-bold">
              18
            </p>
          </div>

          <div className="bg-white rounded-xl shadow-lg p-6">
            <h3 className="text-gray-500">AI Queries</h3>

            <p className="text-3xl mt-2 font-bold">
              25
            </p>
          </div>

        </div>

        {/* Feature Cards */}

        <div className="grid md:grid-cols-2 xl:grid-cols-3 gap-6">

          {cards.map((card, index) => (

            <div
              key={index}
              className="bg-white rounded-xl shadow-lg overflow-hidden hover:shadow-2xl transition"
            >

              <div className={`${card.color} text-white p-5`}>

                <h2 className="text-2xl font-bold">
                  {card.emoji} {card.title}
                </h2>

              </div>

              <div className="p-6">

                <p className="text-gray-600">
                  {card.description}
                </p>

                <button
                  onClick={() => navigate(card.route)}
                  className="mt-6 bg-green-600 hover:bg-green-700 text-white px-5 py-2 rounded-lg"
                >
                  Open Module
                </button>

              </div>

            </div>

          ))}

        </div>

      </div>
    </MainLayout>
  );
}

export default Dashboard;