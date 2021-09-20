package com.hackathon.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.hackathon.cryptocurrency.data.remote.dto.Team


@Composable
fun TeamListItem(
    teamMember: Team,
    modifier: Modifier = Modifier
){
    Text(
        text = teamMember.name,
        style = MaterialTheme.typography.h4
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = teamMember.position,
        style = MaterialTheme.typography.body2,
        fontStyle = FontStyle.Italic
    )
}