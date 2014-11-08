package com.example.kent.myapplication;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by swaroop_sa2004 on 11/8/14.
 */
public class ButtonService extends IntentService {

    private Context mContext;
    private SensorManager mSensorManager;
    private Sensor accelerometerSensor;

    public ButtonService() {
        super("ButtonService");
    }

    private final SensorEventListener myAccelerometerListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float bob = calculateVectorLength(event.values);
            if (bob < 5) {
                Intent i = new Intent(mContext, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        }


        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ButtonService(String name) {
        super(name);

    }

    public float calculateVectorLength(float[] axises) {
        return (float) Math.sqrt(axises[0] * axises[0] + axises[1] * axises[1] + axises[2] * axises[2]);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        mContext = this.getApplicationContext();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(myAccelerometerListener, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }
}
