package com.aneke.peter.nads

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val state = MutableLiveData<String>()
}