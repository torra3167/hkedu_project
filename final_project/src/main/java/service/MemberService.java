package service;

import org.springframework.beans.factory.annotation.Autowired;

import command.MemberJoinCommand;
import model.Member;
import repository.MemberRepository;

public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	
	public Integer insertMember(MemberJoinCommand memberJoinCommand) {
		System.out.println("service "+memberJoinCommand.getMemberEmail());
		return memberRepository.insertMember(memberJoinCommand);
	}
	
}
