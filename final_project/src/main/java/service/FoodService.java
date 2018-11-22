package service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import command.FoodReviewAnswerUpdateCommand;
import command.FoodReviewAnswerWriteCommand;
import command.FoodReviewReportWriteCommand;
import command.FoodReviewUpdateCommand;
import command.FoodReviewWriteCommand;
import command.FoodUpdateCommand;
import model.Food;
import model.FoodAndApplication;
import model.FoodReview;
import model.FoodReviewAndAnswer;
import model.FoodReviewAnswer;
import model.FoodReviewReport;
import repository.FoodRepository;



@Service
public class FoodService {
	Food food;
	FoodReview foodReview;
	
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	MultipartFile multiFile;
	
	@Autowired
	private FoodRepository foodRepository;
	static final String filePath =
//			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
//			"C:\\Users\\hotelalpha\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
	File file = new File(filePath);
	
	
	
	
	
	public List<Food> sellerFoodList(String sellerEmail) {
		 List<Food> list = foodRepository.sellerFoodList(sellerEmail);
//		for(Object temp : list) {
//			 Food food = (Food)temp;
//			 System.out.println("service foodNo : "+food.getFoodNo());
//		}
		 return list;
		
		
	}
	
	public void insertFood(FoodRegCommand foodRegCommand, HttpSession session) {
		//System.out.println("service insertFood " + foodRegCommand.getFoodName());
		
		//foodNum
		Integer foodNum = foodRepository.selectFoodNumber();
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		if(foodNum == 0) {
			foodNum = 1;
		} else {
			foodNum = foodNum + 1;
		}
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		foodRegCommand.setFoodNo(foodNum);
		
		//foodSellerEmail
		String ai = (String) session.getAttribute("email");
		System.out.println("service insertFood sellerEmail " + ai);
		
		//foodImage
		multiFile = foodRegCommand.getFoodImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			
			food = new Food(
					foodNum,
					ai,
					foodRegCommand.getFoodCatANo(), 
					foodRegCommand.getFoodCatBNo(), 
					foodRegCommand.getFoodCatCNo(), 
					foodRegCommand.getFoodName(),
					foodRegCommand.getFoodQuant(),
					foodRegCommand.getFoodExpiryDate(),
					foodRegCommand.getFoodOrigin(),
					foodRegCommand.getFoodSale(),
					foodRegCommand.getFoodPrice(),
					foodRegCommand.getFoodCarbo(),
					foodRegCommand.getFoodProtein(),
					foodRegCommand.getFoodFat(),
					foodRegCommand.getFoodCal(), 
					multiFile.getSize(), 
					originalFile, 
					storedFileName
					);
			System.out.println(food + " : FOOD");
			
			int k = foodRepository.insertFood(food);
			
			if(k < 1) {
				System.out.println("식품 등록실패!");
			} else {
				System.out.println("식품 등록성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//FoodCatC < FoodCatB < FoodCatA
	public List<FoodCatC> dominoSelectC() {
//		System.out.println("service C 실행");
		List<FoodCatC> list = foodRepository.ccaSelect();
//		System.out.println("service C 반환된 list size : " + list.size());
		return list;
//		model.addAttribute("list", list);	//seller_menu 열리는 sellerCntlr에서 생성
	}
	
	public List<FoodCatB> dominoSelectB(FoodCatB foodCatB) {
//		System.out.println("service B 실행, FoodCatCNo : " + foodCatB.getFoodCatCNo());
		List<FoodCatB> list = foodRepository.bcaSelect(foodCatB);
//		System.out.println("service B 반환된 list size : " + list.size());
		return list;
	}
	
	public List<FoodCatA> dominoSelectA(FoodCatA foodCatA) {
//		System.out.println("service A 실행, FoodCatBNo : " + foodCatA.getFoodCatBNo());
		List<FoodCatA> list = foodRepository.acaSelect(foodCatA);
//		System.out.println("service A 반환된 list size : " + list.size());
		return list;
	}

	public Food selectSellerFood(int foodNo) {
		Food food = foodRepository.selectSellerFood(foodNo);
		return food;
	}

	public void updateFood(FoodUpdateCommand foodUpdateCommand) {
		System.out.println("svc : " + foodUpdateCommand.getFoodNo());
		System.out.println("svc : " + foodUpdateCommand.getFoodName());
		
		//foodImage
		multiFile = foodUpdateCommand.getFoodImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			food = new Food();
			food.setFoodNo(foodUpdateCommand.getFoodNo());
			food.setFoodName(foodUpdateCommand.getFoodName());
			food.setFoodPrice(foodUpdateCommand.getFoodPrice());
			food.setFoodSale(foodUpdateCommand.getFoodSale());
			food.setFoodQuant(foodUpdateCommand.getFoodQuant());
			food.setFoodExpiryDate(foodUpdateCommand.getFoodExpiryDate());
			food.setFoodOrigin(foodUpdateCommand.getFoodOrigin());
			food.setFoodCarbo(foodUpdateCommand.getFoodCarbo());
			food.setFoodProtein(foodUpdateCommand.getFoodProtein());
			food.setFoodFat(foodUpdateCommand.getFoodFat());
			food.setFoodCal(foodUpdateCommand.getFoodCal());
			food.setFoodCatANo(foodUpdateCommand.getFoodCatANo());
			food.setFoodCatBNo(foodUpdateCommand.getFoodCatBNo());
			food.setFoodCatCNo(foodUpdateCommand.getFoodCatCNo());
			food.setFoodSize(multiFile.getSize());
			food.setFoodOriginal(originalFile);
			food.setFoodStored(storedFileName);
			System.out.println(food + " : FOOD");
			
			int k = foodRepository.updateFood(food);
			
			if(k < 1) {
				System.out.println("식품변경 실패");
			} else {
				System.out.println("식품변경 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFood(int foodNo) {
		System.out.println("svc deleteFood foodNo : " + foodNo);
		int k = foodRepository.deleteFood(foodNo);
		
		if(k < 1) {
			System.out.println("식품삭제 실패");
		} else {
			System.out.println("식품삭제 성공!");
		}
	}

	public List<FoodAndApplication> selectFoodList() {
		return foodRepository.selectFoodList();
	}

	public FoodAndApplication selectFood(int foodNo) {
		System.out.println("svc selectFood foodNo : " + foodNo);
		FoodAndApplication fa = foodRepository.selectFood(foodNo);
		return fa;
		
	}
	
	public void selectReviewFood(FoodReviewWriteCommand foodReviewWriteCommand) {
		System.out.println("svc selectReviewFood foodNo : " + foodReviewWriteCommand.getFoodNo());
		FoodAndApplication rf = foodRepository.selectFood(foodReviewWriteCommand.getFoodNo());
		foodReviewWriteCommand.setFoodNo(foodReviewWriteCommand.getFoodNo());
		foodReviewWriteCommand.setSellerEmail(rf.getSellerEmail());
		foodReviewWriteCommand.setFoodCatANo(rf.getFoodCatANo());
		foodReviewWriteCommand.setFoodCatBNo(rf.getFoodCatBNo());
		foodReviewWriteCommand.setFoodCatCNo(rf.getFoodCatCNo());
		foodReviewWriteCommand.setFoodReviewFoodName(rf.getFoodName());
	}
	
	public void insertFoodReview(FoodReviewWriteCommand foodReviewWriteCommand, HttpSession session) {
		System.out.println("svc insertFoodReview foodNo : " + foodReviewWriteCommand.getFoodNo());
		System.out.println("svc insertFoodReview ReviewfoodName : " + foodReviewWriteCommand.getFoodReviewFoodName());
		
		//foodReviewNum
			Integer foodReviewNo = foodRepository.selectFoodReviewNo();
			System.out.println("svc insertFoodReview foodReviewNo1 : " + foodReviewNo);
			if(foodReviewNo == 0) {
				foodReviewNo = 1;
			} else {
				foodReviewNo = foodReviewNo + 1;
			}
			System.out.println("svc insertFoodReview foodReviewNo2 : " + foodReviewNo);
		
		//memberEmail
			String memberEmail = (String) session.getAttribute("email");
			
		//foodReviewRegdate
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
	        String theTime = simpleDateFormat.format(Calendar.getInstance().getTime());
	        System.out.println("svc insertFoodReview theTime : " + theTime);
			
			foodReviewWriteCommand.setFoodReviewRegdate(theTime);
			System.out.println("svc insertFoodReview FoodReviewRegdate : " + foodReviewWriteCommand.getFoodReviewRegdate());
			
		//foodImage
			multiFile = foodReviewWriteCommand.getFoodReviewImage();
			originalFile = multiFile.getOriginalFilename();
			originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
			file = new File(filePath + storedFileName);
			
			try {
				multiFile.transferTo(file);
				
				foodReview = new FoodReview(
						foodReviewNo,
						memberEmail,
						foodReviewWriteCommand.getFoodNo(),
						foodReviewWriteCommand.getSellerEmail(),
						foodReviewWriteCommand.getFoodCatANo(),
						foodReviewWriteCommand.getFoodCatBNo(),
						foodReviewWriteCommand.getFoodCatCNo(),
						foodReviewWriteCommand.getFoodReviewRegdate(),
						foodReviewWriteCommand.getFoodReviewFoodName(),
						foodReviewWriteCommand.getFoodReviewTitle(),
						foodReviewWriteCommand.getFoodReviewScore(),
						foodReviewWriteCommand.getFoodReviewComment(),
						multiFile.getSize(), 
						originalFile, 
						storedFileName
				);
				System.out.println("svc insertFoodReview foodReview : " + foodReview);
				
				int k = foodRepository.insertFoodReview(foodReview);
				
				if(k < 1) {
					System.out.println("식품리뷰 등록실패!");
				} else {
					System.out.println("식품리뷰 등록성공!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public List<FoodReviewAndAnswer> selectReviewAndAnswer(int foodNo) {
		System.out.println("svc selectReviewAndAnswer foodNo : " + foodNo);
		List<FoodReviewAndAnswer> foodReviewAndAnswers  = foodRepository.selectReviewAndAnswer(foodNo);
		for(Object temp : foodReviewAndAnswers) {
			FoodReviewAndAnswer fraa = (FoodReviewAndAnswer)temp;
			System.out.println("svc selectReviewAndAnswer selectReviewAndAnswer : " + fraa.getFoodReviewRegdate());
			List<FoodReviewAnswer> fra = fraa.getFoodReviewAnswers();
			System.out.println("svc selectReviewAndAnswer FoodReviewAnswers : " + fra.size());
			for(Object temp2 : fra) {
				FoodReviewAnswer foodReviewAnswer = (FoodReviewAnswer)temp2;
				System.out.println("svc selectReviewAndAnswer getFoodReviewAnswerRegdate : " + foodReviewAnswer.getFoodReviewAnswerRegdate());
			}
		}
		return foodReviewAndAnswers;
	}
	
	
	
	
	public void selectReviewUpdateFood(FoodReviewUpdateCommand foodReviewUpdateCommand) {
			FoodAndApplication fa = foodRepository.selectFood(foodReviewUpdateCommand.getFoodNo());
			foodReviewUpdateCommand.setSellerEmail(fa.getSellerEmail());
			foodReviewUpdateCommand.setFoodCatANo(fa.getFoodCatANo());
			foodReviewUpdateCommand.setFoodCatBNo(fa.getFoodCatBNo());
			foodReviewUpdateCommand.setFoodCatCNo(fa.getFoodCatCNo());
			foodReviewUpdateCommand.setFoodReviewFoodName(fa.getFoodName());
	}
	
	public void updateFoodReview(FoodReviewUpdateCommand foodReviewUpdateCommand, HttpSession session) {
		System.out.println("svc updateFoodReview FoodReviewUpdateCommand foodReviewNo : " + foodReviewUpdateCommand.getFoodReviewNo() );
		
		//memberEmail
		String memberEmail = (String) session.getAttribute("email");
		
		//foodReviewRegdate
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String theTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println("svc insertFoodReview theTime : " + theTime);
        
		foodReviewUpdateCommand.setFoodReviewRegdate(theTime);
		System.out.println("svc updateFoodReview FoodReviewRegdate : " + foodReviewUpdateCommand.getFoodReviewRegdate());
		
		//foodImage
		multiFile = foodReviewUpdateCommand.getFoodReviewImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			
			foodReview = new FoodReview(
					foodReviewUpdateCommand.getFoodReviewNo(),
					memberEmail,
					foodReviewUpdateCommand.getFoodNo(),
					foodReviewUpdateCommand.getSellerEmail(),
					foodReviewUpdateCommand.getFoodCatANo(),
					foodReviewUpdateCommand.getFoodCatBNo(),
					foodReviewUpdateCommand.getFoodCatCNo(),
					foodReviewUpdateCommand.getFoodReviewRegdate(),
					foodReviewUpdateCommand.getFoodReviewFoodName(),
					foodReviewUpdateCommand.getFoodReviewTitle(),
					foodReviewUpdateCommand.getFoodReviewScore(),
					foodReviewUpdateCommand.getFoodReviewComment(),
					multiFile.getSize(), 
					originalFile, 
					storedFileName
					);
			System.out.println("svc insertFoodReview foodReview : " + foodReview);
			
			int k = foodRepository.updateFoodReview(foodReview);
			
			if(k < 1) {
				System.out.println("식품리뷰 수정 실패!");
			} else {
				System.out.println("식품리뷰 수정 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFoodReview(int foodReviewNo) {
		System.out.println("svc deleteFoodReview foodReviewNo : " + foodReviewNo);
		int k = foodRepository.deleteFoodReview(foodReviewNo);
		
		if(k < 1) {
			System.out.println("식품리뷰 삭제 실패");
		} else {
			System.out.println("식품리뷰 삭제 성공!");
		}
	}

	public void selectReviewAnswerFood(FoodReviewAnswerWriteCommand foodReviewAnswerWriteCommand) {
		System.out.println("svc selectReviewAnswerFood foodNo" + foodReviewAnswerWriteCommand.getFoodNo());
		FoodAndApplication fa = foodRepository.selectFood(foodReviewAnswerWriteCommand.getFoodNo());
		foodReviewAnswerWriteCommand.setSellerEmail(fa.getSellerEmail());
		foodReviewAnswerWriteCommand.setFoodCatANo(fa.getFoodCatANo());
		foodReviewAnswerWriteCommand.setFoodCatBNo(fa.getFoodCatBNo());
		foodReviewAnswerWriteCommand.setFoodCatCNo(fa.getFoodCatCNo());
	}

	public void insertFoodReviewAnswer(FoodReviewAnswerWriteCommand foodReviewAnswerWriteCommand) {
		System.out.println("svc insertFoodReviewAnswer foodReviewNo" + foodReviewAnswerWriteCommand.getFoodReviewNo());
		
		//foodReviewAnswerNo
		Integer foodReviewAnswerNo = foodRepository.selectfoodReviewAnswerNo();
		System.out.println("svc insertFoodReviewAnswer foodReviewAnswerNo1 : " + foodReviewAnswerNo);
		if(foodReviewAnswerNo == 0) {
			foodReviewAnswerNo = 1;
		} else {
			foodReviewAnswerNo = foodReviewAnswerNo + 1;
		}
		System.out.println("svc insertFoodReviewAnswer foodReviewAnswerNo2 : " + foodReviewAnswerNo);
		
		//foodReviewRegdate
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String theTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println("svc insertFoodReview theTime : " + theTime);
        
		foodReviewAnswerWriteCommand.setFoodReviewAnswerRegdate(theTime);
		System.out.println("svc insertFoodReviewAnswer FoodReviewAnswerRegdate : " + foodReviewAnswerWriteCommand.getFoodReviewAnswerRegdate());
		
		FoodReviewAnswer foodReviewAnswer = new FoodReviewAnswer(
				foodReviewAnswerWriteCommand.getFoodReviewNo(),
				foodReviewAnswerWriteCommand.getMemberEmail(),
				foodReviewAnswerWriteCommand.getFoodNo(),
				foodReviewAnswerWriteCommand.getSellerEmail(),
				foodReviewAnswerNo,
				foodReviewAnswerWriteCommand.getFoodCatANo(),
				foodReviewAnswerWriteCommand.getFoodCatBNo(),
				foodReviewAnswerWriteCommand.getFoodCatCNo(),
				foodReviewAnswerWriteCommand.getFoodReviewAnswerContent(),
				foodReviewAnswerWriteCommand.getFoodReviewAnswerRegdate()
				);
		System.out.println("svc insertFoodReviewAnswer foodReviewAnswer : " + foodReviewAnswer);
		
		int k = foodRepository.insertFoodReviewAnswer(foodReviewAnswer);
		
		if(k < 1) {
			System.out.println("식품리뷰답변 등록 실패!");
		} else {
			System.out.println("식품리뷰답변 등록 성공!");
		}
	}

	public void selectReviewAnswerUpdateFood(FoodReviewAnswerUpdateCommand foodReviewAnswerUpdateCommand) {
		System.out.println("svc selectReviewAnswerUpdateFood foodNo : " + foodReviewAnswerUpdateCommand.getFoodNo());
		FoodAndApplication fa = foodRepository.selectFood(foodReviewAnswerUpdateCommand.getFoodNo());
		foodReviewAnswerUpdateCommand.setSellerEmail(fa.getSellerEmail());
		foodReviewAnswerUpdateCommand.setFoodCatANo(fa.getFoodCatANo());
		foodReviewAnswerUpdateCommand.setFoodCatBNo(fa.getFoodCatBNo());
		foodReviewAnswerUpdateCommand.setFoodCatCNo(fa.getFoodCatCNo());
		
	}
	
	public void updateFoodReviewAnswer(FoodReviewAnswerUpdateCommand foodReviewAnswerUpdateCommand) {
		System.out.println("svc updateFoodReviewAnswer foodReviewNo : " + foodReviewAnswerUpdateCommand.getFoodReviewNo());
		//foodReviewAnswerRegdate
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String theTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println("svc insertFoodReview theTime : " + theTime);
        
		foodReviewAnswerUpdateCommand.setFoodReviewAnswerRegdate(theTime);
		System.out.println("svc updateFoodReviewAnswer FoodReviewAnswerRegdate : " + foodReviewAnswerUpdateCommand.getFoodReviewAnswerRegdate());
		
		FoodReviewAnswer foodReviewAnswer = new FoodReviewAnswer(
				foodReviewAnswerUpdateCommand.getFoodReviewNo(),
				foodReviewAnswerUpdateCommand.getMemberEmail(),
				foodReviewAnswerUpdateCommand.getFoodNo(),
				foodReviewAnswerUpdateCommand.getSellerEmail(),
				foodReviewAnswerUpdateCommand.getFoodReviewAnswerNo(),
				foodReviewAnswerUpdateCommand.getFoodCatANo(),
				foodReviewAnswerUpdateCommand.getFoodCatBNo(),
				foodReviewAnswerUpdateCommand.getFoodCatCNo(),
				foodReviewAnswerUpdateCommand.getFoodReviewAnswerContent(),
				foodReviewAnswerUpdateCommand.getFoodReviewAnswerRegdate()
				);
		
		int k = foodRepository.updateFoodReviewAnswer(foodReviewAnswer);
		
		if(k < 1) {
			System.out.println("식품리뷰답변 수정 실패!");
		} else {
			System.out.println("식품리뷰답변 수정 성공!");
		}
	}

	public void deleteFoodReviewAnswer(int foodReviewAnswerNo) {
		System.out.println("svc deleteFoodReviewAnswer foodReviewAnswerNo : " + foodReviewAnswerNo);
		int k = foodRepository.deleteFoodReviewAnswer(foodReviewAnswerNo);
		
		if(k < 1) {
			System.out.println("식품리뷰답변 삭제 실패");
		} else {
			System.out.println("식품리뷰답변 삭제 성공!");
		}
	}

	public void selectReviewReportFood(FoodReviewReportWriteCommand foodReviewReportWriteCommand, HttpSession session) {
		System.out.println("svc selectReviewReportFood foodNo : " + foodReviewReportWriteCommand.getFoodNo());
		FoodAndApplication fa = foodRepository.selectFood(foodReviewReportWriteCommand.getFoodNo());
		foodReviewReportWriteCommand.setSellerEmail(fa.getSellerEmail());
		foodReviewReportWriteCommand.setFoodCatANo(fa.getFoodCatANo());
		foodReviewReportWriteCommand.setFoodCatBNo(fa.getFoodCatBNo());
		foodReviewReportWriteCommand.setFoodCatCNo(fa.getFoodCatCNo());
		System.out.println("svc selectReviewReportFood sellerEmail : " + foodReviewReportWriteCommand.getSellerEmail());
		System.out.println("svc selectReviewReportFood foodCatANo : " + foodReviewReportWriteCommand.getFoodCatANo());
		System.out.println("svc selectReviewReportFood foodCatBNo : " + foodReviewReportWriteCommand.getFoodCatBNo());
		System.out.println("svc selectReviewReportFood foodCatCNo : " + foodReviewReportWriteCommand.getFoodCatCNo());
		String foodReportWriter = (String) session.getAttribute("email");
		foodReviewReportWriteCommand.setFoodReportWriter(foodReportWriter);
		System.out.println("svc selectReviewReportFood foodReportWriter : " + foodReviewReportWriteCommand.getFoodReportWriter());
	}

	public void insertFoodReviewReport(FoodReviewReportWriteCommand foodReviewReportWriteCommand) {
System.out.println("svc insertFoodReviewReport foodReviewNo" + foodReviewReportWriteCommand.getFoodReviewNo());
		//foodReportRegdate
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String theTime = simpleDateFormat.format(Calendar.getInstance().getTime());
		System.out.println("svc insertFoodReview theTime : " + theTime);

		foodReviewReportWriteCommand.setFoodReportRegdate(theTime);
		System.out.println("svc insertFoodReviewReport foodReportRegdate : " + foodReviewReportWriteCommand.getFoodReportRegdate());
		
		FoodReviewReport foodReviewReport = new FoodReviewReport(
				foodReviewReportWriteCommand.getFoodReviewNo(),
				foodReviewReportWriteCommand.getMemberEmail(),
				foodReviewReportWriteCommand.getFoodNo(),
				foodReviewReportWriteCommand.getSellerEmail(),
				foodReviewReportWriteCommand.getFoodCatANo(),
				foodReviewReportWriteCommand.getFoodCatBNo(),
				foodReviewReportWriteCommand.getFoodCatCNo(),
				foodReviewReportWriteCommand.getFoodReportTitle(),
				foodReviewReportWriteCommand.getFoodReportContent(),
				foodReviewReportWriteCommand.getFoodReportWriter(),
				foodReviewReportWriteCommand.getFoodReportRegdate()
				);
		System.out.println("svc insertFoodReviewReport foodReviewReport : " + foodReviewReport);
		
		int k = foodRepository.insertFoodReviewReport(foodReviewReport);
		
		if(k < 1) {
			System.out.println("식품리뷰신고 등록 실패!");
		} else {
			System.out.println("식품리뷰신고 등록 성공!");
		}
	}

	public List<FoodReviewReport> selectFoodReviewReportList() {
		List<FoodReviewReport> foodReviewReports = foodRepository.selectFoodReviewReportList();
		return foodReviewReports;
	}

	public FoodReviewReport selectFoodReviewReport(String foodReportRegdate) {
		System.out.println("svc selectFoodReviewReport foodReportRegdate : " + foodReportRegdate);
		FoodReviewReport foodReviewReport = foodRepository.selectFoodReviewReport(foodReportRegdate);
		return foodReviewReport;
	}

	public void deleteFoodReviewReport(String foodReportRegdate) {
		System.out.println("svc deleteFoodReviewReport foodReportRegdate : " + foodReportRegdate);
		int k = foodRepository.deleteFoodReviewReport(foodReportRegdate);
		
		if(k < 1) {
			System.out.println("식품리뷰신고 삭제 실패");
		} else {
			System.out.println("식품리뷰신고 삭제 성공!");
		}
	}


	

	
	
}
