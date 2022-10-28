package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var whiteMage1: WhiteMage
lateinit var whiteMage2: WhiteMage
lateinit var whiteMage3: WhiteMage

class WhiteMageTest : FunSpec({
    beforeEach {
      val queue = LinkedBlockingQueue<GameCharacter>()

      whiteMage1 = WhiteMage("white mage name", 10, 10, 10, queue)
      whiteMage2 = WhiteMage("white mage name", 10, 10, 10, queue)
      whiteMage3 = WhiteMage("other white mage name", 15, 20, 20, queue)
    }

    test("Two white mages with the same name, maxHP, maxMP and defense should be equals") {
      whiteMage1 shouldNotBeSameInstanceAs whiteMage2
      whiteMage1 shouldBe whiteMage2
    }

    test("Two white mages with different names, maxHP, maxMP and defense should not be equal") {
      whiteMage1 shouldNotBe whiteMage3
    }

    test("A white mage and any other mage with the same name, maxHP, maxMP and defense should not be equal") {
      whiteMage1 shouldNotBe blackMage1
    }

    test("The string representation of a white mage should be correct") {
      "$whiteMage1" shouldBe "WhiteMage { name: 'white mage name', maxMP: 10, maxHP: 10, defense: 10, currentMP: 10 }"
    }

    test("A white mage and another mage with the same name, maxHP, maxMP and defense should not have the same hash code") {
      whiteMage1 shouldNot haveSameHashCodeAs(blackMage1)
    }
})