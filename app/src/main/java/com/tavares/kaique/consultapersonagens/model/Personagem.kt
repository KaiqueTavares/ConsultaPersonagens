package com.tavares.kaique.consultapersonagens.model

import com.google.gson.annotations.SerializedName

/**
 * Created by kaiqu on 09/11/2018.
 */
//Isto aqui é um Class no new file
data class Personagem (
        //Vamos colocar em @SerializedName ("NOME PARAMETRO QUE PEDIR NA PROVA")
        //E colocar um val e o tipo para receber depois
        @SerializedName("name") val nome:String,
        @SerializedName("hair_color") val cabelo:String,
        @SerializedName("skin_color") val corPele:String,
        @SerializedName("birth_year") val aniversario:String,
        @SerializedName("gender") val genero:String)