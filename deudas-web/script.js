async function getDeudas() {
  const response = await fetch("/deudas");
  const deudas = await response.json();
  return deudas;
}

function addDeudaToTable(deuda) {
  if (deuda.deuda !== 0) {
    const tableBody = document.getElementById("deudas-body");
    const row = tableBody.insertRow();
    row.insertCell().innerText = deuda.cliente;
    row.insertCell().innerText = deuda.producto;

    const [day, month, year] = deuda.fecha.split(/\/\s*/);
    const dateObj = new Date(year, month - 1, day);
    const options = {
      weekday: "short",
      month: "short",
      day: "numeric",
      year: "numeric",
    };
    const formattedDate = dateObj.toLocaleDateString("es-ES", options);

    row.insertCell().innerText = formattedDate.replace(/\s+/g, " ");
    row.insertCell().innerText = f.format(deuda.deuda);
  }
}

async function loadDeudas() {
  const deudas = await getDeudas();
  deudas.sort((a, b) => a.cliente.localeCompare(b.cliente));
  deudas.forEach(addDeudaToTable);
}

const f = new Intl.NumberFormat("en-US", {
  style: "currency",
  currency: "USD",
  minimumFractionDigits: 0,
});

loadDeudas();

const body = document.querySelector("body");
const toggle = document.querySelector("#dark-mode-toggle");

toggle.addEventListener("click", () => {
  body.classList.toggle("dark-mode");
});
