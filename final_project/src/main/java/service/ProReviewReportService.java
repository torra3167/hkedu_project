package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.ProReviewReportWriteCommand;
import model.ProReviewReport;
import repository.ProReviewReportRepository;

@Service
public class ProReviewReportService {
	ProReviewReport proReviewReport;
	@Autowired
	private ProReviewReportRepository prrr;

	public void proReviewReportInsert(ProReviewReportWriteCommand proReviewReportWriteCommand, Model model) {
		// TODO Auto-generated method stub
		
		//멤버이메일, 프로그램번호, 코치이메일, 타이틀, 콘텐트
		proReviewReport = new ProReviewReport(proReviewReportWriteCommand.getMemberEmail(), 
				proReviewReportWriteCommand.getProNo(), proReviewReportWriteCommand.getCoachEmail(), proReviewReportWriteCommand.getProReviewReportTitle(),
				proReviewReportWriteCommand.getProReviewReportContent());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String regDate = sdf.format(Calendar.getInstance().getTime());
        
		proReviewReport.setProReviewReportRegdate(regDate);
		
		prrr.insertProReviewReport(proReviewReport);
		
	}
}
