package com.abdalla.jetcaluclatorcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdalla.jetcaluclatorcompose.ui.component.NumbersButton


@Composable
fun HomeScreen() {
    val textView = remember { mutableStateOf("0.0") }
    val textValue1 = remember { mutableStateOf("0.0") }
    val textValue2 = remember { mutableStateOf("0.0") }
    val addState = remember { mutableStateOf(false) }
    val subState = remember { mutableStateOf(false) }
    val mulState = remember { mutableStateOf(false) }
    val divState = remember { mutableStateOf(false) }
    val percentState = remember { mutableStateOf(false) }
    val equalState = remember { mutableStateOf(false) }
    val boolState = remember { mutableStateOf(false) }
    if (addState.value || subState.value || mulState.value || divState.value || percentState.value) {
        boolState.value = true
    }
    if (equalState.value) {
        addState.value = false
        subState.value = false
        mulState.value = false
        divState.value = false
        percentState.value = false
        equalState.value = false
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Title(
            modifier = Modifier
                .padding(8.dp, 16.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopTextView(textView.value)
            FirstRow(textView, textValue1, textValue2, boolState, percentState, divState)
            Spacer(modifier = Modifier.height(12.dp))
            SecondRow(textView, textValue1, textValue2, boolState, mulState)
            Spacer(modifier = Modifier.height(12.dp))
            ThirdRow(textView, textValue1, textValue2, boolState, subState)
            Spacer(modifier = Modifier.height(12.dp))
            FourthRow(textView, textValue1, textValue2, boolState, addState)
            Spacer(modifier = Modifier.height(12.dp))
            FifthRow(
                textView,
                textValue1,
                textValue2,
                boolState,
                equalState,
                percentState,
                divState,
                mulState,
                subState,
                addState
            )
        }

    }
}

@Composable
fun Title(modifier: Modifier) {
    Text(
        color = Color.White,
        text = "Calculator Compose",
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp,
        fontFamily = FontFamily.Cursive,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TopTextView(textCalculate: String) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {

        Text(
            color = Color.White,
            text = textCalculate,
            fontWeight = FontWeight.Normal,
            fontSize = 56.sp,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun FirstRow(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>,
    percentState: MutableState<Boolean>,
    divState: MutableState<Boolean>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        NumbersButton(
            num = "C",
            onClick = {
                textView.value = ""
                textValue1.value = ""
                textValue2.value = ""
            },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color.Gray
        )

        NumbersButton(
            num = "+/-",
            onClick = {
                if (textValue1.value.isNotEmpty() && textValue2.value.isEmpty()) {
                    var num = textValue1.value.toFloat()
                    when {
                        num > 0 -> {
                            num *= (-1)
                        }
                        num < 0 -> {
                            num = -num * (-1)
                        }
                    }
                    textValue1.value = num.toString()
                    textView.value = num.toString()
                } else if (textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {
                    var num = textValue2.value.toFloat()
                    when {
                        num > 0 -> {
                            num *= (-1)
                        }
                        num < 0 -> {
                            num = -num * (-1)
                        }
                    }
                    textValue2.value = num.toString()
                    textView.value = textValue1.value + textValue2.value
                }
            },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color.Gray
        )

        NumbersButton(
            num = "%",
            onClick = { myOperation(percentState, textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color.Gray
        )
        NumbersButton(
            num = "%",
            onClick = { myOperation(divState, textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color(0xFFFF6F00)
        )
    }
}

@Composable
fun SecondRow(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>,
    mulState: MutableState<Boolean>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        NumbersButton(
            num = "7",
            onClick = { numOperation("7", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "8",
            onClick = { numOperation("8", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "9",
            onClick = { numOperation("9", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "*",
            onClick = { myOperation(mulState, textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color(0xFFFF6F00)
        )
    }
}

@Composable
fun ThirdRow(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>,
    subState: MutableState<Boolean>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        NumbersButton(
            num = "4",
            onClick = { numOperation("4", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "5",
            onClick = { numOperation("5", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "6",
            onClick = { numOperation("6", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "-",
            onClick = { myOperation(subState, textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color(0xFFFF6F00)
        )
    }
}

@Composable
fun FourthRow(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>,
    addState: MutableState<Boolean>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        NumbersButton(
            num = "1",
            onClick = { numOperation("1", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "2",
            onClick = { numOperation("2", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "3",
            onClick = { numOperation("3", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "+",
            onClick = { myOperation(addState, textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            color = Color(0xFFFF6F00)
        )
    }
}

@Composable
fun FifthRow(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>,
    equalState: MutableState<Boolean>,
    percentState: MutableState<Boolean>,
    divState: MutableState<Boolean>,
    mulState: MutableState<Boolean>,
    subState: MutableState<Boolean>,
    addState: MutableState<Boolean>
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        NumbersButton(
            num = "0",
            onClick = { numOperation("0", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(0.5f)
                .padding(4.dp)
        )
        NumbersButton(
            num = ".",
            onClick = { numOperation(".", textView, textValue1, textValue2, boolState) },
            modifier = Modifier
                .weight(0.25f)
                .padding(4.dp)
        )
        NumbersButton(
            num = "=",
            onClick = {
                if (boolState.value && textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {

                    equalOperation(
                        textView,
                        textValue1,
                        textValue2,
                        percentState,
                        divState,
                        mulState,
                        subState,
                        addState
                    )
                    equalState.value = true
                }
            },
            modifier = Modifier
                .weight(0.25f)
                .padding(4.dp),
            color = Color(0xFFFF6F00)
        )
    }
}


private fun equalOperation(
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    percentState: MutableState<Boolean>,
    divState: MutableState<Boolean>,
    mulState: MutableState<Boolean>,
    subState: MutableState<Boolean>,
    addState: MutableState<Boolean>
) {
    if (textValue1.value.isNotEmpty() && textValue2.value.isNotEmpty()) {


        val num1 = textValue1.value.toFloat()
        val num2 = textValue2.value.toFloat()
        val equal = when {
            percentState.value -> num1 % num2
            divState.value -> num1 / num2
            mulState.value -> num1 * num2
            subState.value -> num1 - num2
            addState.value -> num1 + num2
            else -> 0
        }
        textView.value = equal.toString()
        textValue1.value = ""
        textValue2.value = ""
    }
}

private fun numOperation(
    num: String,
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>
) {
    if (!boolState.value && textView.value == "0.0") {
        textView.value = num
        textValue1.value = textView.value
    } else if (!boolState.value) {
        textView.value = textView.value + num
        textValue1.value = textView.value
    } else if (boolState.value) {
        textView.value = textView.value + num
        textValue2.value = textView.value
    }
}

private fun myOperation(
    thisState: MutableState<Boolean>,
    textView: MutableState<String>,
    textValue1: MutableState<String>,
    textValue2: MutableState<String>,
    boolState: MutableState<Boolean>
) {
    thisState.value = true
    textValue1.value = textView.value
    textView.value = ""

}