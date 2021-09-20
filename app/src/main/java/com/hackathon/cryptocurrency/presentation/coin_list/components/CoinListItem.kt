package com.hackathon.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import com.hackathon.cryptocurrency.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick:(Coin) -> Unit
    ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coin.is_active) "active" else "innactive",
            color = if (coin.is_active) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
        )
    }
}