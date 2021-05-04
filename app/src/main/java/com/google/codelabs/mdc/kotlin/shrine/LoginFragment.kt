package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        // verifica se a senha contem 8 caracteres
        view.next_button.setOnClickListener ({
            if(!isPasswordValid(password_edit_text.text!!)){
                password_edit_text.error = getString(R.string.shr_error_password)
            }else{
                // limpa o erro
                password_text_input.error = null
                // navega para o proximo fragment
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        })

        view.password_edit_text.setOnKeyListener ({ view, i, keyEvent ->
            if(isPasswordValid(password_edit_text.text!!)){
                // limpa o erro
                password_text_input.error =  null
            }
            false
        })
        return view
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private fun isPasswordValid(text: Editable?): Boolean{
        return text != null && text.length  >=8
    }

}
