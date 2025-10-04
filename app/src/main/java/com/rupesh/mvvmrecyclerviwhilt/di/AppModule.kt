package com.rupesh.mvvmrecyclerviwhilt.di

import com.rupesh.mvvmrecyclerviwhilt.core.utils.Constants.BASE_URL
import com.rupesh.mvvmrecyclerviwhilt.data.api.CharacterApi
import com.rupesh.mvvmrecyclerviwhilt.data.repository.CharacterRepositoryImpl
import com.rupesh.mvvmrecyclerviwhilt.domain.reposittory.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit) :CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(characterApi: CharacterApi) : CharacterRepository =
        CharacterRepositoryImpl(characterApi)
}