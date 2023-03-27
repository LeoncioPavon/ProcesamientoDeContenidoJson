package com.example.procesamientodecontenidojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private lateinit var edName: EditText
    private lateinit var edLastName: EditText
    private lateinit var edFechaNac: EditText
    private lateinit var edTitulo: EditText
    private lateinit var edEmail: EditText
    private lateinit var edFac: EditText
    private lateinit var  btnAdd: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        edLastName = findViewById(R.id.edLastName)
        edFechaNac = findViewById(R.id.edFechaNac)
        edTitulo = findViewById(R.id.edTitulo)
        edEmail = findViewById(R.id.edEmail)
        edFac = findViewById(R.id.edFac)
        btnAdd = findViewById(R.id.btnAdd)
    }

    fun clickbtnAdd(view: View){
        val url = "http://192.168.1.67/MyUca/insertarCoord.php"
        val q =  Volley.newRequestQueue(this)
        var resultPost = object : StringRequest(Request.Method.POST,url,
            Response.Listener<String>{ response ->
                Toast.makeText(this, "Registro insertado exitosamente", Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                Toast.makeText(this, "Error al insertar el registro", Toast.LENGTH_LONG).show()
            }) {
            override fun getParams(): MutableMap<String, String>{
                val params = HashMap<String, String>()
                params.put("nombres", edName.text.toString())
                params.put("apellidos", edLastName.text.toString())
                params.put("fechaNac", edFechaNac.text.toString())
                params.put("titulo", edTitulo.text.toString())
                params.put("email", edEmail.text.toString())
                params.put("facultad", edFac.text.toString())

                return params
            }
        }
        q.add(resultPost)
    }
}

