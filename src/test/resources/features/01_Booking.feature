@tag
Feature: Compra de Tickets de PeruRail

  @CompraTicketTrenBelmond @regresion
  Scenario Outline: 1 - Validar compra de ticket con servico de tren Belmond
    Given Ingreso a la web de PeruRail
    And selecciono tipo de ticket "<tipoTicket>", destino "<destino>", ruta "<ruta>"
    And selecciono tren "<tren>"
    And selecciono fecha salida "<fechaSalida>"
    And consulto ticket
    And selecciono tipo cabina "<tipoCabina>" y numero de cabinas "<nroCabinas>"
    And ingreso cantidad de pasajeros "<grupoAdultos>" adultos y "<grupoNinos>" ninos por cabina
    And ingreso datos personales de los pasajeros Belmond
    And realizo compra según medio de pago "<medioPago>"
    Then valido el monto pagado por servicio Belmond

    Examples: 
      | tipoTicket | destino | ruta         | tren                             | fechaSalida | tipoCabina   | nroCabinas | grupoAdultos | grupoNinos | medioPago |
      | One Way    | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 18-05-2022  | SUITE CABINS | 1 CABIN    |            1 |          0 | visa      |
      | One Way    | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | 18-05-2022  | SUITE CABINS | 2 CABINS   | 1-1          | 0-1        | visa      |

  @CompraTicketTrenExpedition @regresion
  Scenario Outline: 2 - Validar compra de ticket con servico de tren Expedition
    Given Ingreso a la web de PeruRail
    And selecciono tipo de ticket "<tipoTicket>", destino "<destino>", ruta "<ruta>"
    And selecciono fecha salida "<fechaSalida>" y fecha retorno "<fechaRetorno>"
    And ingreso cantidad de pasajeros "<nroAdultos>" adultos y "<nroNinos>" ninos
    And consulto ticket
    And selecciono tren salida "<trenSalida>" y tren retorno "<trenRetorno>"
    And ingreso datos personales de los pasajeros Expedition
    And realizo compra en Expedition según medio de pago "<medioPago>"
    Then valido el monto pagado por servicio Expedition

    Examples: 
      | tipoTicket | destino      | ruta                 | fechaSalida | fechaRetorno | nroAdultos | nroNinos | trenSalida    | trenRetorno  | medioPago |
      | Round trip | Machu Picchu | Cusco > Machu Picchu | 18-05-2022  | 18-05-2022   |          1 |        0 | Expedition 33 | Vistadome 34 | visa      |
      | Round trip | Machu Picchu | Cusco > Machu Picchu | 18-05-2022  | 18-05-2022   |          2 |        2 | Expedition 33 | Vistadome 34 | visa      |

  @ValidarNroMaximoPasajerosExpedition @regresion
  Scenario Outline: 3 - Validar mensaje de error al tratar de registrar mas de 9 pasajeros
    Given Ingreso a la web de PeruRail
    And selecciono tipo de ticket "<tipoTicket>", destino "<destino>", ruta "<ruta>"
    And selecciono fecha salida "<fechaSalida>" y fecha retorno "<fechaRetorno>"
    And ingreso cantidad de pasajeros "<nroAdultos>" adultos y "<nroNinos>" ninos
    Then debe mostrarse mensaje de error "Only up to 9 tickets"

    Examples: 
      | tipoTicket | destino      | ruta                 | fechaSalida | fechaRetorno | nroAdultos | nroNinos |
      | One Way    | Machu Picchu | Cusco > Machu Picchu | 13-06-2022  | No Aplica    |          5 |        5 |
      | Round trip | Machu Picchu | Cusco > Machu Picchu | 14-06-2022  | 16-06-2022   |          1 |        9 |
      | Round trip | Machu Picchu | Cusco > Machu Picchu | 15-06-2022  | 28-06-2022   |          9 |        1 |
