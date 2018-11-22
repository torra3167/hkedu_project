package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.CoachRepository;
import repository.ProReviewReportRepository;

@Service
public class ProReviewReportService {

	@Autowired
	private ProReviewReportRepository prrr;
}
