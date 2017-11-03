package com.sh.designpattern.behavioral.command;

public class Client {

	public static void main(String[] args) {
		//创建播放机
		AudioPlayer audioPlayer = new AudioPlayer();
		
		//具体命令对象
		Command playCommand = new PlayCommand(audioPlayer);
		Command rewindCommand = new RewindCommand(audioPlayer);
		Command stopCommand = new StopCommand(audioPlayer);
		
		//调用者对象
		KeyPad keyPad = new KeyPad();
		keyPad.setPlayCommand(playCommand);
		keyPad.setRewindCommand(rewindCommand);
		keyPad.setStopCommand(stopCommand);
		
		keyPad.play();
        keyPad.rewind();
        keyPad.stop();
        keyPad.play();
        keyPad.stop();
	}
}
