package com.arman.dev.androiddocumentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Problem: Undo/Redo Mini Text Editor
//Problem Statement
//You are required to implement a mini text editor screen using Jetpack Compose.
//The editor should support the following features:
//A TextField where the user can type freely.
//An Undo button that restores the text to its immediately previous state.
//A Redo button that reapplies a change that was undone.
//Undo and Redo should behave like a history navigation system:
//Every time the text changes, the current state should be saved.
//Undo moves one step backward in the history (if available).
//Redo moves one step forward in the history (if available).
//If Undo or Redo cannot be performed (e.g., there is no older or newer state), the corresponding button should be disabled.
//The solution should be efficient, and the history must remain consistent after multiple undo/redo actions.
//
//Example Scenarios
//Scenario 1: Simple Typing and Undo/Redo
//User types "h" → editor shows h.
//User types "he" → editor shows he.
//User types "hel" → editor shows hel.
//User types "hell" → editor shows hell.
//User types "hello" → editor shows hello.
//Undo actions:
//Press Undo → editor goes back to hell.
//Press Undo again → editor goes back to hel.
//Redo actions:
//Press Redo → editor goes forward to hell.
//Press Redo again → editor goes forward to hello.
//Scenario 2: New Input After Undo (Redo Reset)
//Starting from "hello", press Undo → editor shows "hell".
//Now type "hello!" (instead of pressing Redo).
//The Redo history should be cleared, because a new edit invalidates the redo path.
//From here, pressing Redo should do nothing, but Undo should take the editor back step by step ("hell" → "hel" → …).

/**
 *use two list -->
 * the moment i type it should be added to the previousStateList
 * the moment i do undo
 */


@Composable
fun TextEditor(){
    var text by remember { mutableStateOf("") }

    val previousStateList = mutableListOf<String>()
    val nextStateList = mutableListOf<String>()

    val undoButtonState by remember {
        derivedStateOf {
           previousStateList.isNotEmpty()
        }
    }
    val redoButtonState by remember {
        derivedStateOf {
          nextStateList.isNotEmpty()
        }
    }

    var currentUndoIndex by remember {
        mutableIntStateOf(previousStateList.lastIndex+1)
    }

    var currentRedoIndex by remember {
        mutableIntStateOf(previousStateList.lastIndex+1)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(
            modifier = Modifier.height(100.dp)
        )

        OutlinedTextField(
            value = text,
            onValueChange = {
                if(currentUndoIndex != previousStateList.lastIndex){
                    nextStateList.clear()
                }
                text = it
                previousStateList.add(it)
                            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {
                    currentUndoIndex--
                    text = previousStateList[currentUndoIndex]?:""
                },
                modifier = Modifier.weight(1f) ,
                enabled = undoButtonState
            ){
                Text(
                    text = "Undo"
                )
            }

            Button(
                onClick = {
                    currentRedoIndex--
                    text = nextStateList[currentRedoIndex]?:""
                },
                modifier = Modifier.weight(1f),
                enabled = redoButtonState
            ){
                Text(
                    text = "Redo"
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewTextEditor(){
    TextEditor()
}