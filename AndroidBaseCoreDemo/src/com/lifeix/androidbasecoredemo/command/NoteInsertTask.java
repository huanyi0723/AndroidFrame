package com.lifeix.androidbasecoredemo.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.SimpleResponse;
import com.lifeix.androidbasecore.command.TPError;
import com.lifeix.androidbasecore.command.TaskBase;
import com.lifeix.androidbasecore.command.TaskProcessListener;
import com.lifeix.androidbasecoredemo.utils.DBUtils;

import de.greenrobot.db.Note;
import de.greenrobot.db.NoteDao;

public class NoteInsertTask extends TaskBase<Response> {

	public NoteInsertTask(TaskProcessListener<Response> taskProcessListener) {
		super(taskProcessListener);
	}

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void execute() {
		try {
			NoteDao noteDao = DBUtils.getDaoSessionWritable().getNoteDao();
			noteDao.deleteAll();
			List<Note> notes = new ArrayList<Note>();
			for (int i = 0; i < 1000; i++) {
				notes.add(new Note((long) i, i + " "
						+ UUID.randomUUID().toString(), i + "" + i * i,
						new Date()));
			}
			noteDao.insertInTx(notes);
			deliverResponse(new SimpleResponse("插入完毕，执行成功"));
		} catch (Exception e) {
			TPError error = new TPError();
			error.setCause(e.getMessage());
			deliverError(error);
		}

	}

}
