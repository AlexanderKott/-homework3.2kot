import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import java.math.RoundingMode

internal class Main3_2KtTest {

    @Test
    fun visa_test() {
        val  prevSum = BigDecimal(0.00)
        val sumToPay = BigDecimal (100.00)

        val actual = Pay.VISA.discount(prevSum,sumToPay).setScale(  2,  RoundingMode.CEILING)
        val expected = BigDecimal (100.75)

        assertEquals(actual,expected)
    }

     @Test  //Самый минимальный платеж может быть не менее 35.00 рублей
    fun visa_test_minimum35rub() {
        val  prevSum = BigDecimal(0.00)
        val sumToPay = BigDecimal (14.00)

        val actual = Pay.VISA.discount(prevSum,sumToPay).setScale(  2,  RoundingMode.CEILING)
        val expected =  "35.00"

         val act = actual.toString()

        assertEquals(act,expected)
    }

    @Test
    fun mir_test() {
        val  prevSum = BigDecimal(0.00)
        val sumToPay = BigDecimal (100.00)

        val actual = Pay.MIR.discount(prevSum,sumToPay).setScale(  2,  RoundingMode.CEILING)
        val expected = BigDecimal (100.75)

        assertEquals(actual,expected)
    }

     @Test  //Самый минимальный платеж может быть не менее 35.00 рублей
    fun mir_test_minimum35rub() {
        val  prevSum = BigDecimal(0.00)
        val sumToPay = BigDecimal (14.00)

        val actual = Pay.MIR.discount(prevSum,sumToPay).setScale(  2,  RoundingMode.CEILING)
        val expected =  "35.00"

         val act = actual.toString()

        assertEquals(act,expected)
    }


    @Test
    fun vk_pay_test(){
        val  prevSum = BigDecimal(0.00)

        val expectedValue = "1000.00"
        val sumToPay = BigDecimal (expectedValue)
        val actual = Pay.VK_PAY.discount(prevSum,sumToPay)

        val act : String = actual.setScale(  2,  RoundingMode.CEILING).toString()

        assertEquals( expectedValue ,act )
    }

    @Test
    fun mastercard_test_in_range(){
        val  prevSum = BigDecimal(0.00)

        val expectedValue = "1000.00"
        val sumToPay = BigDecimal (expectedValue)
        val actual = Pay.MASTERCARD.discount(prevSum,sumToPay)

        val act : String = actual.setScale(  2,  RoundingMode.CEILING).toString()

        assertEquals( expectedValue ,act )
    }


    @Test
    fun mastercard_test_NOT_in_range(){
        val  prevSum = BigDecimal(0.00)

        val expectedValue = "120.60"
        val sumToPay = BigDecimal ("100.00")
        val actual = Pay.MASTERCARD.discount(prevSum,sumToPay)

        val act : String = actual.setScale(  2,  RoundingMode.CEILING).toString()

        assertEquals( expectedValue ,act )
    }

    @Test
    fun maestro_test_in_range(){
        val  prevSum = BigDecimal(0.00)

        val expectedValue = "1000.00"
        val sumToPay = BigDecimal (expectedValue)
        val actual = Pay.MAESTRO.discount(prevSum,sumToPay)

        val act : String = actual.setScale(  2,  RoundingMode.CEILING).toString()

        assertEquals( expectedValue ,act )
    }


    @Test
    fun maestro_d_test_NOT_in_range(){
        val  prevSum = BigDecimal(0.00)

        val expectedValue = "120.60"
        val sumToPay = BigDecimal ("100.00")
        val actual = Pay.MAESTRO.discount(prevSum,sumToPay)

        val act : String = actual.setScale(  2,  RoundingMode.CEILING).toString()

        assertEquals( expectedValue ,act )
    }



}