package com.fkurt.materialdesignkotlin.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.fkurt.kotlingetmaplocation.R
import com.fkurt.kotlingetmaplocation.databinding.FragmentMainPageBinding
import com.fkurt.materialdesignkotlin.adapter.PersonsAdapter
import com.fkurt.materialdesignkotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var design: FragmentMainPageBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        design=FragmentMainPageBinding.inflate(inflater, container, false)
        design.toolbarMainPage.title="Persons"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarMainPage)

        design.recyclerviewMainPage.layoutManager=LinearLayoutManager(requireContext())

        design.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personSaveTransition)
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item=menu.findItem(R.id.action_search)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainPageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel=tempViewModel
    }


    override fun onQueryTextSubmit(p0: String?): Boolean {
        if (p0 != null) {
            call(p0)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        if (p0 != null) {
            call(p0)
        }
        return true
    }

    fun call(callWord:String)
    {
        Log.e("Kişi Ara",callWord)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa","Dönüldü")
    }


}