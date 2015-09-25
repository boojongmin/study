package scalatest.currency

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MoneyServiceTestMock extends FlatSpec with MockFactory with Matchers{

  "Sending money to Sweden" should "convert into SEK" in {

    val converter = mock[Currency]
    val moneyService = new MoneyService(converter)

    (converter.convert _).expects(BigDecimal("200"),"EUR","SEK").returning(BigDecimal(1750))

    val amount = 200
    val from = "EUR"
    val result = moneyService.sendMoneyToSweden(amount, from)
    result.toInt should be (1750)
  }

}
