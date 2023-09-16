package com.stack.open_work_mobile.activities.lay_home

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.activities.lay_my_projects.ProjectProgressCard
import java.time.LocalDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: ProjectCardHomeAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var projectCardProjectHomeList: ArrayList<CardProjectHome>

lateinit var companyName: Array<String>
lateinit var avaliationCompany: Array<Int>
lateinit var describe: Array<String>
lateinit var dateCreated: Array<String>
lateinit var dateEnd: Array<String>
lateinit var qtdDev: Array<Int>
lateinit var value: Array<String>


/**
 * A simple [Fragment] subclass.
 * Use the [HomeMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeMenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycle_view_card_home)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ProjectCardHomeAdapter(projectCardProjectHomeList)
        recyclerView.adapter = adapter

    }

    private fun dataInit() {
        projectCardProjectHomeList = arrayListOf<CardProjectHome>()

        companyName = arrayOf("Comp 1", "Comp 2", "Comp 3")
        avaliationCompany = arrayOf(5, 4, 1)
        describe =
            arrayOf(
                "Criar plataforma freelancer do zero, backend, frontend, bd conectado na nuvem, e aplicação mobile.",
                "Criar plataforma freelancer do zero, backend, frontend, bd conectado na nuvem, e aplicação mobile.",
                "Criar plataforma freelancer do zero, backend, frontend, bd conectado na nuvem, e aplicação mobile."
            )
        dateCreated = arrayOf("2023-03-04", "2023-03-04", "2023-03-04")
        dateEnd = arrayOf("2024-07-04", "2024-07-04", "2024-07-04")

        qtdDev = arrayOf(2, 3, 4)
        value = arrayOf("R$152.54", "R$5464.44", "R$2646.11")

        for (i in companyName.indices) {
            val projectHome = CardProjectHome(
                companyName[i], avaliationCompany[i], describe[i],
                dateCreated[i], dateEnd[i], qtdDev[i], value[i]
            )
            projectCardProjectHomeList.add(projectHome)
        }



    }
}