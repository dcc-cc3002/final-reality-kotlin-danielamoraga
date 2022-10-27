package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

lateinit var axe1: AXE
lateinit var axe2: AXE
lateinit var axe3: AXE

class AXETest : FunSpec({
    beforeEach {
        axe1 = AXE("probando",10,10)
        axe2 = AXE("probando",10,10)
        axe3 = AXE("probandon't",20,20)
    }

    test("Two axes with the same name, damage and weight should be equals") {
        axe1 shouldNotBeSameInstanceAs axe2
        axe1 shouldBe axe2
    }

    test("Two axes with different names, damage or weight should not be equal") {
        axe1 shouldNotBe axe3
    }

    test("An axe and any other weapon with tha same name, damage and weight should not be equal") {
        axe1 shouldNotBe bow1
    }

    test("The string representation of an axe should be correct") {
        "$axe1" shouldBe "AXE { name: probando, damage: 10, weight: 10 }"
    }

    test("An axe and another weapon with the same name, damage and weight should not have the same hash code") {
        axe1 shouldNot haveSameHashCodeAs(bow1)
    }
})