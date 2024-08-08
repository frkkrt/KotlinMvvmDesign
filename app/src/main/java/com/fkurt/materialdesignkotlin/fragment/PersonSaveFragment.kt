package com.fkurt.materialdesignkotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fkurt.kotlingetmaplocation.R
import com.fkurt.kotlingetmaplocation.databinding.FragmentMainPageBinding
import com.fkurt.kotlingetmaplocation.databinding.FragmentPersonDetailBinding
import com.fkurt.kotlingetmaplocation.databinding.FragmentPersonSaveBinding
import com.fkurt.materialdesignkotlin.viewmodel.MainViewModel
import com.fkurt.materialdesignkotlin.viewmodel.PersonSaveViewModel


class PersonSaveFragment : Fragment() {
    private lateinit var design: FragmentPersonSaveBinding
    private lateinit var viewModel: PersonSaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design= FragmentPersonSaveBinding.inflate(inflater, container, false)
        design.toolbarPersonSave.title="Person Save"


        design.buttonSaveDetail.setOnClickListener {
            val personName=design.editTextPersonSave.text.toString()
            val personTel=design.editPersonTelSave.text.toString()
            save(personName,personTel)
        }
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:PersonSaveViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun save(personName:String,personTel:String){
       viewModel.save(personName,personTel)
    }

}