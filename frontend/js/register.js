document.getElementById("registerForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const message = document.getElementById("message");
    message.innerHTML = "";
    message.style.color = "black";

    const user = {
        fullName: document.getElementById("fullName").value.trim(),
        email: document.getElementById("email").value.trim(),
        password: document.getElementById("password").value,
        mobile: document.getElementById("mobile").value.trim(),
        village: document.getElementById("village").value.trim(),
        district: document.getElementById("district").value.trim(),
        state: document.getElementById("state").value.trim(),
        role: document.getElementById("role").value
    };

    try {
        const response = await fetch(
            "https://agrirakshak-backend-gosk.onrender.com/api/auth/register",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            }
        );

        console.log("Response Status:", response.status);

        const data = await response.json();

        console.log("Response Data:", data);

        if (response.ok) {
            message.style.color = "green";
            message.innerHTML = data.message || "Registration Successful";

            setTimeout(() => {
                window.location.href = "login.html";
            }, 1500);
        } else {
            message.style.color = "red";
            message.innerHTML = data.message || "Registration Failed";
        }
    } catch (error) {
        console.error("Fetch Error:", error);
        message.style.color = "red";
        message.innerHTML = "Cannot connect to Backend";
        alert("Fetch Error:\n" + error);
    }
});


