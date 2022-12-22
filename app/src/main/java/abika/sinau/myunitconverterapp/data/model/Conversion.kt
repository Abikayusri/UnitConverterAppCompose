package abika.sinau.myunitconverterapp.data.model


/**
 * @author by Abika Chairul Yusri on 12/22/2022
 */
data class Conversion(
    val id: Int,
    val description: String,
    val convertFrom: String,
    val convertTo: String,
    val multiplyBy: Double
)
