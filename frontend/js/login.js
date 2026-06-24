document.getElementById("loginForm").addEventListener("submit", async function (e) {

    e.preventDefault();

    const user = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    try {

        const response = await fetch("https://agrirakshak-backend.onrender.com/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        });

        const data = await response.json();

        if (data.success) {

            // Save JWT Token
            localStorage.setItem("token", data.token);

            // Save User Details
            localStorage.setItem("user", JSON.stringify(data));

            // Redirect
            window.location.href = "dashboard.html";

        } else {

            document.getElementById("message").style.color = "red";
            document.getElementById("message").innerHTML = data.message;

        }

    } catch (error) {

        document.getElementById("message").style.color = "red";
        document.getElementById("message").innerHTML = "Cannot connect to Backend";

    }

});

