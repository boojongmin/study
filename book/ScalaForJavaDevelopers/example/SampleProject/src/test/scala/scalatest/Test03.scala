package scalatest

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Test03 extends FunSuite{
  test("Exception expected, does not fire, FAIL") {
    val msg = "hello"
    intercept[IndexOutOfBoundsException] {
    msg.charAt(100)
    }
  }
    test("Exception expected, fires, PASS"){
      val msg = "hello"
      intercept[IndexOutOfBoundsException]{
        msg.charAt(-1)
      }
    }

}
