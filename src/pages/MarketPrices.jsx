import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function MarketPrices() {

  const crops = [
    { crop: "Wheat", price: "₹2450 / Quintal" },
    { crop: "Rice", price: "₹2850 / Quintal" },
    { crop: "Cotton", price: "₹7100 / Quintal" },
    { crop: "Soybean", price: "₹5200 / Quintal" },
  ];

  return (
    <>
      <Navbar />

      <div style={styles.layout}>
        <Sidebar />

        <main style={styles.content}>
          <h1>💰 Market Prices</h1>

          <table style={styles.table}>
            <thead>
              <tr>
                <th>Crop</th>
                <th>Price</th>
              </tr>
            </thead>

            <tbody>
              {crops.map((item, index) => (
                <tr key={index}>
                  <td>{item.crop}</td>
                  <td>{item.price}</td>
                </tr>
              ))}
            </tbody>
          </table>
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

  table: {
    width: "100%",
    background: "#fff",
    borderCollapse: "collapse",
  },
};

export default MarketPrices;