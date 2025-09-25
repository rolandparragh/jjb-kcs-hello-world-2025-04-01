package jobAdvertisementFileHandlerjcf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JobUtils {

	List<Job> jobs = new ArrayList<Job>();

	public void readFile() {
		FileHandler fileHandler = new FileHandler();
		jobs = fileHandler.getJobsFromFile("job_ads/job_ads.csv");
	}

	public void formattedOutputForJobs(char divider) {

		for (int i = 0; i < jobs.size(); i++) {
			Job job = jobs.get(i);
			System.out.println(job.formatJobString(divider));
		}
	}

	public Set<String> outputUniqueJobs() {
		Set<String> uniqueJobs = new HashSet<String>();
		for (int i = 0; i < jobs.size(); i++) {
			Job job = jobs.get(i);
			uniqueJobs.add(job.getRole());
		}
		return uniqueJobs;
	}

	public int countJobAdvs() {
		return jobs.size();

	}

	public Job findHighestPayingJob() {
		int highestSalary = 0;
		Job highestJob = null;
		for (int i = 0; i < jobs.size(); i++) {
			Job job = jobs.get(i);
			if (job.getNetSalary() > highestSalary) {
				highestSalary = job.getNetSalary();
				highestJob = jobs.get(i);
			}
		}

		return highestJob;
	}

	public int countAdsBasedOnRole(String role) {
		int counter = 0;
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).getRole().equalsIgnoreCase(role)) {
				counter++;
			}
		}
		return counter;
	}

	public List<Job> findRemoteJobs() {
		List<Job> remoteJobs = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).isRemote()) {
				remoteJobs.add(jobs.get(i));
			}
			
		}
		return remoteJobs;
	}

	public double countAvgNetSalaryOfRemoteJobs(List<Job> remoteJobs) {
		double avgSalary = 0.0;

		for (int i = 0; i < remoteJobs.size(); i++) {
			avgSalary += (double) remoteJobs.get(i).getNetSalary();
		}
		avgSalary = (double) avgSalary / remoteJobs.size();

		return avgSalary;
	}

}
