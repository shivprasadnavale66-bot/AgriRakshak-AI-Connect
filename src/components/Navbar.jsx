import React from "react";

function Navbar() {
  return (
    <nav className="bg-green-700 text-white h-16 px-6 flex justify-between items-center shadow-lg">

      <h2 className="text-2xl font-bold">
        🌾 AgriRakshak AI Connect
      </h2>

      <div className="flex items-center gap-5">

        <button className="text-2xl">
          🔔
        </button>

        <div className="flex items-center gap-3">

          <div className="bg-white text-green-700 rounded-full h-10 w-10 flex items-center justify-center font-bold">
            F
          </div>

          <div>

            <p className="font-semibold">
              Farmer
            </p>

            <small>
              Online
            </small>

          </div>

        </div>

      </div>

    </nav>
  );
}

export default Navbar;