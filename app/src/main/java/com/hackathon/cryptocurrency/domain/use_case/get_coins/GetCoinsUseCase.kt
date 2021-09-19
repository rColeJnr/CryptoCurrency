package com.hackathon.cryptocurrency.domain.use_case.get_coins

import com.hackathon.cryptocurrency.common.Resources
import com.hackathon.cryptocurrency.data.remote.dto.toCoin
import com.hackathon.cryptocurrency.domain.model.Coin
import com.hackathon.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resources<List<Coin>>> = flow {
        try {
            emit(Resources.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resources.Success(coins))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error("Coildn't reach server. Check your internet connection"))
        }
    }
}