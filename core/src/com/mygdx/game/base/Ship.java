package com.mygdx.game.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.math.Rect;
import com.mygdx.game.pool.BulletPool;
import com.mygdx.game.pool.ExplosionPool;
import com.mygdx.game.sprite.Bullet;
import com.mygdx.game.sprite.Explosion;

import java.util.logging.Logger;

public class Ship extends Sprite {

    private static final float DAMAGE_ANIMATE_INTERVAL = 0.1f;

    protected ExplosionPool explosionPool;
    protected BulletPool bulletPool;
    protected Sound bulletSound;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected Vector2 bulletPos;
    protected float bulletHeight;
    protected int damage;
    protected int hp;

    protected Vector2 v;
    protected Vector2 v0;
    protected Vector2 speed;

    protected float reloadTimer;
    protected float reloadInterval;
    protected Rect worldBounds;

    private float damageAnimateTimer = DAMAGE_ANIMATE_INTERVAL;

    public Ship() {
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            bulletPos.set(pos);
            shoot();
        }
        damageAnimateTimer += delta;
        if (damageAnimateTimer >= DAMAGE_ANIMATE_INTERVAL) {
            frame = 0;
        }
    }

    public void damage(int hp) {
        this.hp -= hp;
        if (this.hp <= 0) {
            this.hp = 0;
            destroy();
            System.out.println("delete in class Ship");
        }
        damageAnimateTimer = 0f;
        frame = 1;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletV, worldBounds, bulletHeight, damage);
        //bulletSound.play();
    }

    private void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(this.pos, getHeight());
    }

}
