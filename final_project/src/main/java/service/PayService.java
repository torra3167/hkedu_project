package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CoachRepository;
import repository.PayRepository;

@Service
public class PayService {
	@Autowired
	private PayRepository payR;
}
