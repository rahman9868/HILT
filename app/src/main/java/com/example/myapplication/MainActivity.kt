package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())

    }
}

class MyFragment: Fragment(){

    @Inject
    lateinit var someClass: SomeClass
}


//
//@FragmentScoped -> Jika Menggunakan ini akan error di class MainActivity karena Acivity tidak bisa Menginject Fragment , tp sebalikanya Fragment bisa menginject Activity, seperti pada class MyFragment
//https://developer.android.com/training/dependency-injection/hilt-android#component-scopes

@ActivityScoped
class SomeClass
@Inject
constructor(
){


    fun doAThing(): String{
        return "Look I did a thing"
    }

}

class SomeOtherClass
@Inject
constructor(){

    fun doSOmeOtherThing(): String{
        return "Look I did some other thing!"
    }
}