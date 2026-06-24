const API_URL = "https://agrirakshak-backend.onrender.com/api/crops";
const FARMER_API = "https://agrirakshak-backend.onrender.com/api/farmer";

const cropId = new URLSearchParams(window.location.search).get("id");

window.onload = function () {
    loadFarmers();
};

async function loadFarmers() {
    try {
        const response = await fetch(FARMER_API);

        if (!response.ok) {
            throw new Error("Unable to load farmers.");
        }

        const farmers = await response.json();

        const farmerSelect = document.getElementById("farmer");

        farmerSelect.innerHTML =
            '<option value="">-- Select Farmer --</option>';

        farmers.forEach(farmer => {
            farmerSelect.innerHTML += `
                <option value="${farmer.id}">
                    ${farmer.fullName}
                </option>
            `;
        });

        loadCrop();

    } catch (error) {
        console.error(error);
        alert("Unable to load farmers.");
    }
}

async function loadCrop() {

    try {

        const response = await fetch(`${API_URL}/${cropId}`);

        if (!response.ok) {
            throw new Error("Crop not found.");
        }

        const crop = await response.json();

        document.getElementById("cropName").value = crop.cropName;
        document.getElementById("cropType").value = crop.cropType;
        document.getElementById("season").value = crop.season;
        document.getElementById("area").value = crop.area;
        document.getElementById("soilType").value = crop.soilType;

        if (crop.farmer) {
            document.getElementById("farmer").value = crop.farmer.id;
        }

    } catch (error) {

        console.error(error);
        alert("Unable to load crop.");

    }

}

document.getElementById("editCropForm").addEventListener("submit", updateCrop);

async function updateCrop(event) {

    event.preventDefault();

    const farmerId = document.getElementById("farmer").value;

    if (farmerId === "") {
        alert("Please select a farmer.");
        return;
    }

    const crop = {

        cropName: document.getElementById("cropName").value,
        cropType: document.getElementById("cropType").value,
        season: document.getElementById("season").value,
        area: parseFloat(document.getElementById("area").value),
        soilType: document.getElementById("soilType").value,

        farmer: {
            id: parseInt(farmerId)
        }

    };

    try {

        const response = await fetch(`${API_URL}/${cropId}`, {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(crop)

        });

        const message = await response.text();

        if (response.ok) {

            alert(message);

            window.location.href = "view-crops.html";

        } else {

            alert(message);

        }

    } catch (error) {

        console.error(error);

        alert("Unable to connect to backend.");

    }

}

