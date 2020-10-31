package com.example.divergences

import android.provider.BaseColumns


class GameBase {
    object GameEntry : BaseColumns {
        const val Table_Game = "Juego"
        const val id = "id"
        const val Cap1_Opcion1 = "Opcion1"
        const val Cap1_Opcion2 = "Opcion2"
        const val Cap1_Opcion3 = "Opcion3"
        const val Cap2_Opcion1 = "Opcion4"
        const val Cap2_Opcion2 = "Opcion5"
        const val Cap2_Opcion3 = "Opcion6"
    }
}