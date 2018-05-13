package com.progrexor.sandbox.run

import com.progrexor.sandbox.sbt._

class UseA {
  val message = (new LibA).name
}

object UseA {
  def main(args: Array[String]): Unit = {
    val x = new UseA
    println(x.message)
  }
}
