package seniordeveloper.peter.skylineboutique.databaseHandlers

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "closet")
class Closet {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "clotheId")
    var id: Int = 0

    @ColumnInfo(name = "clotheName")
    var name: String? = null
    var address: String? = null

    @ColumnInfo(name = "clothePrice")
    var price: Float? = null

    @ColumnInfo(name = "clotheImage")
    var image: Int? = null

    @ColumnInfo(name = "clotheCategory")
    var category: String? = null

    @ColumnInfo(name = "clotheTitle")
    var title: String? = null

    @ColumnInfo(name = "clotheDescription")
    var description: String? = null



    constructor() {}

    constructor(id: Int, name: String, address: String, price: Float, image: Int, category: String, description: String) {
        this.id = id
        this.name = name
        this.address = address
        this.price = price
        this.image = image
        this.category = category
        this.description = description

    }

    constructor(name: String, address: String, price: Float, image: Int, category: String, description: String) {
        this.name = name
        this.address = address
        this.price = price
        this.image = image
        this.category = category
        this.description = description
    }
}

@Entity(tableName = "cart")
class Cart {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cartId")
    var id: Int = 0

    @ColumnInfo(name = "cartName")
    var name: String? = null
    var address: String? = null

    @ColumnInfo(name = "cartPrice")
    var price: Float? = null

    @ColumnInfo(name = "cartImage")
    var image: Int? = null

    @ColumnInfo(name = "cartCategory")
    var category: String? = null

    @ColumnInfo(name = "cartDescription")
    var description: String? = null

    @ColumnInfo(name = "cartQuantity")
    var quantity: Int? = null

    constructor()

    constructor(id: Int, name: String, address: String, price: Float, image: Int, category: String, description: String, quantity: Int) {
        this.id = id
        this.name = name
        this.address = address
        this.price = price
        this.image = image
        this.category = category
        this.description = description
        this.quantity = quantity
    }

    constructor(name: String, address: String, price: Float, image: Int, category: String, description: String, quantity: Int) {
        this.name = name
        this.address = address
        this.price = price
        this.image = image
        this.category = category
        this.description = description
        this.quantity = quantity
    }
}

