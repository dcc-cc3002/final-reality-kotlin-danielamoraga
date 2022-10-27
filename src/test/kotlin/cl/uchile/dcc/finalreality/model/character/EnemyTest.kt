package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
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
        // setUpGameCharacter() ???
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

    /*test("An enemy and any other character with the same name, maxHP, defense and weight should not be equal") {
        enemy1 shouldNotBe engineer1
    }*/ //creo que no puedo hacer este test porque no hay personajes similares a enemy

    test("The string representation of an enemy should be correct") {
        //??????????
        "$enemy1" shouldBe "Enemy { name: 'name', maxHP: 10, defense: 10, currentHP: 10, weight: 10 }"
    }

    /*test("An enemy and another character with the same name, maxHP, defense and weight should not have the same hash code") {
        enemy1 shouldNot haveSameHashCodeAs(engineer1)
    }*/
})