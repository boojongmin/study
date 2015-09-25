println("hello")
for {
  elem <- List(1, 2, 3, 4, 5)
} yield "T" + elem

for {
  word <- List("Hello", "Scala")
  char <- word
} yield char.isLower

for {
  word <- List("Hello", "Scala")
  char <- word if char.isUpper
} yield char

for {
  word <- List("Hello", "Scala")
  char <- word
  lowerChar = char.toLower
} yield lowerChar


val exchangeRates =
  "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"
for (
  elem <- xml.XML.load(exchangeRates)\"Cube"\"Cube"\"Cube")
  yield
  (elem\"@currency").text -> BigDecimal((elem\"@rate").text)


