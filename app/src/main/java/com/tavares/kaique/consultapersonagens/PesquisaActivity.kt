package com.tavares.kaique.consultapersonagens

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        //Colocando um action que é o meu botão
        BtnPesquisar.setOnClickListener {
            //Crio uma variavel que ira receber uma intenção da minha proxima tela de resultado
            val resultadoActivity = Intent(this,ResultadoActivity::class.java)
            //Colocando o ID que vamos capturar do usuario para dar GET na API
            //Aqui colocamos o putExtra damos um id e o valor vai ser meu editText que é um editableText.toString()
            resultadoActivity.putExtra("idValue",EtIDPersonagem.editableText.toString())
            //Iniciando a proxima tela passando o valor capturado pelo campo
            startActivity(resultadoActivity)
        }
    }
}
