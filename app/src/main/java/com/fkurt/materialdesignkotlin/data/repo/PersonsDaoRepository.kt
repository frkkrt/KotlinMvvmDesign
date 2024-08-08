package com.fkurt.materialdesignkotlin.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fkurt.materialdesignkotlin.data.entitiy.Persons

class PersonsDaoRepository  {
    var personsList:MutableLiveData<List<Persons>>
    init {
        //data transfer using
        personsList= MutableLiveData()
    }
    fun personsGet():MutableLiveData<List<Persons>>
    {
        return personsList
    }
    fun personKaydet(personName:String,personTel:String)
    {
        Log.e("Kişi Kayıt","$personName - $personTel")
    }

    fun personUpdate(personId:Int,personName:String,personTel:String)
    {
        Log.e("Kişi Güncelle","$personId-$personName - $personTel")
    }

    fun personCall(callWord:String)
    {
        Log.e("Kişi Ara",callWord)
    }
    fun personDelete(personId:Int)
    {
        Log.e("Kişi Sil",personId.toString())
    }

    fun allPersonsGet()
    {
        val list=ArrayList<Persons>()
        val k1= Persons(1,"Furkan","054665488455")
        val k2= Persons(2,"Mert","054992289992")
        val k3= Persons(3,"Sara","050759949196")
        list.add(k1)
        list.add(k2)
        list.add(k3)
        personsList.value=list
    }

}