class CafeDetails (
  val shopName: String,
  val address: String,
  val phone: String,
  val prices: Map[String, Double]
)

class ReceiptPrinter(val cafe: CafeDetails, var order: Map[String, Int] = Map()) {

  def receipt: String = {
    s"""
    ${cafe.shopName}\n${cafe.address}\n${cafe.phone}\n${formatPrices(cafe.prices)}
    """
  }

  def formatPrices(prices: Map[String, Double]): String = {
    if (prices.isEmpty) {
       ""
    }
    else {
        val (item, price) = prices.head
        val remainingPrices = prices.tail
        f"$item: ${price}%.2f\n" + formatPrices(remainingPrices)

  }
    }
  }
  