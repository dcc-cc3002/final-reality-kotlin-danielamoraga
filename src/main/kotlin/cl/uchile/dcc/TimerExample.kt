package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.weapon.KNIFE
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.weapon.AXE
import cl.uchile.dcc.finalreality.model.weapon.SWORD
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    val engineer = Engineer("engineer",10,10,queue)
    val axe = AXE("axe",10,1)
    engineer.equip(axe)
    engineer.waitTurn()

    val knight = Knight("knight",10,10,queue)
    val sword = SWORD("sword",10,3)
    knight.equip(sword)
    knight.waitTurn()

    val thief = Thief("thief",10,10,queue)
    val knife = KNIFE("knife",10,5)
    thief.equip(knife)
    thief.waitTurn()

    // Waits for 5 seconds to ensure that all characters have finished waiting
    Thread.sleep(5000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }
}