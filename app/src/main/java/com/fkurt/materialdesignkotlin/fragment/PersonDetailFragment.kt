package com.fkurt.materialdesignkotlin.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fkurt.kotlingetmaplocation.databinding.FragmentPersonDetailBinding
import com.fkurt.materialdesignkotlin.viewmodel.MainViewModel
import com.fkurt.materialdesignkotlin.viewmodel.PersonDetailViewModel
import com.fkurt.materialdesignkotlin.viewmodel.PersonSaveViewModel


class PersonDetailFragment : Fragment() {
    private lateinit var design: FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design= FragmentPersonDetailBinding.inflate(inflater, container, false)
        design.toolbarPersonDetail.title="Person Detail"

        val bundle:PersonDetailFragmentArgs by navArgs()
        val comePerson=bundle.person

        design.editTextPersonAddDetail.setText(comePerson.personName)
        design.editPersonTelDetail.setText(comePerson.personTel)

        design.buttonUpdateDetail.setOnClickListener {
            val personName=design.editTextPersonAddDetail.text.toString()
            val personTel=design.editPersonTelDetail.text.toString()
            update(comePerson.personId,personName,personTel)
        }

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonDetailViewModel by viewModels()
        viewModel=tempViewModel
    }
    fun update(personId:Int,personName:String,personTel:String)
    {
        viewModel.update(personId,personName,personTel)
    }
}