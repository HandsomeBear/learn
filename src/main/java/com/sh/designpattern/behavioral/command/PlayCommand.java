package com.sh.designpattern.behavioral.command;

//具体命令
public class PlayCommand implements Command {

	private AudioPlayer audioPlayer;
	
	public PlayCommand(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}
	
	@Override
	public void execute() {
		audioPlayer.play();
	}

}
