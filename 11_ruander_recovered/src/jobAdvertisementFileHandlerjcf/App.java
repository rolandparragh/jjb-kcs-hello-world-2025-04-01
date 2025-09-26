package jobAdvertisementFileHandlerjcf;

import java.util.List;

public class App {
	// 1. Olvassuk be a fájlt egy olyan adatszerkezetbe, hogy a további feladatok
	// megoldhatóak
	// legyenek!

	// 2. Írjuk ki az álláshirdetések adatait soronként! Paraméterként legyen
	// megadható, hogy
	// soron belül milyen elválasztó karakterrel jelenik meg!

	// 3. Hány darab állás van a rendszerben?

	// 4. Írjuk ki legtöbb bruttó fizetést kínáló hirdetés adatait!

	// 5. Hány db rendszergazda állásra lehet jelentkezni?

	// 6. Melyik állások végezhetőek távmunkában? Jelenítsük meg az ilyen állásokat!

	// 7. Mennyit lehet keresni átlagosan távmunkában pozíciótól függetlenül!

	// 8. Van –e olyan állás és ha igen melyek azok, ahol nem szükséges
	// munkatapasztalat!

	// 9. Melyek azok az állások, amelyek több, mint 3 hete vannak fent a portálon?

	// 10. Melyik a legfrissebb állásajánlat?

	// 11. Átlagosan melyik pozícióban lehet keresni a legtöbbet (Eddigi legnehezebb
	// alg.)?

	// 12. Kérjünk be egy kezdő és egy végdátumot, majd az intervallumon belüli
	// álláshirdetéseket írjuk ki egy külön fájlba! A fájl neve legyen
	// job_ads_between_interval.csv!
	public static void main(String[] args) {

		JobUtils jobUtils = new JobUtils();

		jobUtils.readFile();
		System.out.println("A fájl mérete:");
		System.out.println(jobUtils.jobs.size());
		jobUtils.formattedOutputForJobs(':');
		System.out.println("A rendszerben lévő állások száma:" + jobUtils.countJobAdvs());
		System.out.println("Ezen különböző állások találhatóak a hírdetések között: " + jobUtils.outputUniqueJobs());
		System.out.println("A legmagasabban fizető munka: " + jobUtils.findHighestPayingJob());
		System.out.println("Rendszergazda állások száma: " + jobUtils.countAdsBasedOnRole("rendszergazda"));
		System.out.println("Remote jobs: " + jobUtils.findRemoteJobs());
		List<Job> remoteJobs = jobUtils.findRemoteJobs();
		System.out.println("A remote jobs keresete:" + jobUtils.countAvgNetSalaryOfRemoteJobs(remoteJobs));
	}

}
