package com.cb.mvvmbaselibrary.dialog

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.cb.mvvmbaselibrary.R
import com.cb.mvvmbaselibrary.core.Logger
import com.cb.mvvmbaselibrary.databinding.WarmingDialogBinding
import com.cb.mvvmbaselibrary.listeners.OnClickListener

/**
 * 警告弹框
 */
class WarmingDialog : Dialog {

    private lateinit var lister: OnClickListener
    private var context: Context
    private var cancelable = false
    private var title: String? = null
    var text: String
    var okText: String? = null
    var cancelText: String? = null
    private lateinit var binding: WarmingDialogBinding

    /**
     * 只带确定 按钮的提示框.没有回调（标题，按钮文字 采用默认名称）
     * @param context
     * @param text：提示内容
     * @param cancelable：弹框是否触摸可取消
     */
    constructor(context: Context, text: String, cancelable: Boolean) : super(context,R.style.AlertDialogStyle) {
        this.text = text
        this.context = context
        this.cancelable = cancelable
        binding = WarmingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    constructor(context: Context, resId: Int, cancelable: Boolean) : super(context,R.style.AlertDialogStyle) {
        this.context = context
        text = context.getString(resId)
        this.cancelable = cancelable
        binding = WarmingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * 只带确定 按钮的提示框.没有回调（标题，按钮文字 采用默认名称）
     * @param context
     * @param title：标题（默认值：提示）
     * @param text：提示内容
     * @param okText:确认按钮文字（默认：确定）
     * @param cancelable：弹框是否触摸可取消
     */
    constructor(
        context: Context,
        title: String?,
        text: String,
        okText: String?,
        cancelable: Boolean
    ) : super(context,R.style.AlertDialogStyle) {
        this.title = title
        this.context = context
        this.text = text
        this.okText = okText
        this.cancelable = cancelable
        binding = WarmingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * 只带确定 按钮的提示框.有回调（标题，按钮文字 采用默认名称）
     * @param context
     * @param text：提示内容
     * @param okText：确认按钮文字（默认：确定）
     * @param cancelable：弹框是否触摸可取消
     * @param lister：按钮点击回调
     */
    constructor(
        context: Context,
        text: String,
        okText: String?,
        cancelable: Boolean,
        lister: OnClickListener
    ) : super(context,R.style.AlertDialogStyle) {
        this.lister = lister
        this.context = context
        this.cancelable = cancelable
        this.text = text
        this.okText = okText
        binding = WarmingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * 选择弹框
     * @param context
     * @param title：标题默认值：提示）
     * @param text：提示内容
     * @param okText：确认按钮文字（默认：确定）
     * @param cancelText：取消按钮 文字（不为空）
     * @param cancelable：弹框是否触摸可取消
     * @param lister：按钮点击回调
     */
    constructor(
        context: Context,
        title: String?,
        text: String,
        okText: String?,
        cancelText: String?,
        cancelable: Boolean,
        lister: OnClickListener
    ) : super(context,R.style.AlertDialogStyle) {
        this.lister = lister
        this.context = context
        this.cancelable = cancelable
        this.title = title
        this.text = text
        this.okText = okText
        this.cancelText = cancelText
        binding = WarmingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        if (TextUtils.isEmpty(cancelText)) {
            binding.btDialogCancel.visibility = View.GONE
        } else {
            binding.btDialogCancel.visibility = View.VISIBLE
        }
        if (null!=title){
            binding.tvDialogTitle.text = title
        }
        if (null!=text){
            binding.tvDialogText.text = text
        }
        if (null!=cancelText&&!TextUtils.isEmpty(cancelText)){
            binding.btDialogCancel.text = cancelText
        }
        if (null!=okText&&!TextUtils.isEmpty(okText)){
            binding.btDialogOk.text = okText
        }
        if (null!=cancelable){
            setCancelable(cancelable)
        }
        binding.btDialogOk.setOnClickListener {
            Logger.d("TAG", "111111111111111")
            if (lister != null) {
                Logger.d("TAG", "22222222222")
                lister!!.Onclick(1, 1,  true)
            }
            dismiss()
        }
        binding.btDialogCancel.setOnClickListener {
            if (lister != null) {
                lister!!.Onclick(1, 1,  false)
            }
            dismiss()
        }
    }

}