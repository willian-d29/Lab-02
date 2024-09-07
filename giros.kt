fun main() {
    // Definir el monto total 
    val montoTotal = 1060.50 

    val tolerancia = 0.01
    var giro = 0.0
    var encontrado = false

    while (!encontrado) {
        val comision = calcularComision(giro)
        val impuestos = calcularImpuestos(giro)

        val montoCalculado = redondearAnterior(giro + comision + impuestos)

        if (kotlin.math.abs(montoCalculado - montoTotal) < tolerancia) {
            encontrado = true
        } else {
            giro += 0.01 
        }
    }

    println("El monto de giro es: %.1f".format(giro))
}

fun calcularComision(giro: Double): Double {
    return when {
        giro <= 1000 -> 5.0
        giro > 1000 && giro <= 10001 -> 0.005 * giro
        else -> 0.015 * giro
    }
}

fun calcularImpuestos(giro: Double): Double {
    return giro * 0.00005 / 100
}

fun redondearAnterior(numero: Double): Double {
    return kotlin.math.floor(numero * 10) / 10.0
}
