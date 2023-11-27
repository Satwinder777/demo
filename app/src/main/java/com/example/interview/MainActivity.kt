package com.example.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.interview.repository.UserRepository
import com.example.interview.retrofitHelper.RetrofitHelper
import com.example.interview.viewmodel.MyViewModelFactory
import com.example.interview.viewmodel.UserViewModel
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var repository = UserRepository(RetrofitHelper.service)
        var viewModel = ViewModelProvider(this, MyViewModelFactory(repository)).get(UserViewModel::class.java)

        viewModel.userss.observe(this, Observer {
            it.forEach {

                Log.e("detailsusers", "onCreate: ${it.name}>>${it.email}", )

            }
        })
    }
}

//fun main() {
//    var arr = intArrayOf(22,54,7,14,7,787,14,5,78)
////    rmduplicate(arr)
////    sortArray(arr)
////     findDuplicates(arr)
////    swapNumber(5,11)
////    addUsingRecursion(arr,arr.size,0)
////    isVowel("z")
////    println(getFactorial(6))
//
//
////    palendrome("clamkdkmac")
////    table(5)
////    fabonaci(2,3)
////    atoz('Z')
//
////    reversesentence("sattaShergill")
////    largestNumber(arr)
////    charfreq('s',"sattaShergill" )
////    myTrangle(5)
////    isPrime(49)
//
////daigonalMatrix(9)
//
////    addTwoMatrix(2,3)
//
//   multiplyArrays(arrayOf(intArrayOf(1,2,3),intArrayOf(5,9,3)),arrayOf(intArrayOf(3,4,2),intArrayOf(4,0,2),intArrayOf(4,0,2)))
//}

fun addTwoMatrix(r:Int,c:Int){
    val first = arrayOf(intArrayOf(1,2,3),intArrayOf(5,9,4))
    val second = arrayOf(intArrayOf(3,4,3),intArrayOf(4,0,3))

    val sum = Array(r){ IntArray(c) }

    for (i in 0 ..r-1){
        for (j in 0 ..c-1){
            sum [i] [j] = first [i] [j] * second [i] [j]
            print("${ sum[i][j] }   ")
        }
println()
    }





}
//fun multiplyArrays(arr1: kotlin.Array<IntArray>, arr2: kotlin.Array<IntArray>){
////    require(arr1.size == arr2.size) { "Arrays must be of the same length" }
//
//    val result = Array(arr1.size){IntArray(arr2[0].size)}
//
//    for(i in 0..arr1.size-1){
//        var sum  = 0
//        for (j in 0..arr2.size){
//
//            for (s in 0..arr2[i].size-1){
//                sum = arr1 [i] [j] * arr2 [i] [j]
//            }
//            result[i][j] = sum
//        }
//        print("${sum}  ")
//    }
//}

//fun multiplyArrays(arr1: kotlin.Array<IntArray>, arr2: kotlin.Array<IntArray>) {
//    val rows1 = arr1.size
//    val columns1 = arr1[0].size
//    val rows2 = arr2.size
//    val columns2 = arr2[0].size
//
////    if (columns1 != rows2) {
////        throw IllegalArgumentException("Matrix multiplication not possible")
////    }
//    val result = Array(rows1) { IntArray(columns2) }
//
////    for (i in 0 until rows1){
////        var sum = 0
////        for (j in 0 until columns2){
////            for ( n in 0 until columns2){
////                sum += arr1[i][j] * arr2[n][j]
////            }
////            result [i][j] = sum
////        }
////        print("$sum  ")
////    }
//
//    for (i in 0 until rows1){
//        print("i1=pointer>>$i   ")
//        var sum = 0
//        for (j in 0 until columns2){
//            print("j2=pointer>>$j   ")
//
//            for (k in 0 until columns1){
//                print("k3=pointer>>$k   ")
//                sum += arr1[i][k] * arr2[k][j]
//            }
//        }
//        println()
//    }
//
////    result.forEach {it1->
////        it1.forEach {it2->
////            print("${it2} ")
////        }
////        println()
////    }
//}

fun multiplyArrays(arr1: kotlin.Array<IntArray>, arr2: kotlin.Array<IntArray>) {
    val rows1 = arr1.size
    val columns1 = arr1[0].size
    val rows2 = arr2.size
    val columns2 = arr2[0].size

    if (columns1 != rows2) {
        throw IllegalArgumentException("Matrix multiplication not possible")
    }else{
//        print("$columns1>>$rows2")
    }

    val result = Array(rows1) { IntArray(columns2) }

   for (i in 0 until rows1){
       var sum = 0
       for (j in 0 until columns2){

           for (k in 0 until columns1){
               sum+=arr1[i][k] * arr2[k][j]
           }
           result[i][j] = sum
       }

   }




    result.forEach { it1->
        it1.forEach {
            it2->
            print("$it2  ")
        }
        println()

    }

}

fun daigonalMatrix(num:Int){
    for (i in 0 until num){
        for (j in 0 until num){
            if (i==j){
                print(" *")
            }else{
                print(" 0")
            }
        }
        println()

    }
}
fun isPrime(num:Int){
    var ism = false
    for (i in 2..num-1){
        if (num%i==0){
            println("$num is devided by $i")
            ism =true
            break
        }
    }
    if (ism==true){
        print("number is notprime")
    }else{
        print("number is prime")
    }
}

fun myTrangle(n:Int){
    for ( i in 0..n-1){
        for (j in n-1 downTo i){
            print("#")
        }
        for (k in 0 ..i ){
            print(" *")
        }
        println()
    }
}

fun charfreq(char: Char,str:String){
    var freq = 0
    for (i in 0 ..str.length-1){
        if (str[i].toLowerCase()==char.toLowerCase()){
            ++freq
        }
    }
    print(freq)
}
fun largestNumber(arr: IntArray){
    var large = arr[0]
    for (i in 0..arr.size-1){
        if (large<arr[i]){
            large = arr[i]
        }
    }
    print(large)
}

fun reversesentence(string: String){

    for (i in string.length-1 downTo 0){
        print(string[i])
    }
}
fun atoz(c:Char){
    var n:Char
    n='a'
    while (n<= c.toLowerCase()){
        print(n)
        n++
    }
}

fun fabonaci(a:Int,b:Int){
    var a = a
    var b = b
    var s = 8

    var n=1
    while (n<s){


       print(" $a + ")
        var sum = a+b
        a=b
        b=sum
        n++
    }

}

fun table(num:Int){
    for (i in 10 downTo 1){
        println("$num * $i  =  ${num * i}")
    }
}
fun palendrome(data:String){
   for (i in 0 ..data.length-1){
      if (data[i]==data[data.length-1-i]){
          println("String is palendrome series")
      }else{

          println("String is not palen series")
              break;

      }
   }
}
fun getFactorial(num:Int):Long{
    if (num>1){
        return num* getFactorial(num-1)
    }else{
        return 1
    }
}
fun isVowel(char: String)
{
    if (char.toLowerCase()=="a"||char.toLowerCase()=="e"||char.toLowerCase()=="i"||char.toLowerCase()=="o"||char.toLowerCase()=="u"){
        print("char $char is vowel")
    }else{
        print("char $char is constant")
    }
}
fun addUsingRecursion(arr: IntArray,size:Int,total:Int){
    var s = size-1
    var total1=total
    if (s>1){
        total1+=arr[s]
        addUsingRecursion(arr, size-1,total1)
    }else{
        print("final >>$total1")

    }
}
fun swapNumber(a:Int,b:Int){
    var a = a
    var b = b

    println( "$a >>$b")

    a = a-b  //-6
    b = a+b  //5
    a = b-a

    println("$a >>$b")

}
fun sortArray(arr: IntArray) {
    var size = arr.size
    var temp :Int
    var duplicate = mutableListOf<Int>()
    for (i in 0..size-1){

        for (j in 0..size-1){
            if (arr[i]>arr[j]){
                temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
            if (arr[i]>arr[j]){

            }
//            if (duplicate.contains(arr[j]).not()){
//                duplicate.add(arr[j])
//            }
//            var dupliPresnt = false
//            duplicate.forEach {
//                if (it==arr[j]){
//                    dupliPresnt = true
//                }
//            }
//            if (dupliPresnt==false){
//                duplicate.add(arr[j])
//            }

        }
    }

    print(arr.joinToString())
    println()
    println(duplicate.joinToString())
}

fun power(base: Int, exp: Int): Int {
    var mexp = exp
    var result = 1
    while (mexp != 0) {
        result *= base.toInt()
        --mexp
    }
    return result
}
fun btdNumber(bn:Int):Long{
    var bn = bn
    var dcNumber :Long=0
    var i = 1
    var step = 1
    var reminder:Int


    while (bn!=0){
        reminder = bn%2
        bn/=2
        dcNumber += (reminder*i).toLong()
        i*=10
    }
    return dcNumber


}
//    fun facto(num: Int): Int {
//
//        var num = num
//
//
//        if (num != 1) {
//           num = num * facto(num - 1)
//        } else {
//            num
//        }
//        return num
//    }

fun rmduplicate(arr: IntArray){

    var s = arr.size
    var marr = mutableListOf<Int>()
    for (i in 0..s-1){
        for (j in 0..s-1){
            if (arr[i]==arr[j]){
                if (i == j){
                    println(j)
                }
                break
            }

        }

    }

}

fun findDuplicates(arr: IntArray){
    var mySet = hashSetOf<Int>()

    arr.forEach {
        mySet.add(it)
    }
    var arr1 = mySet.toIntArray()
    var temp:Int
    for (i in 0 ..arr1.size-1){
        for (j in 0 ..arr1.size-1){
//            arr1 as IntArray
            if (arr1[i] < arr1[j]){
                temp = arr1[i] as Int
                arr1[i] = arr1[j]
                arr1[j] = temp
            }
        }

    }
    println(arr1.joinToString()+"sattta")
}
//fun findDuplicates(arr: IntArray){
//    var list = arrayListOf<Int>()
//    for (i in 0 .. arr.size-1){
//        var index = Math.abs(arr[i]-1)
//        if (index<0){
//            list.add(index+1);
//            arr[index]  = arr[index] *-1
//        }
//
//    }
//    print(list.toString())
//
//}


