import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function MainLayout({ children }) {
  return (
    <div className="flex flex-col h-screen">

      <Navbar />

      <div className="flex flex-1 overflow-hidden">

        <Sidebar />

        <main className="flex-1 bg-gray-100 overflow-y-auto">
          {children}
        </main>

      </div>

    </div>
  );
}

export default MainLayout;