package com.example.myapplication

import org.junit.Test

//Ejercicio 1: Creando una computadora
data class Computadora(
    var RAM:Double,
    var almacenamiento: Double,
    var sistemaOperativo: String,
    val programaInstalado: List<String>,
    var encendida: Boolean = false
) {

    fun encender(){
        if (!encendida){
            encendida = true
            println("La computadora esta encedida")
        } else{
            println("La computadora ya esta encendida")
        }
    }
    fun apagar(){
        if(encendida) {
            encendida = false
            println("La computadora esta apagada")
        } else {
            println("La computadora ya esta apagada")
        }
    }
    fun actualizarRAM(nuevaRam: Double) :Double {
        RAM += nuevaRam
        return RAM
    }
    fun actualizarAlmacenamiento(nuevoAlmacenamiento: Double): Double{
        almacenamiento += nuevoAlmacenamiento
        return almacenamiento
    }
    fun actualizarSO(nuevoSo: String): String{
        sistemaOperativo = nuevoSo
        return sistemaOperativo
    }
}

//Ejercicio2: Una nueva marca de calculadoras?
data class Calculadora(
    val modelo: String,
    val aniosVida: Int,
    var precio: Double
){
    fun sumar(num1: Double, num2:Double): Double {
        return num1+num2
    }
    fun restar(num1: Double, num2:Double): Double {
        return num1-num2
    }
    fun multiplicacion(num1: Double, num2:Double): Double {
        return num1*num2
    }
    fun division(num1: Double, num2:Double): Double {
        return (if(num2 != 0.0){
            num1/num2
        }else{
            println("No se puede dividir un numero entre 0. (No existe)")
            Double.POSITIVE_INFINITY
        }) as Double
    }
}

//Ejercicio 3: Pasando lista
data class Estudiante(
    val nombre: String,
    val carnet: Int,
    val asignatura: String
)
class Ejercicios {
    @Test
    fun main() {
        val programasEstablecidos = listOf(
            "Notepad2026",
            "Chrome2026",
            "Photoshop2020",
            "VSCode2025",
            "Spotify2026",
            "Slack2022",
            "Zoom2026",
            "Firefox2018",
            "Edge2026",
            "Illustrator2017"
        )

        val MiComputadora = Computadora(
            8.0,
            almacenamiento = 128.0,
            sistemaOperativo = "Windows",
            programaInstalado = programasEstablecidos,
            encendida = false,
        )

        MiComputadora.encender()

        println("RAM antes: ${MiComputadora.RAM}")
        MiComputadora.actualizarRAM(8.0)
        println("RAM despues: ${MiComputadora.RAM}")

        println("Almacenamiento antes: ${MiComputadora.almacenamiento}")
        MiComputadora.actualizarAlmacenamiento(128.0)
        println("Almacenamiento despues: ${MiComputadora.almacenamiento}")

        println("Sistema Operativo antes: ${MiComputadora.sistemaOperativo}")
        MiComputadora.actualizarSO("Linux")
        println("Sistema Operativo despues: ${MiComputadora.sistemaOperativo}")

        val programasAnioActual = programasEstablecidos.filter { it.contains("2026") }
        println("$programasAnioActual")

        MiComputadora.apagar()

        val MiCalculadora = Calculadora(
            "Texas Instruments (TI)",
            10,
            200.0
        )
        println("100.0 + 40.0 = ${MiCalculadora.sumar(100.0, 40.0)}")
        println("350.0 - 400.0 =${MiCalculadora.restar(350.0, 400.0)}")
        println("9.0 * 4.0 = ${MiCalculadora.multiplicacion(9.0, 4.0)}")
        println("0.0 * 2.0 = ${MiCalculadora.multiplicacion(0.0, 2.0)}")
        println("120.0 / 12.0 = ${MiCalculadora.division(120.0, 12.0)}")
        println("40.0 / 0.0 = ${MiCalculadora.division(40.0, 0.0)}")


        val Ciclo01 = listOf(
            Estudiante("Julian", 19201318, "PDM"),
            Estudiante("Andrea", 23441023, "Analisis Numerico"),
            Estudiante("Javier", 45723120, "PDM"),
            Estudiante("Daniel", 98231324, "Analisis Numerico"),
            Estudiante("Nicole", 46289219, "PDM"),
            Estudiante("Alisson", 34590110, "Analisis Numerico"),
            Estudiante("Michelle", 12321324, "Analisis Numerico")
        )

        val asistencia = Ciclo01.filter { it.asignatura == "PDM" }
        println("Los estudiantes son: $asistencia")
    }
}


