
import { useEffect, useState } from "react";

export default function App() {
  const [name, setName] = useState("Loading...");
  const [files, setFiles] = useState([]);

  useEffect(() => {
    // Load student profile
    fetch("http://localhost:8080/campus_hub/profile") // adjust if backend is different
      .then((res) => res.json())
      .then((data) => setName(data.name || "Student"))
      .catch(() => setName("Student"));

    // Load notes
    fetch("http://localhost:8080/campus_hub/files")
      .then((res) => res.json())
      .then((data) => setFiles(data))
      .catch(() => setFiles([]));
  }, []);

  return (
    <div
      style={{
        fontFamily: "Segoe UI, sans-serif",
        background: "#f5f7fb",
        minHeight: "100vh",
        margin: 0,
        display: "flex",
        flexDirection: "column",
      }}
    >
      {/* Header */}
      <header
        style={{
          background: "#2196F3",
          color: "white",
          padding: "15px",
          textAlign: "center",
          fontSize: "22px",
          fontWeight: "bold",
        }}
      >
        📚 Campus Hub - Student Dashboard
      </header>

      {/* Centered container */}
      <div
        style={{
          flex: 1,
          display: "flex",
          justifyContent: "center",
          alignItems: "flex-start", // keeps it below the header
          paddingTop: "30px",
        }}
      >
        <div
          style={{
            width: "90%",
            maxWidth: "900px",
            background: "#fff",
            padding: "25px",
            borderRadius: "12px",
            boxShadow: "0 4px 12px rgba(0,0,0,0.1)",
          }}
        >
          <p style={{ fontSize: "18px", color: "#444" }}>
            Welcome, {name} (Student)
          </p>

          <h2 style={{ color: "#333", marginTop: "20px" }}>📂 Available Notes</h2>
          <ul style={{ listStyle: "none", padding: 0 }}>
            {files.length === 0 ? (
              <li
                style={{
                  background: "#eef5ff",
                  padding: "10px",
                  borderRadius: "6px",
                  fontWeight: "500",
                }}
              >
                No notes available.
              </li>
            ) : (
              files.map((file, index) => (
                <li
                  key={index}
                  style={{
                    background: "#eef5ff",
                    margin: "8px 0",
                    padding: "10px",
                    borderRadius: "6px",
                    fontWeight: "500",
                  }}
                >
                  <a
                    href={`http://localhost:8080/campus_hub/uploads/${encodeURIComponent(
                      file
                    )}`}
                    target="_blank"
                    rel="noopener noreferrer"
                    style={{ textDecoration: "none", color: "#2c3e50" }}
                  >
                    {file}
                  </a>
                </li>
              ))
            )}
          </ul>

          <a
            href="http://localhost:8080/campus_hub/logout"
            style={{
              display: "inline-block",
              marginTop: "20px",
              background: "#e74c3c",
              padding: "10px 15px",
              color: "white",
              borderRadius: "6px",
              textDecoration: "none",
              fontWeight: "bold",
            }}
          >
            🚪 Logout
          </a>
        </div>
      </div>
    </div>
  );
}
