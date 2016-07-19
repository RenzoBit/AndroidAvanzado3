package pe.edu.tecsup.androidavanzado3;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Alumno on 02/07/2016.
 */
public class GCMIntentService extends GcmListenerService {

    public GCMIntentService() {
    }

    @Override
    public void onMessageReceived(String from, Bundle data) {
        String texto = data.getString("message");
        sendNotification(texto);
    }

    @Override
    public void onDeletedMessages() {
        sendNotification("Deleted messages on server");
    }

    @Override
    public void onMessageSent(String msgId) {
        sendNotification("Upstream message sent. Id=" + msgId);
    }

    @Override
    public void onSendError(String msgId, String error) {
        sendNotification("Upstream message send error. Id=" + msgId + ", error" + error);
    }

    // Put the message into a notification and post it.
    // This is just one simple example of what you might choose to do with
    // a GCM message.
    private void sendNotification(String msg) {
        //logger.log(Log.INFO, msg);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("Curso Android").setContentText(msg);
        Intent notIntent = new Intent(this, GCMTestActivity.class);
        PendingIntent contIntent = PendingIntent.getActivity(this, 0, notIntent, 0);
        mBuilder.setContentIntent(contIntent);
        mNotificationManager.notify(1, mBuilder.build());

    }


}
