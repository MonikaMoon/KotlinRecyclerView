package com.monika.kotlinrecyclerview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monika.kotlinrecyclerview.R
import com.monika.kotlinrecyclerview.adapters.FactsRecyclerAdapter
import com.monika.kotlinrecyclerview.model.Facts
import kotlinx.android.synthetic.main.fragment_facts_list.*

class FactsListFragment : Fragment() {

    private var factsList = arrayListOf<Facts>()
    lateinit private var name : String

    var recyclerAdapter : FactsRecyclerAdapter? = null
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = arguments!!.getString("name")
    }

    companion object {

        fun newInstance(name: String): FactsListFragment {

            val args = Bundle()
            args.putString("name", name)
            val fragment = FactsListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_facts_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = FactsRecyclerAdapter(requireContext(), factsList)

        fetchFacts()
    }

    private fun fetchFacts() {

    }

    override fun onPause() {
        super.onPause()
    }
}