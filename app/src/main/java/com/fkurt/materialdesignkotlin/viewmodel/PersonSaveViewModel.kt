package com.fkurt.materialdesignkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fkurt.materialdesignkotlin.data.repo.PersonsDaoRepository
import javax.inject.Inject

class PersonSaveViewModel@Inject constructor (var krepo:PersonsDaoRepository):ViewModel()
{
    fun save(personName:String,personTel:String)
    {
        krepo.personKaydet(personName,personTel)
    }
}