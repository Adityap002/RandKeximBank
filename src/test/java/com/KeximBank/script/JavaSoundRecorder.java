package com.KeximBank.script;

import javax.sound.sampled.*;
import javax.sound.sampled.AudioFormat.Encoding;

import java.io.*;

/**
 * A sample program is to demonstrate how to record sound in Java author:
 * www.codejava.net
 */
public class JavaSoundRecorder {
	// record duration, in milliseconds
	static final long RECORD_TIME = 10000; // 1 minute

	// path of the wav file
	File wavFile = new File("G:\\KeximBank\\KeximBank\\test-outputRecordAudio.wav");

	// format of audio file
	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

	// the line from which audio data is captured
	TargetDataLine line;

	/**
	 * Defines an audio format
	 */
	AudioFormat getAudioFormat() {
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 2;
		//boolean signed = true;
		boolean bigEndian = true;
		int frameSize = 40000;
		float frameRate = 1000.0f;
		AudioFormat format = new AudioFormat(Encoding.ULAW, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
		return format;
	}

	/**
	 * Captures the sound and record into a WAV file
	 */
	void start() {
		try {
			AudioFormat format = getAudioFormat();
			SourceDataLine.Info info = new SourceDataLine.Info(TargetDataLine.class, format);
			System.out.println(info);
			

			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start(); // start capturing

			System.out.println("Start capturing...");

			AudioInputStream ais = new AudioInputStream(line);

			System.out.println("Start recording...");

			// start recording
			AudioSystem.write(ais, fileType, wavFile);

		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Closes the target data line to finish capturing and recording
	 */
	void finish() {
		line.stop();
		line.close();
		System.out.println("Finished");
	}

	public static void main(String[] args) {
		final JavaSoundRecorder recorder = new JavaSoundRecorder();

		// creates a new thread that waits for a specified
		// of time before stopping
		Thread stopper = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(RECORD_TIME);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				recorder.finish();
			}
		});

		stopper.start();

		// start recording
		recorder.start();
	}

}
