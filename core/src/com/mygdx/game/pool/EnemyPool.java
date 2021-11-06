package com.mygdx.game.pool;

import com.mygdx.game.base.SpritesPool;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final BulletPool bulletPool;
    private final ExplosionPool explosionPool;
    private final Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(bulletPool, explosionPool, worldBounds);
    }
}
