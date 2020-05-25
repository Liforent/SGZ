package com.zhiquchuanmei.sangz.ui.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment


abstract class SGBaseFragment : Fragment() {

    protected abstract fun getContentLayoutId(): Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getContentLayoutId(), container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewCreated(view)
    }

    protected abstract fun afterViewCreated(view: View)

    fun showToast(msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }





    override fun onDestroy() {
        super.onDestroy()
    }

    open fun checkLoginState() {}
}