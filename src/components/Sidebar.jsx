import React from "react";
import { NavLink } from "react-router-dom";

function Sidebar() {

  const menus = [
    ["🏠 Dashboard", "/dashboard"],
    ["🌤 Weather", "/weather"],
    ["🌾 Crop Disease", "/crop-disease"],
    ["🤖 AI Assistant", "/ai-chat"],
    ["💰 Market Prices", "/market-prices"],
    ["📢 Government Schemes", "/government-schemes"],
    ["👤 Profile", "/profile"],
  ];

  return (
    <aside className="w-64 bg-green-800 text-white">

      <div className="text-center text-xl font-bold py-6 border-b border-green-700">
        MENU
      </div>

      <div className="flex flex-col p-4">

        {menus.map((menu, index) => (

          <NavLink
            key={index}
            to={menu[1]}
            className={({ isActive }) =>
              `p-3 rounded-lg mb-3 ${
                isActive
                  ? "bg-green-600"
                  : "hover:bg-green-700"
              }`
            }
          >
            {menu[0]}
          </NavLink>

        ))}

        <NavLink
          to="/"
          className="mt-8 p-3 rounded-lg bg-red-600 hover:bg-red-700 text-center"
        >
          🚪 Logout
        </NavLink>

      </div>

    </aside>
  );
}

export default Sidebar;