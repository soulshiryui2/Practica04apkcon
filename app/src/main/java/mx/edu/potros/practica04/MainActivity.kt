package mx.edu.potros.practica04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesoK:EditText=findViewById(R.id.etKilos)
        val alturaE:EditText=findViewById(R.id.etEstatura)
        val calcular:Button=findViewById(R.id.btnCalcular)
        val imc:TextView=findViewById(R.id.tvIMC)
        val rango:TextView=findViewById(R.id.tvRange)

        calcular.setOnClickListener {
var peso: Double=0.0
     var estatura:Double = 0.0
            try {
                peso=pesoK.text.toString().toDouble()
                estatura=alturaE.text.toString().toDouble()
            }catch (e:java.lang.Exception){
                imc.setText("debe ingresar valores reales")
                print(e)
            }
            var resultado=calcularIMC(peso,estatura)
            val formattedNumber="%.2f".format(resultado)
            imc.setText(formattedNumber)
            var salud:String
            var color:Int

            when {
                resultado < 18.5 -> {
                    salud = "Bajo Peso"

                }

                resultado >= 18.5 && resultado <= 24.9 -> {
                    salud  = "Saludable"

                }

                resultado >= 25 && resultado < 29.9 -> {
                    salud = "Sobrepeso"

                }

                resultado >= 30 && resultado <= 34.9 -> {
                    salud = "Obesidad Grado FOUNDATION 1"

                }

                resultado >= 35 && resultado <= 39.9 -> {
                    salud = "Obesidad Grado 2"

                }

                resultado >= 40 ->
                {
                    salud = "Obesidad Grado 3"


            }
                else ->{
                    salud = "Error"

                }

            }

            rango.setText(salud)
        }

}
    fun calcularIMC(heigth:Double,weigth: Double): Double {
        return weigth / (heigth * heigth)
    }
    }



