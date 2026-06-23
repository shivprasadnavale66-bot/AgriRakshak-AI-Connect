// ==============================
// AgriRakshak Dashboard
// ==============================

// Get user and token
const user = JSON.parse(localStorage.getItem("user"));
const token = localStorage.getItem("token");

// Login Check
if (!user || !token) {
    alert("Please login first.");
    window.location.href = "login.html";
}

// Display User Details
document.getElementById("welcome").innerText = "Welcome, " + user.fullName + " 👋";
document.getElementById("fullName").innerText = user.fullName;
document.getElementById("email").innerText = user.email;
document.getElementById("role").innerText = user.role;

// ==============================
// Animated Counter
// ==============================

function animateCounter(id, endValue) {

    const element = document.getElementById(id);

    let start = 0;

    const duration = 1200;

    const increment = Math.max(1, Math.ceil(endValue / (duration / 20)));

    const timer = setInterval(() => {

        start += increment;

        if (start >= endValue) {
            start = endValue;
            clearInterval(timer);
        }

        element.innerText = start;

    }, 20);

}

// ==============================
// Dashboard Chart
// ==============================

let dashboardChart = null;
let pieChart = null;
let lineChart = null;

function loadChart(data) {

    const labels = [
        "Farmers",
        "Crops",
        "Markets",
        "Schemes",
        "Users",
        "Fertilizers"
    ];

    const values = [
        data.farmerCount,
        data.cropCount,
        data.marketCount,
        data.schemeCount,
        data.userCount,
        data.fertilizerCount
    ];

    const colors = [
        "#4CAF50",
        "#8BC34A",
        "#FFC107",
        "#2196F3",
        "#9C27B0",
        "#FF5722"
    ];

    // ================= BAR CHART =================

    if (dashboardChart) dashboardChart.destroy();

    dashboardChart = new Chart(
        document.getElementById("dashboardChart"),
        {
            type: "bar",
            data: {
                labels: labels,
                datasets: [{
                    label: "Total Records",
                    data: values,
                    backgroundColor: colors,
                    borderRadius: 8
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        }
    );

    // ================= PIE CHART =================

    if (pieChart) pieChart.destroy();

    pieChart = new Chart(
        document.getElementById("pieChart"),
        {
            type: "pie",
            data: {
                labels: labels,
                datasets: [{
                    data: values,
                    backgroundColor: colors
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        }
    );

    // ================= LINE CHART =================

    if (lineChart) lineChart.destroy();

    lineChart = new Chart(
        document.getElementById("lineChart"),
        {
            type: "line",
            data: {
                labels: labels,
                datasets: [{
                    label: "Dashboard Analytics",
                    data: values,
                    borderColor: "#4CAF50",
                    backgroundColor: "rgba(76,175,80,0.2)",
                    fill: true,
                    tension: 0.4
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false
            }
        }
    );
}
// ==============================
// Dashboard Analytics
// ==============================

function loadDashboardAnalytics() {

    fetch("http://localhost:8080/api/dashboard/analytics", {

        method: "GET",

        headers: {

            "Authorization": "Bearer " + token,

            "Content-Type": "application/json"

        }

    })

        .then(response => {

            if (response.status === 401 || response.status === 403) {

                alert("Session expired. Please login again.");

                localStorage.removeItem("user");
                localStorage.removeItem("token");

                window.location.href = "login.html";

                return;
            }

            if (!response.ok) {
                throw new Error("Failed to load dashboard.");
            }

            return response.json();

        })

        .then(data => {

            if (!data) return;

            animateCounter("farmerCount", data.farmerCount);
            animateCounter("cropCount", data.cropCount);
            animateCounter("marketCount", data.marketCount);
            animateCounter("schemeCount", data.schemeCount);
            animateCounter("userCount", data.userCount);
            animateCounter("fertilizerCount", data.fertilizerCount);

            loadChart(data);

        })

        .catch(error => {

            console.error(error);

            alert("Unable to load dashboard analytics.");

        });

}

// ==============================
// Logout
// ==============================

function logout() {

    if (confirm("Are you sure you want to logout?")) {

        localStorage.removeItem("user");
        localStorage.removeItem("token");

        window.location.href = "login.html";
    }

}

// ==============================
// Start Dashboard
// ==============================

loadDashboardAnalytics();