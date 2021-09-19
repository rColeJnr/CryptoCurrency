package com.hackathon.cryptocurrency.domain.use_case.get_coin

import com.hackathon.cryptocurrency.common.Resources
import com.hackathon.cryptocurrency.data.remote.dto.toCoinDetail
import com.hackathon.cryptocurrency.domain.model.CoinDetail
import com.hackathon.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resources<CoinDetail>> = flow {
        try {
            emit(Resources.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resources.Success(coin))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error("Coildn't reach server. Check your internet connection"))
        }
    }
}