package com.example.revisaodois.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // bellow is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + "INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT," +
                END_COL + " TEXT," +
                BAR_COL + "TEXT," +
                CEP_COL + "TEXT," + ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addPessoa(name: String, endereco : String, bairro : String, cep : String){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(NAME_COL, name)
        values.put(END_COL, endereco)
        values.put(BAR_COL, bairro)
        values.put(CEP_COL, cep)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in out database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "appSQLite"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the  variable for table name
        val TABLE_NAME = "CadastroPessoa"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val NAME_COL = "name"

        // below is the variable for age column
        val END_COL = "endereco"

        // below is the variable for age column
        val BAR_COL = "bairro"

        // below is the variable for age column
        val CEP_COL = "cep"
    }
}

