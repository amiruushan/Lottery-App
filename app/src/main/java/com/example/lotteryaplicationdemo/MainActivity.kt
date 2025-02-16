package com.example.lotteryaplicationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GUI()

        }
    }
}

@Preview
@Composable
fun GUI(){
    var num1: String by remember{ mutableStateOf("")}
    var num2: String by remember{ mutableStateOf("")}
    var num3: String by remember{ mutableStateOf("")}
    var num4: String by remember{ mutableStateOf("")}
    var num5: String by remember{ mutableStateOf("")}
    var num6: String by remember{ mutableStateOf("")}
    var numbers: ArrayList<Int> by remember{ mutableStateOf(ArrayList())}

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Text(num1, fontSize = 30.sp)
            Text(num2, fontSize = 30.sp)
            Text(num3, fontSize = 30.sp)
            Text(num4, fontSize = 30.sp)
            Text(num5, fontSize = 30.sp)
            Text(num6, fontSize = 30.sp)
        }

        Button(onClick = {
            numbers = calculate()
            num1 = numbers[0].toString()
            num2 = numbers[1].toString()
            num3 = numbers[2].toString()
            num4 = numbers[3].toString()
            num5 = numbers[4].toString()
            num6 = numbers[5].toString()
            })
        {
            Text("Generate")
        }

        // Button for val 1
        Button(onClick = {
            var changeNum = changeOneValue(0, numbers)
            num1 = numbers[0].toString()
        })
        {
            Text("1")
        }

        // Button for val 2
        Button(onClick = {
            var changeNum = changeOneValue(1, numbers)
            num2 = numbers[1].toString()
        })
        {
            Text("2")
        }

        // Button for val 3
        Button(onClick = {
            var changeNum = changeOneValue(2, numbers)
            num3 = numbers[2].toString()
        })
        {
            Text("3")
        }

        // Button for val 4
        Button(onClick = {
            var changeNum = changeOneValue(3, numbers)
            num4 = numbers[3].toString()
        })
        {
            Text("4")
        }

        // Button for val 5
        Button(onClick = {
            var changeNum = changeOneValue(4, numbers)
            num5 = numbers[4].toString()
        })
        {
            Text("5")
        }

        // Button for val 6
        Button(onClick = {
            var changeNum = changeOneValue(5, numbers)
            num6 = numbers[5].toString()
        })
        {
            Text("6")
        }



    }

}


fun calculate():ArrayList<Int>{
    var numbers : ArrayList<Int> = ArrayList()

    while(numbers.size < 6){
        var num = Random.nextInt(59)+1
        if (num !in numbers)
            numbers.add(num)
    }


    println("Entered calculate()");
    return numbers
}

fun changeOneValue(index:Int, numbers: ArrayList<Int>): ArrayList<Int> {
    var newVal: Int = Random.nextInt(59)+1
    for (num in numbers){
        if (newVal == num){
            newVal = Random.nextInt(59)+1
        }
    }
    numbers[index] = newVal

    return numbers
}


