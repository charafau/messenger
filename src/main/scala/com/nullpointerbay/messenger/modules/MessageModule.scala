package com.nullpointerbay.messenger.modules

import com.nullpointerbay.messenger.dao.{MessageDao, InMemoryMessageDao}
import com.nullpointerbay.messenger.fragment.MessageFragment
import com.nullpointerbay.messenger.presenter.MessageContract.{MessageView, MessageInteractions}
import com.nullpointerbay.messenger.presenter.MessagePresenter

/**
  * Created by rafal on 1/9/16.
  */
trait MessageModule {

  import com.softwaremill.macwire._

  def messageView: MessageView = wire[MessageFragment]
  lazy val messageDao: MessageDao = wire[InMemoryMessageDao]
  lazy val messagePresenter: MessageInteractions = wire[MessagePresenter]

}
