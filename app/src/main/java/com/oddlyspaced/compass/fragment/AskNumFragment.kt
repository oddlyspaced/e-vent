package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.custom.EventAdapter
import com.oddlyspaced.compass.databinding.FragmentAskNumberBinding
import com.oddlyspaced.compass.databinding.FragmentFollowBinding

class AskNumFragment: Fragment() {

    private lateinit var binding: FragmentAskNumberBinding
    var root: Int? = null

    companion object {
        @JvmStatic
        fun newInstance(): AskNumFragment {
            return AskNumFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAskNumberBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_ask_number, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.customBtnContinue.setOnClickListener {
            val fragment = SignUpFragment.newInstance()
            fragmentManager?.beginTransaction()?.replace(root ?: binding.root.id, fragment)?.addToBackStack("SignUp")?.commit()
        }
    }

}