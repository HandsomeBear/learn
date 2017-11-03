package com.sh.designpattern.behavioral.command;

//命令对象
public class StopCommand implements Command {

private AudioPlayer audioPlayer;
	
	public StopCommand(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}
	
	@Override
	public void execute() {
		audioPlayer.stop();
	}
	
}
