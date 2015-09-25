package scalatest.currency

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class MoneyServiceTest extends FlatSpec with Matchers{


"Sending money to Sweden" should "convert into SEK" in {
    val moneyService =
      new MoneyService(new ECBConverter)
    val amount = 200
    val from = "EUR"
    val result = moneyService.sendMoneyToSweden(amount, from)
    result.toInt should (be > (1700) and be <= (1800))
  }

"Sending money to Sweden via England" should "convert into GBP then SEK" in {
    val moneyService =
      new MoneyService(new ECBConverter)
    val amount = 200
    val from = "EUR"
    val result = moneyService.sendMoneyToSwedenViaEngland(amount, from)
    result.toInt should (be > (1700) and be <= (1800))
  }


}

class ECBConverter extends Currency

