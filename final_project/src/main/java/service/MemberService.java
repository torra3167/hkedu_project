package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.MemberJoinCommand;
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
	public void findID(Member member, Model model) {
		System.out.println("service "+member.getMemberEmail());
		Member mb=memberRepository.memberSelect(member);
		int result=0;
		if(mb!=null) {
			if(!mb.getMemberPass().equals(member.getMemberPass())) {
				result=2;
			}else {
				result=3;
			}
		}else {
			result=1;
		}
		model.addAttribute("result", result);
	}
	
//	public Integer survey1Write(MemberSurveyCommand memberSurveyCommand) {
//		System.out.println("service "+memberSurveyCommand.getSurvNo());
//		return memberRepository.survey1Write(memberSurveyCommand);
//	}
//	public Integer surveyWrite(MemberSurveyCommand memberSurveyCommand) {
//		System.out.println("service "+memberSurveyCommand.getSurvNo());
//		return memberRepository.survey2Write(memberSurveyCommand);
//	}
}
