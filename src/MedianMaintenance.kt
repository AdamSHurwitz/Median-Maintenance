import java.util.*

class MedianMaintenance {
    var lowHeap = PriorityQueue<Int>(Collections.reverseOrder())
    var highHeap = PriorityQueue<Int>()
    var medianSum = 0

    fun compute(array: IntArray): Int {
        for (i in 1..array.size) {
            if (lowHeap.isEmpty() || array[i - 1] < lowHeap.peek()) {
                lowHeap.add(array[i - 1])
            } else {
                highHeap.add(array[i - 1])
            }
            if (Math.abs(lowHeap.size - highHeap.size) > 1) {
                if (Math.max(lowHeap.size, highHeap.size) == lowHeap.size) {
                    highHeap.add(lowHeap.poll())
                } else {
                    lowHeap.add(highHeap.poll())
                }
            }
            getMedianSum(i)
        }
        return medianSum;
    }

    private fun getMedianSum(i: Int) {
        if (i % 2 == 0) {
            medianSum += lowHeap.peek()
        } else {
            if (Math.max(lowHeap.size, highHeap.size) == lowHeap.size) {
                medianSum += lowHeap.peek()
            } else {
                medianSum += highHeap.peek()
            }
        }
    }
}