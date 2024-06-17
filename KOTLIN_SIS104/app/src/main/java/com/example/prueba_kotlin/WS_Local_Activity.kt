package com.example.prueba_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_kotlin.backend.WSAcciones
import com.example.prueba_kotlin.backend.WSAuditoria
import com.example.prueba_kotlin.backend.WSDocumentos
import com.example.prueba_kotlin.backend.WSUsuarios
import com.example.prueba_kotlin.backend.WebServiceAPI2
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WS_Local_Activity : AppCompatActivity() {

    /*var listaAcciones: List<WSAcciones> = java.util.ArrayList<WSAcciones>()
    var listaAuditorias: List<WSAuditoria> = java.util.ArrayList<WSAuditoria>()
    var listaDocumentos: List<WSDocumentos> = java.util.ArrayList<WSDocumentos>()
    var listaUsuarios: List<WSUsuarios> = java.util.ArrayList<WSUsuarios>()*/
    var listaAcciones: List<WSAcciones> = ArrayList()
    var listaAuditorias: List<WSAuditoria> = ArrayList()
    var listaDocumentos: List<WSDocumentos> = ArrayList()
    var listaUsuarios: List<WSUsuarios> = ArrayList()

    private lateinit var textViewInfo: TextView
    private var startTime: Long = 0
    private var endTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws_local)
        textViewInfo = findViewById(R.id.textViewInfo)

        getTiendaOnline2()

    }

    fun getTiendaOnline2() {
        val URL_WS = "http://192.168.0.9/webservice/"
        val gson = GsonBuilder().setLenient().create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit2 = Retrofit.Builder()
            .baseUrl(URL_WS)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val webServiceApi: WebServiceAPI2 = retrofit2.create(WebServiceAPI2::class.java)
        startTime = System.currentTimeMillis()
        val requests: MutableList<Observable<*>> = ArrayList()
        requests.add(webServiceApi.getUsuariosObservable())
        requests.add(webServiceApi.getDocumentosObservable())
        requests.add(webServiceApi.getAuditoriasObservable())
        requests.add(webServiceApi.getAccionesObservable())
        val obs: Disposable = Observable.zip<Any, Any>(
            requests
        ) { objects ->
            /*listaUsuarios = objects[0] as List<WSUsuarios>
            listaDocumentos = objects[1] as List<WSDocumentos>
            listaAuditorias = objects[2] as List<WSAuditoria>
            listaAcciones = objects[3] as List<WSAcciones>*/
            listaUsuarios = (objects[0] as Map<String, WSUsuarios>).values.toList()
            listaDocumentos = (objects[1] as Map<String, WSDocumentos>).values.toList()
            listaAuditorias = (objects[2] as Map<String, WSAuditoria>).values.toList()
            listaAcciones = (objects[3] as Map<String, WSAcciones>).values.toList()
            Any()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<Any?>() {
                override fun onNext(o: Any) {
                    // Método requerido pero no necesitamos hacer nada aquí
                }

                override fun onError(e: Throwable) {
                    Log.d("Datos", "OnError ")
                }

                override fun onComplete() {
                    endTime = System.currentTimeMillis() // Capturar el tiempo de fin
                    val elapsedTime = endTime - startTime
                    Log.d("Datos", "Finalizado con éxito onComplete ")
                    val acciones: WSAcciones = listaAcciones[2]
                    val usuarios: WSUsuarios = listaUsuarios[2]
                    val auditorias: WSAuditoria = listaAuditorias[2]
                    val documentos: WSDocumentos = listaDocumentos[2]
                    val dato = StringBuilder()
                    dato.append("Servicio: Acciones \n\n")
                    dato.append("ID:").append(acciones.getId()).append("\n")
                    dato.append("Accion:").append(acciones.getAccion()).append("\n")
                    dato.append("Descripcion:").append(acciones.getDescripcion()).append("\n")
                    dato.append("Fecha:").append(acciones.getDescripcion()).append("\n\n")
                    dato.append("Servicio: Usuarios \n\n")
                    dato.append("ID:").append(usuarios.getId()).append("\n")
                    dato.append("Nombre:").append(usuarios.getNombre()).append("\n")
                    dato.append("Rol:").append(usuarios.getRol()).append("\n")
                    dato.append("Departamento:").append(usuarios.getDepartamento()).append("\n\n")
                    dato.append("Servicio: Auditorias \n\n")
                    dato.append("ID:").append(auditorias.getId()).append("\n")
                    dato.append("Fecha:").append(auditorias.getFecha()).append("\n")
                    dato.append("Actividad:").append(auditorias.getActividad()).append("\n")
                    dato.append("Resultado:").append(auditorias.getResultado()).append("\n\n")
                    dato.append("Servicio: Documentos \n\n")
                    dato.append("ID:").append(documentos.getId()).append("\n")
                    dato.append("Nombre:").append(documentos.getNombre()).append("\n")
                    dato.append("Categoria:").append(documentos.getCategoria()).append("\n")
                    dato.append("Fecha_Creacion:").append(documentos.getFechaCreacion()).append("\n\n")
                    dato.append("Tiempo de respuesta: ").append(elapsedTime).append(" ms").append("\n")
                    textViewInfo.text = dato.toString()
                }
            })
    }

}