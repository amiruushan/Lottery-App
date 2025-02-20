package com.example.lotteryaplicationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
    var num: String by remember{ mutableStateOf("")}
    var excludeVal: String by remember{ mutableStateOf("")}

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(num, fontSize = 30.sp)
        Button(onClick = {num = calculate(excludeVal)}){
            Text("Generate")
        }

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = excludeVal,
            onValueChange = {excludeVal = it},
            label = { Text("Enter Exclude Number") }
        )


    }

}


fun calculate(excludeVal: String):String{

    var excludeVal = excludeVal.split(" ",",").mapNotNull { it.toIntOrNull() }
    var numbers : MutableList<Int> = mutableListOf()

    while(numbers.size<6){
        var num = Random.nextInt(10)+1
        if (num !in numbers && num !in excludeVal)
            numbers.add(num)
    }

    var res = ""
    for(i in numbers){
        res += "" + i + " "
    }

    println("Entered calculate()");
    println(excludeVal);
    return res
}

