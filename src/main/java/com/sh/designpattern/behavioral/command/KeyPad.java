package com.sh.designpattern.behavioral.command;

//Invoker--具体调用命令的对象
public class KeyPad {

	private Command playCommand;
	private Command rewindCommand;
	private Command stopCommand;
	
	public void setPlayCommand(Command playCommand) {
		this.playCommand = playCommand;
	}
	
	public void setRewindCommand(Command rewindCommand) {
		this.rewindCommand = rewindCommand;
	}
	
	public void setStopCommand(Command stopCommand) {
		this.stopCommand = stopCommand;
	}
	
	public void play() {
		playCommand.execute();
	}
	
	public void rewind() {
		rewindCommand.execute();
	}
	
	public void stop() {
		stopCommand.execute();
	}
}
