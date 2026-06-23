import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function GovernmentSchemes() {

  const schemes = [
    "PM-KISAN",
    "Pradhan Mantri Fasal Bima Yojana",
    "Soil Health Card",
    "Kisan Credit Card",
    "National Agriculture Market (e-NAM)",
  ];

  return (
    <>
      <Navbar />

      <div style={styles.layout}>
        <Sidebar />

        <main style={styles.content}>
          <h1>📢 Government Schemes</h1>

          {schemes.map((scheme, index) => (
            <div key={index} style={styles.card}>
              {scheme}
            </div>
          ))}
        </main>
      </div>
    </>
  );
}

const styles = {
  layout: { display: "flex" },

  content: {
    flex: 1,
    padding: "30px",
    background: "#f5f7fa",
    minHeight: "calc(100vh - 70px)",
  },

  card: {
    background: "#fff",
    padding: "20px",
    marginBottom: "15px",
    borderRadius: "8px",
    boxShadow: "0 3px 10px rgba(0,0,0,.1)",
  },
};

export default GovernmentSchemes;