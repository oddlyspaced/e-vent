package com.oddlyspaced.compass.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.activity.DashboardActivity
import com.oddlyspaced.compass.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

    companion object {
        const val REG_NUM = "reg_num"

        @JvmStatic
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_login, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val regNum = arguments?.getString(REG_NUM) ?: ""

        binding.textView2.text = getString(R.string.using_login, regNum)
        binding.customButton.setOnClickListener {
            startActivity(Intent(context, DashboardActivity::class.java))
            activity?.finish()
        }
    }

}