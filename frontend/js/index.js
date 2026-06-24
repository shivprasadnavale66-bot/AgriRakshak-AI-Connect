const user = JSON.parse(localStorage.getItem("user"));

const welcome = document.getElementById("welcome");
const guestSection = document.getElementById("guestSection");
const userSection = document.getElementById("userSection");

if (user && user.success) {

    welcome.innerHTML = "Welcome, " + user.fullName + "!";

    guestSection.style.display = "none";
    userSection.style.display = "block";

} else {

    guestSection.style.display = "block";
    userSection.style.display = "none";
}

function logout() {

    localStorage.removeItem("user");

    window.location.reload();

}


