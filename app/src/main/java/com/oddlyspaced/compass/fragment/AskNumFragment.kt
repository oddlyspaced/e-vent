package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.FragmentAskNumberBinding

class AskNumFragment: Fragment() {

    private lateinit var binding: FragmentAskNumberBinding
    var root: Int? = null

    companion object {
        const val ROOT = "root_id"
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
        root = arguments?.getInt(ROOT)
        binding.customBtnContinue.setOnClickListener {
            val fragment = SignUpFragment.newInstance().apply {
                arguments = bundleOf(SignUpFragment.REG_NUM to binding.customTextField.getText())
            }

            parentFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
                replace(root ?: binding.root.id, fragment)
                addToBackStack("Signup")
            }.commit()
        }
    }

}