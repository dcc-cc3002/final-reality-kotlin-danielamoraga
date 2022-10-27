package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

lateinit var knife1: KNIFE
lateinit var knife2: KNIFE
lateinit var knife3: KNIFE

class KNIFETest : FunSpec({
    beforeEach {
        knife1 = KNIFE("probando",10,10)
        knife2 = KNIFE("probando",10,10)
        knife3 = KNIFE("probandon't",20,20)
    }

    test("Two knifes with the same name, damage and weight should be equals") {
        knife1 shouldNotBeSameInstanceAs knife2
        knife1 shouldBe knife2
    }

    test("Two knifes with different names, damage or weight should not be equal") {
        knife1 shouldNotBe knife3
    }

    test("A knife and any other weapon with the same name, damage and weight should not be equal") {
        knife1 shouldNotBe staff1
    }

    test("The string representation of a knife should be correct") {
        "$knife1" shouldBe "KNIFE { name: probando, damage: 10, weight: 10 }"
    }

    test("A knife and another weapon with the same name, damage and weight should not have the same hash code") {
        knife1 shouldNot haveSameHashCodeAs(staff1)
    }
})