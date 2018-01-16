package com.neu.demoUtil;

import android.graphics.Bitmap;
import android.net.Uri;

public class TalkData {
	private int userId;
	private long time;
	private Uri iconUri;
	private int state;
	private String userName;
	private String lastMessage;
	private int messageNum;
	
	public TalkData(Uri iconUri, String userName,  String lastMessage, int messageNum, long time) {
		this.iconUri = iconUri;
		this.userName = userName;
		this.lastMessage = lastMessage;
		this.messageNum = messageNum;
		this.time = time;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Uri getIconUri() {
		return iconUri;
	}
	public void setIconUri(Uri iconUri) {
		this.iconUri = iconUri;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
}
