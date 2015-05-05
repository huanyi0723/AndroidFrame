package com.lifeix.androidbasecore.command;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TaskManager taskManager = TaskManager.getInstance();
		taskManager.start();
		taskManager.add(new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {

					@Override
					public void onPrepare() {

					}

					@Override
					public void onSuccess(SimpleResponse response) {
						System.out.println(response);
					}

					@Override
					public void onFail(TPError error) {
						System.out.println(error);
					}
				}));
		taskManager.add(new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {
					@Override
					public void onPrepare() {

					}

					@Override
					public void onSuccess(SimpleResponse response) {
						System.out.println(response);
					}

					@Override
					public void onFail(TPError error) {
						System.out.println(error);
					}
				}));
		taskManager.add(new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {
					@Override
					public void onPrepare() {

					}

					@Override
					public void onSuccess(SimpleResponse response) {
						System.out.println(response);
					}

					@Override
					public void onFail(TPError error) {
						System.out.println(error);
					}
				}));
		taskManager.add(new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {
					@Override
					public void onPrepare() {

					}

					@Override
					public void onSuccess(SimpleResponse response) {
						System.out.println(response);
					}

					@Override
					public void onFail(TPError error) {
						System.out.println(error);
					}
				}));
		taskManager.add(new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {
					@Override
					public void onPrepare() {

					}

					@Override
					public void onSuccess(SimpleResponse response) {
						System.out.println(response);
					}

					@Override
					public void onFail(TPError error) {
						System.out.println(error);
					}
				}));
		try {
			// taskManager.stop();
		} catch (Exception e) {

		}
	}
}
