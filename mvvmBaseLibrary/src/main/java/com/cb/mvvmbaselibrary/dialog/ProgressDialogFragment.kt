package com.cb.mvvmbaselibrary.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.cb.mvvmbaselibrary.R
import com.cb.mvvmbaselibrary.databinding.FragmentProgressDialogBinding

/**
 * @author Mr.常
 * @date 2024/12/23 9:37
 */
class ProgressDialogFragment : DialogFragment() {

    private var messageResId: Int? = null
    private lateinit var binding:FragmentProgressDialogBinding
    companion object {
        fun newInstance() =
            ProgressDialogFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProgressDialogBinding.inflate(layoutInflater)
        return binding.root
//        return inflater.inflate(R.layout.fragment_progress_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        tvMessage.text = getString(messageResId ?: R.string.loading)
        binding.tvMessage.text=getString(messageResId?: R.string.loading)
    }

    fun show(
        fragmentManager: FragmentManager,
        @StringRes messageResId: Int,
        isCancelable: Boolean = false
    ) {
        this.messageResId = messageResId
        this.isCancelable = isCancelable
        try {
            show(fragmentManager, "progressDialogFragment")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}