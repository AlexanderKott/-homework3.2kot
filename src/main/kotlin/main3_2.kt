import java.math.BigDecimal
import java.math.RoundingMode


fun main() {

  val prevSum : BigDecimal  = BigDecimal(0) //Предыдущий перевод
  val sumToPay : BigDecimal  = BigDecimal(100) //Сумма которую должен заплатить пользователь

    for (i in Pay.values()){
      println(" Итого ${i.discount(prevSum,sumToPay).setScale(  2,  RoundingMode.CEILING)} ")

  }

}



