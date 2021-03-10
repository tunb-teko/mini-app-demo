package vn.teko.demo.miniapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import vn.teko.android.auth.core.AuthManager
import vn.teko.android.auth.core.TerraAuth
import vn.teko.android.core.ui.util.autoCleared
import vn.teko.android.payment.example_v2.utils.AuthInterfaceMock
import vn.teko.demo.miniapp.R
import vn.teko.demo.miniapp.databinding.FragmentHomeBinding
import vn.teko.demo.miniapp.databinding.FragmentLoginBinding
import vn.teko.hestia.android.TerraHestia
import vn.teko.hestia.core.HestiaInterface
import vn.teko.hestia.android.utils.uiHelper.DefaultAndroidHestiaUIHelper
import vn.teko.terra.core.AuthInterface
import vn.teko.terra.core.android.terra.TerraApp
import javax.inject.Inject

class HomeFragment : Fragment() {

    lateinit var hestia: HestiaInterface

    lateinit var terraApp: TerraApp

    lateinit var authManager: AuthManager

    private val authMock: AuthInterface by lazy { AuthInterfaceMock() }

    private var viewDataBinding by autoCleared<FragmentHomeBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        terraApp = TerraApp.getInstance()
        authManager = TerraAuth.getInstance(terraApp)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.btnLogin.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        }
        viewDataBinding.btnOpenMiniApp.setOnClickListener {
            openMiniApp()
        }
    }

    private fun openMiniApp() {
        val hestia = TerraHestia.getInstance(terraApp)
        hestia.startApp("mini_app", authManager, DefaultAndroidHestiaUIHelper(requireContext()))
    }
}