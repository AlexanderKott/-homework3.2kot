import java.math.BigDecimal



interface PayMethods{
    fun discount(
                       prevSum: BigDecimal,
                       currentSum: BigDecimal ): BigDecimal
}


enum class Pay: PayMethods{

    MAESTRO{
        override fun discount(  prevSum: BigDecimal, currentSum: BigDecimal): BigDecimal {
            val percent = BigDecimal(0.6)    //Процент за перевод
            val sum = BigDecimal(20.00)      //Сумма добавки по условию процента
            val minSum = BigDecimal(300.00)  //Минимальная сумма
            val maxSum = BigDecimal(75000.00)  //Максимальная сумма


            print(this.name)

            return if ((currentSum > minSum)&&(currentSum < maxSum)){
                 currentSum
            } else{
                var res: BigDecimal = currentSum.multiply(percent).divide(BigDecimal(100))
                res.plus(sum).plus(currentSum)
            }
        }
    },

    MASTERCARD{
        override fun discount( prevSum: BigDecimal, currentSum: BigDecimal): BigDecimal {
            val percent = BigDecimal(0.6)    //Процент за перевод
            val sum = BigDecimal(20.00)      //Сумма добавки по условию процента
            val minSum = BigDecimal(300.00)  //Минимальная сумма
            val maxSum = BigDecimal(75000.00)  //Максимальная сумма
            var res = BigDecimal.ZERO

            print(this.name)

            return if ((currentSum > minSum)&&(currentSum < maxSum)){
                currentSum
            } else{
                var res: BigDecimal = currentSum.multiply(percent).divide(BigDecimal(100))
                res.plus(sum).plus(currentSum)
            }
        }
    },
    VK_PAY{
        override fun discount(  prevSum: BigDecimal, currentSum: BigDecimal): BigDecimal {

            print(this.name)
            return currentSum
        }
    },

    MIR{
        override fun discount(  prevSum: BigDecimal, currentSum: BigDecimal): BigDecimal {
            val percent = BigDecimal(0.75)    //Процент за перевод
            val minPercent = BigDecimal(35.00)  //Минимальная сумма

            val res: BigDecimal = currentSum.multiply(percent).divide(BigDecimal(100))

            print(this.name)
            return if (currentSum.toInt() > minPercent.toInt()) res.plus(currentSum) else minPercent
        }
    },
    VISA{
        override fun discount(  prevSum: BigDecimal, currentSum: BigDecimal): BigDecimal {
            val percent = BigDecimal(0.75)    //Процент за перевод
            val minPercent = BigDecimal(35.00)  //Минимальная сумма

            val res: BigDecimal = currentSum.multiply(percent).divide(BigDecimal(100))

            print(this.name)
            return if (currentSum.toInt() > minPercent.toInt()) res.plus(currentSum) else minPercent
        }
    }
}