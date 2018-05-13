package com.progrexor.sandbox.run

import com.progrexor.sandbox.sbt._

class UseB {
  val message = (new LibB).name
}

object UseB {
  def main(args: Array[String]): Unit = {
    val x = new UseB
    println(x.message)
  }
}