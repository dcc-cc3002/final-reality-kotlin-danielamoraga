Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of
enemies controlled by the computer.

---

How it works
------------

There are six characters in total, but only five of them
are playable, you can't play with enemies.
You can choose between engineer, knight, thief, and mages (black mage or white mage).
Each character will have a name (String type), a max Hp (Int type) (therefore a current Hp, also
Int type), defense, and the turns queue (which is a BlockingQueue). Something special about mages
is that only they have magic, represented on its Mp, which are mana points (Int type).
To create a character, use the syntax: CharacterType(name, maxHp, defense, turnsQueue), or, if it's
a mage: MageType(name, maxHp, maxMp, defense, queue).

There also are six weapons: axe, bow, knife, staff and sword; each one of them has their own name (String type), damage (Int type)
and weight (Int type). To create a weapon, use the syntax: WeaponType(name, damage, weight).

To use a player character you'll have to create it and then you'll
be able to apply methods on them, for example, equip a weapon, which you'll also have to create first. There are some restrictions
to equip different weapons to different types of characters: axes can only be equipped to knights
and engineers, bows can only be equipped to engineers and thieves, knifes can only be
equipped to knights, thieves and black mages, staffs can only be equipped to mages, and 
swords can only be equipped to knights and thieves. If you try to equip a weapon that cannot be
equipped to some specific character, it just won't be equipped. To equip a weapon use the syntax:
character.equip(weapon).

Another method you can use is wait turn; where after an amount of time they'll be ordered by weight
in the turns queue. Enemies have its own weight, but player characters have to have an equipped weapon
in order to be in the turns queue and use the wait turn method. This method can be used with the syntax
character.waitTurn().