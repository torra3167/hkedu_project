package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.NoticeInsertCommand;
import controller.NoticeController;
import model.Notice;
import repository.NoticeRepository;

@Service
public class NoticeService {
	
	private Notice notice;
	
	@Autowired
	private NoticeRepository noticeRepository;

	public Integer insertNotice(NoticeInsertCommand noticeInsertCommand) {
		System.out.println("NOTICESERVICE InsertNotice " + noticeInsertCommand.getNoticeTitle());
		notice=new Notice(noticeInsertCommand.getNoticeNo(), noticeInsertCommand.getNoticeTitle(),
				noticeInsertCommand.getNoticeContent(), noticeInsertCommand.getNoticeDate());
		Integer result=noticeRepository.insertNotice(notice);
		System.out.println("NoticeService "+result);
		return result;
	}
}
