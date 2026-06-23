import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function CropDisease() {
  return (
    <>
      <Navbar />

      <div style={styles.layout}>
        <Sidebar />

        <main style={styles.content}>
          <h1>🌾 Crop Disease Detection</h1>

          <div style={styles.card}>
            <h3>Upload Crop Image</h3>

            <input type="file" />

            <button style={styles.button}>
              Detect Disease
            </button>

            <div style={styles.result}>
              <h4>Prediction</h4>

              <p>No image uploaded.</p>
            </div>
          </div>
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
    padding: "30px",
    borderRadius: "10px",
    maxWidth: "600px",
    boxShadow: "0 5px 15px rgba(0,0,0,.1)",
  },

  button: {
    marginTop: "20px",
    padding: "10px 20px",
    background: "#2e7d32",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer",
  },

  result: {
    marginTop: "30px",
  },
};

export default CropDisease;