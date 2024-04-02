package com.example.quotesappusingroomandretrofitmvvm

import android.app.Application
import com.example.quotesappusingroomandretrofitmvvm.api.QuoteService
import com.example.quotesappusingroomandretrofitmvvm.api.RetrofitHelper
import com.example.quotesappusingroomandretrofitmvvm.db.QuoteDatabase
import com.example.quotesappusingroomandretrofitmvvm.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)

    }
}