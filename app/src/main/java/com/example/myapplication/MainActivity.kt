package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someInterfaceImpl: SomeInterfaceImpl
    //private val gson: Gson
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAthing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor() : SomeInterface{

    override fun getAthing(): String {
        return "A Thing"
    }
}

interface SomeInterface{

    fun getAthing(): String
}