package com.nullpointerbay.messenger.activity

import android.os.Bundle
import com.nullpointerbay.messenger.fragment.MessageFragment
import com.nullpointerbay.messenger.{R, TypedFindView}

class MainActivity extends BaseActivity with TypedFindView {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
    val ft = getSupportFragmentManager.beginTransaction
    ft.replace(R.id.root, MessageFragment.getInstance(), MessageFragment.TAG).commit
    //    findView(TR.txt_hello).setText(textProvider.provide)
    //    val recyclerView: RecyclerView = findView(TR.recycler_cards)
    //    val manager: LinearLayoutManager = new LinearLayoutManager(this)
    //    recyclerView.setLayoutManager(manager)
    //    recyclerView.setAdapter(new MessageAdapter(Vector(Message("Hello"))))
  }
}
