const API_URL = "https://agrirakshak-backend.onrender.com/api/crops";

const cropForm = document.getElementById("cropForm");
const cropTableBody = document.getElementById("cropTableBody");

loadCrops();

cropForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const id = document.getElementById("cropId").value;

    const crop = {
        cropName: document.getElementById("cropName").value,
        cropType: document.getElementById("cropType").value,
        season: document.getElementById("season").value,
        area: document.getElementById("area").value,
        soilType: document.getElementById("soilType").value
    };

    if (id === "") {
        // Create Crop
        fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(crop)
        })
        .then(res => res.json())
        .then(() => {
            alert("Crop Added Successfully!");
            cropForm.reset();
            loadCrops();
        });

    } else {
        // Update Crop
        fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(crop)
        })
        .then(res => res.json())
        .then(() => {
            alert("Crop Updated Successfully!");
            cropForm.reset();
            document.getElementById("cropId").value = "";
            loadCrops();
        });
    }
});

function loadCrops() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {

            cropTableBody.innerHTML = "";

            data.forEach(crop => {

                cropTableBody.innerHTML += `
                    <tr>
                        <td>${crop.id}</td>
                        <td>${crop.cropName}</td>
                        <td>${crop.cropType}</td>
                        <td>${crop.season}</td>
                        <td>${crop.area}</td>
                        <td>${crop.soilType}</td>
                        <td>
                            <button onclick="editCrop(${crop.id})">Edit</button>
                            <button onclick="deleteCrop(${crop.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });

        });
}

function editCrop(id) {

    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(crop => {

            document.getElementById("cropId").value = crop.id;
            document.getElementById("cropName").value = crop.cropName;
            document.getElementById("cropType").value = crop.cropType;
            document.getElementById("season").value = crop.season;
            document.getElementById("area").value = crop.area;
            document.getElementById("soilType").value = crop.soilType;

        });
}

function deleteCrop(id) {

    if (!confirm("Are you sure?")) return;

    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Crop Deleted Successfully!");
        loadCrops();
    });
}