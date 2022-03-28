package eg.esperantgada.roommultipletables.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import eg.esperantgada.roommultipletables.MainActivity
import eg.esperantgada.roommultipletables.R
import eg.esperantgada.roommultipletables.SecondActivity
import eg.esperantgada.roommultipletables.utils.Constants.Companion.BIG_TEXT
import eg.esperantgada.roommultipletables.utils.Constants.Companion.CHANNEL_ID
import eg.esperantgada.roommultipletables.utils.Constants.Companion.DESCRIPTION_TEXT
import eg.esperantgada.roommultipletables.utils.Constants.Companion.NAME
import eg.esperantgada.roommultipletables.utils.Constants.Companion.NOTIFICATION_ID

class Notification(private val context: Context) {

    //Create the notification after the channel is created

    fun onCreateNotification(title : String, message : String){
        onCreateNotificationChannel()

        val intent = Intent(context, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val icon = BitmapFactory.decodeResource(context.resources, R.drawable.school_image)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_student)
            .setLargeIcon(icon)
            .setContentTitle(title)
            .setContentText(message)
            .setStyle(NotificationCompat.BigPictureStyle().bigLargeIcon(icon))
            .setStyle(NotificationCompat.BigTextStyle().bigText(BIG_TEXT))
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
    }


    //Create notification channel that will help the device to recognize the unique channel of this
    //notification and distinguish it from other notifications
    @SuppressLint("NewApi")
    private fun onCreateNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, NAME, importance).apply {
                description = DESCRIPTION_TEXT
            }

            val notificationManager : NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }
    }
}