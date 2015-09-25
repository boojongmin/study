package scalatest

import org.scalatest._

class Test01 extends FunSuite {
  test("Very Basic") {
    assert(1 == 1)
  }
  test("Another Very Basic"){
    assert("Hello World" == "Hello World")
  }
}
