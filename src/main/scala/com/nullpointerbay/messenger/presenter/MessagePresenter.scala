package com.nullpointerbay.messenger.presenter

import com.nullpointerbay.messenger.dao.MessageDao
import com.nullpointerbay.messenger.data.Message
import com.nullpointerbay.messenger.presenter.MessageContract.{MessageView, MessageInteractions}

/**
  * Created by rafal on 1/9/16.
  */
class MessagePresenter(messageDao: MessageDao, messageView: MessageView) extends MessageInteractions {
  override def loadMessages(): Unit = {
    messageView.showLoadedMessages(messageDao.loadMessages)
  }
}

object MessageContract {

  trait MessageInteractions {
    def loadMessages(): Unit

  }

  trait MessageView {
    def showLoadedMessages(loadMessages: Seq[Message]): Unit
  }

}
