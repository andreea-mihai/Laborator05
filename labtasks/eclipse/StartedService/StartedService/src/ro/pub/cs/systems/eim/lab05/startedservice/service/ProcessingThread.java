package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class ProcessingThread extends Thread {
	
	Context context;
	
	public ProcessingThread(Context context){
		this.context = context;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendMessage(Constants.MESSAGE_STRING);
		sleep();
		sendMessage(Constants.MESSAGE_INTEGER);
        sleep();
        sendMessage(Constants.MESSAGE_ARRAY_LIST);
        sleep();
        Log.d(Constants.TAG, "Thread.run() was invoked, PID:" + android.os.Process.myPid() + " TID:" + android.os.Process.myTid());

	}
	
	public void sleep(){
		try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
	}
	
	public void sendMessage(int type){
		Intent i = new Intent();
		switch(type){
		case Constants.MESSAGE_STRING:
			i.setAction(Constants.ACTION_STRING);
			i.putExtra(Constants.DATA, Constants.STRING_DATA);
			break;
		case Constants.MESSAGE_INTEGER:
			i.setAction(Constants.ACTION_INTEGER);
			i.putExtra(Constants.DATA, Constants.INTEGER_DATA);
			break;
		case Constants.MESSAGE_ARRAY_LIST:
			i.setAction(Constants.ACTION_ARRAY_LIST);
			i.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
			break;
		}
		context.sendBroadcast(i);
		
	}

}
