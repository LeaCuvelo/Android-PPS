package com.example.android_pps;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Effects {
	
	private static final Effects INSTANCE = new Effects();
	 
	// Sound ID can't be 0 (zero)
	public static final int SOUND_1 = 1;
	 
	private Effects() {
	 
	}
	 
	public static Effects getInstance() {
	return INSTANCE;
	}
	 
	private SoundPool soundPool;
	private HashMap<Integer, Integer> soundPoolMap;
	int priority = 1;
	int no_loop = 0;
	private int volume;
	float normal_playback_rate = 1f;
	 
	private Context context;
	 
	public void init(Context context) {
	this.context = context;
	soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
	soundPoolMap = new HashMap<Integer, Integer>();
	soundPoolMap.put(SOUND_1, soundPool.load(context, R.raw.sound_1, 1)); 
	AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	volume = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
	}
	 
	public void playSound(int soundId) {
	soundPool.play(soundId, volume, volume, priority, no_loop, normal_playback_rate);
	}
}
