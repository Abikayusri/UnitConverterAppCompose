package abika.sinau.myunitconverterapp.component.converter

import abika.sinau.myunitconverterapp.data.model.Conversion
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


/**
 * @author by Abika Chairul Yusri on 12/22/2022
 */

@Composable
fun TopScreen(
    list: List<Conversion>,
//    selectedConversion: MutableState<Conversion?>,
//    inputText: MutableState<String>,
//    typedValue: MutableState<String>,
//    isLandscape: Boolean,
//    save: (String, String) -> Unit
) {
    var toSave by remember {
        mutableStateOf(false)
    }

    val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }

    val inputText : MutableState<String> = remember {
        mutableStateOf("")
    }

    ConversionMenu(list = list, isLandscape = false, convert = {
        selectedConversion.value = it

    })

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText)
    }
}