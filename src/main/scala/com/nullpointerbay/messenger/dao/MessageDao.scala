package com.nullpointerbay.messenger.dao

import com.nullpointerbay.messenger.data.Message

/**
  * Created by rafal on 1/9/16.
  */
trait MessageDao {

  def loadMessages: Seq[Message]

}
