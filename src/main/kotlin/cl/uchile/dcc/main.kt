package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.BOW
import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.weapon.STAFF
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {

    // Tests for addToQueue() for different characters and equip(weapon) by them equipping different weapons
    val queue = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        Knight("$i", 10, 10, queue).equip(SWORD("", 0, Random.nextInt(1, 50)))
        Engineer("$i", 10, 10, queue).equip(AXE("",0, Random.nextInt(1, 50)))
        Thief("$i", 10, 10, queue).equip(KNIFE("", 0, Random.nextInt(1, 50)))
        BlackMage("$i", 10, 10, 10, queue) // Mages can't use weapons
        WhiteMage("$i", 10, 10, 10, queue) // Mages can't use weapons
    }

    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }

    // Test for Enemy.attack(PlayerCharacter)
    Enemy("some enemy name",10, 10, queue, 10).attack(Knight("",10,10,queue))
    Enemy("some enemy name",10, 10, queue, 10).attack(Engineer("",10,10,queue))
    Enemy("some enemy name",10, 10, queue, 10).attack(Thief("",10,10,queue))
    Enemy("some enemy name",10, 10, queue, 10).attack(BlackMage("", 10, 10, 10, queue))
    Enemy("some enemy name",10, 10, queue, 10).attack(WhiteMage("", 10, 10, 10, queue))

    // Game characters:
    val knight = Knight("some knight name", 10, 10, queue)
    val engineer = Engineer("some engineer name", 10, 10, queue)
    val thief = Thief("some thief name", 10, 10, queue)
    val whitemage = WhiteMage("some white mage name", 10, 10, 10, queue)
    val blackmage = BlackMage("some black mage name", 10, 10, 10, queue)
    val enemy = Enemy("some enemy name",10, 10, queue, 10)

    // testing toString for game characters
    println("Knight:")
    println(knight.toString())
    println("Engineer:")
    println(engineer.toString())
    println("Thief:")
    println(thief.toString())
    println("White Mage:")
    println(whitemage.toString())
    println("Black Mage:")
    println(blackmage.toString())
    println("Enemy:")
    println(enemy.toString())

    // testing equals for game characters
    // Knight:
    println("Are knight and engineer the same?")
    println(knight.equals(engineer))
    println("Are knight and knight the same?")
    println(knight.equals(knight))
    // Engineer:
    println("Are engineer and thief the same?")
    println(engineer.equals(thief))
    println("Are engineer and engineer the same?")
    println(engineer.equals(engineer))
    // Thief:
    println("Are thief and whitemage the same?")
    println(thief.equals(whitemage))
    println("Are thief and thief the same?")
    println(thief.equals(thief))
    // WhiteMage:
    println("Are whitemage and blackmage the same?")
    println(whitemage.equals(blackmage))
    println("Are whitemage and whitemage the same?")
    println(whitemage.equals(whitemage))
    // BlackMage:
    println("Are blackmage and thief the same?")
    println(blackmage.equals(thief))
    println("Are blackmage and blackmage the same?")
    println(blackmage.equals(blackmage))

    //Weapons:
    val knife = KNIFE("knife's name",5,5) // random numbers for the testing, they have nothing to do with the real ones
    val staff = STAFF("staff's name", 5,5)
    val sword = SWORD("sword's name",5,5)
    val axe = AXE("axe's name",5,5)
    val bow = BOW("bow's name",5,5)

    // testing toString for weapons
    println("Knife:")
    println(knife.toString())
    println("Staff:")
    println(staff.toString())
    println("Sword:")
    println(sword.toString())
    println("Axe:")
    println(axe.toString())
    println("Bow:")
    println(bow.toString())

    // testing equals for weapons
    // KNIFE
    println("Are knife and staff the same?")
    println(knife.equals(staff))
    println("Are knife and knife the same?")
    println(knife.equals(knife))
    // STAFF
    println("Are staff and sword the same")
    println(staff.equals(sword))
    println("Are staff and staff the same?")
    println(staff.equals(staff))
    // SWORD
    println("Are sword and axe the same?")
    println(sword.equals(axe))
    println("Are sword and sword the same?")
    println(sword.equals(sword))
    // AXE
    println("Are axe and bow the same?")
    println(axe.equals(bow))
    println("Are axe and axe the same?")
    println(axe.equals(axe))
    // BOW
    println("Are bow and knife the same?")
    println(bow.equals(knife))
    println("Are bow and bow the same?")
    println(bow.equals(bow))

    // testing useOn method
    knife.useOn(knight)
    staff.useOn(whitemage)
    sword.useOn(thief)
    axe.useOn(engineer)
    bow.useOn(engineer)

    println(" ")

    println("All tests done.")
}