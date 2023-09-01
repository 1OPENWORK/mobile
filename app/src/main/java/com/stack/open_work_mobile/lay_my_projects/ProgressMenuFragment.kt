package com.stack.open_work_mobile.lay_my_projects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.stack.open_work_mobile.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: ProjectProgressCardAdapter
private lateinit var recycleView: RecyclerView
private lateinit var projectCardProcessList: ArrayList<ProjectProgressCard>

lateinit var title: Array<String>
lateinit var subTitle: Array<String>
lateinit var desc: Array<String>


/**
 * A simple [Fragment] subclass.
 * Use the [ProgressMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProgressMenuFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_progress_menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProgressMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProgressMenuFragment().apply {
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
        recycleView = view.findViewById(R.id.recycle_view_progress)
        recycleView.layoutManager = layoutManager
        recycleView.setHasFixedSize(true)
        adapter = ProjectProgressCardAdapter(projectCardProcessList)
        recycleView.adapter = adapter
    }

    private fun dataInit() {
        projectCardProcessList = arrayListOf<ProjectProgressCard>()

        title = arrayOf("Projeto 1", "Projeto 2", "Projeto 3")
        subTitle = arrayOf("Close Work, 13/08/2023", "CLosed, 13/08/2023", "Formouch, 13/08/2023")
        desc = arrayOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500sLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s ",
            "Projeto 3 asohdjasnfkaskjfnkajsfkman smknfd kajsnjkl"
        )

        for (i: Int in title.indices) {

            val project = ProjectProgressCard(title[i], subTitle[i], desc[i])
            projectCardProcessList.add(project)
        }

    }


}