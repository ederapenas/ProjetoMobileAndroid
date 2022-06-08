package br.unicap.c3.projetomobileandroid

data class Pergunta(
    val id: Int,
    val pergunta: String,
    val imagem: Int,
    val alternativaUm: String,
    val alternativaDois: String,
    val alternativaTres: String,
    val alternativaQuatro: String,
    val alternativaCerta: Int
)