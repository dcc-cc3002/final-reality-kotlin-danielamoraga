package cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.model.character.GameCharacter

/**
 * This represents an item from the game.
 * An item is something that can be equipped by a character.
 *
 * @property name
 *    The name of the item.
 * @property damage
 *    The damage caused by the item.
 * @property weight
 *    The weight of the item.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

interface Item {
    val name: String
    val damage: Int
    val weight: Int
}