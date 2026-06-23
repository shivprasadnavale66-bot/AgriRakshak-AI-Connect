import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function Profile() {
  return (
    <>
      <Navbar />

      <div style={styles.layout}>
        <Sidebar />

        <main style={styles.content}>
          <h1>👤 Farmer Profile</h1>

          <div style={styles.card}>
            <p><strong>Name:</strong> Demo Farmer</p>

            <p><strong>Email:</strong> farmer@example.com</p>

            <p><strong>Village:</strong> Aurangabad</p>

            <p><strong>State:</strong> Maharashtra</p>

            <button style={styles.button}>
              Edit Profile
            </button>
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
    maxWidth: "500px",
    borderRadius: "10px",
    boxShadow: "0 5px 15px rgba(0,0,0,.1)",
    lineHeight: "2",
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
};

export default Profile;