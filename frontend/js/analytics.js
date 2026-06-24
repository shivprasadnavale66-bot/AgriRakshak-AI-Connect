const token = localStorage.getItem("token");

if (!token) {
    alert("Please login first.");
    window.location.href = "login.html";
}

fetch("https://agrirakshak-backend.onrender.com/api/dashboard/analytics", {
    method: "GET",
    headers: {
        "Authorization": "Bearer " + token
    }
})
.then(response => {
    if (!response.ok) {
        throw new Error("Failed to load analytics");
    }
    return response.json();
})
.then(data => {

    document.getElementById("farmers").innerText = data.totalFarmers;
    document.getElementById("crops").innerText = data.totalCrops;
    document.getElementById("marketPrices").innerText = data.totalMarketPrices;
    document.getElementById("schemes").innerText = data.totalSchemes;

})
.catch(error => {
    console.error(error);
    alert("Unable to load analytics.");
});