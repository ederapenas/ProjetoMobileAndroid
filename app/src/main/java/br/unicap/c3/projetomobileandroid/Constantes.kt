package br.unicap.c3.projetomobileandroid

object Constantes{

    const val USUARIO: String = "usuario"
    const val TOTAL_PERGUNTAS: String = "total_perguntas"
    const val RESPOSTAS_CERTAS: String = "respostas_certas"

    fun getPerguntas(): ArrayList<Pergunta>{
        val listaPerguntas = ArrayList<Pergunta>()

        val pg1 = Pergunta(1, "O que o homem de ferro disse antes de morrer?",
        R.drawable.img,
            "Eu sou inevitavel",
            "Perdeu otario",
        "Eu sou o homem de ferro",
            "Shazam!", 3)
        listaPerguntas.add(pg1)

        val pg2 = Pergunta(2, "Apos receber o pikachu, qual foi o primeiro pokemon que o Ash capturou?",
        R.drawable.img_1,
            "Charmander",
            "Caterpie",
            "Pidgey",
            "Gengar", 2)
        listaPerguntas.add(pg2)

        val pg3 = Pergunta(3, "Qual a profissão do Mário?",
        R.drawable.img_2,
        "Encanador",
        "Marinheiro",
        "Professor de História",
        "Jornalista", 1)
        listaPerguntas.add(pg3)

        val pg4 = Pergunta(4, "Qual a famosa frase do Darth Vader?",
        R.drawable.img_3,
            "Luke, voce vai cair",
            "Luke, cadê você meu filho?",
            "Que a força esteja com você!",
        "Luke, eu sou seu pai", 4)
        listaPerguntas.add(pg4)

        val pg5 = Pergunta(5,"O que você vai precisar caso o universo acabe?",
        R.drawable.img_4,
        "Uma toalha",
        "Uma arma",
        "Oxigenio",
        "Um sabre de luz", 1)
        listaPerguntas.add(pg5)

        val pg6 = Pergunta(6, "Em Stranger things, qual musica salvou a vida da Max?",
        R.drawable.img_5,
            "Pass the dutchie",
            "Running up that hill",
        "Final Countdown",
        "Bohemian Rhapsody", 2)
        listaPerguntas.add(pg6)

        val pg7 = Pergunta(7, "Quem é O Escolhido, em Star Wars?",
        R.drawable.img_6,
        "Obi-Wan Kenobi",
        "Rey",
        "Luke Skywalker",
        "Anakin Skywalker", 4)
        listaPerguntas.add(pg7)

        val pg8 = Pergunta(8, "Qual o nome da Akuma no Mi do Luffy?",
        R.drawable.img_7,
            "Gomu Gomu no Mi",
            "Ito Ito no Mi",
            "Hito Hito no Mi",
            "Mera Mera no Mi", 3)
        listaPerguntas.add(pg8)

        val pg9 = Pergunta(9, "Em Haikyuu, qual numero do Hinata?",
        R.drawable.img_8,
            "5",
        "4",
        "10",
        "9", 3)
        listaPerguntas.add(pg9)

        val pg10 = Pergunta(10, "Qual o ponto fraco do Super homem?",
        R.drawable.img_9,
            "Suco de uva",
        "Kryptonita",
        "Chumbo",
        "Martha", 2)
        listaPerguntas.add(pg10)

        return listaPerguntas
    }
}