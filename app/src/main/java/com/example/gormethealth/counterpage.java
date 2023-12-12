package com.example.gormethealth;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gormethealth.databinding.ActivityCounterpageBinding;

import java.util.Locale;

public class counterpage extends AppCompatActivity implements SensorEventListener  {

    private TextView stepCountTextView;
    private TextView distanceTextView;
    private TextView timeTextView;
    private Button pauseButton;
    private SensorManager sensorManger;
    private Sensor stepCounterSensor;
    private int stepCount = 0;

    private ProgressBar progressBar;
    private boolean isPause = false;
    private long timePause = 0;
    private float stepLengthInMeters = 0.762f;
    private long startTime;
    private int steoCountTagget = 2000;
    private TextView stepCountTargetTextView;
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long milis = System.currentTimeMillis() - startTime;
            int seconds=(int)(milis/1000);
            int min = seconds/60;
            seconds = seconds % 60;
            timeTextView.setText(String.format(Locale.getDefault(), "Time: %02d:%02d",min,seconds));
            timerHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onStop(){
        super.onStop();

        if(stepCounterSensor != null) {
            sensorManger.unregisterListener( this);
            timerHandler.removeCallbacks(timerRunnable);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();

        if(stepCounterSensor != null) {
            sensorManger.registerListener(this, stepCounterSensor, sensorManger.SENSOR_DELAY_NORMAL);

            timerHandler.postDelayed(timerRunnable, 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counterpage);

        stepCountTextView = findViewById(R.id.stepCountTextView);
        distanceTextView = findViewById(R.id.distanceTextView);
        timeTextView = findViewById(R.id.timeTextView);
        pauseButton = findViewById(R.id.pausebutton);
        stepCountTargetTextView = findViewById(R.id.stepCountTargetTextView);
        progressBar = findViewById(R.id.progressbar);

        startTime = System.currentTimeMillis();

        sensorManger = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        stepCounterSensor =sensorManger.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        progressBar.setMax(steoCountTagget);

        stepCountTextView.setText("Step Goal:" + steoCountTagget);

        if (stepCounterSensor == null){

            stepCountTextView.setText("Step counter not available");
        }




    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        SensorEvent sensorEvent = null;
        if (sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {

            stepCount = (int) sensorEvent.values[0];
            stepCountTextView.setText("Step Count " + stepCount);
            progressBar.setProgress(stepCount);

            if (stepCount>= steoCountTagget){
                stepCountTextView.setText("Daily Step Goal Achieved");
            }

            float distanceInKm = stepCount * stepLengthInMeters / 1000;
            distanceTextView.setText(String.format(Locale.getDefault(), "Distance:%.2f km", distanceInKm));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onPauseButtonclicked(View view){
        if (isPause) {

            isPause = false;
            pauseButton.setText("Pause");
            startTime= System.currentTimeMillis()-timePause;
            timerHandler.postDelayed(timerRunnable, 0);
        }else{

            isPause = true;
            pauseButton.setText("Resume");

            timerHandler.removeCallbacks(timerRunnable);
            timePause = System.currentTimeMillis()-startTime;
        }
    }
}