package com.example.farm_application_2.ui.egg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EggViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is egg Fragment"
    }
    val text: LiveData<String> = _text
}