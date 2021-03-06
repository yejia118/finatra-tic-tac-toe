package com.twitter.tictactoe.heroku.parser

import com.twitter.tictactoe.heroku.controllers.RequestParams

object StatusParamParser extends ParamParser {
  def validate(request: RequestParams): Status = {
    request.game match {
      case Some(g) => Status(StatusType.OK, None)
      case _ => Status(
        StatusType.ERROR,
        Some("There is no game in this channel. Please type / ttt challenge <user> to start a new game!"))
    }
  }
}
