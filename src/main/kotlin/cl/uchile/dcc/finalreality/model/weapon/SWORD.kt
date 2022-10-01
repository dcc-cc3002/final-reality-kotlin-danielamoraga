package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * An `SWORD` is a type of [Item] (Weapon)
 *
 * @param name        the SWORD's name
 * @param damage      the SWORD's damage
 * @param weight      the SWORD's weight
 * @constructor Creates a new SWORD.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Daniela Moraga
 */

class SWORD (
    name: String,
    damage: Int,
    weight: Int
) : Weapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is SWORD -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(SWORD::class, name, damage, weight)

    override fun toString() = "SWORD { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"
}