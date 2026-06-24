const API_URL = "https://agrirakshak-backend.onrender.com/api/farmer";

const farmerId = new URLSearchParams(window.location.search).get("id");

window.onload = loadFarmer;

// ===============================
// Load Farmer Details
// ===============================
async function loadFarmer() {

    if (!farmerId) {
        alert("Farmer ID not found.");
        window.location.href = "view-farmers.html";
        return;
    }

    try {

        const response = await fetch(`${API_URL}/${farmerId}`);

        if (!response.ok) {
            throw new Error("Unable to fetch farmer.");
        }

        const farmer = await response.json();

        document.getElementById("id").value = farmer.id;
        document.getElementById("fullName").value = farmer.fullName || "";
        document.getElementById("village").value = farmer.village || "";
        document.getElementById("district").value = farmer.district || "";
        document.getElementById("state").value = farmer.state || "";
        document.getElementById("mobileNumber").value = farmer.mobileNumber || "";
        document.getElementById("landArea").value = farmer.landArea || "";
        document.getElementById("soilType").value = farmer.soilType || "";
        document.getElementById("waterSource").value = farmer.waterSource || "";

    } catch (error) {

        console.error(error);
        alert("Unable to load farmer.");
        window.location.href = "view-farmers.html";

    }

}

// ===============================
// Update Farmer
// ===============================
document.getElementById("editForm").addEventListener("submit", updateFarmer);

async function updateFarmer(e) {

    e.preventDefault();

    const farmer = {

        id: farmerId,
        fullName: document.getElementById("fullName").value,
        village: document.getElementById("village").value,
        district: document.getElementById("district").value,
        state: document.getElementById("state").value,
        mobileNumber: document.getElementById("mobileNumber").value,
        landArea: parseFloat(document.getElementById("landArea").value) || 0,
        soilType: document.getElementById("soilType").value,
        waterSource: document.getElementById("waterSource").value

    };

    try {

        const response = await fetch(`${API_URL}/${farmerId}`, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(farmer)

        });

        const message = await response.text();

        if (response.ok) {

            alert(message);

            window.location.href = "view-farmers.html";

        } else {

            alert(message);

        }

    } catch (error) {

        console.error(error);

        alert("Unable to connect to backend.");

    }

}