package com.nullpointerbay.messenger.fragment

import android.os.Bundle
import android.support.v7.widget.{LinearLayoutManager, RecyclerView}
import android.util.Log
import android.view.View.OnClickListener
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{Button, EditText}
import com.nullpointerbay.messenger.TypedResource.TypedView
import com.nullpointerbay.messenger.data.{MessageAdapter, Message}
import com.nullpointerbay.messenger.modules.MessageModule
import com.nullpointerbay.messenger.presenter.MessageContract.MessageView
import com.nullpointerbay.messenger.utils.ScalaViewTrait
import com.nullpointerbay.messenger.{R, TR}

/**
  * Created by rafal on 1/9/16.
  */
class MessageFragment extends BaseFragment with MessageView with ScalaViewTrait with MessageModule {

  lazy val adapter: MessageAdapter = new MessageAdapter(Vector())

  override def onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle): View = {
    super.onCreateView(inflater, container, savedInstanceState)
    val view: View = inflater.inflate(R.layout.fragment_message, container, false)

    val recyclerView: RecyclerView = view.findView(TR.recycler_messages)
    recyclerView.setAdapter(adapter)

    val manager: LinearLayoutManager = new LinearLayoutManager(getContext)
    recyclerView.setLayoutManager(manager)

    val btnSend: Button = view.findView(TR.btn_send)
    val editText: EditText = view.findView(TR.edit_message)
    btnSend.onClick(v => {
      adapter.add(Message(editText.getText.toString))
      adapter.notifyDataSetChanged()
      editText.setText("")
      manager.scrollToPosition(adapter.last() - 1 )
    })


    view
  }


  override def messageView: MessageView = this

  override def onResume(): Unit = {
    super.onResume()
    messagePresenter.loadMessages()
  }

  implicit def funcOnClick(f: View => Unit): OnClickListener = {
    new OnClickListener() {
      def onClick(v: View) = f.apply(v)
    }
  }

  override def showLoadedMessages(messages: Seq[Message]): Unit = {
    Log.d("MessageFragment", "showing messages" + messages)
    adapter.messages = messages
    adapter.notifyDataSetChanged()
    Log.d("MessageFragment", "showing messages" + adapter.getItemCount)
  }
}

object MessageFragment {

  val TAG = MessageFragment.getClass.getSimpleName

  def getInstance() = new MessageFragment()
}

