const API_URL = "https://agrirakshak-backend.onrender.com/api/market";

window.onload = function () {
    loadAllPrices();
};

async function loadAllPrices() {

    try {

        const response = await fetch(`${API_URL}/all`);

        if (!response.ok) {
            throw new Error("Failed to load market prices.");
        }

        const data = await response.json();
        displayPrices(data);

    } catch (error) {
        alert(error.message);
        console.error(error);
    }
}

async function searchCrop() {

    const crop = document.getElementById("crop").value.trim();

    if (crop === "") {
        alert("Please enter a crop name.");
        return;
    }

    try {

        const response = await fetch(`${API_URL}/${encodeURIComponent(crop)}`);

        if (!response.ok) {
            throw new Error("No market prices found.");
        }

        const data = await response.json();
        displayPrices(data);

    } catch (error) {
        alert(error.message);
        console.error(error);
    }
}

function displayPrices(prices) {

    const tbody = document.querySelector("#marketTable tbody");
    tbody.innerHTML = "";

    if (!prices || prices.length === 0) {
        tbody.innerHTML = `
            <tr>
                <td colspan="8">No market prices available.</td>
            </tr>
        `;
        return;
    }

    prices.forEach(price => {

        const row = `
            <tr>
                <td>${price.crop}</td>
                <td>${price.state}</td>
                <td>${price.district}</td>
                <td>${price.market}</td>
                <td>₹ ${price.minPrice}</td>
                <td>₹ ${price.maxPrice}</td>
                <td>₹ ${price.modalPrice}</td>
                <td>${formatDate(price.createdAt)}</td>
            </tr>
        `;

        tbody.innerHTML += row;
    });
}

function formatDate(dateTime) {

    if (!dateTime) return "-";

    return new Date(dateTime).toLocaleString();
}

document.getElementById("crop").addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
        searchCrop();
    }
});