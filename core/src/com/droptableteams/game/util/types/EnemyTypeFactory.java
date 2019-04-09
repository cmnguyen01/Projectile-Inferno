package com.droptableteams.game.util.types;

import com.droptableteams.game.util.data.FirePatternData;
import com.droptableteams.game.util.constants.Directions;

public class EnemyTypeFactory {
    public static EnemyType make(String type) {
        if("EnemyA".equals(type)) {
            return makeEnemyA();
        }
        else if("EnemyB".equals(type)) {
            return makeEnemyB();
        }
        return makeEnemyA();
    }

    public static EnemyType makeEnemyA() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 7, (float)(3.0), (float)(Math.PI), 0.4f, "PlayerBullet");
        return new EnemyType("EnemyEntity", "EnemyA",fpd, 52, 52, 128, 100, true, false,"sprites/enemyA.png");
    }

    public static EnemyType makeEnemyB() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 2, (float)(Math.PI), (float)(Math.PI), 0.4f, "EnemyBulletA");
        return new EnemyType("EnemyEntity", "EnemyB",fpd, 52, 52, 128, 100, true, false,"sprites/enemyB.png");
    }
}
