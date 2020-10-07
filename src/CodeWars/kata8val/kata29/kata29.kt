package CodeWars.kata8val.kata29
import kotlin.*
fun main() {
 val sif: SmallestIntegerFinder = SmallestIntegerFinder()
    println(sif.findSmallestInt(listOf(15, 20, 10, 17, 22, 9001)))
}

class SmallestIntegerFinder {

    fun findSmallestInt(nums: List<Int>): Int {
        var smallesInteger = nums[nums.size - 1]
        for (i in 1..nums.size - 1) {
            if (nums[i] < smallesInteger) smallesInteger = nums[i]
        }
        return smallesInteger
    }
}

/*

class SmallestIntegerFinder {

  fun findSmallestInt(nums: List<Int>): Int {
    val listCopy = nums.toMutableList()
    listCopy.sort()
    return listCopy[0] // Implement me!
  }

}
 */