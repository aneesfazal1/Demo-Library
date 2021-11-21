package com.example.demoapplication

import android.app.Application
import androidx.lifecycle.MutableLiveData

import androidx.annotation.NonNull

import androidx.lifecycle.AndroidViewModel
import com.example.demoapplication.model.CurrentResponse


class MyViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MyRepo = MyRepo(application)
    fun loadData(): MutableLiveData<ArrayList<CurrentResponse>?> {
        return repository.callAPI()
    }
}



