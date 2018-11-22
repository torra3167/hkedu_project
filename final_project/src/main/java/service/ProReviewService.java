package service;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import command.ProReviewUpdateCommand;
import command.ProReviewWriteCommand;
import model.ProReview;
import model.ProgramExercise;
import repository.ProReviewRepository;

@Service
public class ProReviewService {
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	ProReview proReview;
	ProgramExercise programExercise;
	MultipartFile multiFile;
	static final String filePath = 
//			"C:\\Users\\FUTURE\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
//			"C:\\Users\\admin\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
	
			File file = new File(filePath);

	@Autowired
	ProReviewRepository prr;

	

	public void programReviewWrite(ProReviewWriteCommand proReviewWriteCommand, Model model) {
		
		// 파일저장
		multiFile = proReviewWriteCommand.getProReviewImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {

			multiFile.transferTo(file);
		
			
			// 프로그램 생성자
			// 프로그램번호, 코치이메일, 프로그램이름, 사이즈, 오리지널, 저장된, 내용

			//주문결제완료되면 멤버이메일등록필요 "1"
			//멤버이메일, 프로그램번호, 코치이메일, 타이틀, 스코어, 코멘트, 사이즈, 오리지널, 저장
			
			proReview = new ProReview(proReviewWriteCommand.getMemberEmail(), proReviewWriteCommand.getProNo(), proReviewWriteCommand.getCoachEmail(), 
					proReviewWriteCommand.getProReviewTitle(), proReviewWriteCommand.getProReviewScore(),
					proReviewWriteCommand.getProReviewComment(), multiFile.getSize(), originalFile, storedFileName);
			proReview.setProReviewRegdate(Calendar.getInstance().getTime());


			int proReviewResult = prr.insertProReview(proReview);

			if (proReviewResult < 1) {
				System.out.println("프로그램리뷰 등록실패!");
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectProReviewListByProNo(int proNo, Model model) {
		// TODO Auto-generated method stub
		List<ProReview> list = prr.selectProReviewListByProNo(proNo);
		model.addAttribute("list", list);
	}

	public void selectProReviewAllList(Model model) {
		// TODO Auto-generated method stub
		List<ProReview> list = prr.selectProReviewAllList();
		model.addAttribute("list", list);
	}

	public void updateProReview(ProReviewUpdateCommand proReviewUpdateCommand) {
		
		//파일삭제
		
		String fileName = proReviewUpdateCommand.getProReviewStored();
		
		if(fileName != null) {
			String path = filePath + fileName;
			
			file = new File(path);
			
			if(file.exists()) {
				file.delete();
				System.out.println("프로그램리뷰 파일삭제성공");
			}
		}
		
		//파일저장
		multiFile = proReviewUpdateCommand.getProReviewImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			
			//리뷰업데이트
		
			//번호 제목 총점 총평 사이즈 오리지널 저장파일
			proReview = new ProReview(proReviewUpdateCommand.getProReviewNo(), proReviewUpdateCommand.getProReviewTitle(),
					proReviewUpdateCommand.getProReviewScore(), proReviewUpdateCommand.getProReviewComment(),
					multiFile.getSize(), originalFile, storedFileName);
			
			//날짜
			proReview.setProReviewRegdate(Calendar.getInstance().getTime());
			
			int updateProReviewResult = prr.updateProReview(proReview);
			
			if(updateProReviewResult < 1) {
				
				System.out.println("리뷰업데이트 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}


