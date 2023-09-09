package seniordeveloper.peter.skylineboutique.closetModel


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import seniordeveloper.peter.skylineboutique.models._menwears

class DBHandler (context: Context?):
        SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {
            override fun onCreate(db:SQLiteDatabase){
                val query = ("CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_TITLE + " TEXT,"
                        + COLUMN_PRICE + " FLOAT,"
                        + COLUMN_CATEGORY + " TEXT,"
                        + COLUMN_DESCRIPTION + " TEXT,"
                        + COLUMN_IMAGE + " TEXT"
                        + ")")

                db.execSQL(query)
            }

    override fun onUpgrade(db:SQLiteDatabase, oldVersion:Int, newVersion: Int){
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "myClosetDB.db"
        val TABLE_NAME = "Mycloset"
        val COLUMN_ID = "_id"
        val COLUMN_TITLE = "title"
        val COLUMN_PRICE = "price"
        val COLUMN_CATEGORY = "category"
        val COLUMN_DESCRIPTION = "description"
        val COLUMN_IMAGE = "image"
    }



    fun initializeDatabaseWithClothesData() {
        val menWears = _menwears // Assuming _menwears is accessible here

        for (clotheData in menWears) {
            addNewCloset(
                clotheData.title,
                clotheData.price,
                clotheData.category,
                clotheData.description,
                clotheData.image
            )
        }
    }
    fun addNewCloset(
        title: String,
        price: Float,
        category: String,
        description: String,
        image: String
    ){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITLE, title)
        values.put(COLUMN_PRICE, price)
        values.put(COLUMN_CATEGORY, category)
        values.put(COLUMN_DESCRIPTION, description)
        values.put(COLUMN_IMAGE, image)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun readAllCloset(): ArrayList<ClosetData> {
        val db = this.readableDatabase
        val cursorCloset:Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val closetArrayList : ArrayList<ClosetData> = ArrayList<ClosetData>()

        if (cursorCloset.moveToFirst()) {
            do {
                closetArrayList.add(
                    ClosetData(
                        cursorCloset.getString(cursorCloset.getColumnIndex(COLUMN_TITLE)),
                        cursorCloset.getFloat(cursorCloset.getColumnIndex(COLUMN_PRICE)),
                        cursorCloset.getString(cursorCloset.getColumnIndex(COLUMN_CATEGORY)),
                        cursorCloset.getString(cursorCloset.getColumnIndex(COLUMN_DESCRIPTION)),
                        cursorCloset.getString(cursorCloset.getColumnIndex(COLUMN_IMAGE))
                    )
                )

            } while (cursorCloset.moveToNext())
        }
        cursorCloset.close()
        return closetArrayList
    }
        }

