package com.example.withingstest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.withingstest.data.api.APIProvider
import com.example.withingstest.data.api.Listener
import com.example.withingstest.data.model.Photo


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
private lateinit var btn: Button
private lateinit var edt: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn = view.findViewById(R.id.ButtonSearch)
        edt = view.findViewById(R.id.EditTextSearch)
        btn.setOnClickListener {

            //getPhotos(edt.text.toString())



            findNavController().navigate(
                SearchFragmentDirections.actionBaseFragmentToBlankFragment2(
                    edt.text.toString()
                )
            )
        }
    }





}
