package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val listNeighbours = createNumberNeighbours()

        val numberChars = number.toCharArray()

        val result = mutableListOf<String>()
        for (i in numberChars.indices) {
            if (!numberChars[i].isDigit()) {
                return null
            }

            val neighbourNumber = numberChars.clone()
            val neighbours : List<Int>? = listNeighbours[Character.getNumericValue(neighbourNumber[i])]
            findAllNeighbours(i, result, neighbours, neighbourNumber)
        }
        return result.toTypedArray()
    }

    private fun findAllNeighbours(
        position : Int,
        futureResult: MutableList<String>,
        neighbours : List<Int>?,
        number : CharArray
    ) {
        neighbours?.let {
            for (j in it.indices) {
                number[position] = '0' + it[j]
                futureResult.add(number.joinToString(
                    separator = ""
                ))
            }
        }
    }

    private fun createNumberNeighbours() : Map<Int, List<Int>> {
        return mapOf(
            0 to listOf(8),
            1 to listOf(2,4),
            2 to listOf(1,3,5),
            3 to listOf(2,6),
            4 to listOf(1,5),
            5 to listOf(2,4,6,8),
            6 to listOf(3,5,9),
            7 to listOf(4,8),
            8 to listOf(5,7,9,0),
            9 to listOf(8,6)
        )
    }
}
