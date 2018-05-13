package com.progrexor.sandbox.run

object Main {
  def main(args: Array[String]): Unit = {
    val uA = new UseA
    println(uA.message)

    val uB = new UseB
    println(uB.message)
  }
}
