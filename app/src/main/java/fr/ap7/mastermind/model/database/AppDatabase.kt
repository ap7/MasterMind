package fr.ap7.mastermind.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.ap7.mastermind.model.Post
import fr.ap7.mastermind.model.PostDao

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}