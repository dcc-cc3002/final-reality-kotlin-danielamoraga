package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var engineer1: Engineer
lateinit var engineer2: Engineer
lateinit var engineer3: Engineer

class EngineerTest : FunSpec({
    beforeEach {
      // setUpGameCharacter() ???
      val queue = LinkedBlockingQueue<GameCharacter>()

      engineer1 = Engineer("name", 10, 10, queue)
      engineer2 = Engineer("name", 10, 10, queue)
      engineer3 = Engineer("other name", 15, 15, queue)
    }

    test("Two engineers with the same name, maxHP and defense should be equals") {
      engineer1 shouldNotBeSameInstanceAs engineer2
      engineer1 shouldBe engineer2
    }

    test("Two engineers with different names, maxHP or defense should not be equal") {
      engineer1 shouldNotBe engineer3
    }

    test("An engineer and any other player character with the same name, maxHP and defense should not be equal") {
      engineer1 shouldNotBe knight1
    }

    test("The string representation of an engineer should be correct") {
      "$engineer1" shouldBe "Engineer { name: 'name', maxHP: 10, defense: 10, currentHP: 10 }"
    }

    test("An engineer and another player character with the same name, maxHP and defense should not have the same hash code") {
      engineer1 shouldNot haveSameHashCodeAs(knight1)
    }
})