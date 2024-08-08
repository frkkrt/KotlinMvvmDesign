package com.fkurt.materialdesignkotlin.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import com.fkurt.materialdesignkotlin.data.repo.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor (var krepo:PersonsDaoRepository):ViewModel()
{
    fun update(personId:Int,personName:String,personTel:String)
    {
       krepo.personUpdate(personId,personName,personTel)
    }
}