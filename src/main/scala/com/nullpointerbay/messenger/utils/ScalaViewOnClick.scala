package com.nullpointerbay.messenger.utils

import android.view.View
import android.view.View.OnClickListener

/**
  * Created by rafal on 1/10/16.
  */
trait ScalaViewTrait {
  implicit def view2ScalaView[T <: View](view: T) =
    new ScalaView[T](view)
}

class ScalaView[T <: View](view: T) {
  def onClick(action: T => Any) =
    view.setOnClickListener(new OnClickListener {
      def onClick(view: View) {
        action(view.asInstanceOf[T])
      }
    })
}