package seniordeveloper.peter.skylineboutique.databaseHandlers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Closet::class, Cart::class], version = 1)
abstract class ClosetDatabase : RoomDatabase() {
    abstract fun closetDao(): ClosetDAO
    abstract fun cartDao(): CartDAO

    companion object {
        private var INSTANCE: ClosetDatabase? = null
        fun getInstance(context: Context?): ClosetDatabase? {
            if (INSTANCE == null) {
                synchronized(ClosetDatabase::class) {
                    if (context != null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ClosetDatabase::class.java, "closet.db"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}



