package scalatest.currency

trait Currency {

  //http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml
  lazy val rates: Map[String, BigDecimal] = {
    val exchangeRates = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
    for (
      elem <- xml.XML.load(exchangeRates)\"Cube"\"Cube"\"Cube"
    ) yield (elem\"@currency").text -> BigDecimal((elem\"@rate").text)
  }.toMap ++ Map[String, BigDecimal]("EUR"->1)

  def convert(amount:BigDecimal, from:String, to:String) =
    amount / rates(from) * rates(to)
}
