package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var blackMage1: BlackMage
lateinit var blackMage2: BlackMage
lateinit var blackMage3: BlackMage

class BlackMageTest : FunSpec({
    beforeEach {
      // setUpCharacter() ???
      val queue = LinkedBlockingQueue<GameCharacter>()

      blackMage1 = BlackMage("black mage name", 10, 10, 10, queue)
      blackMage2 = BlackMage("black mage name", 10, 10, 10, queue)
      blackMage3 = BlackMage("other black mage name", 15, 20, 20, queue)
    }

    test("Two black mages with the same name, maxHP, maxMP and defense should be equals") {
      blackMage1 shouldNotBeSameInstanceAs blackMage2
        blackMage1 shouldBe blackMage2
    }

    test("Two black mages with different names, maxHP, maxMP and defense should not be equal") {
        blackMage1 shouldNotBe blackMage3
    }

    test("A black mage and any other mage with the same name, maxHP, maxMP and defense should not be equal") {
        blackMage1 shouldNotBe whiteMage1
    }

    test("The string representation of a black mage should be correct") {
      "$blackMage1" shouldBe "BlackMage { name: 'black mage name', maxMP: 10, maxHP: 10, defense: 10, currentMP: 10 }"
    }

    test("A black mage and another mage with the same name, maxHP, maxMP and defense should not have the same hash code") {
        blackMage1 shouldNot haveSameHashCodeAs(whiteMage1)
    }
})