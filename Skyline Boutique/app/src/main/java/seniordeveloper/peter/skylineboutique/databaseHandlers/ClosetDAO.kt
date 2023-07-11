package seniordeveloper.peter.skylineboutique.databaseHandlers

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClosetDAO {
    @Query("SELECT * FROM closet")
    fun getAll(): List<Closet?>?

    @Query("SELECT * FROM closet WHERE clotheId IN (:clotheIds)")
    fun loadAllByIds(clotheIds: IntArray?): List<Closet?>?

    @Query("SELECT * FROM closet WHERE clotheName LIKE :first AND " +
            "clotheName LIKE :last LIMIT 1")
    fun findByName(first: String?, last: String?): Closet?


    @Insert
    fun insertAll(vararg closets: Closet?)

    @Delete
    fun delete(closet: Closet?)

    @Query("DELETE FROM closet")
    fun deleteAll()

    @Query("DELETE FROM closet WHERE clotheId = :id")
    fun deleteById(id: Int)

    fun update(id:Int) {

    }


}

@Dao
interface CartDAO {
    @Query("SELECT * FROM cart")
    fun getAll(): List<Cart?>?

    @Query("SELECT * FROM cart WHERE cartId IN (:cartIds)")
    fun loadAllByIds(cartIds: IntArray?): List<Cart?>?

    @Query("SELECT * FROM cart WHERE cartName LIKE :first AND " +
            "cartName LIKE :last LIMIT 1")
    fun findByName(first: String?, last: String?): Cart?

    @Insert
    fun insertAll(vararg carts: Cart?)

    @Delete
    fun delete(cart: Cart?)

}