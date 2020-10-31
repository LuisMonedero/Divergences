package com.example.divergences

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*


class Teatro : AppCompatActivity(){
    private var  mplayer : MediaPlayer? = null
    private var  mplayer2 : MediaPlayer? = null
    private var  mplayer3 : MediaPlayer? = null
    private var  mplayer4 : MediaPlayer? = null
    private var  pj1 :ImageView? = null
    private var  pj2 : ImageView? = null
    private var  iconoGuardado : ImageView? = null
    private var  logo : ImageView? = null
    private var  animation : Animation? = null
    private var  animation2 : Animation? = null
    private var  animation3 : Animation? = null
    private var  animation4 : Animation? = null
    private var  animationGuardado : Animation? = null
    private var  animationTitulo : Animation? = null
    private var  cont : Int = 0
    private var  texto : TextView? = null
    private var  nombre : TextView? = null
    private var  capitulo : TextView? = null
    private var  fondo : ConstraintLayout? = null
    private var  fondoanim : ConstraintLayout? = null
    private var  fondoClicks : ConstraintLayout? = null
    private var  cap : Int = 0
    private var  bundle : Bundle? = null
    private var  opciones : FragmentoOpciones? = null
    private var  partida : Game? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teatro)
        pj1 = findViewById(R.id.imagePrimario)
        pj2 = findViewById(R.id.imageSecundario)
        logo = findViewById(R.id.imageView3)
        fondo = findViewById(R.id.layout)
        fondoanim = findViewById(R.id.fondoanim)
        fondoClicks = findViewById(R.id.clicks)
        fondoClicks!!.setOnClickListener(View.OnClickListener { interaccion() })
        mplayer = MediaPlayer.create(this, R.raw.happy_day)
        mplayer2 = MediaPlayer.create(this, R.raw.click)
        mplayer4 = MediaPlayer.create(this, R.raw.ding_dong)
        mplayer!!.isLooping = true
        iconoGuardado = findViewById(R.id.guardado)
        animation = AnimationUtils.loadAnimation(this, R.anim.pj2saldeescena)
        animationGuardado = AnimationUtils.loadAnimation(this, R.anim.rotacion_guardado)
        capitulo = findViewById(R.id.capitulo)
        bundle = Bundle()
        miPartida()
    }
    override fun onStart(){
        super.onStart()
        val  flags = (android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
                or android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        window.decorView.systemUiVisibility = flags
        mplayer!!.start()
    }
    fun interaccion(){
        texto = findViewById(R.id.textView2)
        nombre = findViewById(R.id.nombre)
        mplayer2!!.start()

        //CAPITULO1
        if (cap == 1){
            when(cont) {
                -1 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_academy)
                    texto!!.visibility = View.INVISIBLE
                    nombre!!.visibility = View.INVISIBLE
                    logo!!.visibility = View.VISIBLE
                    capitulo!!.text = "CAPITULO $cap"
                    capitulo!!.visibility = View.VISIBLE
                    animationTitulo = AnimationUtils.loadAnimation(this, R.anim.titulo_rotado)
                }
                0 -> {
                    capitulo!!.visibility = View.INVISIBLE
                    logo!!.visibility = View.INVISIBLE
                    texto!!.visibility = View.VISIBLE
                    nombre!!.visibility = View.VISIBLE
                    nombre!!.text = "¿¿??"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "La academia Kibougamine..."
                }
                1 -> texto!!.text =
                    "Esta academia privilegiada y acreditada federalmente, escoge a los mejores estudiantes de todo el país con el fin de prepararles para ser lo mejor de lo mejor."
                2 -> {
                    desapareceFondo()
                    texto!!.text =
                        "Se dice que graduarse allí garantiza una vida de éxito. Y hoy era ese día; el día en que comenzaría mi vida escolar en la academia Kibougamine."
                }
                3 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_cocina_house)
                    apareceFondo()
                    aparecer(pj1!!)
                    pj1!!.setImageResource(R.drawable.naegi1)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text =
                        "Me llamo Naegi Makoto y aunque parezca un estudiante normal y corriente, conseguí una plaza en esta academia sin demasiados problemas."
                }
                4 -> {
                    pj1!!.setImageResource(R.drawable.naegi2)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Bueno... ¡Vamos allá!"
                }
                5 -> {
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text =
                        "Me dirigí hacia la puerta dispuesto a asistir a mi primer día a la academia cuando..."
                }
                6 -> {
                    pj2!!.setImageResource(R.drawable.komaru1)
                    cambioAPj2()
                    nombre!!.text = "¿¿??"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Heyyy!"
                }
                7 -> {
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text =
                        "Esta es mi hermana pequeña Komaru. Está muy orgullosa de que haya conseguido entrar en la academia Kibougamine."
                }
                8 -> texto!!.text =
                    "Ella también aspira a entrar el año que viene, cuando comience la preparatoria."
                9 -> {
                    pj2!!.setImageResource(R.drawable.komaru2)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    nombre!!.text = "Komaru Makoto"
                    texto!!.text =
                        "¡No pensarías en irte sin decir nada! Recuerda que debes dejar el listón bien alto para cuando yo entre el año que viene."
                }
                10 -> {
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text =
                        "Si si... Pero antes de preocuparte por eso deberías prepararte para ir a clase."
                }
                11 -> {
                    pj1!!.setImageResource(R.drawable.naegi4)
                    texto!!.text =
                        "Además, ya sabes que necesitas unas notas excelentes para conseguir entrar y llegando tarde no las vas a conseguir."
                }
                12 -> {
                    pj2!!.setImageResource(R.drawable.komaru3)
                    cambioAPj2()
                    nombre!!.text = "Komaru Makoto"
                    texto!!.text = "Jeje.. Tranquilo hermanito, lo tengo todo controlado."
                }
                13 -> {
                    pj2!!.setImageResource(R.drawable.komaru4)
                    texto!!.text =
                        "Bueno... ¡No te entretengo más!\n¡¡Buena suerte en tu primer día!!"
                }
                14 -> {
                    desapareceFondo()
                    mplayer3 = MediaPlayer.create(this, R.raw.pasos)
                    mplayer3!!.seekTo(0)
                    mplayer3!!.start()
                    nombre!!.text = "Naegi Makoto"
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text =
                        "Salí por la puerta y puse rumbo a la academia, pero nada mas iniciar la marcha me percaté de que alguien me estaba esperando..."
                }
                15 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_outside_house)
                    apareceFondo()
                    pj2!!.setImageResource(R.drawable.kaede1)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    nombre!!.text = "¿¿??"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text =
                        "¡Venga Naegi! ¡Que hoy es nuestro primer día! ¡No podemos llegar tarde!"
                }
                16 -> {
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text =
                        "Se trataba de Kaede Akamatsu. Ibamos a la misma escuela media y competíamos por tener las mejores notas. También resulta ser mi vecina y amiga de la infancia."
                }
                17 -> {
                    pj2!!.setImageResource(R.drawable.kaede2)
                    nombre!!.text = "Kaede Akamatsu"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text =
                        "Espero que no te importe que vayamos juntos. Al ser el primer día estoy un poco nerviosa y ya que vivimos al lado pensé que podríamos ir juntos..."
                }
                18 -> {
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text =
                        "¡Suena genial! A decir verdad yo también estoy algo nervioso, asique sería bueno tener algo de compañía...."
                }
                19 -> {
                    pj1!!.setImageResource(R.drawable.naegi4)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Y bien... ¿de qué deberíamos hablar de camino a la academia?"
                    bundle!!.putString("opcion1", "Hablar del tiempo.")
                    bundle!!.putString("opcion2", "Preguntar por las vacaciones.")
                    bundle!!.putString("opcion3", "Preguntar por la familia.")
                    fondoClicks!!.isEnabled = false
                    opciones =
                        supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones?
                    opciones = FragmentoOpciones()
                    opciones!!.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .add(R.id.misOpciones, opciones!!, "misOpciones").commit()
                }
                20 -> {
                    //PUNTO DE SALIDA
                    iconoGuardado!!.startAnimation(animationGuardado)
                    nombre!!.text = "Naegi Makoto"
                    pj1!!.setImageResource(R.drawable.naegi4)
                    fondo!!.setBackgroundResource(R.drawable.back_outside_house)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    if (partida!!.cap1_Opcion1 == "1") {
                        texto!!.text = "Bueno... Parece que hará buen día, ¿no crees?"
                        pj1!!.setImageResource(R.drawable.naegi5)
                    } else if (partida!!.cap1_Opcion1 == "2") {
                        texto!!.text = "Bueno... ¿Y qué has hecho durante las vacaciones?"
                    } else if (partida!!.cap1_Opcion1 == "3") {
                        texto!!.text =
                            "¿Qué tal está tu hermana gemela? Creo recordar que ella también quería venir a esta academia."
                    }
                }
                21 -> {
                    nombre!!.text = "Kaede Akamatsu"
                    pj2!!.setImageResource(R.drawable.kaede3)
                    cambioAPj2()
                    if (partida!!.cap1_Opcion1 == "1")
                        texto!!.text =
                            "¡Por favor Naegi! ¿¡Vas caminando a solas con una chica y se te ocurre preguntar eso!?"
                    else if (partida!!.cap1_Opcion1 == "2")
                        texto!!.text =
                            "No mucho la verdad... Estuve repasando para este curso y practicando con el piano."
                    else if (partida!!.cap1_Opcion1 == "3")
                        texto!!.text =
                            "Bueno... Al parecer no consiguió entrar. Ya sabes que solo aceptan a los mejores estudiantes de todo el país."
                }
                22 -> if (partida!!.cap1_Opcion1 == "1") {
                    pj2!!.setImageResource(R.drawable.kaede1)
                    texto!!.text =
                        "¡Tendrás que mejorar mucho si quieres conseguir una novia durante la preparatoria!"
                } else if (partida!!.cap1_Opcion1 == "2") {
                    nombre!!.text = "Naegi Makoto"
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    texto!!.text = "¿Sigues tocando el piano? Si que te gusta eh..."
                } else if (partida!!.cap1_Opcion1 == "3") {
                    pj2!!.setImageResource(R.drawable.kaede2)
                    texto!!.text =
                        "Al principio estuvo bastante deprimida... pero últimamente parecía más animada. Parece ser que ha encontrado una nueva meta.."
                }
                23 -> if (partida!!.cap1_Opcion1 == "1") {
                    nombre!!.text = "Naegi Makoto"
                    pj1!!.setImageResource(R.drawable.naegi6)
                    cambio_a_pj1()
                    texto!!.text = "¿Q-Qu-Queee? ¿A qué viene eso tan de repente?"
                } else if (partida!!.cap1_Opcion1 == "2") {
                    nombre!!.text = "Kaede Akamatsu"
                    pj2!!.setImageResource(R.drawable.kaede4)
                    cambioAPj2()
                    texto!!.text =
                        "Me encanta poder transmitir sentimientos con mi música y hacer sonreir a la gente."
                } else if (partida!!.cap1_Opcion1 == "3") {
                    pj2!!.setImageResource(R.drawable.kaede5)
                    texto!!.text =
                        "¿Qué me dices de tu hermana, Naegi? ¿Sigue queriendo ir a Kibougamine?"
                }
                24 -> if (partida!!.cap1_Opcion1 == "1") {
                    pj1!!.setImageResource(R.drawable.naegi7)
                    texto!!.text =
                        "Además, no es como si me interesasen ese tipo de cosas ni nada por el estilo..."
                } else if (partida!!.cap1_Opcion1 == "2") {
                    pj2!!.setImageResource(R.drawable.kaede2)
                    texto!!.text =
                        "Pero todavía no estoy segura de que sea eso a lo que me quiera dedicar en el futuro. Todavía tengo tiempo para decidirme asique me lo estoy tomando con calma."
                    cont++
                } else if (partida!!.cap1_Opcion1 == "3") {
                    nombre!!.text = "Naegi Makoto"
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    texto!!.text =
                        "Si. Además, desde que se enteró de que yo había entrado, se la ve más motivada que nunca a entrar.."
                }
                25 -> if (partida!!.cap1_Opcion1 == "1") {
                    nombre!!.text = "Kaede Akamatsu"
                    pj2!!.setImageResource(R.drawable.kaede4)
                    cambioAPj2()
                    texto!!.text =
                        "¡Hahaha! Me encanta ver que sigues siendo el mismo de siempre..."
                } else if (partida!!.cap1_Opcion1 == "3") {
                    nombre!!.text = "Kaede Akamatsu"
                    pj2!!.setImageResource(R.drawable.kaede4)
                    cambioAPj2()
                    texto!!.text =
                        "¡Hahaha! Ya veo.. Debería pasarme algún día a saludar a Komaru. Hace bastante que no la veo..."
                }
                26 -> {
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    pj2!!.visibility = View.INVISIBLE
                    texto!!.text =
                        "Fué casi mágico lo corto que se nos hizo el paseo de camino a la academia mientras recordábamos algunas historias que ocurrieron en el pasado."
                }
                27 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_outside_school)
                    apareceFondo()
                    texto!!.text = "Hasta que por fin llegamos a la famosa escuela Kibougamine..."
                }
                28 -> {
                    pj2!!.visibility = View.VISIBLE
                    pj2!!.setImageResource(R.drawable.naegi7)
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text =
                        "Asique esta es la academia Kibougamine... La verdad es que impone un poco vista desde fuera."
                }
                29 -> {
                    pj1!!.setImageResource(R.drawable.kaede3)
                    nombre!!.text = "Kaede Akamatsu"
                    cambio_a_pj1()
                    texto!!.text =
                        "Si... Según tengo entendido tenemos que ir al gimnasio. Al parecer la presentación tendrá lugar ahí."
                }
                30 -> {
                    pj2!!.setImageResource(R.drawable.nagito1)
                    cambioAPj2()
                    nombre!!.text = "¿¿??"
                    texto!!.text = "Asique hay que ir al gimansio..."
                }
                31 -> {
                    pj2!!.setImageResource(R.drawable.nagito2)
                    texto!!.text =
                        "Disculpad, no he podido evitar escuchar vuestra conversación... Parece que vosotros sois de primer año como yo."
                }
                32 -> {
                    pj2!!.setImageResource(R.drawable.nagito3)
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.text =
                        "Mi nombre es Nagito Komaeda. Siendo honestos, estoy algo perdido y no sabía adonde ir... ¡He tenido mucha suerte encontrándome con vosotros!"
                }
                33 -> {
                    nombre!!.text = "Kaede Akamatsu"
                    pj1!!.setImageResource(R.drawable.kaede3)
                    cambio_a_pj1()
                    texto!!.text =
                        "Encantada. Yo soy Kaede Akamatsu y él es mi amigo Naegi Makoto. Ambos íbamos a la misma escuela media, por eso ya nos conocemos."
                }
                34 -> {
                    nombre!!.text = "Nagito Komaeda"
                    pj2!!.setImageResource(R.drawable.nagito4)
                    cambioAPj2()
                    texto!!.text =
                        "¿Qué? ¿Dos alumnos de la misma escuela fueron aceptados aquí? ¡Entonces vosotros tenéis incluso más suerte que yo!"
                }
                35 -> {
                    pj2!!.setImageResource(R.drawable.nagito3)
                    texto!!.text =
                        "Bueno, ¿qué os parece si vamos todos juntos al gimnasio? Tiene sentido ya que los tres nos dirigimos hacia allí."
                }
                36 -> {
                    nombre!!.text = "Naegi Makoto"
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    texto!!.text = "Si... ¡Vamos! Ya casi es la hora."
                }
                37 -> {
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    desapareceFondo()
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text =
                        "Nos apresuramos hacia el gimnasio donde tuvimos una ceremonia de apertura. Allí se encontraban los 16 alumnos de nuestra clase, entre ellos, Nagito, Kaede y yo."
                }
                38 -> texto!!.text =
                    "Más tarde nos llevaron a nuestra clase, donde nos estaba esperando nuestra profesora..."
                39 -> {
                    pj1!!.setImageResource(R.drawable.profe1)
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text =
                        "¡Bienvenidos a todos chicos! Yo seré vuestra profesora durante este curso, mi nombre es Hiroko Hagakure."
                }
                40 -> {
                    pj1!!.setImageResource(R.drawable.profe2)
                    texto!!.text =
                        "Antes de nada me gustaría que os presentaseis cada uno. También estaría bien que contaseis algo sobre vosotros. ¿Quién quiere empezar?"
                }
                41 -> {
                    pj2!!.setImageResource(R.drawable.kuzuryu1)
                    cambioAPj2()
                    nombre!!.text = "¿¿??"
                    texto!!.text = "¡Menuda gilipollez! Esto es una perdida de tiemp...."
                }
                42 -> {
                    pj1!!.setImageResource(R.drawable.profe1)
                    cambio_a_pj1()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text =
                        "¡Vaya vaya! Parece que tenemos al primer voluntario... Adelante."
                }
                43 -> {
                    pj2!!.setImageResource(R.drawable.kuzuryu2)
                    cambioAPj2()
                    nombre!!.text = "¿¿??"
                    texto!!.text = "¿¡!?"
                }
                44 -> {
                    pj1!!.setImageResource(R.drawable.profe2)
                    cambio_a_pj1()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "Y bien, ¿te vas a presentar o qué?"
                }
                45 -> {
                    pj2!!.setImageResource(R.drawable.kuzuryu4)
                    cambioAPj2()
                    nombre!!.text = "Fuyuhiko Kuzuryu"
                    texto!!.text = "Si... Mi nombre es Fuyuhiko Kuzuryu..."
                }
                46 -> {
                    pj2!!.setImageResource(R.drawable.kuzuryu3)
                    texto!!.text = "No me gusta especialmente nada, y no soporto muchas cosas..."
                }
                47 -> {
                    pj2!!.setImageResource(R.drawable.kuzuryu1)
                    texto!!.text =
                        "Pero si de verdad apreciáis vuestra vida, no os conviene tocarme las narices."
                }
                48 -> {
                    pj1!!.setImageResource(R.drawable.profe2)
                    cambio_a_pj1()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text =
                        "¡Genial! ¿Por qué no os vais presentando cada uno de izquierda a derecha eh? Así podemos hacer esto de manera más dinámica. ¡Venga!"
                }
                49 -> {
                    pj2!!.setImageResource(R.drawable.sayaka1)
                    nombre!!.text = "¿¿??"
                    cambioAPj2()
                    texto!!.text = "Supongo que me toca a mi..."
                }
                50 -> {
                    nombre!!.text = "Sayaka Maizono"
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "¡Hola a todos! Mi nombre es Sayaka Maizono. Encantada. "
                }
                51 -> texto!!.text =
                    "Sé que nos acabamos de conocer, pero intentemos llevarnos bien."
                52 -> {
                    pj1!!.setImageResource(R.drawable.leon1)
                    cambio_a_pj1()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "¡Sí! ¡Es mi turno! ¡Me llamo Leon Kuwata!"
                }
                53 -> {
                    pj1!!.setImageResource(R.drawable.leon2)
                    texto!!.text =
                        "¡Me encanta tocar la guitarra! No es por alardear... pero toco unos solos de guitarra de infarto."
                }
                54 -> {
                    pj1!!.setImageResource(R.drawable.leon3)
                    texto!!.text = "¡Voy a ser el mejor guitarrista del mundo!"
                }
                55 -> {
                    pj1!!.setImageResource(R.drawable.leon4)
                    texto!!.text = "Espero que os lo metais bien en el coco, ¿me habeis oído?"
                }
                56 -> {
                    nombre!!.text = "¿¿??"
                    pj2!!.setImageResource(R.drawable.togami1)
                    cambioAPj2()
                    texto!!.text = "Uh... como si a alguien le importasen tus estupideces..."
                }
                57 -> {
                    nombre!!.text = "Leon Kuwata"
                    pj1!!.setImageResource(R.drawable.leon3)
                    cambio_a_pj1()
                    texto!!.text = "¿¡Qué has dicho cuatro ojos!?"
                }
                58 -> {
                    nombre!!.text = "Byakuya Togami"
                    pj2!!.setImageResource(R.drawable.togami2)
                    cambioAPj2()
                    texto!!.text = "En fin... Mi nombre es Byakuya Togami, ¡alegraos de conocerme!"
                }
                59 -> {
                    pj2!!.setImageResource(R.drawable.togami4)
                    texto!!.text =
                        "Pertenezco a la prestigiosa familia Togami, asi que no penséis que vamos a ser amiguitos ni nada de eso. Para mi solo sois gente vulgar y ordinaria."
                }
                60 -> {
                    nombre!!.text = "Leon Kuwata"
                    pj1!!.setImageResource(R.drawable.leon3)
                    cambio_a_pj1()
                    texto!!.text = "¿¡Quién se ha creido el niñato este!?"
                }
                61 -> {
                    nombre!!.text = "¿¿??"
                    pj2!!.setImageResource(R.drawable.koizumi1)
                    cambioAPj2()
                    texto!!.text = "Vamos vamos tranquilizate... Dios santo, pareceis unos críos..."
                }
                62 -> {
                    pj2!!.setImageResource(R.drawable.koizumi2)
                    nombre!!.text = "Mahiru Koizumi"
                    texto!!.text = "Yo soy Mahiru Koizumi. Un gusto conoceros."
                }
                63 -> {
                    pj2!!.setImageResource(R.drawable.koizumi3)
                    texto!!.text =
                        "Me encanta viajar a lugares que no haya visitado y tomar muchas fotos."
                }
                64 -> {
                    pj2!!.setImageResource(R.drawable.koizumi4)
                    texto!!.text = "Sin embargo, odio que la gente tenga malos modales..."
                }
                65 -> {
                    nombre!!.text = "Nagito Komaeda"
                    pj1!!.setImageResource(R.drawable.nagito2)
                    cambio_a_pj1()
                    texto!!.text = "¡Hahahaha! ¡Pero que divertidos que sois todos!"
                }
                66 -> {
                    pj1!!.setImageResource(R.drawable.nagito3)
                    texto!!.text =
                        "Definitivamente soy muy afortunado de estar aquí. Yo soy Nagito Komaeda."
                }
                67 -> texto!!.text =
                    "Me gustan mucho las cosas interesantes asique, por favor, mantenedme entretenido."
                68 ->{
                    pj2!!.setImageResource(R.drawable.togami1)
                    cambioAPj2()
                    nombre!!.text = "Byakuga Togami"
                    texto!!.text = "Como si no tuviese otra cosa mejor que hacer..."
                    }
                69 -> {
                    nombre!!.text = "Leon Kuwata"
                    pj1!!.setImageResource(R.drawable.leon4)
                    cambio_a_pj1()
                    texto!!.text = "Madre mía... Estais todos como una cabra, ¿lo sabíais?"
                }
                70 -> {
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Uno a uno nos fuimos presentando todos. Resultó ser una clase de lo más extraña. Todos ellos rebosaban una confianza abrumadora."
                }
                71 -> texto!!.text = "Aunque no es que me sorprenda, después de todo, éramos los dieciseis mejores estudiantes de todo Japón..."
                72 -> {
                    mplayer3 = MediaPlayer.create(this, R.raw.pasos)
                    mplayer3!!.seekTo(0)
                    mplayer3!!.start()
                    desapareceFondo()
                    texto!!.text = "Una vez finalizadas las presentaciones, dió la hora del almuerzo... Quise ir a tomar un poco el aire pero alguien me estaba esperando en la puerta..."
                }
                73 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_pasillo)
                    apareceFondo()
                    pj1!!.setImageResource(R.drawable.hinata1)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Hey! Naegi! ¿Tienes un momento?"
                }
                74 -> {
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Era Hajime. En su presentación me pareció un chico bastante normal comparándolo con los de clase..."
                }
                75 -> {
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Claro! Dime, ¿qué ocurre?"
                    pj2!!.setImageResource(R.drawable.naegi3)
                    cambioAPj2()
                }
                76 -> {
                    pj1!!.setImageResource(R.drawable.hinata2)
                    nombre!!.text = "Hajime Hinata"
                    cambio_a_pj1()
                    texto!!.text = "Lo cierto es que venía con la intención de llevarme bien con todos... Pero después de escuchar las presentaciones... "
                }
                77 -> {
                    pj1!!.setImageResource(R.drawable.hinata3)
                    texto!!.text = "Digamos que de los chicos eres el único que me ha parecido más 'normal'... asique... ¿quieres venir a tomar algo a la cafetería?"
                }
                78 -> {
                    pj1!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Creo que podría ser una buena oportunidad para conocernos un poco más."
                }
                79 -> {
                    nombre!!.text = "Naegi Makoto"
                    pj2!!.setImageResource(R.drawable.naegi1)
                    cambioAPj2()
                    texto!!.text = "Claro, ¡suena bastante bien!"
                }
                80 -> {
                    mplayer3 = MediaPlayer.create(this, R.raw.pasos)
                    mplayer3!!.seekTo(0)
                    mplayer3!!.start()
                    pj2!!.visibility = View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Fuimos a la cafetería mientras explorábamos un poco la academia. Cuando llegamos, nos encontramos una cafetería enorme para los pocos alumnos que tenía el centro."
                }
                81 -> {
                    nombre!!.text = "Hajime Hinata"
                    pj2!!.setImageResource(R.drawable.hinata5)
                    fondo!!.setBackgroundResource(R.drawable.back_cafeteria)
                    pj2!!.visibility = View.VISIBLE
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    aparecer(pj2!!)
                    apareceFondo()
                    texto!!.text = "Vaya... Parece que en Kibougamine solo saben hacer las cosas a lo grande..."
                }
                82 -> {
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Y que lo digas! Bueno y dime... ¿de qué querías hablar conmigo?"
                }
                83 -> {
                    pj2!!.setImageResource(R.drawable.hinata6)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "En realidad de nada en particular, cualquier cosa esta bien... Por ejemplo... ¿Te llama la atención alguna chica de clase?"
                }
                84 -> {
                    pj1!!.setImageResource(R.drawable.naegi6)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¿¡Eh!? Mmmmm... En realidad todavía no las conozco lo suficiente. Además, ya me olvidé de casi todos los nombres..."
                }
                85 -> {
                    pj2!!.setImageResource(R.drawable.hinata1)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Claro claro... entonces cuéntame... ¿Qué es lo que más te esta llamando la atención de este juego?"
                }
                86 -> {
                    pj1!!.setImageResource(R.drawable.naegi9)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Espera... ¿¡De qué narices está hablando...!? Supongo que tendré que seguirle la corriente..."
                    fondoClicks!!.isEnabled = false
                    bundle!!.putString("opcion1", "Las animaciones del menu principal.")
                    bundle!!.putString("opcion2", "La cantidad de Sprites que usa.")
                    bundle!!.putString("opcion3", "Los efectos de sonido.")
                    opciones = supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones?
                    opciones = FragmentoOpciones()
                    opciones!!.arguments = bundle
                    supportFragmentManager.beginTransaction().add(R.id.misOpciones, opciones!!, "misOpciones").commit()
                }
                87 -> {
                    //PUNTO DE SALIDA
                    iconoGuardado!!.startAnimation(animationGuardado)
                    fondoClicks!!.isEnabled = true
                    fondo!!.setBackgroundResource(R.drawable.back_cafeteria)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    pj1!!.setImageResource(R.drawable.naegi9)
                    if (partida!!.cap1_Opcion2 == "1")
                        texto!!.text = "Definitivamente el menú principal usa bastantes animaciones, mola un montón. Además, ¡parece que soy el protagonista del juego!"
                    else if (partida!!.cap1_Opcion2 == "2")
                        texto!!.text = "¿Has pensado en la cantidad de imágenes que usa este juego? ¡Me parece una locura que tengamos tantas expresiones diferentes!"
                    else if (partida!!.cap1_Opcion2 == "3")
                        texto!!.text = "El juego está bien, pero me encanta el detalle de los efectos de sonido."
                }
                88 -> {
                    pj2!!.setImageResource(R.drawable.hinata7)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    if (partida!!.cap1_Opcion2 == "1"){
                        texto!!.text = "¡Hahahahaha! ¡me alegro por tí!"
                    } else if (partida!!.cap1_Opcion2 == "2"){
                        texto!!.text = "¡Estoy bastante de acuerdo contigo! ¡No me gustaría tener siempre la misma cara de pardillo cuando hablásemos!"
                    } else if (partida!!.cap1_Opcion2 == "3"){
                        texto!!.text = "¡Definitavente es un detalle bastante bueno!"
                    }
                }
                89 -> if (partida!!.cap1_Opcion2 == "1"){
                    pj2!!.setImageResource(R.drawable.hinata8)
                    texto!!.text = "Aunque entre tu y yo... Creo que la gente preferiría que el protagonista fuese yo..."
                } else if (partida!!.cap1_Opcion2 == "2"){
                    pj2!!.setImageResource(R.drawable.hinata1)
                    texto!!.text = "Creo que es un truco para poder empatizar más con los personajes... y si me permites la opinión, ¡es muy efectivo!"
                } else if (partida!!.cap1_Opcion2 == "3"){
                    pj2!!.setImageResource(R.drawable.hinata1)
                    texto!!.text = "Aunque me sorprende bastante que te hayas dado cuenta... ¡Veo que estas atento a los pequeños detalles!"
                }
                90 -> {
                    pj2!!.setImageResource(R.drawable.hinata2)
                    texto!!.text = "Pero dejando esto de lado... ¿sabes ya qué es lo que tienes que hacer para ganar?"
                }
                91 -> {
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Pues... si te soy sincero me he estado dejando llevar hasta ahora..."
                }
                92 -> {
                    pj2!!.setImageResource(R.drawable.hinata4)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Vaya vaya... asi que todavía no te has dado cuenta ¿eh?. Supongo que está bien, al menos por ahora..."
                }
                93 -> {
                    pj1!!.setImageResource(R.drawable.naegi6)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¿¡Perdona!? ¿Tú ya lo sabes?"
                }
                94 -> {
                    pj2!!.setImageResource(R.drawable.hinata7)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Quien sabe, quien sabe... ¡Hahahahaha!"
                }
                95 -> {
                    pj2!!.visibility = View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Seguimos con aquella conversación sin sentido durante toda la comida hasta que tuvimos que volver a clase..."
                }
                96 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    pj2!!.setImageResource(R.drawable.kaede5)
                    pj2!!.visibility = View.VISIBLE
                    aparecer(pj2!!)
                    nombre!!.text = "Kaede Akamatsu"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Ah Naegi! ¡Aquí estas!"
                }
                97 -> {
                    pj2!!.setImageResource(R.drawable.kaede4)
                    texto!!.text = "¡Han dicho que ahora vamos a elegir al delegado y al subdelegado de clase! ¡Creo que deberías presentarte!"
                }
                98 -> {
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Ehh... ¿Yo? No creo que sea una buena idea."
                }
                99 -> {
                    pj2!!.setImageResource(R.drawable.kaede1)
                    cambioAPj2()
                    nombre!!.text = "Kaede Akamatsu"
                    texto!!.text = "Ohhh... Venga no digas eso, lo harías genial...Seguro que tu también lo piensas, ¿verdad Hajime?"
                }
                100 -> {
                    pj1!!.setImageResource(R.drawable.hinata5)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Bueno... Creo que coincido con Kaede. Eres una persona muy sociable y eso podría ayudar mucho a la comunicación de la clase."
                }
                101 -> {
                    pj2!!.setImageResource(R.drawable.kaede4)
                    cambioAPj2()
                    nombre!!.text = "Kaede Akamatsu"
                    texto!!.text = "¡Animate Naegi! ¡Cuando estábamos en la escuela media lo hacías muy bien!"
                }
                102 -> {
                    pj1!!.setImageResource(R.drawable.profe2)
                    cambio_a_pj1()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "Bueno chicos, ha llegado la hora de determinar quién sera el delegado y subdelegado de clase."
                }
                103 -> {
                    pj1!!.setImageResource(R.drawable.profe1)
                    texto!!.text = "Quiero advertiros de que no es algo que cualquiera pueda hacer, y que conlleva una serie de obligaciones..."
                }
                104 -> {
                    pj1!!.setImageResource(R.drawable.profe2)
                    texto!!.text = "Y bien... ¿algún voluntario?"
                }
                105 -> {
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "La clase se quedó en un silencio sepulcral que resultaba muy incómodo..."
                }
                106 -> {
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    pj1!!.setImageResource(R.drawable.kuzuryu4)
                    nombre!!.text = "Fuyuhiko Kuzuryu"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "..."
                }
                107 -> {
                    pj2!!.setImageResource(R.drawable.nanami1)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "..."
                }
                108 -> {
                    pj1!!.setImageResource(R.drawable.kirigiri1)
                    cambio_a_pj1()
                    nombre!!.text = "Kyoko Kirigiri"
                    texto!!.text = "..."
                }
                109 -> {
                    pj1!!.setImageResource(R.drawable.kirigiri2)
                    texto!!.text = "Supongo que me haré cargo... Profesora, yo me presento como delegada si todos mis compañeros están de acuerdo."
                }
                110 -> {
                    pj2!!.setImageResource(R.drawable.profe2)
                    cambioAPj2()
                    nombre!!.text = "Kyoko Kirigiri"
                    texto!!.text = "¡Estupendo! Ahora ya solo falta un subdelegado... ¿Quién será el afortunado de ayudar a Kyoko con su deber como delegada?"
                }
                111 -> {
                    pj1!!.setImageResource(R.drawable.naegi9)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "..."
                }
                112 -> {
                    pj1!!.setImageResource(R.drawable.naegi7)
                    texto!!.text = "Yo podría hacerlo. Siempre he sido el representante de clase en la escuela media, asique creo que podría ser de utilidad..."
                }
                113 -> {
                    pj2!!.setImageResource(R.drawable.profe2)
                    cambioAPj2()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "¡Gracias Naegi! Con esto ya tenemos a nuestros representantes de clase. Espero que hagáis un gran trabajo."
                }
                114 -> {
                    pj2!!.setImageResource(R.drawable.profe1)
                    texto!!.text = "Ahora ya solo falta una cosa por hacer. Haremos un sorteo para asignar los turnos para limpiar la clase al final del día."
                }
                115 -> {
                    pj1!!.setImageResource(R.drawable.nagito3)
                    cambio_a_pj1()
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.text = "¿Un sorteo? ¡Qué divertido!"
                }
                116 -> {
                    pj1!!.setImageResource(R.drawable.nagito1)
                    texto!!.text = "Me pregunto cuanta suerte tendré hoy..."
                }
                117 -> {
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Preparamos el sorteo, con la mala fortuna de que me tocó limpiar ese mismo junto con alguien más..."
                }
                118 -> {
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    pj1!!.setImageResource(R.drawable.sayaka3)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Asi que me toca limpiar hoy, ¿eh?"
                }
                119 -> {
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "Vaya Naegi, parece que nos toca limpiar juntos hoy..."
                }
                120 -> {
                    pj1!!.setImageResource(R.drawable.sayaka4)
                    texto!!.text = "No puedo decir que me guste limpiar, pero me alegro de que me haya tocado contigo..."
                }
                121 -> {
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "..."
                }
                122 -> {
                    pj2!!.setImageResource(R.drawable.naegi4)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "¿Cómo que se alegra? ¿¡Nos conocemos de algo!?"
                }
                123 -> {
                    pj2!!.setImageResource(R.drawable.naegi6)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Me está empezando a poner nervioso que me mire tan fijamente... ¡Debería decir algo rápido!"
                }
                124 -> {
                    cambio_a_pj1()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "..."
                }
                125 -> {
                    pj2!!.setImageResource(R.drawable.naegi3)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... cuento contigo despés de clase Sayaka."
                }
                126 -> {
                    pj1!!.setImageResource(R.drawable.sayaka4)
                    cambio_a_pj1()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "¡Si! Lo mismo digo Naegi..."
                }
                127 -> {
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Una vez acabadas las clases todos los estudiantes fueron dejando el aula, hasta que me quedé a solas con Sayaka..."
                }
                128 -> {
                    pj1!!.setImageResource(R.drawable.sayaka5)
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Bien! ¿Por dónde deberíamos empezar?"
                }
                129 -> {
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Sayaka y yo nos repartimos las tareas..."
                }
                130 -> {
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    texto!!.text = "Nos quedamos en silencio mientras hacíamos la limpieza, pero algo me decía que tenía que romper ese silencio fuese como fuese..."
                }
                131 -> {
                    pj1!!.setImageResource(R.drawable.naegi4)
                    aparecer(pj1!!)
                    pj1!!.visibility = View.VISIBLE
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¿Qué debería preguntar a Sayaka mientras limpiamos la clase?"
                    bundle = Bundle()
                    bundle!!.putString("opcion1", "¿Qué cosas te gusta hacer en tu tiempo libre?")
                    bundle!!.putString("opcion2", "¿A que escuela media fuiste?")
                    bundle!!.putString("opcion3", "¿Nos conocemos de algo?")
                    fondoClicks!!.isEnabled = false
                    opciones = supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones?
                    opciones = FragmentoOpciones()
                    opciones!!.arguments = bundle
                    supportFragmentManager.beginTransaction().add(R.id.misOpciones, opciones!!, "misOpciones").commit()
                }
                132 -> {
                    //PUNTO DE SALIDA
                    iconoGuardado!!.startAnimation(animationGuardado)
                    fondoClicks!!.isEnabled = true
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    pj1!!.setImageResource(R.drawable.naegi7)
                    if (partida!!.cap1_Opcion3 == "1")
                        texto!!.text = "Sayaka ¿qué es lo que te gusta hacer en tu tiempo libre?"
                    else if (partida!!.cap1_Opcion3 == "2")
                        texto!!.text = "Sayaka ¿dónde estudiabas antes de haber sido aceptada en esta academia?"
                    else if (partida!!.cap1_Opcion3 == "3")
                        texto!!.text = "Sayaka... Antes he tenido la impresión de que me conocías de algo..."
                }
                133 -> if (partida!!.cap1_Opcion3 == "1"){
                    nombre!!.text = "Sayaka Maizono"
                    pj2!!.setImageResource(R.drawable.sayaka4)
                    cambioAPj2()
                    texto!!.text = "Puees... me da algo de verguenza decir esto..."
                } else if (partida!!.cap1_Opcion3 == "2"){
                    nombre!!.text = "Sayaka Maizono"
                    pj2!!.setImageResource(R.drawable.sayaka3)
                    cambioAPj2()
                    texto!!.text = "Bueno... estuve estudiando en Hokkaido, al Norte."
                } else if (partida!!.cap1_Opcion3 == "3"){
                    pj1!!.setImageResource(R.drawable.naegi6)
                    texto!!.text = "He estado dandole vueltas pero creo que nunca  hemos ido a la misma escuela ¿no?"
                }
                134 -> if (partida!!.cap1_Opcion3 == "1"){
                            pj2!!.setImageResource(R.drawable.sayaka2)
                            texto!!.text = "Me gusta mucho cantar... Últimamente he estado teniendo clases de canto y dicen que se me da bastante bien."
                        } else if (partida!!.cap1_Opcion3 == "2"){
                            pj2!!.setImageResource(R.drawable.sayaka5)
                            texto!!.text = "Es muy bonita esa zona, definitivamente deberías ir alguna vez."
                        } else if (partida!!.cap1_Opcion3 == "3"){
                    nombre!!.text = "Sayaka Maizono"
                            pj2!!.setImageResource(R.drawable.sayaka3)
                            cambioAPj2()
                            texto!!.text = "Mmmm... creo que eso no es posible."
                }
                135 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj2!!.setImageResource(R.drawable.sayaka1)
                            texto!!.text = "Pero... ¿por qué querías saberlo Naegi?"
                        } else if (partida!!.cap1_Opcion3 == "2"){
                            pj2!!.setImageResource(R.drawable.sayaka8)
                            texto!!.text = "Aunque cuando era muy pequeña estuve viviendo aquí, en Kyoto."
                        } else if (partida!!.cap1_Opcion3 == "3"){
                            texto!!.text = "Yo fui a la escuela en la otra punta de Japón, asique creo que sería muy difícil coincidir..."
                        }
                136 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj1!!.setImageResource(R.drawable.naegi7)
                            cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                            texto!!.text = "Simplemente me interesaba por tí."
                        } else if (partida!!.cap1_Opcion3 == "2"){
                    nombre!!.text = "Naegi Makoto"
                            pj1!!.setImageResource(R.drawable.naegi4)
                            cambio_a_pj1()
                            texto!!.text = "¡Ohhh! ya veo..."
                        } else if (partida!!.cap1_Opcion3 == "3"){
                            pj2!!.setImageResource(R.drawable.sayaka2)
                            texto!!.text = "Y aunque lo hubiesemos hecho, me acordaría de ello, asique te puedo asegurar de que nunca hemos ido al mismo centro."
                        }
                137 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj1!!.setImageResource(R.drawable.naegi3)
                            texto!!.text = "Si voy a ser uno de los representantes de la clase me gustaría conocer bien a mis compañeros."
                        } else if (partida!!.cap1_Opcion3 == "2"){
                            pj1!!.setImageResource(R.drawable.naegi3)
                            texto!!.text = "Yo nunca estuve en el distrito Hokkaido... Cuentame como es."
                            cont = 141
                        } else if (partida!!.cap1_Opcion3 == "3"){
                    nombre!!.text = "Naegi Makoto"
                            pj1!!.setImageResource(R.drawable.naegi7)
                            cambio_a_pj1()
                            texto!!.text = "Ya veo... Supongo que me lo he debido de imaginar..."
                            cont = 141
                        }
                138 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj2!!.setImageResource(R.drawable.sayaka3)
                            cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                            texto!!.text = "Oh... Ya veo..."
                        }
                139 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj2!!.setImageResource(R.drawable.sayaka2)
                            texto!!.text = "Bueno... ¿y que me puedes contar de nuestro subdelegado de clase? Cuentame que clase de persona es."
                        }
                140 ->  if (partida!!.cap1_Opcion3 == "1"){
                            pj1!!.setImageResource(R.drawable.naegi7)
                            cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                            texto!!.text = "Jajaja... pues..."
                            cont = 141
                        }
                142 -> {
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Sayaka y yo seguimos conversando mientras limpiabamos la clase. Pasamos un rato bastante divertido hasta que terminamos de limpiar la clase."
                }
                143 -> {
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Buen trabajo Naegi! Lo hemos hecho bastante rápido los dos juntos."
                }
                144 -> {
                    pj1!!.setImageResource(R.drawable.sayaka3)
                    texto!!.text = "Definitivamente creo que he tenido suerte al tocarme contigo limpiar la clase..."
                }
                145 -> {
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "Espero con ansias la próxima vez..."
                }
                146 -> {
                    mplayer3 = MediaPlayer.create(this, R.raw.pasos)
                    mplayer3!!.seekTo(0)
                    mplayer3!!.start()
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Antes de que pudiera responder, Sayaka salió de la clase rapidamente."
                }
                147 -> texto!!.text = "Y juraría haber visto que estaba muy sonrojada..."
                148 -> {
                    desapareceFondo()
                    texto!!.text = "Cogí mis cosas y me marche a casa, donde me esperaba Komaru."
                }
                149 -> texto!!.text = "Ella me interrogó durante el resto del día sobre mi primer contacto con la academia."
                150 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_outside_house_night)
                    apareceFondo()
                    texto!!.text = "Me acosté temprano esa noche, dandole vueltas a si las decisiones que había tomado ese día serían importantes de cara al futuro."
                }
                151 -> texto!!.text = "Mientras más pensaba en ello, más sueño tenía... hasta que me quedé completamente dormido."
                152 -> {
                    texto!!.visibility = android.view.View.INVISIBLE
                    nombre!!.visibility = android.view.View.INVISIBLE
                }
                153 -> {
                    desapareceFondo()
                    mplayer!!.stop()
                    fondo!!.isEnabled = false
                }}
            cont++
            if (cont == 154){
                cap++
                cont = 1
            }
        } else if (cap == 2){
            when(cont){1 -> {
                capitulo!!.text = "CAPITULO $cap"
                capitulo!!.visibility = android.view.View.VISIBLE
                if (mplayer!!.isPlaying == false){
                    mplayer = MediaPlayer.create(this, R.raw.happy_day)
                    mplayer!!.isLooping = true
                    mplayer!!.start()
                }
                iconoGuardado!!.startAnimation(animationGuardado)
                texto!!.visibility = android.view.View.INVISIBLE
                nombre!!.visibility = android.view.View.INVISIBLE
                fondo!!.setBackgroundResource(R.drawable.back_outside_house)
                apareceFondo()
                animationTitulo = AnimationUtils.loadAnimation(this, R.anim.titulo_rotado)
            }
                2 -> {
                    capitulo!!.setVisibility(android.view.View.INVISIBLE)
                    texto!!.visibility = android.view.View.VISIBLE
                    nombre!!.visibility = android.view.View.VISIBLE
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Pasaron varios días, y me fuí acostumbrando a aquella vida escolar y a mis nuevos compañeros de clase..."
                }
                3 -> texto!!.text = "Todos los días eran divertidos y ocurría algo diferente. Además, sus personalidades tan extravagantes provocaban que ningún día fuese igual a otro."
                4 -> {
                    desapareceFondo()
                    texto!!.text = "Y por supuesto que hoy no iba a ser una excepción..."
                }
                5 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_room) //FONDO DE MI CUARTO
                    apareceFondo()
                    pj1!!.setImageResource(R.drawable.naegi6)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Mierda! ¡Me he quedado dormido! ¡¡Llegaré tarde como no me de prisa!!"
                }
                6 -> {
                    mplayer3 = MediaPlayer.create(this, R.raw.pasos)
                    mplayer3!!.start()
                    desaparecer(pj1!!)
                    desapareceFondo()
                    pj1!!.visibility = android.view.View.INVISIBLE
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Bajé las escaleras a toda prisa y desayuné lo mas rápido que pude..."
                }
                7 -> {
                    fondo!!.setBackgroundResource(R.drawable.back_cocina_house)
                    apareceFondo()
                    texto!!.text = "Por fin estaba listo para ir a la academia... Si salía justo en ese momento llegaría a tiempo a la academia."
                }
                8 -> texto!!.text = "Sin embargo, un viejo enemigo hizo su aparición y estaba a punto de frustrar todos mis esfuerzos...."
                9 -> {
                    pj1!!.setImageResource(R.drawable.naegi11)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "¿¿??"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Brrrrrrrrr"
                }
                10 -> {
                    pj1!!.setImageResource(R.drawable.naegi7)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Maldición! Justo en un momento así..."
                }
                11 -> {
                    pj1!!.setImageResource(R.drawable.naegi8)
                    texto!!.text = "¡¡Y TENGO QUE IR A CAGAR!!"
                }
                12 -> texto!!.text = "Si lo hago seguramente llegue tarde a primera hora... Por otra parte, quizas sea capaz de aguantar hasta clase... Aunque con estos apretones... uffff"
                13 -> {
                    pj1!!.setImageResource(R.drawable.naegi9)
                    texto!!.text = "¿Qué debería hacer?"
                    bundle = Bundle()
                    bundle!!.putString("opcion1", "Ir al baño primero.")
                    bundle!!.putString("opcion2", "Ir al instituto directamente.")
                    bundle!!.putString("opcion3", "")
                    fondoClicks!!.isEnabled = false
                    opciones = supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones
                    opciones = FragmentoOpciones()
                    opciones!!.arguments = bundle
                    supportFragmentManager.beginTransaction().add(R.id.misOpciones, opciones!!, "misOpciones").commit()
                }
                14 -> {
                    //PUNTO DE SALIDA
                    iconoGuardado!!.startAnimation(animationGuardado)
                    fondoClicks!!.isEnabled = true
                    fondo!!.setBackgroundResource(R.drawable.back_cocina_house)
                    nombre!!.text = "Makoto Naegi"
                    if (partida!!.cap2_Opcion1 == "1"){
                        pj1!!.setImageResource(R.drawable.naegi7)
                        texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                        texto!!.text = "No hay forma de que aguante hasta el instituto... Supongo que llegaré tarde hoy..."
                    } else if (partida!!.cap2_Opcion1 == "2"){
                        pj1!!.setImageResource(R.drawable.naegi8)
                        texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                        texto!!.text = "Ahhhhhhh... ¡Maldicion!"
                    }
                }
                15 -> {
                    desaparecer(pj1!!)
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desapareceFondo()
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    if (partida!!.cap2_Opcion1 == "1") texto!!.text = "Al final decidí ir al baño, sabiendo que no llegaría a primera hora. Me tomé mi tiempo antes de salir de casa y me dirigí sin ninguna prisa al instituto." else if (partida!!.cap2_Opcion1 == "2") texto!!.text =
                        "Salí por la puerta con resentimiento y fuí directo a la escuela apretando el esfinter tanto como me fuese posible."
                }
                16 -> if (partida!!.cap2_Opcion1 == "1"){
                    fondo!!.setBackgroundResource(R.drawable.back_pasillo)
                    apareceFondo()
                    texto!!.text = "Una vez en el instituto, me dirigí al pasillo de mi clase para que al acabar la primera hora, entrar. Sin embargo, me encontré con una imagen poco usual..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    fondo!!.setBackgroundResource(R.drawable.back_bath_school)
                    apareceFondo()
                    texto!!.text = "Me las arreglé para llegar 10 minutos antes a la academia, y fui directo al baño, donde pude liberarme..."
                }
                17 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi1)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¿Chiaki? ¿Qué haces aquí? ¿Tampoco has llegado a tiempo?"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    texto!!.text = "Cuando estaba a punto de terminar escuché un par de voces acercandose al baño... ¡Parecían ser Leon y Fuyuhiko!"
                }
                18 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami1)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "...zzzZZZzzz..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.leon2)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Leon Kuwata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Venga Fuyuhiko tio! Enróllate un poco y dejame tu libro, que la profe me va a matar si ve que me lo he olvidado de nuevo."
                }
                19 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami2)
                    texto!!.text = "¡Oh! Buenos dias Naegi..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.kuzuryu3)
                    cambioAPj2()
                    nombre!!.text = "Fuyuhiko Kuzuryu"
                    texto!!.text = "Joder, que pesado que eres. ¿También me vas a seguir al baño? Ya te dije que no es mi problema."
                }
                20 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami3)
                    texto!!.text = "Si... la verdad es que me quedé jugando toda la noche..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.leon4)
                    cambio_a_pj1()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "¡Que la profesora está mal de la cabeza! Es posible que me mate ¿sabes?"
                }
                21 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami4)
                    texto!!.text = "Pero no podía esperar, justo ayer salió a la venta un juego nuevo y no pude evitar empezarlo..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.kuzuryu5)
                    cambioAPj2()
                    nombre!!.text = "Fuyuhiko Kuzuryu"
                    texto!!.text = "¡Je! Si tan desesperado estás... ¿por que no le pillas el libro a alguien de clase en la hora del almuerzo?"
                }
                22 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi6)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¿¡No me digas que hablas del Portal 3!?"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    texto!!.text = "El salón se suele quedar vacío a esa hora, nadie se dará cuenta..."
                }
                23 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi7)
                    texto!!.text = "¡Se agotó nada más salió a la venta! ¿¡Como te hicistes con uno!?"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.leon5)
                    cambio_a_pj1()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "Pfff... Parece que no me queda opción... supongo que se lo pillaré a Hajime o a cualquier pardillo de turno..."
                }
                24 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami5)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "En este caso se trataba de algo muy serio, asi que... ¡estuve refrescando la pagina cada segundo hasta que salió a la venta!"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.leon1)
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "Parece que no tenía que preocuparme por nada... ¡Genial!"
                }
                25 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami6)
                    texto!!.text = "¡Aunque no me arrepiento de nada, porque cada segundo que estuve refrescando en la web valio la pena por ese juego!"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.kuzuryu3)
                    cambioAPj2()
                    nombre!!.text = "Fuyuhiko Kuzuryu"
                    texto!!.text = "Me alegro por tí... y ahora..."
                }
                26 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami3)
                    texto!!.text = "Aunque me sorprende que supieses acerca de ese juego... La gente de clase suele ser muy aplicada por eso de que somos los mejores estudiantes de Japón y eso..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.kuzuryu1)
                    texto!!.text = "¡Dejame mear tranquilo de una maldita vez!"
                }
                27 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami6)
                    texto!!.text = "¿¡No me digas que a ti tambien te gustan este tipo de cosas!?"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Leon se marchó del baño y a los pocos minutos se fue tambien Fuyuhiko..."
                }
                28 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Supongo que si... los disfruto mucho, pero creo que no llegaría a esos límites por uno..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    desapareceFondo()
                    texto!!.text = "Silenciosamente salí del baño asegurandome de que no me viese nadie..."
                }
                29 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami6)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "¡Con que los disfrutes es más que suficiente!"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    texto!!.text = "Llegué a clase a tiempo. Pensé en la conversación que había escuchado en el baño, y en si debería hacer algo al respecto..."
                }
                30 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami3)
                    texto!!.text = "Oye... en los descansos suelo estar en la azotea jugando videojuegos..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.hinata4)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Hey Naegi! ¡Buenos días!"
                }
                31 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami4)
                    texto!!.text = "Si quieres pasarte y jugar juntos a algo no me importaría..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.naegi1)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... buenos días Hajime..."
                }
                32 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi10)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Claro! ¡Pero te advierto que sea el juego que sea no perderé!"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.hinata1)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "¿Eh? ¿Ocurre algo Naegi? Se te ve muy pensativo..."
                }
                33 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.nanami7)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Si si, cuanto más ego tengas más dolorosa será tu derrota..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "No no ¡que va! Solo tengo un poco de sueño, nada más."
                }
                34 -> if (partida!!.cap2_Opcion1 == "1"){
                    desaparecer(pj2!!)
                    desapareceFondo()
                    pj2!!.visibility = android.view.View.INVISIBLE
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Seguimos charlando tranquilamente en el pasillo hasta que llego el momento de entrar a clase a segunda hora."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj2!!.setImageResource(R.drawable.hinata5)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Si tu lo dices... ¡Recuerda que si tienes algún problema puedes contar conmigo!"
                }
                35 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj2!!.setImageResource(R.drawable.kaede1)
                    aparecer(pj2!!)
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    pj2!!.visibility = android.view.View.VISIBLE
                    nombre!!.text = "Kaede Akamatsu"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Naegi! ¿¡Donde te habias metido!?"
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Gracias, lo tendré en cuenta."
                }
                36 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi1)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Jaja... Me quedé dormido..."
                } else if (partida!!.cap2_Opcion1 == "2"){
                    pj1!!.setImageResource(R.drawable.naegi2)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Definitivamente tengo que advertirle de lo que va a hacer León..."
                    cont++
                }
                37 -> if (partida!!.cap2_Opcion1 == "1"){
                    pj1!!.setImageResource(R.drawable.naegi7)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Ni de coña le puedo decir que llegué tarde porque me estaba cagando..."
                }
                38 -> {
                    desaparecer(pj1!!)
                    pj1!!.visibility = android.view.View.INVISIBLE
                    texto!!.text = "Me senté en mi sitio y enseguida empezaron las clases. Fue una mañana larga hasta que llegó la hora del almuerzo..."
                }
                39 -> {
                    mplayer!!.pause()
                    apareceFondo()
                    mplayer4!!.start()
                    nombre!!.visibility = android.view.View.INVISIBLE
                    texto!!.text = "Ding-Dong Bing-Bong"
                }
                40 -> {
                    mplayer!!.seekTo(50000)
                    mplayer!!.start()
                    nombre!!.visibility = android.view.View.VISIBLE
                    pj1!!.visibility = android.view.View.VISIBLE
                    pj1!!.setImageResource(R.drawable.leon6)
                    aparecer(pj1!!)
                    nombre!!.text = "Leon Kuwata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Fiuuu! Creía que no iba a aguantar más, necesito un respiro tronco..."
                }
                41 -> {
                    pj2!!.setImageResource(R.drawable.shuichi2)
                    cambioAPj2()
                    nombre!!.text = "Shuichi Saihara"
                    texto!!.text = "..."
                }
                42 -> {
                    pj1!!.setImageResource(R.drawable.hinata4)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "¡Hey Naegi! Nagito y yo habíamos pensado en salir un rato a que nos de un poco el aire...."
                }
                43 -> {
                    pj1!!.setImageResource(R.drawable.hinata1)
                    texto!!.text = "Las clases de hoy han sido muy intensas y nos vendría bien un poco de aire fresco..."
                }
                44 -> {
                    pj1!!.setImageResource(R.drawable.hinata5)
                    texto!!.text = "Bueno, ¿qué me dices? ¿vienes?"
                    fondoClicks!!.isEnabled = false
                    if (partida!!.cap2_Opcion1 == "1"){
                        bundle!!.putString("opcion1", "Ir a la azotea.")
                        bundle!!.putString("opcion2", "Salir con Hajime y Nagito.")
                        bundle!!.putString("opcion3", "")
                    } else if (partida!!.cap2_Opcion1 == "2"){
                        bundle!!.putString("opcion1", "Advertir a Hajime.")
                        bundle!!.putString("opcion2", "Salir con Hajime y Nagito.")
                        bundle!!.putString("opcion3", "")
                    }
                    opciones = supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones
                    opciones = FragmentoOpciones()
                    opciones!!.arguments = bundle
                    supportFragmentManager.beginTransaction().add(R.id.misOpciones, opciones!!, "misOpciones").commit()
                }
                45 -> {
                    //PUNTO DE SALIDA
                    iconoGuardado!!.startAnimation(animationGuardado)
                    fondoClicks!!.isEnabled = true
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    texto!!.visibility = android.view.View.VISIBLE
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                        pj2!!.setImageResource(R.drawable.naegi7)
                        cambioAPj2()
                        nombre!!.text = "Naegi Makoto"
                        texto!!.text = "Suena genial chicos, pero lo cierto es que ya había acordado reunirme con alguien..."
                    } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                        pj2!!.setImageResource(R.drawable.naegi4)
                        cambioAPj2()
                        nombre!!.text = "Naegi Makoto"
                        texto!!.text = "Suena genial Hajime, pero antes de eso tenemos que hablar de una cosa en privado."
                    } else if (partida!!.cap2_Opcion2 == "2"){ //Standart
                        pj2!!.setImageResource(R.drawable.naegi1)
                        cambioAPj2()
                        nombre!!.text = "Naegi Makoto"
                        texto!!.text = "Si, salgamos un rato. Estoy agotado y necesito despejarme."
                    }
                }
                46 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami3)
                    cambio_a_pj1()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.hinata6)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "¿Eh? Me pregunto que puede ser tan importante..."
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "1"){ //Standart NANAMI
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Salimos de clase tranquilamente... pero al parecer me había olvidado de algo importante..."
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "2"){ //Standart BAÑOS LEON
                    pj2!!.setImageResource(R.drawable.naegi4)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Probablemente Leon no fuese en serio cuando dijo aquellas cosas..."
                }
                47 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami8)
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Cogi a Hajime y nos fuimos al fondo de la clase donde nadie pudiese escucharnos..."
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "1"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nanami3)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "2"){ //Standart BAÑOS LEON
                    pj2!!.setImageResource(R.drawable.naegi1)
                    texto!!.text = "Asi que seguramente no debería preocuparme."
                }
                48 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami9)
                    texto!!.text = "¡Naegi! Me voy adelantando..."
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.naegi12)
                    pj1!!.visibility = View.VISIBLE
                    aparecer(pj1!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Leon planea robarte tu libro!"
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "1"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nanami4)
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "2"){ //Standart BAÑOS LEON
                    pj2!!.visibility = View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.text = "Salimos de clase tranquilamente..."
                }
                49 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.naegi3)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... ahora voy..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.naegi9)
                    texto!!.text = "Le escuché decirlo antes de que empezasen las clases..."
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "1"){ //Standart NANAMI
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    nombre!!.visibility = android.view.View.INVISIBLE
                    texto!!.visibility = android.view.View.INVISIBLE
                } else if (partida!!.cap2_Opcion2 == "2" && partida!!.cap2_Opcion1 == "2"){ //Standart BAÑOS LEON
                    desapareceFondo()
                    nombre!!.visibility = android.view.View.INVISIBLE
                    texto!!.visibility = android.view.View.INVISIBLE
                }
                50 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.hinata6)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Vaya vaya..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    texto!!.text = "Al parecer él se olvidó del suyo y planea robartelo a tí durante la hora del almuerzo."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    fondo!!.setBackgroundResource(R.drawable.back_outside_school)
                    pj2!!.setImageResource(R.drawable.nagito3)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    apareceFondo()
                    nombre!!.text = "Nagito Komaeda"
                    nombre!!.visibility = android.view.View.VISIBLE
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Me sorprende que no tuvieseis nada mejor que hacer que pasar tiempo conmigo..."
                    texto!!.visibility = android.view.View.VISIBLE
                }
                51 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.hinata7)
                    texto!!.text = "Me temo que no podemos competir contra eso... ¡Hahahahaha!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.hinata2)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "¿¡Eh!? ¿Estás seguro de eso Naegi?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nagito4)
                    texto!!.text = "Sobre todo tú Hajime, te sueles quedar en clase estudiando. ¿Qué pasó hoy?"
                }
                52 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Pues entonces otro día vamos juntos. Pasatelo bien Naegi."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.naegi12)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Completamente!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata5)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Bueno, ya sabes... las clases de hoy han sido muy intensas y estaba un poco cansado."
                }
                53 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Hajime se despidió con una mirada cómplice y abandonó el aula junto con Nagito..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.hinata1)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Hajima se quedó pensativo durante unos segundos hasta que por fin me respondió..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Además, ya empieza a hacer buen tiempo y sería un desperdicio no aprovecharlo."
                }
                54 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi2)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Bien, creo que yo debería irme ya..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.hinata2)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Bien! Necesito que vayas a buscar a la delegada. Ella será capaz de arreglar este problema... Mientras tanto Nagito y yo nos quedaremos en clase vigilando a Leon."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata2)
                    texto!!.text = "¡Y te recuerdo que suelo pasar todos los recreos contigo en clase!"
                }
                55 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    desapareceFondo()
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Fui a la azotea donde me estaba esperando Nanami..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.naegi12)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Entendido!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nagito2)
                    cambioAPj2()
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.text = "Si si... pero es que siempre hablas de las asignaturas y no es divertido..."
                }
                56 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    fondo!!.setBackgroundResource(R.drawable.back_school_roof)
                    apareceFondo()
                    pj2!!.setImageResource(R.drawable.naegi1)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Hey Chiaki! ¿Lista para echar una partida?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.visibility = View.INVISIBLE
                    desaparecer(pj1!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Salí del salón de clase como un rayo y me puse a buscar a Kioko, nuestra delegada..."
                    cont++
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata1)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Lo que de verdad es raro es que Naegi venga hoy..."
                }
                57 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami6)
                    nombre!!.text = "Chiaki Nanami"
                    cambio_a_pj1()
                    texto!!.text = "¡Venga Naegi! Eres muy lento..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Sueles pasar tus almuerzos con Sayaka..."
                }
                58 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami10)
                    texto!!.text = "¡Ven a por mi con todo lo que tengas!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    fondo!!.setBackgroundResource(R.drawable.back_outside_school)
                    apareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "...hasta que al final di con ella en el patio de la academia..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.hinata6)
                    texto!!.text = "¿No será que te gusta?"
                }
                59 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi10)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Allá voy!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri1)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Kioko Kirigiri"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nagito4)
                    cambioAPj2()
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.text = "¡Yo creo que le gusta Kaede! ¡Tambien pasan mucho tiempo juntos!"
                }
                60 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Empezamos a jugar... y mientras más tiempo pasaba enfrentandome a ella, más me daba cuenta de que fue un error pensar que podría ganarla..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.naegi7)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Kioko! Te estaba buscando... Hay un problema en clase..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.naegi6)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Pero... ¿¡como narices hemos terminado hablando de esto!?"
                }
                61 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    texto!!.text = "Ella era absurdamente buena en aquel juego, hasta que ocurrió lo inevitable..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri3)
                    cambio_a_pj1()
                    nombre!!.text = "Kioko Kirigiri"
                    texto!!.text = "Tsch... Sabía que algo estaba mal..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.naegi7)
                    texto!!.text = "Kaede es mi amiga desde que somos pequeños, y Sayaka... bueno, simplemente nos hicimos amigos después de que nos tocara limpiar la clase juntos."
                }
                62 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi6)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    texto!!.text = "¿Qué es lo que ocurre?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart BAÑOS LEON
                    pj1!!.setImageResource(R.drawable.naegi4)
                    texto!!.text = "Pero no es como si me gustasen ni nada parecido..."
                }
                63 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami10)
                    cambio_a_pj1()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Y así es como se hace..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.naegi12)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Leon va a intentar robar el libro de Hajime durante el descanso..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.naegi9)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Al menos eso es lo que creo..."
                }
                64 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi6)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri1)
                    cambio_a_pj1()
                    nombre!!.text = "Kioko Kirigiri"
                    texto!!.text = "¿Eh? ¿Solo es eso? ¿Y para qué me necesitais exactamente? ¿No deberíais ser capaces de solucionar esto por vuestra cuenta?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nagito2)
                    cambioAPj2()
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Vamos Naegi, no te lo tomes a mal... Nosotros ni siquiera hablamos con una chica..."
                }
                65 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami8)
                    cambio_a_pj1()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Venga venga... Animate que has jugado bastante bien."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    nombre!!.text = "Naegi Makoto"
                    pj2!!.setImageResource(R.drawable.naegi9)
                    cambioAPj2()
                    texto!!.text = "Pensaba que te tomarías más en serio un problema de la clase..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.nagito3)
                    texto!!.text = "No nos metemos contigo, solo te envidiamos porque eres muy popular con las chicas..."
                }
                66 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami4)
                    texto!!.text = "Estoy segura de que si jugases más a menudo habrías tenido más probabilidades..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.naegi2)
                    texto!!.text = "¡Es una de tus obligaciones como delegada el velar para que no haya ningun problema en clase!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Igual es que todavía no habeis tenido oportunidad de conoceros..."
                }
                67 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi7)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si.. Claro..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    nombre!!.text = "Kyoko Kirigiri"
                    pj1!!.setImageResource(R.drawable.kirigiri6)
                    cambio_a_pj1()
                    texto!!.text = "Jeje... Sabía que dirías eso Naegi... Aunque no olvides que tambien es tuya..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Seguimos charlando normalmente durante nuestro descanso hasta tuvimos que volver a clase..."
                }
                68 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Juego todos los malditos días a este juego y he sido completamente derrotado. Ni en un millón de años podría ganarle."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri4)
                    texto!!.text = "¡Muy bien! Vayamos al salón de clases."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    desapareceFondo()
                }
                69 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    pj1!!.setImageResource(R.drawable.nanami6)
                    cambio_a_pj1()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "¿Que? ¿Te animas a jugar otra partida?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Fuimos caminando en silencio hasta el salón de clases donde estaban Leon, Hajime, Nagito y Fuyuhiko."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "¡Hola Naegi!"
                }
                70 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.nanami7)
                    texto!!.text = "¿o te ha entrado miedo porque sabes que no puedes ganar?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri5)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    nombre!!.text = "Kyoko Kirigiri"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "No sé por qué estais tantos en clase, pero la profesora me encargó hacer unas tareas como delegada de la clase."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.sayaka3)
                    texto!!.text = "Me preguntaba donde te habías metido durante el almuerzo, pero ya veo que estabas con los chicos."
                }
                71 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.naegi10)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Vamos allá! ¡te advierto que esta vez no me pienso contener!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.kirigiri1)
                    texto!!.text = "Asi que os pido amablemente que abandoneis todos la clase para que pueda llevarlas a cabo."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.naegi5)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... resulta que querían que fuesemos juntos hoy ya que normalmente no suelo estar con ellos..."
                }
                72 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Sobra decir que durante toda la hora del almuerzo no conseguí ganarle ni una partida..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.leon7)
                    cambioAPj2()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "¿¡!?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.sayaka2)
                    cambio_a_pj1()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "¡Oh! Ya veo, supongo que está bien..."
                }
                73 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    desapareceFondo()
                    texto!!.text = "Sin embargo, creo que nunca en mi vida me había divertido tanto jugando a un videojuego..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.hinata4)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "En ese momento Hajime me estaba mirando con una cara agradecida y sonriente."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.sayaka4)
                    texto!!.text = "Pero a cambio tendrás que acompañarme a casa cuando terminemos las clases..."
                }
                74 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    nombre!!.visibility = android.view.View.INVISIBLE
                    texto!!.visibility = android.view.View.INVISIBLE
                    cont++
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.hinata5)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Gracias Naegi, al final lo has conseguido..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj1!!.setImageResource(R.drawable.sayaka1)
                    texto!!.text = "Aun que solo si quieres claro..."
                }
                75 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    desapareceFondo()
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Al final todos abandonamos el salón de clase hasta que terminó la hora del almuerzo."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setImageResource(R.drawable.naegi3)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Claro! ¡Cuenta conmigo!"
                }
                76 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ //Ir al baño Nanami
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    nombre!!.visibility = android.view.View.VISIBLE
                    texto!!.visibility = android.view.View.VISIBLE
                    texto!!.text = "Volvimos al salón de clase para las ultimas horas de clase... Pero cinco minutos después de que comenzase la clase pasó algo bastante extraño..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    fondo!!.setBackgroundResource(R.drawable.back_class)
                    apareceFondo()
                    nombre!!.visibility = android.view.View.VISIBLE
                    texto!!.visibility = android.view.View.VISIBLE
                    texto!!.text = "Cuando comenzaron las ultimas horas de clase ocurrió lo inevitable... "
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart NANAMI
                    pj2!!.setVisibility(android.view.View.INVISIBLE)
                    desaparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Volvimos al salón de clase para las ultimas horas de clase... Pero cinco minutos después de que comenzase la clase pasó algo bastante extraño..."
                }
                77 -> {
                    pj2!!.setImageResource(R.drawable.profe1)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "Bien, por favor, sacad todos los libros, vamos a comenzar la clase..."
                }
                78 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.hinata3)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Esto... profesora... creo que me ha desaparecido el libro..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.leon8)
                    cambio_a_pj1()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "..."
                }
                79 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    texto!!.text = "Estoy practicamente seguro de haberlo traido hoy pero no lo encuentro por ninguna parte..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "Esto... profe... se me ha vuelto a olvidar traer el libro..."
                }
                80 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    pj2!!.setImageResource(R.drawable.profe3)
                    cambioAPj2()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "¿Qué clase de excusa es esa, Hajime? ¿Ya sabes lo que ocurre si no traes el libro verdad?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.profe1)
                    cambioAPj2()
                    nombre!!.text = "Hiroko Hagakure"
                    texto!!.text = "Honestamente ya ni me sorprendes Leon..."
                }
                81 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    texto!!.text = "¡No entrásteis en esta academia para ser alumnos mediocres! ¡Fuera de clase ahora mismo!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.profe3)
                    texto!!.text = "...y como ya estás agotando mi paciencia te daré un último aviso... lo próximo será la expulsión."
                }
                82 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    texto!!.text = "¡Espero que esto te haga espabilar para ser un mejor alumno!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.profe1)
                    texto!!.text = "No podemos permitir que sigas desprestigiando esta academia de élite con esa actitud tan despreocupada."
                }
                83 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.hinata1)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Pero..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj2!!.setImageResource(R.drawable.profe3)
                    texto!!.text = "Ahora fuera de clase Leon, y recuerda que ya no hay mas oportunidades..."
                }
                84 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    pj1!!.setImageResource(R.drawable.hinata3)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Si profesora..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                    pj1!!.setImageResource(R.drawable.leon7)
                    cambio_a_pj1()
                    nombre!!.text = "Leon Kuwata"
                    texto!!.text = "Si señora..."
                }
                85 -> {
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                        texto!!.text = "Hajime abandonó la clase cabizbajo..."
                    } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime
                        texto!!.text = "Leon abandonó la clase cabizbajo..."
                        cont++
                    }
                }
                86 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1" || partida!!.cap2_Opcion2 == "2"){ //Ir al baño Nanami
                    texto!!.text = "Era bastante extraño que a Hajime se le hubiese olvidado algo tan importante... Pero no le dí mayor importancia al asunto..."
                }
                87 -> {
                    desapareceFondo()
                    texto!!.text = "El resto de las clases transcurrieron con normalidad hasta que por fin..."
                }
                88 -> {
                    apareceFondo()
                    mplayer!!.pause()
                    mplayer4!!.start()
                    nombre!!.visibility = android.view.View.INVISIBLE
                    texto!!.text = "Ding-Dong Bing-Bong"
                }
                89 -> {
                    mplayer!!.seekTo(50000)
                    mplayer!!.start()
                    nombre!!.visibility = android.view.View.VISIBLE
                    texto!!.text = "Aquel era el sonido de la libertad que tanta alegría nos daba escuchar."
                }
                90 -> {
                    pj1!!.setImageResource(R.drawable.naegi4)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    texto!!.text = "Ahora que las clases han terminado... ¿Qué debería hacer?"
                }
                91 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami9)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¿Qué haces Naegi?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata5)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Hey Naegi! ¡Salgamos a tomar algo!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Hey Naegi! No creas que puedes escaquearte, me prometiste que me acompañarías a casa ¿recuerdas?"
                }
                92 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Ah! ¡Hola Chiaki! Estaba pensando si tenía que hacer algo después de clases..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Quiero agradecerte apropiadamente por tu ayuda durante el almuerzo..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¡Es cierto! Casi se me olvida..."
                }
                93 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami2)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Ya veo..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "No tienes por qué agradecerme... Tu habrías hecho lo mismo por mí."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka3)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "Eso no es bueno Naegi..."
                }
                94 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami4)
                    texto!!.text = "¡Oye! Si no tienes nada que hacer... ¿Te gustaría probar el Portal 3?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata7)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Venga dejame agradecerte... conozco un sitio donde hacen unos batidos geniales."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    texto!!.text = "Mi padre me dijo una vez que los hombres que se precien jamás olvidan sus promesas..."
                }
                95 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Para eso tendría que ir a tu casa... ¿Seguro que no te importa?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.naegi1)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Esta bien ¡cuenta conmigo!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi1)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Tu padre lleva razón Sayaka... es solo que estoy un poco cansado por las clases..."
                }
                96 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami8)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Por mi está bien. Mi instinto me dice que puedo confiar en Naegi."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata5)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "¿Y tu Nagito? ¿Te animas a venir?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi1)
                    texto!!.text = "Bueno ¿estas lista para irnos?"
                }
                97 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi4)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si tu estas de acuerdo no tengo ninguna razón para no ir..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.nagito2)
                    cambio_a_pj1()
                    nombre!!.text = "Nagito Komaeda"
                    texto!!.text = "Lo siento chicos, pero en casa prometí que ayudaría con unas cosas... Divertios sin mí."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "¡Por supuesto!"
                }
                98 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi10)
                    texto!!.text = "Además... ¡me muero de ganas por probar ese juego!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.naegi4)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Que mala suerte..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Abandonamos el instituto y acompañe a Sayaka mientras charlabamos sobre cosas sin importancia... Hasta que llegamos a lo que parecía un parque..."
                }
                99 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami6)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "¡Asi se habla!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.hinata6)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Tendremos que ir otro día con Nagito..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    fondo!!.setBackgroundResource(R.drawable.back_park)
                    apareceFondo()
                    texto!!.visibility = android.view.View.INVISIBLE
                    nombre!!.visibility = android.view.View.INVISIBLE
                }
                100 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Fuimos a casa de Nanami mientras me iba explicando curiosidades acerca de videojuegos que conocía..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj1!!)
                    desapareceFondo()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Hajime me llevó a un local que al parecer es muy popular entre la gente joven."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    texto!!.visibility = android.view.View.VISIBLE
                    nombre!!.visibility = android.view.View.VISIBLE
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    pj2!!.setImageResource(R.drawable.sayaka5)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Ahhh ¡Que bonito es este sitio!"
                }
                101 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami3)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    fondo!!.setBackgroundResource(R.drawable.back_nanami_house)
                    apareceFondo()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Bien! Por fin hemos llegado..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    fondo!!.setBackgroundResource(R.drawable.back_restaurant)
                    apareceFondo()
                    pj1!!.setImageResource(R.drawable.hinata2)
                    pj1!!.visibility = android.view.View.VISIBLE
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Vaya... parece que hay bastante hueco hoy. Normalmente suele estar lleno de estudiantes..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Esto... Sayaka..¿no estamos yendo a tu casa verdad?"
                }
                102 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami9)
                    texto!!.text = "Ponte cómodo mientras traigo las cosas para poder jugar..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.naegi7)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Hajime ¿vienes mucho a este local? Da la impresión de que lo conoces muy bien..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka8)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Sayaka sonrió e ignoró mi pregunta mientras se quedaba mirando el paisaje..."
                }
                103 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "¡No podía ponerme cómodo! ¡Sin darme cuenta estaba en casa de una chica de clase!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.hinata6)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Bueno... no es exactamente eso... lo cierto es que..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    texto!!.text = "Tenía que reconocer que aquel sitio era muy bonito, asi que seguí caminando en silencio mientras admiraba las vistas..."
                }
                104 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    texto!!.text = "Empecé a ponerme nervioso de la situación tán incomoda en la que me encontraba cuando..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.mikan1)
                    cambioAPj2()
                    nombre!!.text = "¿¿??"
                    texto!!.text = "¡Hajime! ¡Has venido!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka4)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¿Sabes? Cuando era muy pequeña solía venir muy a menudo a este parque a jugar... "
                }
                105 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami6)
                    pj2!!.visibility = android.view.View.VISIBLE
                    aparecer(pj2!!)
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "¡Ya estoy aquí!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.hinata5)
                    cambio_a_pj1()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Bueno, ahí lo tienes."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi4)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... creo que mi madre tambien me traía de vez en cuando, pero no lo recuerdo muy bien..."
                }
                106 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami9)
                    texto!!.text = "¿Eh? ¿Te encuentras bien Naegi?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.mikan2)
                    cambioAPj2()
                    nombre!!.text = "Mikan Hinata"
                    texto!!.text = "Vaya, parece que vienes acompañado. Mucho gusto, yo soy Mikan, la hermana de Hajime."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka6)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "..."
                }
                107 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Pues la verdad... esto es un poco..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.naegi1)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Encantado... Mi nombre es Naegi Makoto, soy un compañero de clases."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka1)
                    texto!!.text = "En esa época yo no tenía ningún amigo... Asique siempre jugaba sola."
                }
                108 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi2)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "*Resoplé*"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata5)
                    cambioAPj2()
                    nombre!!.text = "Hajime Hinata"
                    texto!!.text = "Esta es la verdadera razón por la que conozco tán bien este sitio. Todos los días Mikan me cuenta que tal le fue el día en el restaurante, por eso lo conozco tán bien."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "Hasta que un dia otro niño se me acercó y comenzamos a jugar como si nos conociesemos de toda la vida..."
                }
                109 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi9)
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "No puedo tranquilizarme si estoy a solas en casa de una chica."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.hinata4)
                    texto!!.text = "Le prometí a mi hermanita que vendría un día a verla al trabajo y esta me pareció una buena ocasión."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "A partir de ese día, solía jugar con él en este parque todos los días. ¡Estaba tán felíz de haber hecho un amigo por fin!"
                }
                110 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi12)
                    texto!!.text = "¿No se te ha ocurrido pensar que quizás podría intentar hacer algo?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan3)
                    cambio_a_pj1()
                    nombre!!.text = "Mikan Tsumiki"
                    texto!!.text = "Esto... disculpa... igual he escuchado mal, pero has dicho que te apellidabas Makoto ¿verdad?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka1)
                    texto!!.text = "Sin embargo... repentinamente nos tuvimos que mudar a otra ciudad por el trabajo de mi padre. Ni siquiera pude despedirme de mi amigo..."
                }
                111 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami7)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Ohhh... asi que estas pensando en cosas obscenas ¿eh?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan4)
                    texto!!.text = "¿Por casualidad no seras el hermano de Komaru...? Me comentó que su hermano tambien entró en Kibougamine..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka1)
                    texto!!.text = "No tuve problemas para hacer más amigos en la nueva ciudad ni nada por el estilo, pero me seguía sintiendo culpable por no haberme despedido de mi amigo."
                }
                112 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami9)
                    texto!!.text = "Tranquilo, eso no pasará."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.naegi5)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Si... ¿Eres amiga de mi hermana?"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    texto!!.text = "A veces me imaginaba que volvía a la ciudad y él me estaba esperando aqui como siempre..."
                }
                113 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami5)
                    texto!!.text = "Y si intentabas algo te habría puesto en tu sitio."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan7)
                    cambio_a_pj1()
                    nombre!!.text = "Mikan Tsumiki"
                    texto!!.text = "Si, vamos juntas a la escuela media y nos llevamos bastante bien..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka7)
                    texto!!.text = "Esta fue una de las razones por las que quise ingresar en esta academia, quería volver a encontrarme con esa persona..."
                }
                114 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami10)
                    texto!!.text = "Sé que no lo parece pero soy muy hábil en combate cuerpo a cuerpo."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan8)
                    texto!!.text = "Ella es muy buena persona y ayuda cuando alguien se mete conmigo o cuando tengo algún problema..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka4)
                    texto!!.text = "Pero nunca me hubiese imaginado que estaría con él en el mismo instituto y en la misma clase..."
                }
                115 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi5)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "¿En la realidad o en un videojuego?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.naegi1)
                    cambioAPj2()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Me alegro de escuchar eso... Por favor, sigue cuidando de mi hermana."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Sayaka... No me digas que..."
                }
                116 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami11)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Mmmmm... ¡Piensa lo que quieras, yo te he advertido!"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan7)
                    cambio_a_pj1()
                    nombre!!.text = "Mikan Tsumiki"
                    texto!!.text = "¡Por supuesto!"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka2)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "Si, ese niño con el que jugaba eres tú."
                }
                117 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi3)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Jajaja... perdona Chiaki. Te creo, te creo..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.mikan9)
                    texto!!.text = "Por favor, sentaos mientras acabo unos papeles y enseguida os atiendo..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka8)
                    texto!!.text = "No me importa si no te acuerdas de mí, pero quería decirte que has sido una persona muy importante para mí, y que me alegro de esta segunda oportunidad que tengo."
                }
                118 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj1!!.setImageResource(R.drawable.naegi1)
                    texto!!.text = "Entonces ¿qué?... ¿te apetece jugar?"
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    desaparecer(pj1!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Pasamos un rato bastante agradable tomando el batido mientras conocía un poco más acerca de la familia de Hajime..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi7)
                    cambio_a_pj1()
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Lo siento Sayaka... en verdad no lo recuerdo."
                }
                119 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.setImageResource(R.drawable.nanami11)
                    cambioAPj2()
                    nombre!!.text = "Chiaki Nanami"
                    texto!!.text = "Claro, por eso estamos aquí..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    texto!!.text = "Al rato, el local comenzó a llenarse y decidimos irnos para no darle trabajo de mas a Tsumiki..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj1!!.setImageResource(R.drawable.naegi9)
                    texto!!.text = "Por eso... aseguremonos de hacer un montón de recuerdos nuevos para que no los olvide nunca."
                }
                120 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Estuvimos jugando al Portal 3 mientras seguimos charlando sobre cosas como la escuela, aquella situación tan rara, etc..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj1!!.setImageResource(R.drawable.hinata5)
                    pj1!!.visibility = android.view.View.VISIBLE
                    aparecer(pj1!!)
                    nombre!!.text = "Hajime Hinata"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.blanco))
                    texto!!.text = "Bueno, creo que nosotros nos vamos a ir yendo hermanita... que parece que esto se está empezando a llenar..."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.setImageResource(R.drawable.sayaka4)
                    cambioAPj2()
                    nombre!!.text = "Sayaka Maizono"
                    texto!!.text = "Si..."
                }
                121 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    desapareceFondo()
                    texto!!.text = "Despues de un rato jugando tuve que irme ya que comenzaba a oscurecer..."
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.mikan1)
                    cambioAPj2()
                    nombre!!.text = "Mikan Tsumiki"
                    texto!!.text = "Si. ¡Muchas gracias por venir! Espero que hayais disfrutado."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    nombre!!.text = "Naegi Makoto"
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    texto!!.text = "Dimos una vuelta por el parque mientras hablabamos como amigos que se conocían de toda la vida."
                }
                122 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "1"){ // NANAMI TE INVITA A UNA CITA
                    texto!!.text = "Aunque fue una situación extraña, me divertí mucho con Chiaki y fuí capaz de ver una nueva faceta suya..."
                    cont = 124
                } else if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.setImageResource(R.drawable.mikan7)
                    texto!!.text = "Y... Naegi... encantada de haberte conocido... Creo que nos veremos dentro de poco... jiji"
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    desapareceFondo()
                    texto!!.text = "Hasta que al final la acompañé a su casa y nos despedimos..."
                }
                123 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    pj2!!.visibility = android.view.View.INVISIBLE
                    desaparecer(pj2!!)
                    desapareceFondo()
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Salimos del restaurante y nos despedimos tambien Hajime y yo, ya que viviamos en direcciones contrarias."
                } else if (partida!!.cap2_Opcion2 == "2"){ //Standart TE VAS CON SAYAKA
                    texto!!.text = "De camino a casa estuve pensando en lo cercanos que nos habíamos vuelto en tan poco tiempo, y en lo unido que me sentía a ella..."
                    cont++ //FIN ARCO
                }
                124 -> if (partida!!.cap2_Opcion2 == "1" && partida!!.cap2_Opcion1 == "2"){ //Advertir Hajime HAJIME TE INVITA A CASA
                    texto!!.text = "De camino a casa pensé en lo buen amigo que me había vuelto de Hajime y de que podía contar con el para cualquier cosa..."
                }
                125 -> {
                    texto!!.setTextColor(ContextCompat.getColor(this, R.color.pensamiento))
                    nombre!!.text = "Naegi Makoto"
                    texto!!.text = "Desgraciadamente aqui es donde termina la demo... Espero que hayais disfrutado..."
                }
                126 -> {
                    mplayer!!.stop()
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }}
            cont++
        }
    }


    fun tomaDato(a: Int){
        val mybd = BD(this)
        partida = mybd.partida
        if (partida!!.cap1_Opcion1 == "0"){
            partida!!.cap1_Opcion1 = a.toString()
        } else if (partida!!.cap1_Opcion2 == "0"){
            partida!!.cap1_Opcion2 = a.toString()
        } else if (partida!!.cap1_Opcion3 == "0"){
            partida!!.cap1_Opcion3 = a.toString()
        } else if (partida!!.cap2_Opcion1 == "0"){
            partida!!.cap2_Opcion1 = a.toString()
        } else if (partida!!.cap2_Opcion2 == "0"){
            partida!!.cap2_Opcion2 = a.toString()
        }
        mybd.cambiarPartida(partida!!)
        mybd.close()
    }


    private fun cambioAPj2(){
        pj2!!.visibility = android.view.View.VISIBLE
        animation = AnimationUtils.loadAnimation(this, R.anim.pj1veder)
        animation2 = AnimationUtils.loadAnimation(this, R.anim.pj2veder)
        pj2!!.startAnimation(animation2)
        pj1!!.startAnimation(animation)
        pj1!!.visibility = android.view.View.INVISIBLE
    }
    private fun cambio_a_pj1(){
        pj1!!.visibility = android.view.View.VISIBLE
        animation = AnimationUtils.loadAnimation(this, R.anim.pj1veizq)
        animation2 = AnimationUtils.loadAnimation(this, R.anim.pj2veizq)
        pj1!!.startAnimation(animation)
        pj2!!.startAnimation(animation2)
        pj2!!.visibility = android.view.View.INVISIBLE
    }
    private fun aparecer(a: android.widget.ImageView){
        animation3 = AnimationUtils.loadAnimation(this, R.anim.alpha0to100)
        a.startAnimation(animation3)
    }
    private fun desaparecer(a: android.widget.ImageView){
        animation4 = AnimationUtils.loadAnimation(this, R.anim.alpha100to0)
        a.startAnimation(animation4)
    }
    private fun desapareceFondo(){
        animation4 = AnimationUtils.loadAnimation(this, R.anim.alpha0to100)
        fondoanim!!.startAnimation(animation4)
        fondoanim!!.visibility = android.view.View.VISIBLE
    }
    private fun apareceFondo(){
        fondoanim!!.visibility = android.view.View.INVISIBLE
        animation4 = AnimationUtils.loadAnimation(this, R.anim.alpha100to0)
        fondoanim!!.startAnimation(animation4)
    }
    override fun onPause(){
        mplayer!!.stop()
        super.onPause()
    }
    private fun miPartida(){
        val mybd = BD(this)
        partida = mybd.partida
        mybd.close()
        if (partida!!.cap1_Opcion1 == "0"){
            cap = 1
            cont = -1
        } else if (partida!!.cap1_Opcion2 == "0"){
            cap = 1
            cont = 20
        } else if (partida!!.cap1_Opcion3 == "0"){
            cap = 1
            cont = 87
        } else if (partida!!.cap2_Opcion1 == "0"){
            cap = 1
            cont = 132
        } else if (partida!!.cap2_Opcion2 == "0"){
            cap = 2
            cont = 14
        } else if (partida!!.cap2_Opcion3 == "0"){
            cap = 2
            cont = 45
        }
        interaccion()
    }

    override fun onBackPressed() {
        val fondo : ConstraintLayout = findViewById(R.id.clicks)
        var fragmentExitTeatro: FragmentExitTeatro? = supportFragmentManager.findFragmentByTag("MyExitTeatro") as FragmentExitTeatro?

        var fragmentoOpciones: FragmentoOpciones? = supportFragmentManager.findFragmentByTag("misOpciones") as FragmentoOpciones?
        if(fragmentoOpciones != null && !fragmentoOpciones.isHidden){
            val boton1: Button? = fragmentoOpciones!!.activity!!.findViewById(R.id.btn1)
            val boton2: Button? = fragmentoOpciones!!.activity!!.findViewById(R.id.btn2)
            val boton3: Button? = fragmentoOpciones!!.activity!!.findViewById(R.id.btn3)
            boton1?.isEnabled=false
            boton2?.isEnabled=false
            boton3?.isEnabled=false
        }

        if (fragmentExitTeatro == null) {
            fragmentExitTeatro = FragmentExitTeatro()
            supportFragmentManager.beginTransaction().add(R.id.miSalidaTeatro, fragmentExitTeatro, "MyExitTeatro").commit()
            fondo.isEnabled=false
        } else {
            if (fragmentExitTeatro.isHidden || fragmentExitTeatro.isDetached) {
                supportFragmentManager.beginTransaction().attach(fragmentExitTeatro)
                    .show(fragmentExitTeatro).commit()
                fondo.isEnabled = false
            }else{
                supportFragmentManager.beginTransaction().hide(fragmentExitTeatro).commit()
                fondo.isEnabled=true
            }
        }
    }
}