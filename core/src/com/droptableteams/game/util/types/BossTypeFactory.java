package com.droptableteams.game.util.types;

import com.droptableteams.game.util.data.FirePatternData;
import com.droptableteams.game.util.constants.Directions;

public class BossTypeFactory {
    public static BossType make(String type)
    {
        if("MidBoss".equals(type))
        {
        return makeMidBoss();
        }
        else if("FinalBoss".equals(type)) {
            return makeFinalBoss();
        }
        return makeMidBoss();
    }

    public static BossType makeMidBoss() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 7, (float)(3.0), (float)(Math.PI), 0.4f, "PlayerBullet");
        return new BossType("EnemyEntity", "EnemyA",fpd, 52, 52, 128, 100, true, false,"sprites/bossA.png");
    }

    public static BossType makeFinalBoss() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 6, (float)(Math.PI), (float)(Math.PI), 0.4f, "EnemyBulletA");
        return new BossType("EnemyEntity", "EnemyB",fpd, 52, 52, 128, 100, true, false,"sprites/bossB.png");
    }

}
