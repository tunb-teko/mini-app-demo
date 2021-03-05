package vn.teko.demo.miniapp.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import vn.teko.android.auth.login.LoginManager
import vn.teko.android.auth.login.TerraLogin
import vn.teko.android.auth.login.provider.LoginType
import vn.teko.android.core.ui.util.autoCleared
import vn.teko.android.core.util.Result
import vn.teko.android.core.util.android.extension.setStatusBarColor
import vn.teko.demo.miniapp.R
import vn.teko.demo.miniapp.databinding.FragmentLoginBinding
import vn.teko.terra.core.android.terra.TerraApp

class LoginFragment : Fragment() {

    lateinit var terraLogin: LoginManager

    private var viewDataBinding by autoCleared<FragmentLoginBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        terraLogin = TerraLogin.getInstance(TerraApp.getInstance())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.btnLoginGoogle.setOnClickListener {
            loginWithGoogle()
        }
    }

    private fun loginWithGoogle() {
        terraLogin.login(this, LoginType.GOOGLE)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        terraLogin.processLoginResult(requestCode, resultCode, data) {
            if (it is Result.Failure) {
                terraLogin.logout { }
            } else {
                navigateBack()
            }
        }
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }
}