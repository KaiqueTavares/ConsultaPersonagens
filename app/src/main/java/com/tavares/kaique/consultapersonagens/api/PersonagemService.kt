package com.tavares.kaique.consultapersonagens.api

import com.tavares.kaique.consultapersonagens.model.Personagem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by kaiqu on 09/11/2018.
 */
//Isto aqui é um new file do tipo Interface
interface PersonagemService {
    //Estou dando um get e passo o final de minha URL
    //Aonde esta {SERA A PARTE RANDOMICA DA API QUE O USUARIO INPUTA PELO EDIT TEXT DA TELA PESQUISA ACTIVITY}
    @GET("{id}")
    //Crio uma função para buscar aonde meu @Path vai ser o Querry acima que esta em {VALOR USUARIO}
    //Crio uma variavel que vou usar depois
    //LEMBRE-SE DO :Call<SeuModel>
    fun buscarPersonagem(@Path("id") id:String):Call<Personagem>
}