package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor
    public StartedServiceBroadcastReceiver() {
        this.messageTextView = null;
    }


    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView
    	String action = intent.getAction();
    	String info = null;
    	if (Constants.ACTION_STRING.equals(action))
    		info = intent.getStringExtra(Constants.DATA);
    	else if (Constants.ACTION_INTEGER.equals(action))
    		info = String.valueOf(intent.getIntExtra(Constants.DATA, -1));
    	else if (Constants.ACTION_ARRAY_LIST.equals(action))
		info = intent.getStringArrayExtra(Constants.DATA).toString();
    	
    	if (messageTextView != null) {
    	      messageTextView.setText(messageTextView.getText().toString() + "\n" + info);
    	      Log.d("BUM","Heeeeere");
    	    }

        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
    }

}
