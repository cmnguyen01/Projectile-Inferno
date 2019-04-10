package com.droptableteams.game.util.types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;

@Deprecated
public class BulletTypeFactory {

    private static void makeBullet() {
        float speed = 430;
        float width = 10;
        float height = 24;
        int damage = 10;
        String texture = "sprites/playerBullet.png";
        BulletType bb = new BulletType("BulletEntity", "PlayerBullet",speed, width, height, damage, texture);
        Json json = new Json();
        json.toJson(bb, Gdx.files.local("scripts/enemies/PlayerBullet.json"));
    }
}
