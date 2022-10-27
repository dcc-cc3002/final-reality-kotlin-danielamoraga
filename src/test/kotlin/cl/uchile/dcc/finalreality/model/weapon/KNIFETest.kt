package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

lateinit var bow1: BOW
lateinit var bow2: BOW
lateinit var bow3: BOW

class BOWTest : FunSpec({
    beforeEach {
        bow1 = BOW("probando",10,10)
        bow2 = BOW("probando",10,10)
        bow3 = BOW("probandon't",20,20)
    }

    test("Two bows with the same name, damage and weight should be equals") {
        bow1 shouldNotBeSameInstanceAs bow2
        bow1 shouldBe bow2
    }

    test("Two bows with different names, damage or weight should not be equal") {
        bow1 shouldNotBe bow3
    }

    test("A bow and any other weapon with the same name, damage and weight should not be equal") {
        bow1 shouldNotBe knife1
    }

    test("The string representation of a bow should be correct") {
        "$bow1" shouldBe "BOW { name: probando, damage: 10, weight: 10 }"
    }

    test("A bow and another weapon with the same name, damage and weight should not have the same hash code") {
        bow1 shouldNot haveSameHashCodeAs(knife1)
    }
})