import React, { useState } from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";

function AIChat() {
  const [message, setMessage] = useState("");
  const [chat, setChat] = useState([]);

  const sendMessage = () => {
    if (!message.trim()) return;

    setChat([
      ...chat,
      {
        user: message,
        bot: "AI response will appear here after backend integration.",
      },
    ]);

    setMessage("");
  };

  return (
    <>
      <Navbar />

      <div style={styles.layout}>
        <Sidebar />

        <main style={styles.content}>
          <h1>🤖 AI Agriculture Assistant</h1>

          <div style={styles.chatBox}>
            {chat.map((item, index) => (
              <div key={index}>
                <p><strong>You:</strong> {item.user}</p>
                <p><strong>AI:</strong> {item.bot}</p>
                <hr />
              </div>
            ))}
          </div>

          <input
            style={styles.input}
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            placeholder="Ask about farming..."
          />

          <button
            style={styles.button}
            onClick={sendMessage}
          >
            Send
          </button>
        </main>
      </div>
    </>
  );
}

const styles = {
  layout: { display: "flex" },

  content: {
    flex: 1,
    padding: "30px",
    background: "#f5f7fa",
    minHeight: "calc(100vh - 70px)",
  },

  chatBox: {
    background: "#fff",
    height: "350px",
    overflowY: "auto",
    padding: "20px",
    borderRadius: "10px",
    marginBottom: "20px",
  },

  input: {
    width: "100%",
    padding: "12px",
    marginBottom: "10px",
  },

  button: {
    padding: "10px 20px",
    background: "#2e7d32",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
  },
};

export default AIChat;