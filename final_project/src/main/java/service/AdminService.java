package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.CoachUpdateCommand;
import model.Coach;
import repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public List<Coach> coachList() {
		List<Coach> coachList=new ArrayList<Coach>();
		coachList=adminRepository.coachList();
		System.out.println("AdminService CoachList");
		return coachList;
	}
	
	public Coach coachInfo(String email) {
		Coach coach = adminRepository.selectByEmail(email);
		System.out.println("AdminService CoachInfo " + email);
		return coach;
	}
	
	public int coachDelete(String email) {
		System.out.println("AdminService DeleteMemberList " + email);
		int result = adminRepository.deleteCoach(email);
		return result;
	}

	public Integer updateCoach(CoachUpdateCommand coachUpdateCommand) {
		Coach coach=new Coach(coachUpdateCommand.getCoachEmail(), coachUpdateCommand.getCoachName(), coachUpdateCommand.getCoachPW(), coachUpdateCommand.getCoachCareer());
		Integer result=adminRepository.updateCoach(coach);
		return result;
	}
}
