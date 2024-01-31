package com.example.fetchingdetails.viewModel
import com.example.fetchingdetails.model.Details
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel:ViewModel() {
    private var _detailsList= MutableStateFlow<List<Details>>(emptyList())
    val detailsList: StateFlow<List<Details>>
        get() = _detailsList.asStateFlow()
    fun addDetail(){
        var currentList=_detailsList.value
        currentList=currentList+Details()
        _detailsList.value=currentList
    }
    init {
        addDetail()
        addDetail()
        addDetail()
    }
}