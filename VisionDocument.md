#Projectile Inferno Vision Document

## Overview
    Projectile Inferno is a bullet-hell type game, where the player will control a small space ship.
    It will support several difficulty levels, with the choice affecting number of enemies,
    speed of bullets, firing patterns, and more.  The main menu will also have entries to display
    the credits, high scores, level selection, and possibly more.

## Levels
    Each level will be scripted within a separate file, which will be read by the game at runtime.  The script will include what enemies to spawn, when to spawn them, where to spawn them, and what movement patterns and bullet patterns they will use. Players must avoid all enemy bullets or die, but they can pick up power ups that may
    include shields, weapon power increases, extra lives, and special weapon ammo (such as bombs that
    may clear bullets from the screen and do large damage to any enemies). Upon player death, all bullets (but not all enemies) will be cleared from the screen, and the player will respawn if they have lives remaining.

## Boses
    The game will support a slow-motion toggle that reduces the speed of the player for easier dodging. Power ups can either drop from specified killed enemies, from random enemies,  or spawn at specific times in a level.  Each type of enemy will have a certain amount of HP, and  the player must shoot it until this is depleted to kill it.  If any enemy, except the final boss,  is not killed in time, it will leave the screen and be despawned.  When this occurs, the player will get no score for that enemy, and any power up it may have dropped will be lost.

## Scoring and Cheats
    Upon the end of a level, the player will be shown their score, and if it is high enough to make the high score
    list for that level, they will be prompted to enter their name. Finally, the game will have a suite
    of cheat codes to make testing easier.  These may include commands to spawn power ups, make the player
    invulnerable, and give infinite special ammo. If time allows, stretch goals include saving replays, and
    implementing customizable controls for the player. In addition to game functionality, the game will have
    sound effects and music for enemy firing, player firing, bullets hitting player and
    enemies, etc. These features will also depend on the time of the other parts of the project.