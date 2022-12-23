package abika.sinau.myunitconverterapp.component

import abika.sinau.myunitconverterapp.component.converter.TopScreen
import abika.sinau.myunitconverterapp.component.history.HistoryScreen
import abika.sinau.myunitconverterapp.presentation.ConverterViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


/**
 * @author by Abika Chairul Yusri on 12/22/2022
 */

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel()
){
    val list = converterViewModel.getConversions()

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list)
        Spacer(modifier = modifier.height(20.dp))
//        HistoryScreen()
    }
}