package seniordeveloper.peter.skylineboutique.closetModel

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import seniordeveloper.peter.skylineboutique.models.LoginData
import seniordeveloper.peter.skylineboutique.models._menwears

class ClosetDBHandler(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val closetTableQuery = ("CREATE TABLE " + CLOSET_TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_PRICE + " FLOAT,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_IMAGE + " TEXT"
                + ")")

        val shoppingCartTableQuery = ("CREATE TABLE " + SHOPPING_CART_TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_PRICE + " FLOAT,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_IMAGE + " TEXT"
                + ")")

        val loginTableQuery = ("CREATE TABLE " + LOGIN_TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USEREMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT"
                + ")")

        db.execSQL(closetTableQuery)
        db.execSQL(shoppingCartTableQuery)
        db.execSQL(loginTableQuery)

    }
    fun initializeDatabaseWithClothesData() {
        val menWears = _menwears // Assuming _menwears is accessible here

        for (clotheData in menWears) {
            addNewCloth(
                clotheData.title,
                clotheData.price,
                clotheData.category,
                clotheData.description,
                clotheData.image
            )
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        // Drop older table if existed
        db?.execSQL("DROP TABLE IF EXISTS $CLOSET_TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $SHOPPING_CART_TABLE_NAME")
        db?.execSQL("DROP TABLE IF EXISTS $LOGIN_TABLE_NAME")

        // Create tables again
        onCreate(db!!)

    }

    // Other functions for adding, reading, and updating data...

    companion object {
        private const val DB_VERSION = 1
        private const val DB_NAME = "myClosetDB.db"
        const val CLOSET_TABLE_NAME = "Closet"
        const val SHOPPING_CART_TABLE_NAME = "ShoppingCart"
        const val LOGIN_TABLE_NAME = "Login"
        const val COLUMN_ID = "_id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_PRICE = "price"
        const val COLUMN_CATEGORY = "category"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_IMAGE = "image"
        const val COLUMN_USEREMAIL = "useremail"
        const val COLUMN_PASSWORD = "password"

        // Other column and table names...
    }
//Handling the Clothes Database
    fun addNewCloth(
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
        db.insert(CLOSET_TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getClosetData(): ArrayList<ClosetData>? {
        val db = this.readableDatabase
        val cursor:Cursor = db.rawQuery("SELECT * FROM $CLOSET_TABLE_NAME", null)
        val clothesArrayList: ArrayList<ClosetData> = ArrayList()
        if (cursor.moveToFirst()) {
            do {
                clothesArrayList.add(
                    ClosetData(
                    cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                    cursor.getFloat(cursor.getColumnIndex(COLUMN_PRICE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
                )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return clothesArrayList
    }

    fun deleteCloth(title: String) {
        val db = this.writableDatabase
        db.delete(CLOSET_TABLE_NAME, "$COLUMN_TITLE = ?", arrayOf(title))
        db.close()
    }

    @SuppressLint("Range")
    fun getClotheItem(title: String): ClosetData? {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $CLOSET_TABLE_NAME WHERE $COLUMN_TITLE = '$title'", null)
        var clothe: ClosetData? = null
        if (cursor.moveToFirst()) {
            clothe = ClosetData(
                cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                cursor.getFloat(cursor.getColumnIndex(COLUMN_PRICE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)),
                cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)),
                cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
            )
        }
        cursor.close()
        db.close()
        return clothe
    }

    //The login database functions

    fun addUser(username: String, password: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USEREMAIL, username)
        values.put(COLUMN_PASSWORD, password)
        db.insert(LOGIN_TABLE_NAME, null, values)
        db.close()
    }

    fun updateUser(username: String, password: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USEREMAIL, username)
        values.put(COLUMN_PASSWORD, password)
        db.update(LOGIN_TABLE_NAME, values, "$COLUMN_USEREMAIL = ?", arrayOf(username))
        db.close()
    }

    fun deleteUser(username: String) {
        val db = this.writableDatabase
        db.delete(LOGIN_TABLE_NAME, "$COLUMN_USEREMAIL = ?", arrayOf(username))
        db.close()
    }

    @SuppressLint("Range")
    fun getUser(useremail: String): LoginData? {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $LOGIN_TABLE_NAME WHERE $COLUMN_USEREMAIL = '$useremail'", null)
        var user: LoginData? = null
        if (cursor.moveToFirst()) {
            user = LoginData(
                cursor.getString(cursor.getColumnIndex(COLUMN_USEREMAIL)),
                cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
            )
        }
        cursor.close()
        db.close()
        return user

    }

    //The shopping cart database functions

    fun addNewClothToCart(
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
        db.insert(SHOPPING_CART_TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getCartItem(title: String): ClosetData? {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $SHOPPING_CART_TABLE_NAME WHERE $COLUMN_TITLE = '$title'", null)
        var cart: ClosetData? = null
        if (cursor.moveToFirst()) {
            cart = ClosetData(
                cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                cursor.getFloat(cursor.getColumnIndex(COLUMN_PRICE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)),
                cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)),
                cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
            )
        }
        cursor.close()
        db.close()
        return cart
    }

    @SuppressLint("Range")
    fun getCartData(): ArrayList<ClosetData>? {
        val db = this.readableDatabase
        val cursor:Cursor = db.rawQuery("SELECT * FROM $SHOPPING_CART_TABLE_NAME", null)
        val cartArrayList: ArrayList<ClosetData> = ArrayList()
        if (cursor.moveToFirst()) {
            do {
                cartArrayList.add(
                    ClosetData(
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getFloat(cursor.getColumnIndex(COLUMN_PRICE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return cartArrayList
    }

    @SuppressLint("Range")
    fun getCartCount(): Int {
        val db = this.readableDatabase
        val cursor:Cursor = db.rawQuery("SELECT * FROM $SHOPPING_CART_TABLE_NAME", null)
        val cartArrayList: ArrayList<ClosetData> = ArrayList()
        if (cursor.moveToFirst()) {
            do {
                cartArrayList.add(
                    ClosetData(
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getFloat(cursor.getColumnIndex(COLUMN_PRICE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE))
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return cartArrayList.size
    }

    fun deleteCartItem(title: String) {
        val db = this.writableDatabase
        db.delete(SHOPPING_CART_TABLE_NAME, "$COLUMN_TITLE = ?", arrayOf(title))
        db.close()
    }



}
