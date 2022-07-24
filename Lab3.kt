/**JOSE DANIEL GOMEZ CABRERA 21429
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * PROGRAMACION DE PLATAFORMAS MOVILES
 * Franciso Anzueto*/

fun main() { val result = processList(listOf(25, "Hola!", null, true)); println(result) }

fun processList(inputList: List<Any?>?): List<ItemData>? {
    if (inputList == null) return null //Filtro para evitar error en ejecucion
    var myFinalList = ArrayList<ItemData>()//Crear la lista de ItemData
    for(n in inputList.indices){
        if((inputList[n]!=null)){ //Realizar proceso solo si el elemento no es null (ignora los nulls)
            val objectPosition = n; var objectOriginalValue = inputList[n]; var objectType: String? = null; var objectInfo: String? = null //crear propiedades del objeto ItemData
            when (inputList[n]) { //Evaluar tipo de dato
                is Int -> {
                    objectOriginalValue = inputList[n].toString().toInt(); objectType = "Entero"; val myComparison: Int = inputList[n].toString().toInt(); objectInfo = if((myComparison%10)==0){"M10"} else if((myComparison%5)==0){"M5"} else if((myComparison%2)==0){"M2"} else{null}}
                is String -> {
                    objectOriginalValue = inputList[n].toString(); objectType = "Cadena"; objectInfo = "L"+(objectOriginalValue.toString().length)}
                is Boolean -> {
                    objectOriginalValue = inputList[n].toString().toBoolean(); objectType = "Booleano"; objectInfo = if(objectOriginalValue.toString().toBoolean()) "Verdadero" else "Falso"}
                is Double ->{
                    objectOriginalValue = inputList[n].toString().toDouble()}
                else -> {objectOriginalValue = inputList[n].toString()}}
            myFinalList.add(returnItemData(objectPosition, objectOriginalValue, objectType, objectInfo))}} //Agregar objeto ItemData a lista myFinalList
    return myFinalList}

fun returnItemData(objectPosition:Int, objectOriginalValue:Any?, objectType:String?, objectInfo:String?): ItemData{
    val newItem = ItemData(originalPos = objectPosition, originalValue = objectOriginalValue, type = objectType, info = objectInfo)
    return newItem}

data class ItemData(var originalPos: Int, var originalValue: Any?, var type: String? = null, var info: String? = null)