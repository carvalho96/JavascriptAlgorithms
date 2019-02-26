package sort

object MergeSort {

  /*
   *
   * PARAM: Array of integers
   * RETURN: Sorted array
   *
   */

  def mergeSort(array: Array[Int]): Array[Int] = {
    //Nesting functions inside mergeSort;

    //The main function, just starts the process of dividing the arrays;
    def startSorting (array: Array[Int]): Array[Int] = {
      divideArray(array, 0, array.length - 1)
    }

    //
    //Divide the array into two shares until it can't divide anymore, then just return the array;
    def divideArray (array: Array[Int], init: Int, end: Int): Array[Int] = {
      if (init < end){

        var mid = (init + end) / 2
        divideArray(array, init, mid)
        divideArray(array, mid+1, end)
        mergeArray(array, init, mid, end)

      } else {

        array

      }
    }

    //Merge two shares of the array sorting it;
    def mergeArray (array: Array[Int], init: Int, mid: Int, end: Int): Array[Int] = {

      var arrayLeft = array.slice(init, mid+1)
      var arrayRight = array.slice(mid+1, end+1)
      var auxLeft = 0
      var auxRight = 0
      var count = init

      while (count < end + 1){

        //Checks if the left array is empty;
        if (auxLeft > arrayLeft.length - 1){
          array(count) = arrayRight(auxRight)

        //Checks if the right array is empty;
        }else if (auxRight > arrayRight.length - 1) {

          array(count) = arrayLeft(auxLeft)
          auxLeft = auxLeft + 1

        //Checks if the left array has the smallest value,  and placed on the beginning of the array if so;
        }else if (arrayLeft(auxLeft) <= arrayRight(auxRight)) {

          array(count) = arrayLeft(auxLeft)
          auxLeft = auxLeft + 1

        //Places a value of the right array on the main array;
        }else {
          array(count) = arrayRight(auxRight)
          auxRight = auxRight + 1
        }

        //Cont var controls if all numbers were already placed on the main array;
        count = count + 1

      }

      array

    }

    startSorting(array)

  }

}