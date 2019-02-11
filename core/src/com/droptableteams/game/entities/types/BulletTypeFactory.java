package com.droptableteams.game.entities.types;

public class BulletTypeFactory {

    public static BulletType make(String type) {
        if("PlayerBullet" == type) {
            return makePlayerBullet();
        }
        else if("EnemyBulletA" == type) {
            return makeEnemyBulletA();
        }
        return makePlayerBullet();
    }

    private static BulletType makePlayerBullet() {
        float speed = 430;
        float width = 24;
        float height = 24;
        int damage = 0;
        String texture = "sprites/playerBullet.png";
        return new BulletType("BulletEntity", "PlayerBullet",speed, width, height, damage, texture);
    }

    private static BulletType makeEnemyBulletA() {
        float speed = 60;
        float width = 30;
        float height = 35;
        int damage = 0;
        String texture = "sprites/enemyBulletA.png";
        return new BulletType("BulletEntity", "EnemyBulletA",speed, width, height, damage, texture);
    }
}
