let crops = [];

window.onload = loadCrops;

async function loadCrops() {

    try {

        const response = await fetch("https://agrirakshak-backend.onrender.com/api/crops");

        if (!response.ok) {
            throw new Error("Failed to fetch crops");
        }

        crops = await response.json();

        displayCrops(crops);

    } catch (error) {

        console.error(error);
        alert("Unable to load crops.");

    }

}

function displayCrops(list) {

    const tableBody = document.getElementById("cropTableBody");

    tableBody.innerHTML = "";

    if (list.length === 0) {

        tableBody.innerHTML = `
            <tr>
                <td colspan="8">No Crops Found</td>
            </tr>
        `;

        return;
    }

    list.forEach(crop => {

        tableBody.innerHTML += `
            <tr>
                <td>${crop.id}</td>
                <td>${crop.farmer ? crop.farmer.fullName : "-"}</td>
                <td>${crop.cropName}</td>
                <td>${crop.cropType}</td>
                <td>${crop.season}</td>
                <td>${crop.area}</td>
                <td>${crop.soilType}</td>
                <td>
                    <button class="btn edit" onclick="editCrop(${crop.id})">
                        Edit
                    </button>

                    <button class="btn delete" onclick="deleteCrop(${crop.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;

    });

}

function searchCrop() {

    const keyword = document
        .getElementById("search")
        .value
        .toLowerCase();

    const filtered = crops.filter(crop =>

        crop.cropName.toLowerCase().includes(keyword) ||

        crop.cropType.toLowerCase().includes(keyword) ||

        crop.season.toLowerCase().includes(keyword) ||

        crop.soilType.toLowerCase().includes(keyword) ||

        (crop.farmer &&
            crop.farmer.fullName.toLowerCase().includes(keyword))

    );

    displayCrops(filtered);

}

function editCrop(id) {

    window.location.href = `edit-crop.html?id=${id}`;

}

async function deleteCrop(id) {

    if (!confirm("Are you sure you want to delete this crop?")) {
        return;
    }

    try {

        const response = await fetch(`https://agrirakshak-backend.onrender.com/api/crops/${id}`, {
            method: "DELETE"
        });

        const message = await response.text();

        if (response.ok) {

            alert(message);

            loadCrops();

        } else {

            alert(message);

        }

    } catch (error) {

        console.error(error);

        alert("Unable to connect to backend.");

    }

}

