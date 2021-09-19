package com.hackathon.cryptocurrency.domain.repository

import com.hackathon.cryptocurrency.data.remote.dto.CoinDetailDto
import com.hackathon.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto

}