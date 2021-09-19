package com.hackathon.cryptocurrency.presentation.coin_detail

import com.hackathon.cryptocurrency.domain.model.Coin
import com.hackathon.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
