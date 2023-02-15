const express = require("express");
const { createPool } = require("mysql2/promise");
const path = require("path");

const app = express();

// Configuración de la conexión a la base de datos
const pool = createPool({
  database: "more-yl-gestion",
  user: "kzofohhrtku9pn97jljd",
  host: "us-east.connect.psdb.cloud",
  password: "pscale_pw_I82VMui2yq6JXYkULiE2ErozJQS0JYpojUnPhvmpsk0",
  ssl: {
    rejectUnauthorized: false,
  },
});

// Ruta para obtener todas las deudas
app.get("/deudas", async (req, res) => {
  try {
    const [rows] = await pool.query("SELECT * FROM deudas");
    res.json(rows);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: "Error al obtener las deudas" });
  }
});

app.use(express.static(path.join(__dirname, "./")));
app.get("*", (req, res) =>
  res.sendFile(path.resolve(__dirname, "./index.html"))
);

// Iniciar el servidor
app.listen(process.env.PORT || 5000, () => {
  console.log("Servidor iniciado en el puerto 3000");
});
