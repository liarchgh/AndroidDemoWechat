package com.neu.demoUtil;

import android.graphics.Bitmap;
import android.net.Uri;

public class OneSentence {
	public boolean isFromOther() {
		return fromOther;
	}
	public void setFromOther(boolean fromOther) {
		this.fromOther = fromOther;
	}
	private Bitmap otherIcon;
	private Bitmap myIcon;
	private String sentence;
	private boolean fromOther;

	public OneSentence() {
		super();
		otherIcon = null;
		myIcon = null;
		sentence = null;
		fromOther = false;
	}
	public OneSentence(Bitmap otherIcon, Bitmap myIcon, String sentence) {
		super();
		this.otherIcon = otherIcon;
		this.myIcon = myIcon;
		this.sentence = sentence;
	}
	public OneSentence(String sentence) {
		super();
		this.sentence = sentence;
	}
	public Bitmap getOtherIcon() {
		return otherIcon;
	}
	public void setOtherIcon(Bitmap otherIcon) {
		this.otherIcon = otherIcon;
	}
	public Bitmap getMyIcon() {
		return myIcon;
	}
	public void setMyIcon(Bitmap myIcon) {
		this.myIcon = myIcon;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
}
