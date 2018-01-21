import java.io.File

object MedianMaintenanceTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var list = arrayListOf<Int>()
        File("src/data/fullDataSet.txt")
                .inputStream()
                .bufferedReader()
                .useLines { lines ->
                    lines.forEach {
                        list.add(it.toInt())
                    }
                }
        println("Medium Sum: " + MedianMaintenance().compute(list.toIntArray()))
    }
}