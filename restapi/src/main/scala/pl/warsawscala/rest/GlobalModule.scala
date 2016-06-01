package pl.warsawscala.rest

import com.google.inject.AbstractModule
import com.typesafe.scalalogging.StrictLogging
import play.api.{Configuration, Environment}

class GlobalModule(
    environment: Environment,
    configuration: Configuration
) extends AbstractModule with StrictLogging {
  override def configure(): Unit = {
    ()
  }
}
