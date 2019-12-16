package com.monika.kotlinrecyclerview.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.monika.kotlinrecyclerview.R
import com.monika.kotlinrecyclerview.adapters.FactsRecyclerAdapter
import com.monika.kotlinrecyclerview.model.Facts
import com.monika.kotlinrecyclerview.viewmodel.FactsListViewModel
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_facts_list.*

class FactsListFragment : Fragment() {

    private var factsList = arrayListOf<Facts>()

    private var disposable: Disposable? = null
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var factsListViewModel: FactsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_facts_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView(factsList)

        getFactsList()
    }

    private fun setUpRecyclerView(factsList : ArrayList<Facts>) {
        layoutManager = LinearLayoutManager(requireContext())
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = FactsRecyclerAdapter(requireContext(), factsList)
    }

    private fun setViewModel() {
        factsListViewModel = ViewModelProviders.of(this)
            .get(FactsListViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    private fun getFactsList() {
        factsListViewModel.fetchFacts().observe(this, Observer { factsListData ->
            getActivity()?.setTitle(factsListData.title)
            setUpRecyclerView(factsListData.getObjList())
        })
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}