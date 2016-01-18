package com.nullpointerbay.messenger.data

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.TextView
import com.nullpointerbay.messenger.{TR, R, TypedFindView}

/**
  * Created by rafal on 1/7/16.
  */
class MessageAdapter(var messages: Seq[Message]) extends RecyclerView.Adapter[MessageViewHolder] {

  def last(): Int = messages.size

  def add(message: Message) = {
    messages = messages :+ message
    Log.d("Adding message", "mesages: " + messages.size)
  }

  override def getItemCount: Int = messages.size

  override def onBindViewHolder(vh: MessageViewHolder, i: Int): Unit = {
    vh.txtMessage.setText(messages(i).message)
  }

  override def onCreateViewHolder(viewGroup: ViewGroup, i: Int): MessageViewHolder = {
    val view: View = LayoutInflater.from(viewGroup.getContext).inflate(R.layout.item_message, viewGroup, false)
    new MessageViewHolder(view)
  }
}

class MessageViewHolder(view: View) extends RecyclerView.ViewHolder(view) with TypedFindView {
  override protected def findViewById(id: Int): View = view.findViewById(id)

  val txtMessage: TextView = findView(TR.txt_message)

}
