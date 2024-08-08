package com.fkurt.materialdesignkotlin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fkurt.kotlingetmaplocation.databinding.CardDesignBinding
import com.fkurt.materialdesignkotlin.data.entitiy.Persons
import com.fkurt.materialdesignkotlin.fragment.MainPageFragmentDirections
import com.fkurt.materialdesignkotlin.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter(var mContext:Context,var personList:List<Persons>,var viewModel:MainViewModel):
    RecyclerView.Adapter<PersonsAdapter.CardDesignKeeper>() {

    inner class CardDesignKeeper(design:CardDesignBinding):RecyclerView.ViewHolder(design.root)
    {
        var design: CardDesignBinding
        init {
            this.design=design
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignKeeper {
        val layoutInflater=LayoutInflater.from(mContext)
        val design= CardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignKeeper(design)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardDesignKeeper, position: Int) {
        val person= personList.get(position)
        val t=holder.design
        t.textViewPersonInfo.text="${person.personName} - ${person.personTel}"

        t.rowCard.setOnClickListener {
            val transition=MainPageFragmentDirections.personDetailTransition(person)
            Navigation.findNavController(it).navigate(transition)
        }
        t.imageView.setOnClickListener {
            Snackbar.make(it,"${person.personName} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET")
                {
                    viewModel.delete(person.personId)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

}