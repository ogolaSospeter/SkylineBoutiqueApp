package seniordeveloper.peter.skylineboutique.databaseHandlers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClosetRepository (private val closetDao: ClosetDAO) {
    private  val  coroutineScope = CoroutineScope(Dispatchers.IO)

    val allClothes: List<Closet?>? = closetDao.getAll()

    fun getCloset(closet: Closet) {
        coroutineScope.launch {
            closetDao.getAll()
        }
    }

    fun getClosetById(id: Int) {
        coroutineScope.launch {
            closetDao.loadAllByIds(intArrayOf(id))
        }
    }

    fun deleteClosetbyId(id: Int) {
        coroutineScope.launch {
            closetDao.deleteById(id)
        }
    }

    fun addCloset(closet: Closet) {
        coroutineScope.launch {
            closetDao.insertAll(closet)
        }
    }

    fun deleteCloset(closet: Closet) {
        coroutineScope.launch {
            closetDao.delete(closet)
        }
    }

    fun updateClosetbyId(id: Int) {
        coroutineScope.launch {
            closetDao.update(id)
        }
    }

    suspend fun insert(closet: Closet) {
        closetDao.insertAll(closet)
    }

    suspend fun delete(closet: Closet) {
        closetDao.delete(closet)
    }

    suspend fun deleteAll() {
        closetDao.deleteAll()
    }

    suspend fun deleteById(id: Int) {
        closetDao.deleteById(id)
    }



}

class CartRepository(private  val CartDAO:CartDAO)
{

}


//private val repository: ClosetRepository = TODO()
//val closetDB = ClosetDatabase.getInstance(context = Application())
//val closetDao = closetDB?.closetDao()
//val cartDao = closetDB?.cartDao()
//val closetRepository = ClosetRepository(closetDao!!)
//val cartRepository = CartRepository(cartDao!!)



