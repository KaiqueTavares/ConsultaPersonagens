package com.tavares.kaique.consultapersonagens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tavares.kaique.consultapersonagens.api.PersonagemService
import com.tavares.kaique.consultapersonagens.model.Personagem
import kotlinx.android.synthetic.main.activity_resultado.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Recuperando o valor do ID que o usuario colocou
        //Lembre-se que devo pegar meu name que passei la no putExtra da tela PesquisaActivity
        val idValue = intent.getStringExtra("idValue")

        //Chamando o serviço lembre-se que esta no site do RetroFit isto.
        val retrofit = Retrofit.Builder()
                //Aqui vou passar a url do meu serviço até chegar no meu PATH
                .baseUrl("https://swapi.co/api/people/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //Coloque o seu Service no que ficar em vermelho se copiou do RetroFit
        val service = retrofit.create<PersonagemService>(PersonagemService::class.java!!)
        //Aqui vou buscar meus personagens passando como meu parametro o ID que estou recuperando no começo deste codigo
        //GetStringExtra do começo do codigo
        service.buscarPersonagem(idValue.toString()).enqueue(object : Callback<Personagem>{
            override fun onFailure(call: Call<Personagem>?, t: Throwable?) {
                Toast.makeText(this@ResultadoActivity,
                        "Falha no recebimento de dados",
                        Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Personagem>?, response: Response<Personagem>?) {
                val personagem = response?.body()
                tvNome.text = personagem?.nome
                tvCabelo.text = personagem?.cabelo
                tvPele.text = personagem?.corPele
                tvAno.text = personagem?.aniversario
                tvGenero.text = personagem?.genero
            }
        })
    }
}
