package com.tavares.kaique.consultapersonagens

import android.content.Intent
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
            //onFailure vai executar quando der falha em pegar meu JSON na API
            override fun onFailure(call: Call<Personagem>?, t: Throwable?) {
                //Dando a mensagem de erro em caso de falha de dados
                Toast.makeText(this@ResultadoActivity,
                        "Falha no recebimento de dados",
                        Toast.LENGTH_SHORT).show()
            }

            //Aqui se der tudo certo eu vou:
            override fun onResponse(call: Call<Personagem>?, response: Response<Personagem>?) {
                //Vou pegar meu JSON codificado e assim vou conseguir fazer pegar meu TEXT e colocar o valor que veio do JSON
                val personagem = response?.body()
                //Pegando meus TextView e colocando os valores trazidos pela API
                tvNome.text = personagem?.nome
                tvCabelo.text = personagem?.cabelo
                tvPele.text = personagem?.corPele
                tvAno.text = personagem?.aniversario
                tvGenero.text = personagem?.genero
            }
        })

        //Ao clicar no personagem de voltar
        btnVoltar.setOnClickListener {
            //Finalizo minha activity
            finish()
        }

        //Ao clicar no botão sobre
        btnSobre.setOnClickListener {
            //Vou abrir a tela sobre
            val telaSobre = Intent(this,SobreActivity::class.java)
            startActivity(telaSobre)
        }

    }
}
