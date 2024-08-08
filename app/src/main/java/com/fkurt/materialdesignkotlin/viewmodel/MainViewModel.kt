package com.fkurt.materialdesignkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fkurt.materialdesignkotlin.data.entitiy.Persons
import com.fkurt.materialdesignkotlin.data.repo.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (var krepo:PersonsDaoRepository):ViewModel() {
    var personsList=MutableLiveData<List<Persons>>()

    init {
        personsLoad()
        personsList=krepo.personsGet()
    }

    fun call(callWord:String)
    {
        krepo.personCall(callWord)
    }
    fun delete(personId:Int)
    {
        krepo.personDelete(personId)
    }
    fun personsLoad()
    {
        krepo.allPersonsGet()
    }
}