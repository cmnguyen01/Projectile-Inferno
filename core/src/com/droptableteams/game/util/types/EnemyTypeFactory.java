package com.droptableteams.game.util.types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.droptableteams.game.util.Spawnable;
import com.droptableteams.game.util.data.FirePatternData;
import com.droptableteams.game.util.constants.Directions;

import java.util.ArrayList;
//DEPRECATED
public class EnemyTypeFactory {

    public static void makeEnemy() {
        FirePatternData fpd = new FirePatternData(Directions.DOWN, 7, (float)(3.0), (float)(Math.PI), 0.4f, "PlayerBullet");
        EnemyType enemyA = new EnemyType("EnemyEntity", "EnemyA",fpd, 52, 52, 128, 100, true, false,"sprites/enemyA.png");
        Json json = new Json();
        json.toJson(enemyA, Gdx.files.local("scripts/enemies/enemyA.json"));
    }
}
