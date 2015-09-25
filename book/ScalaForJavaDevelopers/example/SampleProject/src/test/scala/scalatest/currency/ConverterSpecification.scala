package scalatest.currency

import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalacheck.Prop.forAll
import Arbitrary.arbitrary

object ConverterSpecification extends Properties("Currency") with Currency {

//  val currencies = Gen.oneOf("EUR", "GBP", "SEK", "JPY", "DUMMY")
  val currencies = Gen.oneOf("EUR", "GBP", "SEK", "JPY")

  lazy val conversions: Gen[(BigDecimal, String, String)] = for {
    amt <- arbitrary[BigDecimal] suchThat {_ >= 0 }
    from <- currencies
    to <- currencies
  } yield (amt, from, to)

  property("Conversion to same value") = forAll(currencies) { c:String =>
    val amount = BigDecimal(200)
    val convertedAmount = convert(amount, c, c)
    convertedAmount == amount
  }

  property("Various currencies") = forAll(conversions) { c =>
    val convertedAmount = convert(c._1, c._2, c._3)
    convertedAmount >= 0
  }

}
