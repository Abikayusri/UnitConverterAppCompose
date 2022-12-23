package abika.sinau.myunitconverterapp.component.converter

import abika.sinau.myunitconverterapp.data.model.Conversion
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.math.RoundingMode
import java.text.DecimalFormat


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

    val inputText: MutableState<String> = remember {
        mutableStateOf("")
    }

    val typedValue = remember {
        mutableStateOf("0.0")
    }

    ConversionMenu(list = list, isLandscape = false, convert = {
        selectedConversion.value = it

    })

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText, calculate = { input ->
            Log.i("MYTAG", "User Typed: $input")
            typedValue.value = input
        })
    }

    if (typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input * multiply

        // rounding off the result to 4 decimal places
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
        if (toSave) {
//            save(message1, message2)
            toSave = false
        }
        ResultBlock(message1, message2)
    }
}