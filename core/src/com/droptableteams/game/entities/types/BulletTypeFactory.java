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
        float width = 25;
        float height = 25;
        int damage = 0;
        String texture = "sprites/playerBullet.png";
        return new BulletType(speed, width, height, damage, texture);
    }

    private static BulletType makeEnemyBulletA() {
        float speed = 180;
        float width = 30;
        float height = 35;
        int damage = 0;
        String texture = "sprites/enemyBulletA.png";
        return new BulletType(speed, width, height, damage, texture);
    }
}
