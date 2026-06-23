document.getElementById("farmerForm").addEventListener("submit", saveFarmer);

async function saveFarmer(event) {

    event.preventDefault();

    const farmer = {

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

        const response = await fetch("http://localhost:8080/api/farmer", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(farmer)

        });

        const message = await response.text();

        if (response.ok) {

            alert(message);

            document.getElementById("farmerForm").reset();

            window.location.href = "view-farmers.html";

        } else {

            alert(message);

        }

    } catch (error) {

        console.error(error);

        alert("Unable to connect to backend.");

    }

}