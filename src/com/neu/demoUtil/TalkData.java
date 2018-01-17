package com.neu.demoUtil;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.net.Uri;

public class TalkData implements Serializable{
	private long userId;
	private long time;
	private Bitmap iconUri;
	private int state;
	private String userName;
	private String lastMessage;
	private int messageNum;
	
	public TalkData(long userId, long time, Bitmap iconUri, int state, String userName, String lastMessage,
			int messageNum) {
		super();
		this.userId = userId;
		this.time = time;
		this.iconUri = iconUri;
		this.state = state;
		this.userName = userName;
		this.lastMessage = lastMessage;
		this.messageNum = messageNum;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Bitmap getIconUri() {
		return iconUri;
	}
	public void setIconUri(Bitmap iconUri) {
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
