package com.droptableteams.game.entities.types;

import com.droptableteams.game.factories.data.FirePatternData;
import com.droptableteams.game.util.constants.Directions;

public class EnemyTypeFactory {
    public static EnemyType make(String type) {
        if(type.equals("EnemyA")) {
            return makeEnemyA();
        }
        else if(type.equals("EnemyB")) {
            return makeEnemyB();
        }
        return makeEnemyA();
    }

    public static EnemyType makeEnemyA() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 2, (float)(Math.PI), (float)(Math.PI), 0.3f, "EnemyBulletA");
        return new EnemyType("EnemyEntity", "EnemyA",fpd, 52, 52, 128, true, false,"sprites/enemyA.png");
    }

    public static EnemyType makeEnemyB() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 2, (float)(Math.PI), (float)(-1*Math.PI), 0.3f, "EnemyBulletA");
        return new EnemyType("EnemyEntity", "EnemyB",fpd, 52, 52, 128, true, false,"sprites/enemyB.png");
    }
}
