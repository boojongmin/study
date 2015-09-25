package scalatest

import org.scalatest.{FlatSpec, Matchers}

class Test07 extends FlatSpec with Matchers {
  "This test" should "pass" in {
    true should be === true
  }

}
