package scalatest.currency


class MoneyService(converter:Currency ) {

  def sendMoneyToSweden(amount:BigDecimal,from:String): BigDecimal = {
    val convertedAmount = converter.convert(amount,from,"SEK")
    println(s" $convertedAmount SEK are on their way...")
    convertedAmount
  }

  def sendMoneyToSwedenViaEngland(amount:BigDecimal,from:String): BigDecimal = {
    val englishAmount = converter.convert(amount,from,"GBP")
    println(s" $englishAmount GBP are on their way...")
    val swedishAmount = converter.convert(englishAmount,"GBP","SEK")
    println(s" $swedishAmount SEK are on their way...")
    swedishAmount
  }
}