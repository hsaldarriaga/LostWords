package com.movil.pixelcode.lostwords.Views.Animations;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import com.movil.pixelcode.lostwords.R;

import java.util.Random;

/**
 * Created by hass-pc on 02/05/2015.
 */
public class StartGameAnimation extends View implements Runnable{

    public static final float Rate = 1f/30f * 1000f;
    private Bitmap Globe_red, Globe_blue;
    private Bitmap cloud1, cloud2, cloud3;
    private Bitmap BackG;
    private Thread thread;
    private boolean Running = false;
    private int Width, Height;
    private float BackGPosY, c1x, c1y, c2x, c2y, c3x, c3y, grx, gry, gbx, gby; // Positions
    private float VelBackGPosy, Velc1x, Velc2x, Velc3x, Velgrx, Velgbx; //Velocity
    private int SmallCloudWidth, SmallCloudHeight, LargeCloudWidth, LargeCloudHeight, GlobeWidth, GlobeHeight;
    private int BackgroundColor;
    private long time;

    public StartGameAnimation(Context context) {
        super(context);
        Instance(context);
    }

    public StartGameAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        Instance(context);
    }

    private void Instance(Context c) {
        BitmapDrawable bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.pre_globe1);
        if (bd != null)
        Globe_red = bd.getBitmap();
        bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.pre_globe2);
        if (bd != null)
        Globe_blue = bd.getBitmap();
        bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.pre_cloud1);
        if (bd != null)
        cloud1 = bd.getBitmap();
        bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.pre_cloud2);
        if (bd != null)
        cloud2 = bd.getBitmap();
        bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.pre_cloud3);
        if (bd != null)
        cloud3 = bd.getBitmap();
        bd = (BitmapDrawable)c.getResources().getDrawable(R.drawable.bg_startgame);
        if (bd!= null)
        BackG = bd.getBitmap();
        SmallCloudWidth = 226; SmallCloudHeight = 83;
        LargeCloudWidth = 311; LargeCloudHeight = 83;
        GlobeWidth = 323; GlobeHeight = 458;
        Display display = ((Activity)c).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Width = size.x;
        Height = size.y;
        BackgroundColor = c.getResources().getColor(R.color.blue_bg);
        Resize();
        Initialize();
        Running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void Resize() {
        //Calculate Relation Aspect
        float SmallCloudRelation = SmallCloudHeight / (float)SmallCloudWidth;
        float LargeCloudRelation = LargeCloudHeight / (float)LargeCloudWidth;
        float GlobeRelation = GlobeHeight / (float)GlobeWidth;
        SmallCloudWidth = Width / 5; // 0.2%
        LargeCloudWidth = Width * 7 / 25; // 0.28 %
        GlobeWidth = Width * 7 / 20; // 0.35%
        //Keep Relation Aspect
        SmallCloudHeight = 2*(int)(SmallCloudWidth * SmallCloudRelation);
        LargeCloudHeight = 2*(int)(LargeCloudWidth * LargeCloudRelation);
        GlobeHeight = (int)(GlobeWidth * GlobeRelation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            cloud1.setWidth(SmallCloudWidth);
            cloud1.setHeight(SmallCloudHeight);
            cloud2.setWidth(SmallCloudWidth);
            cloud2.setHeight(SmallCloudHeight);
            cloud3.setWidth(LargeCloudWidth);
            cloud3.setHeight(LargeCloudHeight);
            Globe_blue.setWidth(GlobeWidth);
            Globe_blue.setHeight(GlobeHeight);
            Globe_red.setWidth(GlobeWidth);
            Globe_red.setHeight(GlobeHeight);
            BackG.setWidth(Width);
            BackG.setHeight(Height);
        } else {
            cloud1 = Bitmap.createScaledBitmap(cloud1, SmallCloudWidth, SmallCloudHeight, true);
            cloud2 = Bitmap.createScaledBitmap(cloud2, SmallCloudWidth, SmallCloudHeight, true);
            cloud3 = Bitmap.createScaledBitmap(cloud3, LargeCloudWidth, LargeCloudHeight, true);
            Globe_blue = Bitmap.createScaledBitmap(Globe_blue, GlobeWidth, GlobeHeight, true);
            Globe_red = Bitmap.createScaledBitmap(Globe_red, GlobeWidth, GlobeHeight, true);
            BackG = Bitmap.createScaledBitmap(BackG, Width, Height, true);
        }
    }

    private void Initialize(){
        int middleH = Height / 2;
        BackGPosY = Height / 2;
        Random Rand = new Random();
        if ((1 + Rand.nextInt(1) % 2 == 0)) {
            c1x = - SmallCloudWidth; c2x = Width; c3x = -LargeCloudWidth;
            Velc1x = Rand.nextFloat()*2; Velc2x = -(Rand.nextFloat()*2); Velc3x = Rand.nextFloat()*2;
        } else {
            c1x = Width; c2x = - SmallCloudWidth; c3x = Width;
            Velc1x = -(Rand.nextFloat()*2); Velc2x = Rand.nextFloat()*2 ; Velc3x = -(Rand.nextFloat()*2);
        }
        if ((1 + Rand.nextInt(1) % 2 == 0)) {
            grx = -GlobeWidth; gbx = Width;
            Velgbx = 1+ Rand.nextFloat()*3; Velgrx = -( 1+Rand.nextFloat()*3);
        } else {
            grx = Width; gbx = -GlobeWidth;
            Velgbx = -(1+Rand.nextFloat()*3); Velgrx = 1+Rand.nextFloat()*3;
        }
        gry = Rand.nextInt(Height / 2 - GlobeHeight);
        gby = Rand.nextInt(Height / 2 - GlobeHeight);
        c1y = Rand.nextInt(middleH / 3);
        c2y = middleH / 3 + Rand.nextInt(middleH/3);
        c3y = middleH  * 2 / 3 + Rand.nextInt(middleH / 3);
        VelBackGPosy = -10f;
    }

    private void Draw(Canvas canvas) {
        if (canvas!=null) {
            c1x += Velc1x;
            c2x += Velc2x;
            c3x += Velc3x;
            gbx += Velgbx;
            grx += Velgrx;
            BackGPosY += VelBackGPosy;
            if (c1x > Width)
                Velc1x = -Math.abs(Velc1x);
            else if (c1x < -SmallCloudWidth)
                Velc1x = Math.abs(Velc1x);
            if (c2x > Width)
                Velc2x = -Math.abs(Velc2x);
            else if (c2x < -SmallCloudWidth)
                Velc2x = Math.abs(Velc2x);
            if (c3x > Width)
                Velc3x = -Math.abs(Velc3x);
            else if (c3x < -LargeCloudWidth)
                Velc3x = Math.abs(Velc3x);
            if (gbx > Width)
                Velgbx = -Math.abs(Velgbx);
            if (gbx < -GlobeWidth)
                Velgbx = Math.abs(Velgbx);
            if (grx > Width)
                Velgrx = -Math.abs(Velgrx);
            if (grx < -GlobeWidth)
                Velgrx = Math.abs(Velgrx);
            if (BackGPosY - VelBackGPosy > 0)
                BackGPosY += VelBackGPosy;
            else
                BackGPosY = 0;
            canvas.drawColor(BackgroundColor);
            canvas.drawBitmap(BackG, 0, BackGPosY, null);
            canvas.drawBitmap(Globe_blue, gbx, gby, null);
            canvas.drawBitmap(Globe_red, grx, gry, null);
            canvas.drawBitmap(cloud1, c1x, c1y, null);
            canvas.drawBitmap(cloud2, c2x, c2y, null);
            canvas.drawBitmap(cloud3, c3x, c3y, null);
        }
    }

    @Override
    public void run() {
        while(Running) {
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long t = System.currentTimeMillis() - time;
            if (t < Rate) {
                long milli = (long) ((Rate - t));
                postInvalidateDelayed(milli);
            } else {
                postInvalidate();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        time = System.currentTimeMillis();
        Draw(canvas);
        synchronized (thread) {
            thread.notify();
        }
    }

    public void OnDestroy() {
        Running = false;
    }
}
