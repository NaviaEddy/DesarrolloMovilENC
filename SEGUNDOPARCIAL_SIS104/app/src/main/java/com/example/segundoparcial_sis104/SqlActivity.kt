package com.example.segundoparcial_sis104

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.segundoparcial_sis104.Backend.BaseDatos
import com.example.segundoparcial_sis104.Backend.WSPuntos
import com.example.segundoparcial_sis104.Backend.WebService
import com.example.segundoparcial_sis104.Backend.ecuacion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sqrt

class SqlActivity : AppCompatActivity() {

    var dbHandler: BaseDatos? = null
    var listTasks: List<ecuacion> = ArrayList<ecuacion>()

    private lateinit var textViewInfo: TextView
    private lateinit var textViewResult: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql)

        dbHandler = BaseDatos(this)
        textViewInfo = findViewById(R.id.textViewInfo)
        textViewResult = findViewById(R.id.TextViewResultado)

        val buttCalcular = findViewById<Button>(R.id.buttonCalcular)

        getDataPuntos()



        val stringBuilder = StringBuilder()
        buttCalcular.setOnClickListener {
            listTasks = (dbHandler as BaseDatos).d_result

            if (listTasks.isEmpty()) {
                Log.d("Sqlite", "No results found in database")
                textViewResult.setText("No results found")
                return@setOnClickListener
            }

            for (ecuacion in listTasks) {
                stringBuilder.append("${ecuacion.d}")
                break
            }

            textViewResult.setText(stringBuilder.toString())
        }

    }

    fun calcular_ecuacion(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
    }

    fun getDataPuntos() {
        val URL_WS = "http://192.168.0.9/WS_SegundoParcial/puntos.php/"
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_WS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val webServiceApi: WebService = retrofit.create(WebService::class.java)
        val call: Call<Map<String, WSPuntos>> = webServiceApi.getpuntos()
        call.enqueue(object : Callback<Map<String, WSPuntos>> {
            override fun onResponse(
                call: Call<Map<String, WSPuntos>>, response: Response<Map<String, WSPuntos>>
            ) {
                if (response.isSuccessful) {
                    val dataMap = response.body() ?: return
                    val p_ecuacion = ecuacion()
                    val userInfoBuilder = StringBuilder()
                    for (entry in dataMap.entries) {
                        val punto = entry.value
                        userInfoBuilder.append("---------------------------------------\n")
                        userInfoBuilder.append("x1: ").append(punto.getX1()).append("\n")
                        p_ecuacion.x1 = punto.getX1()!!
                        userInfoBuilder.append("y1: ").append(punto.getY1()).append("\n")
                        p_ecuacion.y1 = punto.getY1()!!
                        userInfoBuilder.append("x2: ").append(punto.getX2()).append("\n")
                        p_ecuacion.x2 = punto.getX2()!!
                        userInfoBuilder.append("y2: ").append(punto.getY2()).append("\n")
                        userInfoBuilder.append("---------------------------------------\n")
                        p_ecuacion.y2 = punto.getY2()!!
                        p_ecuacion.d = calcular_ecuacion(punto.getX1()!!, punto.getY1()!!, punto.getX2()!!, punto.getY2()!!)
                        val success = dbHandler?.addResultado(p_ecuacion)?:false
                        val mensaje = if(success){
                            /*Log.d("Sqlite", "--->${punto.getX1()!!}")
                            Log.d("Sqlite", "--->${punto.getY1()!!}")
                            Log.d("Sqlite", "--->${punto.getX2()!!}")
                            Log.d("Sqlite", "--->${punto.getY2()!!}")
                            Log.d("Sqlite", "--->${calcular_ecuacion(punto.getX1()!!, punto.getY1()!!, punto.getX2()!!, punto.getY2()!!)}")*/
                            "Insercion exitosa"
                        } else {
                            "No se pudo insertar"
                        }
                        Log.d("Sqlite", "--->$mensaje")
                        break
                    }

                    // Mostrar la información en el TextView
                    textViewInfo.text = userInfoBuilder.toString()
                } else {
                    Toast.makeText(this@SqlActivity, "Algo paso", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Map<String, WSPuntos>>, throwable: Throwable) {
                Toast.makeText(
                    this@SqlActivity,
                    "REVISE EL SERVICIO WEB DE INTERNET",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

}