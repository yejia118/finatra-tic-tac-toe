package com.twitter.tictactoe.heroku

import com.codahale.metrics.MetricFilter
import com.google.inject.Stage
import com.twitter.finagle.metrics.MetricsStatsReceiver
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import com.twitter.tictactoe.heroku.server.TicTacToeServer

class HelloWorldStartupTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(
    twitterServer = new TicTacToeServer,
    stage = Stage.PRODUCTION,
    verbose = false)

  override def afterEach() {
    MetricsStatsReceiver.metrics.removeMatching(MetricFilter.ALL)
  }

  "Server" should {
    "startup" in {
      // Because we disabled the adminHttpServer we instead check the started flag.
      server.assertStarted()
    }
  }
}
