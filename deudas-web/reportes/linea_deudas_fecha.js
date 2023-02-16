fetch("/deudas")
  .then((response) => response.json())
  .then((data) => {
    data = data.filter((dato) => dato.deuda !== 0);

    data.sort(function (a, b) {
      return new Date(a.fecha) - new Date(b.fecha);
    });

    data = data.map(function (objeto) {
      return {
        fecha: objeto.fecha,
        deuda: Math.abs(objeto.deuda),
      };
    });

    var acumuladoPorFecha = {};

    data.reduce(function (acumulado, actual) {
      var fecha = actual.fecha;
      if (!acumuladoPorFecha.hasOwnProperty(fecha)) {
        acumuladoPorFecha[fecha] = 0;
      }
      acumuladoPorFecha[fecha] += actual.deuda;
      return acumulado;
    }, {});

    // Crea un array de objetos con las fechas y los acumulados
    var datosGrafico = Object.keys(acumuladoPorFecha).map(function (fecha) {
      return { x: fecha, y: acumuladoPorFecha[fecha] };
    });

    var ctx = document.getElementById("grafico-barras").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "line",
      data: {
        datasets: [
          {
            label: "Deuda acumulada",
            data: datosGrafico,
            backgroundColor: "rgba(255, 99, 132, 0.2)",
            borderColor: "rgba(255, 99, 132, 1)",
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        scales: {
          xAxes: [
            {
              type: "time",
              time: {
                unit: "day",
              },
            },
          ],
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
              },
            },
          ],
        },
      },
    });

    // Ajustar tamaño del canvas al tamaño de su contenedor
    function resizeChart() {
      var chartContainer = document.querySelector(".chart-container");
      var canvas = document.querySelector("#grafico-barras");
    }

    resizeChart();

    window.addEventListener("resize", function () {
      resizeChart();
      myChart.resize();
    });

    function addDeudaToTable(deuda) {
      if (deuda.deuda !== 0) {
        const tableBody = document.getElementById("deudas-body");
        const row = tableBody.insertRow();
        row.insertCell().innerText = deuda.fecha;
        row.insertCell().innerText = f.format(deuda.deuda);
      }
    }

    async function loadDeudas() {
      data.forEach(addDeudaToTable);
    }

    const f = new Intl.NumberFormat("en-US", {
      style: "currency",
      currency: "USD",
      minimumFractionDigits: 0,
    });

    loadDeudas();
  });
