package com.example.farm_application_2.ui.bird

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirdViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}
/*import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.farm_application_2.Bird
import com.example.farm_application_2.BirdDAO
import com.example.farm_application_2.BirdDBHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BirdViewModel(context: Context) : ViewModel() {

    private val _birdList = MutableLiveData<List<Bird>>()
    val birdList: LiveData<List<Bird>> get() = _birdList

    private val birdDAO: BirdDAO

    init {
        // Initialize your ViewModel, you can fetch data from the DAO here
        birdDAO = BirdDAO(BirdDBHelper(context))
        loadBirdList()
    }

    private fun loadBirdList() {
        CoroutineScope(Dispatchers.IO).launch {
            val birds = birdDAO.getAllBirdRecords()
            _birdList.postValue(birds)
        }
    }
}*/
