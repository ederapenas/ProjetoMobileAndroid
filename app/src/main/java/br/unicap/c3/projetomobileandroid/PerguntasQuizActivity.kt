package br.unicap.c3.projetomobileandroid

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class PerguntasQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var nPosicaoAtual: Int = 1
    private var nListaPergunta: ArrayList<Pergunta>? = null
    private var nPosicaoSelecionadaAtual: Int = 0
    private var nRespostasCorretas: Int = 0
    private var nUsuario: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas_quiz)

        nUsuario = intent.getStringExtra(Constantes.USUARIO)

        nListaPergunta = Constantes.getPerguntas()

        setPergunta()

        val opcaoUm = findViewById<TextView>(R.id.tv_primeira_opcao)
        val opcaoDois = findViewById<TextView>(R.id.tv_segunda_opcao)
        val opcaoTres = findViewById<TextView>(R.id.tv_terceira_opcao)
        val opcaoQuatro = findViewById<TextView>(R.id.tv_quarta_opcao)
        val btn_responder = findViewById<Button>(R.id.btn_responder)

        opcaoUm.setOnClickListener(this)
        opcaoDois.setOnClickListener(this)
        opcaoTres.setOnClickListener(this)
        opcaoQuatro.setOnClickListener(this)
        btn_responder.setOnClickListener(this)


    }

    private fun setPergunta(){
        val pergunta = nListaPergunta!![nPosicaoAtual - 1]

        opcoesIniciais()

        if(nPosicaoAtual == nListaPergunta!!.size){
            findViewById<Button>(R.id.btn_responder).text = "TERMINAR!"
        }else{
            findViewById<Button>(R.id.btn_responder).text = "POP!"
        }

        findViewById<ProgressBar>(R.id.barra_progresso).progress = nPosicaoAtual
        findViewById<TextView>(R.id.tv_progresso).text = "$nPosicaoAtual " + "/" + findViewById<ProgressBar>(R.id.barra_progresso).max

        findViewById<TextView>(R.id.tv_pergunta).text = pergunta!!.pergunta
        findViewById<ImageView>(R.id.iv_imagem).setImageResource(pergunta.imagem)
        findViewById<TextView>(R.id.tv_primeira_opcao).text = pergunta.alternativaUm
        findViewById<TextView>(R.id.tv_segunda_opcao).text = pergunta.alternativaDois
        findViewById<TextView>(R.id.tv_terceira_opcao).text = pergunta.alternativaTres
        findViewById<TextView>(R.id.tv_quarta_opcao).text = pergunta.alternativaQuatro
    }

    private fun opcoesIniciais(){
        val opcoes = ArrayList<TextView>()
        opcoes.add(0, findViewById<TextView>(R.id.tv_primeira_opcao))
        opcoes.add(1, findViewById<TextView>(R.id.tv_segunda_opcao))
        opcoes.add(2, findViewById<TextView>(R.id.tv_terceira_opcao))
        opcoes.add(3, findViewById<TextView>(R.id.tv_quarta_opcao))

        for(opcao in opcoes){
            opcao.setTextColor(Color.parseColor("#7A8089"))
            opcao.typeface = Typeface.DEFAULT
            opcao.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_primeira_opcao ->{
                opcaoSelecionada(findViewById(R.id.tv_primeira_opcao), 1)
            }
            R.id.tv_segunda_opcao ->{
                opcaoSelecionada(findViewById(R.id.tv_segunda_opcao), 2)
            }
            R.id.tv_terceira_opcao ->{
                opcaoSelecionada(findViewById(R.id.tv_terceira_opcao), 3)
            }
            R.id.tv_quarta_opcao ->{
                opcaoSelecionada(findViewById(R.id.tv_quarta_opcao), 4)
            }
            R.id.btn_responder ->{
                if(nPosicaoSelecionadaAtual == 0){
                    nPosicaoAtual++

                    when{
                        nPosicaoAtual <= nListaPergunta!!.size ->{
                            setPergunta()
                        }else->{
                            val intent = Intent(this, ResultadosActivity::class.java)
                            intent.putExtra(Constantes.USUARIO, nUsuario)
                            intent.putExtra(Constantes.RESPOSTAS_CERTAS, nRespostasCorretas)
                            intent.putExtra(Constantes.TOTAL_PERGUNTAS, nListaPergunta!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val pergunta = nListaPergunta?.get(nPosicaoAtual - 1)
                    if(pergunta!!.alternativaCerta != nPosicaoSelecionadaAtual){
                        pegarResposta(nPosicaoSelecionadaAtual, R.drawable.wrong_option_border_bg)

                    }else{
                        nRespostasCorretas++
                    }
                    pegarResposta(pergunta.alternativaCerta, R.drawable.correct_option_border_bg)

                    if(nPosicaoAtual == nListaPergunta!!.size){
                        findViewById<Button>(R.id.btn_responder).text = "TERMINAR!"
                    }else{
                        findViewById<Button>(R.id.btn_responder).text = "PROXIMA PERGUNTA!"
                    }
                    nPosicaoSelecionadaAtual = 0
                }
            }
        }
    }

    private fun pegarResposta(resposta: Int, drawableView: Int){
        when(resposta){
            1->{
                findViewById<TextView>(R.id.tv_primeira_opcao).background = ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                findViewById<TextView>(R.id.tv_segunda_opcao).background = ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                findViewById<TextView>(R.id.tv_terceira_opcao).background = ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                findViewById<TextView>(R.id.tv_quarta_opcao).background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun opcaoSelecionada(tv: TextView, selecionado: Int){
        opcoesIniciais()
        nPosicaoSelecionadaAtual = selecionado

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}