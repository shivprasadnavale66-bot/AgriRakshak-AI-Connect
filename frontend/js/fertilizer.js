const API_URL = "https://agrirakshak-backend.onrender.com/api/fertilizer";

const fertilizerForm = document.getElementById("fertilizerForm");
const result = document.getElementById("result");
const historyBody = document.getElementById("historyBody");

loadHistory();

fertilizerForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const request = {
        crop: document.getElementById("crop").value,
        soilType: document.getElementById("soilType").value,
        nitrogen: parseInt(document.getElementById("nitrogen").value),
        phosphorus: parseInt(document.getElementById("phosphorus").value),
        potassium: parseInt(document.getElementById("potassium").value)
    };

    fetch(API_URL + "/recommend", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(request)
    })
    .then(response => response.json())
    .then(data => {

        result.innerHTML = `
            <h4>${data.recommendation}</h4>
        `;

        fertilizerForm.reset();
        loadHistory();
    })
    .catch(error => {
        console.error(error);
        alert("Failed to get recommendation.");
    });
});

function loadHistory() {

    fetch(API_URL + "/history")
        .then(response => response.json())
        .then(data => {

            historyBody.innerHTML = "";

            data.forEach(item => {

                historyBody.innerHTML += `
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.crop}</td>
                        <td>${item.soilType}</td>
                        <td>${item.nitrogen}</td>
                        <td>${item.phosphorus}</td>
                        <td>${item.potassium}</td>
                        <td>${item.recommendation}</td>
                    </tr>
                `;
            });

        })
        .catch(error => {
            console.error(error);
        });
}