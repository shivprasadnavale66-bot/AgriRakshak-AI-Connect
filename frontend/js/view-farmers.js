let farmers = [];

window.onload = loadFarmers;

async function loadFarmers() {

    try {

        const response = await fetch("https://agrirakshak-backend.onrender.com/api/farmer");

        if (!response.ok) {
            throw new Error("Failed to fetch farmers");
        }

        farmers = await response.json();

        displayFarmers(farmers);

    } catch (error) {

        console.error(error);
        alert("Unable to load farmers.");

    }

}

function displayFarmers(list) {

    const tableBody = document.getElementById("farmerTableBody");

    tableBody.innerHTML = "";

    if (list.length === 0) {

        tableBody.innerHTML = `
        <tr>
            <td colspan="10">No Farmers Found</td>
        </tr>
        `;

        return;
    }

    list.forEach(farmer => {

        tableBody.innerHTML += `
        <tr>

            <td>${farmer.id}</td>

            <td>${farmer.fullName}</td>

            <td>${farmer.village}</td>

            <td>${farmer.district}</td>

            <td>${farmer.state}</td>

            <td>${farmer.mobileNumber}</td>

            <td>${farmer.landArea}</td>

            <td>${farmer.soilType}</td>

            <td>${farmer.waterSource}</td>

            <td>

                <button onclick="editFarmer(${farmer.id})">
                    Edit
                </button>

                <button onclick="deleteFarmer(${farmer.id})">
                    Delete
                </button>

            </td>

        </tr>
        `;

    });

}

function searchFarmer() {

    const keyword = document
        .getElementById("search")
        .value
        .toLowerCase();

    const filtered = farmers.filter(farmer =>

        farmer.fullName.toLowerCase().includes(keyword) ||
        farmer.village.toLowerCase().includes(keyword) ||
        farmer.district.toLowerCase().includes(keyword) ||
        farmer.state.toLowerCase().includes(keyword) ||
        farmer.mobileNumber.toLowerCase().includes(keyword) ||
        farmer.soilType.toLowerCase().includes(keyword) ||
        farmer.waterSource.toLowerCase().includes(keyword)

    );

    displayFarmers(filtered);

}

function editFarmer(id) {

    window.location.href = "edit-farmer.html?id=" + id;

}

async function deleteFarmer(id) {

    if (!confirm("Delete this farmer?")) {
        return;
    }

    try {

        const response = await fetch(
            `https://agrirakshak-backend.onrender.com/api/farmer/${id}`,
            {
                method: "DELETE"
            }
        );

        const message = await response.text();

        alert(message);

        loadFarmers();

    } catch (error) {

        console.error(error);

        alert("Unable to connect to backend.");

    }

}

