package com.example.divergences

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class BD(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        // TODO Auto-generated method stub
        db.execSQL(
            "create table " + GameBase.GameEntry.Table_Game.toString() + "("
                    + GameBase.GameEntry.id.toString() + " String primary key,"
                    + GameBase.GameEntry.Cap1_Opcion1.toString() + " text,"
                    + GameBase.GameEntry.Cap1_Opcion2.toString() + " text,"
                    + GameBase.GameEntry.Cap1_Opcion3.toString() + " text,"
                    + GameBase.GameEntry.Cap2_Opcion1.toString() + " text,"
                    + GameBase.GameEntry.Cap2_Opcion2.toString() + " text,"
                    + GameBase.GameEntry.Cap2_Opcion3.toString() + " text)"
        )
        val contentValues = ContentValues()
        contentValues.put(GameBase.GameEntry.id, "1")
        contentValues.put(GameBase.GameEntry.Cap1_Opcion1, "0")
        contentValues.put(GameBase.GameEntry.Cap1_Opcion2, "0")
        contentValues.put(GameBase.GameEntry.Cap1_Opcion3, "0")
        contentValues.put(GameBase.GameEntry.Cap2_Opcion1, "0")
        contentValues.put(GameBase.GameEntry.Cap2_Opcion2, "0")
        contentValues.put(GameBase.GameEntry.Cap2_Opcion3, "0")
        db.insert(GameBase.GameEntry.Table_Game, null, contentValues)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + GameBase.GameEntry.Table_Game)
        onCreate(db)
    }

    fun nuevaPartida() {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(GameBase.GameEntry.id, 1)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion1, 0)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion2, 0)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion3, 0)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion1, 0)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion2, 0)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion3, 0)
        db.update(GameBase.GameEntry.Table_Game, contentValues, null, null)
    }

    fun cambiarPartida(a: Game) {
        val db = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(GameBase.GameEntry.id, a.id)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion1, a.cap1_Opcion1)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion2, a.cap1_Opcion2)
        contentValues.put(GameBase.GameEntry.Cap1_Opcion3, a.cap1_Opcion3)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion1, a.cap2_Opcion1)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion2, a.cap2_Opcion2)
        contentValues.put(GameBase.GameEntry.Cap2_Opcion3, a.cap2_Opcion3)
        db.update(GameBase.GameEntry.Table_Game, contentValues, null, null)
    }

    val partida: Game
        get() {
            val db = this.readableDatabase
            val projection = arrayOf<String>(
                GameBase.GameEntry.Cap1_Opcion1,
                GameBase.GameEntry.Cap1_Opcion2,
                GameBase.GameEntry.Cap1_Opcion3,
                GameBase.GameEntry.Cap2_Opcion1,
                GameBase.GameEntry.Cap2_Opcion2,
                GameBase.GameEntry.Cap2_Opcion3
            )
            val res = db.query(
                GameBase.GameEntry.Table_Game,
                projection,
                null,
                null,
                null,
                null,
                null
            )
            val aux = Game()
            res.moveToFirst()
            aux.id="1"
            aux.cap1_Opcion1=res.getString(0)
            aux.cap1_Opcion2=res.getString(1)
            aux.cap1_Opcion3=res.getString(2)
            aux.cap2_Opcion1=res.getString(3)
            aux.cap2_Opcion2=res.getString(4)
            aux.cap2_Opcion3=res.getString(5)
            return aux
        }

    companion object {
        const val DATABASE_NAME = "BaseDatosAndroid.db"
    }
}
