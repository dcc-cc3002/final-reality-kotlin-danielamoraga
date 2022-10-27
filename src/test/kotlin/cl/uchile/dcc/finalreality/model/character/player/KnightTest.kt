package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var knight1: Knight
lateinit var knight2: Knight
lateinit var knight3: Knight

class KnightTest : FunSpec({
    beforeEach {
      // setUpGameCharacter() ???
      val queue = LinkedBlockingQueue<GameCharacter>()

      knight1 = Knight("name", 10, 10, queue)
      knight2 = Knight("name", 10, 10, queue)
      knight3 = Knight("other name", 15, 15, queue)
    }

    test("Two knights with the same name, maxHP and defense should be equals") {
      knight1 shouldNotBeSameInstanceAs knight2
      knight1 shouldBe knight2
    }

    test("Two knights with different names, maxHP or defense should not be equal") {
      knight1 shouldNotBe knight3
    }

    test("A knight and any other player character with the same name, maxHP and defense should not be equal") {
      knight1 shouldNotBe thief1
    }

    test("The string representation of a knight should be correct") {
      "$knight1" shouldBe "Knight { name: 'name', maxHP: 10, defense: 10, currentHP: 10 }"
    }

    test("A knight and another player character with the same name, maxHP and defense should not have the same hash code") {
      knight1 shouldNot haveSameHashCodeAs(thief1)
    }
})