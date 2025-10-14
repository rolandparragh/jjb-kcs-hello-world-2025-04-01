package jobAdvertisementFileHandlerjcf;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
			if (jobs.get(i).getRole().contains(role)) {
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
//kell bele az 
	public List<Job> findNoExpYears() {
		List<Job> jobsWithoutExperience = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).getExpInYears() < 1) {
				jobsWithoutExperience.add(jobs.get(i));
			}

		}
		return jobsWithoutExperience;
	}
//ezt írd át ez szar 
	public List<Job> findAdvsOlderThanInt(int weeks) {
		List<Job> olderAdvs = new ArrayList<>();
	
		LocalDate localDateActual = LocalDate.now();
		for (int i = 0; i < jobs.size(); i++) {
			if (localDateActual.compareTo(jobs.get(i).getDateOfPublication()) >= weeks) {
				olderAdvs.add(jobs.get(i));
			}

		}
		return olderAdvs;
	}
	
	//csináld újra pls! 
	public void findTheMaxAvg() {
	    Map<String, Integer> countMap = new HashMap<>();
	    Map<String, Integer> sumMap = new HashMap<>();


	    for (Job job : jobs) {
	        String role = job.getRole().trim();
	        int salary = job.getNetSalary();

	        // darabszám
	        countMap.put(role, countMap.getOrDefault(role, 0) + 1);

	        // fizetések összege
	        sumMap.put(role, sumMap.getOrDefault(role, 0) + salary);
	    }

	    // átlag kiszámítása
	    Map<String, Double> avgMap = new HashMap<>();
	    for (String role : sumMap.keySet()) {
	        double avg = (double) sumMap.get(role) / countMap.get(role);
	        avgMap.put(role, avg);
	    }

	    String maxRole = null;
	    double maxAvg = 0.0;

	    for (Map.Entry<String, Double> entry : avgMap.entrySet()) {
	        if (entry.getValue() > maxAvg) {
	            maxAvg = entry.getValue();
	            maxRole = entry.getKey();
	        }
	    }

	    System.out.println("Legmagasabb átlagfizetésű role: " + maxRole + " (" + maxAvg + ")");
	}


}
