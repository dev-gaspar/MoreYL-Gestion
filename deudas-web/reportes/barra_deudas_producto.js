fetch("/deudas")
  .then((response) => response.json())
  .then((data) => {
    data = data.filter((dato) => dato.deuda !== 0);

    var resultado = data.reduce(function (acumulador, valorActual) {
      var producto = valorActual.producto;
      var deuda = valorActual.deuda;
      if (!acumulador[producto]) {
        acumulador[producto] = { producto: producto, deuda: 0 };
      }
      acumulador[producto].deuda += deuda;
      return acumulador;
    }, {});

    resultado = Object.values(resultado);

    console.log(resultado);

    var colores = [
      "#FF6384",
      "#36A2EB",
      "#FFCE56",
      "#4BC0C0",
      "#9966FF",
      "#FF9933",
      "#FF6666",
      "#33CC99",
      "#CC66CC",
      "#6699FF",
      "#FF99CC",
      "#66CCCC",
      "#99CC66",
      "#FFCC66",
      "#9933FF",
      "#CC9999",
      "#33CCFF",
      "#FF99FF",
      "#99CCFF",
      "#CC66FF",
      "#66FF66",
      "#FFCC99",
      "#6699CC",
      "#FF99FF",
      "#FF6666",
      "#CCFFCC",
      "#CCFFFF",
      "#FFCCCC",
      "#99FF99",
      "#CC99CC",
      "#CCCCFF",
      "#FF9966",
      "#FFCCCC",
      "#CCCC99",
      "#FF99CC",
      "#99FFCC",
      "#FF9966",
      "#66FFCC",
      "#CCFF99",
      "#FFFF66",
      "#66CCFF",
      "#FF6666",
      "#CCFF66",
      "#CCFFFF",
      "#CC99FF",
      "#99CCCC",
      "#99FF99",
      "#FF9966",
      "#CCFFCC",
      "#CCCCFF",
      "#FF6666",
      "#FFFF99",
      "#99CCFF",
      "#FFCCFF",
      "#99CC99",
      "#FFCC66",
      "#CC99FF",
      "#99FF99",
      "#FFCC99",
      "#FF99FF",
      "#CCFF99",
      "#CCFFCC",
      "#FFFF99",
      "#99CCCC",
      "#99FFCC",
      "#CCFFFF",
      "#CC99CC",
      "#99CC99",
    ];

    var ctx = document.getElementById("grafico-barras").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: resultado.map((dato) => dato.producto),
        datasets: [
          {
            label: "Monto de deudas",
            data: resultado.map((dato) => dato.deuda),
            backgroundColor: colores,
          },
        ],
      },
      options: {
        scales: {
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
  });
