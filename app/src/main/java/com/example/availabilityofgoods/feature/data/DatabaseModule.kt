package com.example.availabilityofgoods.feature.data

import android.content.Context
import androidx.room.Room
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "availability_db"
        ).build()
    }

    @Provides
    fun provideProductAvailabilityDao(db: AppDatabase): ProductAvailabilityDao {
        return db.productAvailabilityDao()
    }
}