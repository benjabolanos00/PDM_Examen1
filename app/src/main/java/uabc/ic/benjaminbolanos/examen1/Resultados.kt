package uabc.ic.benjaminbolanos.examen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.Exception

class Resultados : AppCompatActivity() {

    lateinit var archivo: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)
        leerArchivo()
        mostrarTexto()
    }

    fun leerArchivo(){
        val datos = intent.extras
        if(datos != null){
            archivo = datos.get("Archivo") as File
        }
    }

    fun mostrarTexto(){
        try {
            val tv = findViewById<TextView>(R.id.resultados_archivo_text)
            val fr = FileReader(archivo)
            val br = BufferedReader(fr)
            var linea = br.readLine()
            var texto = ""
            while(linea != null){
                texto += linea + "\n"
                linea = br.readLine()
            }
            tv.text = texto
        } catch (e:Exception){
            Log.i("Resultados", "No se ha creado el archivo")
        }

    }
}