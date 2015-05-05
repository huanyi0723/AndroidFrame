package com.lifeix.androidbasecoredemo.tasks;

import java.util.Random;

import com.lifeix.androidbasecore.command.SimpleResponse;
import com.lifeix.androidbasecore.command.TPError;
import com.lifeix.androidbasecore.command.TaskBase;
import com.lifeix.androidbasecore.command.TaskProcessListener;
import com.lifeix.androidbasecore.utils.logger.Logger;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TaskCounter<T extends SimpleResponse> extends TaskBase {

	private Random random = new Random(System.currentTimeMillis());
	private int limitUp = random.nextInt(10) + 100;
	int counter;

	public TaskCounter(TaskProcessListener<SimpleResponse> taskProcessListener) {
		super(taskProcessListener);
	}

	@Override
	public void execute() {
		System.out.println(String.format("index:%s|limitUp:%s", getIndex(),
				limitUp));
		while (counter <= limitUp && !isCanceled()) {
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
		if (isCanceled()) {
			Logger.i("task:%s has been canceled.", getId());
			return;
		}
		SimpleResponse simpleResponse = new SimpleResponse(String.format(
				"index:%s,limitUp:%s and count complete", getIndex(), limitUp));
		deliverResponse(simpleResponse);
	}

}
