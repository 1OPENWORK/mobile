package com.stack.open_work_mobile.activities.lay_my_projects

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stack.open_work_mobile.R
import com.stack.open_work_mobile.api.Rest
import com.stack.open_work_mobile.services.ProjectService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var adapter: ProjectProgressCardAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var projectCardCanceled: ArrayList<ProjectProgressCard>

private val api by lazy {
    Rest.getInstance()?.create(ProjectService::class.java)
}

/**
 * A simple [Fragment] subclass.
 * Use the [CanceledMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CanceledMenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        projectCardCanceled = ArrayList()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_canceled_menu, container, false)
        recyclerView = view.findViewById(R.id.recycle_view_canceled)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        adapter = ProjectProgressCardAdapter(projectCardCanceled)
        recyclerView.adapter = adapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CanceledMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CanceledMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {

        val list: ArrayList<ProjectProgressCard> = ArrayList()

        api?.getAllCanceled()?.enqueue(object : Callback<List<ProjectProgressCard>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<ProjectProgressCard>>,
                response: Response<List<ProjectProgressCard>>
            ) {
                if (response.isSuccessful) {
                    val projectList = response.body()

                    projectList?.forEach { current ->
                        list.add(current)
                        adapter.notifyDataSetChanged()
                    }
                    projectCardCanceled.addAll(list)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_LONG).show()
                    print("Message: ${response.message()}\n" + "Error Body: ${response.errorBody()}\n" + "Header: ${response.headers()}")
                }
            }

            override fun onFailure(call: Call<List<ProjectProgressCard>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                print("Error Api: ${t.message}")
            }
        })
    }
}