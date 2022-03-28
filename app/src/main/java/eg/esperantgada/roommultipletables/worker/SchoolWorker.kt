package eg.esperantgada.roommultipletables.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import eg.esperantgada.roommultipletables.notification.Notification

/**
 * The [doWork] method needs two parameters : the notification [title] and [message]
 */
class SchoolWorker(private val context: Context, parameters: WorkerParameters) : Worker(context, parameters){
    override fun doWork(): Result {
        Notification(context).onCreateNotification(
            inputData.getString("title").toString(),
            inputData.getString("message").toString()
        )
        return Result.success()
    }
}