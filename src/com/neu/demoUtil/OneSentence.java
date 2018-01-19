package com.neu.demoUtil;

import java.io.Serializable;

import android.net.Uri;

public class OneSentence implements Serializable{
	private byte[] otherIcon;
	private byte[] myIcon;
	private String sentence;
	private boolean fromOther;

	public boolean isFromOther() {
		return fromOther;
	}

	public void setFromOther(boolean fromOther) {
		this.fromOther = fromOther;
	}

	public OneSentence() {
		super();
		otherIcon = null;
		myIcon = null;
		sentence = null;
		fromOther = false;
	}
	public OneSentence(byte[] otherIcon, byte[] myIcon, String sentence) {
		super();
		this.otherIcon = otherIcon;
		this.myIcon = myIcon;
		this.sentence = sentence;
	}
	public OneSentence(String sentence) {
		super();
		this.sentence = sentence;
	}
	public byte[] getOtherIcon() {
		return otherIcon;
	}
	public void setOtherIcon(byte[] otherIcon) {
		this.otherIcon = otherIcon;
	}
	public byte[] getMyIcon() {
		return myIcon;
	}
	public void setMyIcon(byte[] myIcon) {
		this.myIcon = myIcon;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
}
