package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

lateinit var sword1: SWORD
lateinit var sword2: SWORD
lateinit var sword3: SWORD

class SWORDTest : FunSpec({
    beforeEach {
      sword1 = SWORD("probando",10,10)
      staff2 = SWORD("probando",10,10)
      staff3 = SWORD("probandon't",20,20)
    }

    test("Two swords with the same name, damage and weight should be equals") {
      sword1 shouldNotBeSameInstanceAs sword2
      sword1 shouldBe sword2
    }

    test("Two swords with different names, damage or weight should not be equal") {
      sword1 shouldNotBe sword3
    }

    test("A sword and any other weapon with the same name, damage and weight should not be equal") {
      sword1 shouldNotBe axe1
    }

    test("The string representation of a sword should be correct") {
      "$sword1" shouldBe "SWORD { name: probando, damage: 10, weight: 10 }"
    }

    test("A sword and another weapon with the same name, damage and weight should not have the same hash code") {
      sword1 shouldNot haveSameHashCodeAs(axe1)
    }
})