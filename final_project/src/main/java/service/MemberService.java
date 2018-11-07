package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import model.Member;
import repository.MemberRepository;
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	
	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		System.out.println("service "+memberJoinCommand.getMemberEmail());
		return memberRepository.insertMember(memberJoinCommand);
	}
	public Integer survey1Write(MemberSurveyCommand memberSurveyCommand) {
		System.out.println("service "+memberSurveyCommand.getSurvNo());
		return memberRepository.survey1Write(memberSurveyCommand);
	}
}
