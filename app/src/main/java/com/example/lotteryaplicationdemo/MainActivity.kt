package com.example.lotteryaplicationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
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
    var numbers = calculate().toMutableList()

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
            numbers = calculate().toMutableList()
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

    }

}


fun calculate():List<Int>{
    var numbers : MutableList<Int> = mutableListOf()

    while(numbers.size<6){
        var num = Random.nextInt(59)+1
        if (num !in numbers)
            numbers.add(num)
    }

    var res = ""
    for(i in numbers){
        res += "" + i + " "
    }

    println("Entered calculate()");
    return numbers
}

