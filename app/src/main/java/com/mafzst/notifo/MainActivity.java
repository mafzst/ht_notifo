package com.mafzst.notifo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Notification Manager service
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        /////////// CHANNELS BUILDING ///////////

        /*/***************************************
        Urgent notification channel: channel_urgent
           - Sound
           - Long vibration
           - Red flashlight
           - High priority
         ****************************************/
        // Channel ID
        final String urgent_id = "channel_urgent";
        // Channel friendly name (for user)
        CharSequence urgent_name = "Urgent notifications";
        // Channel description
        String urgent_description = "Urgent notifications like server crashes";
        // Channel importance
        int urgent_importance = NotificationManager.IMPORTANCE_HIGH;
        // Is flashlight enabled?
        boolean urgent_flashlight = true;
        // If so what color?
        int urgent_color = Color.RED;
        // Is vibration enabled?
        boolean urgent_vibration = true;
        // What pattern?
        long[] urgent_pattern = {100, 200, 300, 400, 500, 400, 300, 200, 400};

        // Create channel and configure it
        NotificationChannel urgent_channel = new NotificationChannel(urgent_id, urgent_name, urgent_importance);
        urgent_channel.setDescription(urgent_description);
        urgent_channel.enableLights(urgent_flashlight);
        urgent_channel.setLightColor(urgent_color);
        urgent_channel.enableVibration(urgent_vibration);
        urgent_channel.setVibrationPattern(urgent_pattern);
        // Add channel to notification manager
        notificationManager.createNotificationChannel(urgent_channel);

        /*/***************************************
        Normal notification channel: channel_normal
           - Sound
           - Normal vibration
           - Blue flashlight
           - Default priority
         ****************************************/
        // Channel ID
        final String normal_id = "channel_normal";
        // Channel friendly name (for user)
        CharSequence normal_name = "Normal notifications";
        // Channel description
        String normal_description = "Normal notifications like daily reports";
        // Channel importance
        int normal_importance = NotificationManager.IMPORTANCE_DEFAULT;
        // Is flashlight enabled?
        boolean normal_flashlight = true;
        // If so what color?
        int normal_color = Color.BLUE;
        // Is vibration enabled?
        boolean normal_vibration = true;
        // What pattern?
        long[] normal_pattern = {0, 200, 300};

        // Create channel and configure it
        NotificationChannel normal_channel = new NotificationChannel(normal_id, normal_name, normal_importance);
        normal_channel.setDescription(normal_description);
        normal_channel.enableLights(normal_flashlight);
        normal_channel.setLightColor(normal_color);
        normal_channel.enableVibration(normal_vibration);
        normal_channel.setVibrationPattern(normal_pattern);
        // Add channel to notification manager
        notificationManager.createNotificationChannel(normal_channel);

        /*/***************************************
        Not important notification channel: channel_not_important
           - No Sound
           - No vibration
           - No flashlight
           - Low priority
         ****************************************/
        // Channel ID
        final String not_important_id = "channel_not_important";
        // Channel friendly name (for user)
        CharSequence not_important_name = "Not important notifications";
        // Channel description
        String not_important_description = "Not important notifications like new SSH login";
        // Channel importance
        int not_important_importance = NotificationManager.IMPORTANCE_LOW;
        // Is flashlight enabled?
        boolean not_important_flashlight = false;
        // If so what color?
        int not_important_color = Color.BLUE;
        // Is vibration enabled?
        boolean not_important_vibration = false;
        // What pattern?
        long[] not_important_pattern = {0, 200, 300};

        // Create channel and configure it
        NotificationChannel not_important_channel = new NotificationChannel(not_important_id, not_important_name, not_important_importance);
        not_important_channel.setDescription(not_important_description);
        not_important_channel.enableLights(not_important_flashlight);
        not_important_channel.setLightColor(not_important_color);
        not_important_channel.enableVibration(not_important_vibration);
        not_important_channel.setVibrationPattern(not_important_pattern);
        // Add channel to notification manager
        notificationManager.createNotificationChannel(not_important_channel);

        /////////// GROUPS BUILDING ///////////

        String group_1_id = "group_1";
        CharSequence group_1_name = "Server 1";
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(group_1_id, group_1_name));

        String group_2_id = "group_1";
        CharSequence group_2_name = "Server 2";
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(group_2_id, group_2_name));

        /////////// NOTIFICATIONS BUILDING ///////////

        final Notification notif_urgent_1 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[1] Urgent!")
                .setContentText("Your server crashed!")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(urgent_id)
                .setGroup(group_1_id)
                .setColorized(true)
                .setColor(0xFF7F0000)
                .build();

        final Notification notif_normal_1 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[1] Normal")
                .setContentText("Your daily log analysis")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(normal_id)
                .setGroup(group_1_id)
                .setColorized(true)
                .setColor(0xFF00007F)
                .build();

        final Notification notif_not_important_1 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[1] Not important")
                .setContentText("New SSH connection from 192.168.0.145")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(not_important_id)
                .setGroup(group_1_id)
                .setColorized(true)
                .build();

        final Notification notif_urgent_2 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[2] Urgent!")
                .setContentText("Your server crashed!")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(urgent_id)
                .setGroup(group_2_id)
                .setColorized(true)
                .setColor(0xFF7F0000)
                .build();

        final Notification notif_normal_2 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[2] Normal")
                .setContentText("Your daily log analysis")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(normal_id)
                .setGroup(group_2_id)
                .setColorized(true)
                .setColor(0xFF00007F)
                .build();

        final Notification notif_not_important_2 = new Notification.Builder(MainActivity.this)
                .setContentTitle("[2] Not important")
                .setContentText("New SSH connection from 192.168.0.145")
                .setSmallIcon(R.drawable.ic_notif)
                .setChannel(not_important_id)
                .setGroup(group_2_id)
                .setColorized(true)
                .build();


        /////////// BUTTONS LISTENERS ///////////

        Button btn_urgent_1 = findViewById(R.id.btn_urgent_1);
        btn_urgent_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(1, notif_urgent_1);
            }
        });
        Button btn_normal_1 = findViewById(R.id.btn_normal_1);
        btn_normal_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(2, notif_normal_1);
            }
        });
        Button btn_not_important_1 = findViewById(R.id.btn_not_important_1);
        btn_not_important_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(3, notif_not_important_1);
            }
        });

        Button btn_urgent_2 = findViewById(R.id.btn_urgent_2);
        btn_urgent_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(4, notif_urgent_2);
            }
        });
        Button btn_normal_2 = findViewById(R.id.btn_normal_2);
        btn_normal_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(5, notif_normal_2);
            }
        });
        Button btn_not_important_2 = findViewById(R.id.btn_not_important_2);
        btn_not_important_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationManager.notify(6, notif_not_important_2);
            }
        });
    }
}
