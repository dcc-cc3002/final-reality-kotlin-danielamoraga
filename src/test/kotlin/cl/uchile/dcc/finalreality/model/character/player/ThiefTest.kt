package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.knife1
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var thief1: Thief
lateinit var thief2: Thief
lateinit var thief3: Thief

class ThiefTest : FunSpec({
    beforeEach {
       val queue = LinkedBlockingQueue<GameCharacter>()

       thief1 = Thief("name", 10, 10, queue)
       thief2 = Thief("name", 10, 10, queue)
       thief3 = Thief("other name", 15, 15, queue)
    }

    test("Two thiefs with the same name, maxHP and defense should be equals") {
       thief1 shouldNotBeSameInstanceAs thief2
       thief1 shouldBe thief2
    }

    test("Two thiefs with different names, maxHP or defense should not be equal") {
       thief1 shouldNotBe thief3
    }

    test("A thief and any other player character with the same name, maxHP and defense should not be equal") {
       thief1 shouldNotBe engineer1
    }

    test("The string representation of a thief should be correct") {
       "$thief1" shouldBe "Thief { name: 'name', maxHP: 10, defense: 10, currentHP: 10 }"
    }

    test("A thief and another player character with the same name, maxHP and defense should not have the same hash code") {
       thief1 shouldNot haveSameHashCodeAs(engineer1)
    }

    test("A thief should be able to equip a weapon"){
    thief1.equip(knife1)
    thief1.equippedWeapon shouldBe knife1
    }
})