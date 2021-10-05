package com.example.withingstest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axt.esgi.esgi4a2020.recycler.PhotoAdapter
import com.example.withingstest.data.api.APIProvider
import com.example.withingstest.data.api.Listener
import com.example.withingstest.data.model.Photo

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var photosRecyclerView: RecyclerView
    private val photoAdapter: PhotoAdapter by lazy { PhotoAdapter() }
    private val args by navArgs<ListFragmentArgs>()
    private lateinit var btn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photosRecyclerView = view.findViewById(R.id.photos_rcv)
        initRecyclerView()
        btn = view.findViewById(R.id.ButtonSearch)

        getPhotos(args.search)
    }

    private fun initRecyclerView() {
        photosRecyclerView.layoutManager = GridLayoutManager(context,2)
        photosRecyclerView.adapter = photoAdapter
        photosRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )



    }

    private fun getPhotos(search:String) {
       APIProvider.getImages(search,object : Listener<List<Photo>> {
           override fun onSuccess(data: List<Photo>) {
               Toast.makeText(context,"success",Toast.LENGTH_SHORT).show()
               photoAdapter.data = data as ArrayList<Photo>

           }

           override fun onError(t: Throwable) {
               Toast.makeText(context,t.toString(),Toast.LENGTH_SHORT).show()
           }
       })
   }
}