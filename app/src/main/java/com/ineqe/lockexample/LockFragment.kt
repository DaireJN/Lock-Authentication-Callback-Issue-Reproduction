package com.ineqe.lockexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.auth0.android.Auth0
import com.auth0.android.lock.Lock

class LockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val auth0 = Auth0(
            resources.getString(R.string.com_auth0_client_id),
            resources.getString(R.string.com_auth0_domain)
        )

        val lock = Lock.newBuilder(auth0, AuthenticationCallbackImpl)
            .withAudience("https://${resources.getString(R.string.com_auth0_domain)}/userinfo")
            .closable(true)
            .loginAfterSignUp(true)
            .withScheme("lockexample")
            .setDefaultDatabaseConnection("Username-Password-Authentication")
            .build(requireContext())

        getView()?.findViewById<Button>(R.id.button)?.setOnClickListener {
            startActivity(lock.newIntent(requireContext()))
        }
    }

}