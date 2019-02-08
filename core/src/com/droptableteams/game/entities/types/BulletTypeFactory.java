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
        return new BulletType(512,0,"sprites/playerBullet.png");
    }

    private static BulletType makeEnemyBulletA() {
        return new BulletType(200,0,"sprites/enemyBulletA.png");
    }
}
