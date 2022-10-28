package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

lateinit var enemy1: Enemy
lateinit var enemy2: Enemy
lateinit var enemy3: Enemy

class EnemyTest : FunSpec({
    beforeEach {
        val queue = LinkedBlockingQueue<GameCharacter>()

        enemy1 = Enemy("name",10,10,queue,10)
        enemy2 = Enemy("name",10,10,queue,10)
        enemy3 = Enemy("other name",15,20,queue,20)
    }

    test("Two enemies with the same name, maxHP, defense and weight should be equals") {
        enemy1 shouldNotBeSameInstanceAs enemy2
        enemy1 shouldBe enemy2
    }

    test("Two enemies with different names, maxHP, defense or weight should not be equal") {
        enemy1 shouldNotBe enemy3
    }

    test("Two enemies with the same name, maxHP, defense and weight should have the same hash code") {
        enemy1 should haveSameHashCodeAs(enemy2)
    }

    test("An enemy and another enemy with different name, maxHP, defense and weight should not have the same hash code") {
        enemy1 shouldNot haveSameHashCodeAs(enemy3)
    }

    test("The string representation of an enemy should be correct") {
        "$enemy1" shouldBe "Enemy { name: 'name', maxHP: 10, defense: 10, currentHP: 10, weight: 10 }"
    }
})