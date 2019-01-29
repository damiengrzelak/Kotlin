package usage

fun multiplyMatrixByVector(firstMatrix: Array<List<Int>>, secondMatrix: Array<Int>): ArrayList<ArrayList<Int>> {
    var row: ArrayList<Int>
    val resultList: ArrayList<ArrayList<Int>> = arrayListOf()

    for (i in 0..2) {
        row = arrayListOf()
        for (j in 0..2) {
            row.add(j, firstMatrix[i][j].times(secondMatrix[j]))
        }
        resultList.add(i, row)
    }
    return resultList
}

fun ArrayList<ArrayList<Int>>.showMatrixForm(){
    for (i in 0..2) {
        for (j in 0..2) {
            if(j%3 != 0) {
                print( "" +this[i][j] + " ")
            } else {
                print( "\n" +this[i][j] + " ")
            }
        }
    }
}

fun ArrayList<ArrayList<Int>>.swapPositions(swapFrom: Int, swapTo: Int){
    val swapFromList = this[swapFrom]
    val swapToList = this[swapTo]

    this[swapFrom] = swapToList
    this[swapTo] = swapFromList
}

fun Array<Int>.swapPositions(swapFrom: Int, swapTo: Int) {
    val temp = this[swapFrom]

    this[swapFrom] = this[swapTo]
    this[swapTo] = temp
}

