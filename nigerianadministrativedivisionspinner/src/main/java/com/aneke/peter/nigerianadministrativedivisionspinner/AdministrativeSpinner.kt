package com.aneke.peter.nigerianadministrativedivisionspinner

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ArrayAdapter
import com.aneke.peter.nigerianadministrativedivisionspinner.models.Lga
import com.aneke.peter.nigerianadministrativedivisionspinner.models.State


class AdministrativeSpinner constructor(context: Context, attrs: AttributeSet)  : androidx.appcompat.widget.AppCompatAutoCompleteTextView(context, attrs) {

    var attrset: TypedArray

    var level : Int = 0

    var stateList = getAllStates()

    var lgaList = emptyList<Lga>()

    init {
        attrset = context.obtainStyledAttributes(attrs, R.styleable.AdministrativeSpinner)
        level = attrset.getInt(R.styleable.AdministrativeSpinner_admin_level, 0)
        setupListAndAdapters()
        attrset.recycle()
    }


    fun setCurrentState(state: State){
        if (level == 1){
            lgaList = getLocalGovernmentsForState(state)
            setupListAndAdapters()
        }
    }

    private fun setupListAndAdapters(){
        when(level){
            0 -> {
                setAdapter(
                    ArrayAdapter(
                        context,
                        android.R.layout.simple_list_item_1,
                        stripStateList(stateList))
                )
            }
            1 -> {
                setAdapter(
                    ArrayAdapter(
                        context,
                        android.R.layout.simple_list_item_1,
                        stripLgaList(lgaList))
                )
            }
        }
    }


    private fun stripStateList(stateList : List<State>) : List<String>{
        val list = mutableListOf<String>()
        stateList.forEach {state ->
            list.add(state.name)
        }
        return list
    }

    private fun stripLgaList(lgaList: List<Lga>) : List<String>{
        val list = mutableListOf<String>()
        lgaList.forEach {lga ->
            list.add(lga.name)
        }
        return list
    }




}