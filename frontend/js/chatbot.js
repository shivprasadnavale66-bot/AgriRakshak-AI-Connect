const API_URL = "https://agrirakshak-backend.onrender.com/api/chatbot/ask";

async function sendMessage() {

    const input = document.getElementById("message");
    const chatBox = document.getElementById("chatBox");

    const message = input.value.trim();

    if (message === "") {
        return;
    }

    // Show user message
    chatBox.innerHTML += `
        <div class="user-message">
            ${message}
        </div>
    `;

    input.value = "";

    // Auto scroll
    chatBox.scrollTop = chatBox.scrollHeight;

    try {

        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                message: message
            })
        });

        const data = await response.json();

        chatBox.innerHTML += `
            <div class="bot-message">
                ${data.reply}
            </div>
        `;

    } catch (error) {

        chatBox.innerHTML += `
            <div class="bot-message">
                ❌ Unable to connect to AI server.
            </div>
        `;

        console.error(error);
    }

    // Auto scroll again
    chatBox.scrollTop = chatBox.scrollHeight;
}

// Press Enter to send
document.getElementById("message").addEventListener("keypress", function (event) {

    if (event.key === "Enter") {
        sendMessage();
    }

});

