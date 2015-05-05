package com.lifeix.androidbasecore.command;

import java.util.Random;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TaskCounter<T extends SimpleResponse> extends TaskBase {

	private Random random = new Random(System.currentTimeMillis());
	private int limitUp = random.nextInt(10) + 10;
	int counter;

	public TaskCounter(TaskProcessListener<SimpleResponse> taskProcessListener) {
		super(taskProcessListener);
	}

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void execute() {
		System.out.println(String.format("index:%s|limitUp:%s", getIndex(),
				limitUp));
		while (counter <= limitUp) {
			System.out.println(getIndex() + "----" + counter);
			counter++;
			try {
				Thread.sleep(500l);
			} catch (InterruptedException e) {
				e.printStackTrace();
				TPError tpError = new TPError();
				deliverError(tpError);
				return;
			}
		}
		SimpleResponse simpleResponse = new SimpleResponse(String.format(
				"index:%s,limitUp:%s and count complete", getIndex(), limitUp));
		deliverResponse(simpleResponse);
	}

}
