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
import com.oddlyspaced.compass.databinding.FragmentSignUpBinding

class SignUpFragment: Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    companion object {
        @JvmStatic
        fun newInstance(): SignUpFragment {
            return SignUpFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSignUpBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_sign_up, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.customButton.setOnClickListener {

        }
    }

}