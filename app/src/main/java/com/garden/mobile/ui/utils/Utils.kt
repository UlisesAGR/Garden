package com.garden.mobile.ui.utils

import android.content.Context
import android.widget.Toast
import com.garden.mobile.domian.model.Plant

const val TERMS =
    "<!DOCTYPE html><html><head><style>body{-webkit-text-size-adjust:300%; font-family:Arial; font-size:15; color:gray; border-radius:12px; background:#fff; padding:20px; margin:0px; } ol { counter-reset:list; padding:0px; margin:0px; } ol > li { list-style: none; display:grid; grid-template-columns:20px 1fr; gap:1rem; align-items:start; } ol > li:before { content:counter(list, lower-alpha) ')'; counter-increment:list; } </style> </head><body><ol><li>Participan clientes solo por invitaciÃ³n. MÃ¡s informaciÃ³n en el 55 2226 3639 de lunes a viernes de 8:00 a 21:00 h y sÃ¡bado de 9:00 a 18:00 h.</li><li>El monto mÃ­nimo a diferir es de $2,000.00 (dos mil pesos 00/100 M.N.) y el mÃ¡ximo es de $500,000.00 (quinientos mil pesos 00/100 M.N.).</li><li>Ãšnicamente el titular de la cuenta a quien haya sido enviada la promociÃ³n podrÃ¡ solicitar el diferimiento del saldo. Oferta sujeta a autorizaciÃ³n.</li><li>Aplican compras con tarjetas de crÃ©dito adicionales.</li><li>En caso de haber recibido una invitaciÃ³n a la promociÃ³n de meses con intereses, aplicarÃ¡n las condiciones descritas en dicha oferta. Ejemplo: tasa, plazo, vigencia, entre otros.</li><li>Aplica solo para tarjetas de crÃ©dito que se encuentren activas y al corriente en todos sus pagos.</li><li>La tasa de interÃ©s anual fija preferente aplicarÃ¡ Ãºnicamente al diferimiento del plan de Pagos Fijos Citibanamex.</li><li>El monto diferido correspondiente serÃ¡ cobrado dentro del pago mÃ­nimo indicado en el estado de cuenta de la tarjeta.</li><li>La primera mensualidad del plan de diferimiento se verÃ¡ reflejada en el estado de cuenta siguiente a la fecha de autorizaciÃ³n del plan de Pagos Fijos Citibanamex, por lo que para no caer en atraso, se debe hacer al menos el pago mÃ­nimo de dicho corte.</li><li>El programa de Pagos Fijos Citibanamex no aplica sobre otros programas o planes de pago previamente contratados.</li><li>Oferta vÃ¡lida siempre y cuando se conserve el mismo historial crediticio y la cuenta estÃ© al corriente en todos sus pagos.</li><li>Limitado a que la cuenta tenga un mÃ¡ximo de 10 Planes de Pago Diferidos.</li><li>Esta operaciÃ³n se celebra con la emisora de la tarjeta de crÃ©dito, Tarjetas Banamex S.A. de C.V. SOFOM, E.R., integrante del Grupo Financiero Banamex.</li><li>Oferta sujeta a autorizaciÃ³n y vÃ¡lida sÃ³lo por invitaciÃ³n. Aplican cambios sin previo aviso.</li><li>CitibanamexÂ® podrÃ¡ cancelar el plan de pagos diferidos si el cliente no realiza al menos el pago mÃ­nimo de la tarjeta de crÃ©dito en dos periodos de facturaciÃ³n consecutivos.</li><li>El diferimiento podrÃ¡ ser cancelado a decisiÃ³n del cliente en cualquier momento llamando al 55 2226 3639 de lunes a viernes de 8:00 a 21:00 h y sÃ¡bados de 9:00 a 18:00 h, el movimiento se verÃ¡ reflejado 24 horas hÃ¡biles posteriores. Al cancelar el servicio el monto pendiente del plan se integrarÃ¡ al saldo revolvente y aplicarÃ¡ la tasa de interÃ©s correspondiente a la tarjeta de crÃ©dito.</ol></body></html>"

fun getPlants() = (1..10).map {
    Plant(
        id = it,
        name = "Plant $it",
        description = "Mangoes are juicy stone fruit (drupe) from numerous species of tropical trees belonging to the flowering plant genus Mangifera, cultivated mostly for their edible fruit. The majority of these species are found in nature as wild mangoes. The genus belongs to the cashew family Anacardiaceae. Mangoes are native to South Asia, from where the 'common mango' or 'Indian mango', Mangifera indica, has been distributed worldwide to become one of the most widely cultivated fruits in the tropics. Other Mangifera species (e.g. horse mango, Mangifera foetida) are grown on a more localized basis. It is the national fruit of India, Pakistan, and the Philippines, and the national tree of Bangladesh.",
        type = "Sol",
        plantDate = "May 7, 2024",
        growZoneNumber = 1,
        wateringInterval = 1,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/67/Mangos_criollos_y_pera.JPG",
    )
}

fun Context.showToast(text: String?) {
    if (!text.isNullOrBlank()) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
