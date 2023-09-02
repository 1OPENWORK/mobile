package com.stack.open_work_mobile.lay_my_projects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stack.open_work_mobile.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private lateinit var adapter: ProjectProgressCardAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var projectCardCompleted: ArrayList<ProjectProgressCard>


/**
 * A simple [Fragment] subclass.
 * Use the [CompletedMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompletedMenuFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_completed_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CompletedMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CompletedMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()

        val layouManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycle_view_completed)
        recyclerView.layoutManager = layouManager
        recyclerView.setHasFixedSize(true)
        adapter = ProjectProgressCardAdapter(projectCardCompleted)
        recyclerView.adapter = adapter
    }

    private fun dataInit() {
        projectCardCompleted = arrayListOf<ProjectProgressCard>()

        title = arrayOf(
            "Projeto completed 01 pdvs", "Projeto Completed 02", "Projeto 3"
        )
        subTitle = arrayOf("Company 1, 11/11/1111", "CClo, 11/11/1111", "FormOu, 11/11/1111")
        desc = arrayOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500sLorem Ipsum is simply dummy text o",
            "Projeto 3 asohdjasnfkaskjfnkajsfkman smknfd kajsnjkl"
        )

        for (i: Int in title.indices) {

            val project = ProjectProgressCard(title[i], subTitle[i], desc[i])
            projectCardCompleted.add(project)
        }

    }
}