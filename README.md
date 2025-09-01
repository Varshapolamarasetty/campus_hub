# campus_hub
Campus Hub is a college resource-sharing platform where admins (faculty/staff) can upload academic resources (notes, PPTs, PDFs, etc.), and students can log in to view and download them.  The project was built as part of an academic learning exercise to understand full-stack web development using Java, Servlets, MySQL, HTML,CSS and React.
🚀 Features

User Authentication

Login & Register functionality for both students and admins.

Role-Based Dashboard

Admin Dashboard → Upload and manage academic resources.

Student Dashboard → View and download available resources.

File Upload & Download

Admins upload files (PDF, PPT, DOC, etc.).

Students can securely download them.

Profile Integration

Displays the logged-in user’s name.

Logout functionality for both admins and students.

Responsive UI with HTML, CSS, and a modern React-based enhancement.

🛠️ Tech Stack

Frontend

HTML, CSS, JavaScript (Vanilla)

React.js (for enhanced dashboard & notes listing)

Backend

Java Servlets (Eclipse, Tomcat Server)

JDBC for database connection

Database

MySQL (user authentication, file metadata storage)

Server

Apache Tomcat

📂 Project Structure
CampusHub/
│── src/                       # Java backend code (Servlets, Filters)
│── webapp/                    # Frontend HTML, CSS, JS files
│   ├── login.html
│   ├── register.html
│   ├── dashboard_admin.html
│   ├── dashboard_student.html
│   └── ...
│── uploads/                   # Uploaded resources (stored on server)
│── React-Frontend/            # React app (for enhanced student dashboard)
│── database.sql               # MySQL schema
│── README.md                  # Project description

🔧 Setup & Run
Backend (Java + Tomcat)

Import project into Eclipse.

Configure Tomcat server.

Create MySQL database using database.sql.

Update DB credentials in DBConnection.java.

Run the project → accessible at http://localhost:8080/campus_hub/.

Frontend (React – optional)

Install Node.js
.

Navigate to React-Frontend/ folder.

Run:

npm install
npm start


React app runs on http://localhost:3000
 and fetches data from backend.
