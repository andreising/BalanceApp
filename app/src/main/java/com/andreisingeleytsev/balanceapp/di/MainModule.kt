package com.andreisingeleytsev.balanceapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.andreisingeleytsev.balanceapp.data.list_manager.ListManager
import com.andreisingeleytsev.balanceapp.data.room.BalanceAppMainDataBase
import com.andreisingeleytsev.balanceapp.data.room.repository.DiaryItemRepositoryImpl
import com.andreisingeleytsev.balanceapp.domain.get_list.GetListRepository
import com.andreisingeleytsev.balanceapp.domain.onboard.OnboardStateRepository
import com.andreisingeleytsev.balanceapp.domain.room.DiaryItemRepository
import com.andreisingeleytsev.playingquizapp.data.datastore.DataStoreHub
import com.andreisingeleytsev.playingquizapp.data.datastore.repository.OnBoardStateRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideDataStoreHub(
        @ApplicationContext context: Context
    ) = DataStoreHub(context = context)

    @Provides
    @Singleton
    fun provideOnBoardStateRepository(dataStoreHub: DataStoreHub): OnboardStateRepository {
        return OnBoardStateRepositoryImpl(dataStoreHub)
    }

    @Provides
    @Singleton
    fun provideListManager(
        @ApplicationContext context: Context
    ) = ListManager(context = context)

    @Provides
    @Singleton
    fun provideGetListRepository(listManager: ListManager): GetListRepository {
        return listManager
    }

    @Provides
    @Singleton
    fun provideMainDatabase(app: Application): BalanceAppMainDataBase {
        return Room.databaseBuilder(
            app,
            BalanceAppMainDataBase::class.java,
            "diary_db"
        ).build()
    }

    @Provides
    @Singleton
    fun  provideDiaryItemRepository(dataBase: BalanceAppMainDataBase): DiaryItemRepository{
        return DiaryItemRepositoryImpl(dataBase.diaryItemDao)
    }
}