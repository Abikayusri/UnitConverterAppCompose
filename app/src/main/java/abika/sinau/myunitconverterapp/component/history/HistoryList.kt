package abika.sinau.myunitconverterapp.component.history

import abika.sinau.myunitconverterapp.data.model.Conversion
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier


/**
 * @author by Abika Chairul Yusri on 12/23/2022
 */

@Composable
fun HistoryList(
    list: State<List<Conversion>>,
    onCloseTask: (Conversion) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = list.value, key = { item ->
            item.id
        }) { item ->
            HistoryItem(
                messagePart1 = item.description,
                messagePart2 = item.description,
                onClose = {
                    onCloseTask(item)
                })
        }
    }
}
