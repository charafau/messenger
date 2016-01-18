package com.nullpointerbay.messenger.dao

import com.nullpointerbay.messenger.data.Message

/**
  * Created by rafal on 1/9/16.
  */
class InMemoryMessageDao extends MessageDao {
  override def loadMessages: Seq[Message] = Vector(
    Message("First"),
    Message("Second"),
    Message("Third"),
    Message("Fourth"),
    Message("Fifth")
  )
}
