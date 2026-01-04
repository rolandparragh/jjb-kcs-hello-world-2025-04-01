	package dateHandling;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.time.Period;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.GregorianCalendar;
	import java.util.Locale;
	import java.util.TimeZone;
	
	public class DateExample {
	
		public static void main(String[] args) {
			// Feladatoknál miért van sok dátumkezelés?
			// Pld. Feladat01: Kérjen be két dátumot, majd írja ki hány nap telt el a két dátum között!
			// Pld. Feladat02: Futó versenyzők eredményeinek értékelés: indulás óra:perc:mp értkezés ua.
			// Megoldáshoz használjunk idő és dátumkezelő beépített metódusokat!
			
			Date dateActual = new Date(); //aktuális idő lekérdezése
			System.out.println(dateActual); //Thu Aug 07 19:45:53 CEST 2025
	
			//Date firstDate = new Date(2001,1,2); // deprecated - elavult: java11-től már ne használjuk
			//System.out.println(firstDate);
	//		firstDate.setDate();
	//		firstDate.setYear();
			
			//SimpleDateFormat - régebbi osztály (elavult)
			try {
				Date publishDate = new SimpleDateFormat("yyyy-MM-dd").parse("2012-01-08");
				System.out.println(publishDate); //Sun Jan 08 00:00:00 CET 2012
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Calendar osztályból létrehoz egy calendarObj-t (objektumpéldányt) nincs new kulcsszó
			// Calendar elavult, java11 helyette automatikusan betölti a GregorianCalendar-t, ami nem deprecated
	 		Calendar calendarObj = Calendar.getInstance();
			System.out.println("Aktuális év: "+calendarObj.get(Calendar.YEAR)); //Aktuális év: 2025
			System.out.println("Aktuális hónap: "+calendarObj.get(Calendar.MONTH)); //0.tól indexel (január-0)
			System.out.println("Aktuális nap: "+calendarObj.get(Calendar.DATE));
			System.out.println("Aktuális óra: "+calendarObj.get(Calendar.HOUR));
			System.out.println("Aktuális perc: "+calendarObj.get(Calendar.MINUTE));
			System.out.println("Aktuális mp: "+calendarObj.get(Calendar.SECOND));
			System.out.println("Az évben: "+calendarObj.get(Calendar.DAY_OF_YEAR)+ ". nap");
			
			Calendar.getInstance(Locale.US);
			
			// Feladat01: Írassuk ki a 2 héttel ezelőtti dátumot! Aktuális dátum alapján!
			System.out.println("Feladat01: Írassuk ki a 2 héttel ezelőtti dátumot! Aktuális dátum alapján");
			Calendar dateCalendar = Calendar.getInstance();
			dateCalendar.add(Calendar.DATE,-14);
			System.out.println("2 héttel ezelőtti dátum: "+dateCalendar); // java.util.GregorianCalendar[time=1718543008464,areFieldsSet=true,ar..
			// 1718543008464 - 1970.01.01 óta eltelt mp-ek száma
			System.out.println("2 héttel ezelőtti dátum: "+dateCalendar.getTime()); //Thu Jul 24 19:53:52 CEST 2025
			System.out.println("2 héttel ezelőtti év: "+dateCalendar.get(Calendar.YEAR)); 
			System.out.println("2 héttel ezelőtti hónap: "+(dateCalendar.get(Calendar.MONTH)+1)); 
			System.out.println("2 héttel ezelőtti nap: "+dateCalendar.get(Calendar.DATE));
			System.out.println("2 héttel ezelőtti, az évben: "+dateCalendar.get(Calendar.DAY_OF_YEAR)+ ". nap");
			
			//System.out.println(dateCalendar.getTime().getYear()); //deprecated
			//Helyette a SimpleDatFormat használható
				
			// Feladat02: Kérjünk be két dátumot (kivételkezeléssel), majd döntsük el, hogy melyik korábbi/későbbi,
			// esetleg nem azonosak!
	
			try {	
				System.out.println("Feladat02 - Dátumok összehasonlítása:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Kérem adja meg az első dátum adatait, egész számokkal!");
			System.out.print("Év: (pld. 2024):");
			int firstYear = Integer.parseInt(br.readLine());
			System.out.print("Hónap: (1-12: 1-Január.. 12-December):");
			int firstMonth = (Integer.parseInt(br.readLine()))-1;
			System.out.print("Nap: (pld. 21):");
			int firstDay = Integer.parseInt(br.readLine());
			System.out.println("Kérem adja meg az második dátum adatait, egész számokkal!");
			System.out.print("Év: (pld. 2024):");
			int secondYear = Integer.parseInt(br.readLine());
			System.out.print("Hónap: (1-12: 1-Január.. 12-December):");
			int secondMonth = (Integer.parseInt(br.readLine()))-1;
			System.out.print("Nap: (pld. 21):");
			int secondDay = Integer.parseInt(br.readLine());
			
			Calendar firstDate = Calendar.getInstance();
			firstDate.set(firstYear, firstMonth,firstDay);
			System.out.println("Az első megadott dátum: "+firstDate.getTime());
			
			Calendar secondDate = Calendar.getInstance();
			secondDate.set(secondYear, secondMonth,secondDay);
			System.out.println("Az második megadott dátum: "+secondDate.getTime());
			
			// rossz megoldás - nincs ilyen megoldás
			//if (firstDate>secondDay)  
			
			//Helyesen 1. jó megoldás
			if (firstDate.after(secondDate)) {
				System.out.println("Az első dátum későbbi, mint a második...");
			} else if (firstDate.before(secondDate)) {
				System.out.println("Az első dátum korábbi, mint a második...");
			} else {
				System.out.println("A két dátum azonos :)");
			}
			//Hibás dátum esetén - automatikus javítást végez: 
			//2024-02-30 -ból 2024-03-01
			
			// 2. jó megoldás:
			System.out.println("compareTo() összehasonlítás: ");
			if (firstDate.compareTo(secondDate)<0) {
				System.out.println("Az első dátum korábbi, mint a második...");
			} else if (firstDate.compareTo(secondDate)>0) {
				System.out.println("Az első dátum későbbi, mint a második...");
			} else if (firstDate.compareTo(secondDate)==0) {
				System.out.println("A két dátum azonos :)");
			} 
			// FONTOS: realációs operátorokat dátumoknál ne használjuk == <> stb.
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// java11 óta a Time package-et használjuk dátum és időkezelésre (LocalDate-et)
		LocalDate localDateActual = LocalDate.now(); //aktuális dátummal tér vissza
		System.out.println("Aktuális dátum - localdate: "+localDateActual); //2025-08-07 - ISO szabvány szerinti formátum
		System.out.println(LocalDate.of(2015, 02, 20));
		//System.out.println(LocalDate.of(2015, 02, 30)); //DateTimeException
		
		LocalDate registrationDate = LocalDate.parse("2024-02-15");
		registrationDate = registrationDate.plus(Period.ofDays(30));
		System.out.println("Regisztráció ideje + 30 nap:"+registrationDate);
		
		System.out.println(registrationDate.isAfter(localDateActual));//false
		System.out.println(registrationDate.isBefore(localDateActual)); //true
		
		//Feladat03: Két dátum közötti különbség napokban: 
		System.out.println("Feladat03: Két dátum közötti különbség napokban:");
		LocalDate dateBegin = LocalDate.of(2015, 02,20);
		LocalDate dateEnd = LocalDate.of(2017, 03, 28);
		
		//System.out.println(dateActual.getMonth()); //deprecated
		//Hibás megoldás
		int daysBetween = Period.between(dateBegin, dateEnd).getDays();
		System.out.println("Eltelt napok száma: "+daysBetween);
		// x év, y hónap, z nap a különbség
		
		//Helyes megoldás
		LocalDate date01 = LocalDate.of(2020,9,11);
		LocalDate date02 = LocalDate.of(2021,8,10);
		Period period = Period.between(date01, date02);
		int years = Math.abs(period.getYears());
		int months = Math.abs(period.getMonths());
		int days = Math.abs(period.getDays());
		
		System.out.println("Év: "+years);
		System.out.println("Hónap: "+months);
		System.out.println("Nap: "+days);
		
		//Feladat04: Idők közötti különbség: 
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now); //2024-06-30T15:37:51.884032600
		LocalDateTime sixMinutesBehind = now.minusMinutes(6);
		System.out.println("Hat perccel korábban: "+sixMinutesBehind); //2024-06-30T15:31:51.884032600
		
		Duration duration = Duration.between(now, sixMinutesBehind);
		long diff = Math.abs(duration.toMinutes());
		System.out.println("Eltelt különbség percekben: "+diff); //6
		
		@SuppressWarnings("unused")
		TimeZone tz = TimeZone.getTimeZone("GMT+9:00");
		Locale loc = new Locale("en","US","US"); 
		Calendar calendar2 = Calendar.getInstance(loc);
		GregorianCalendar gregorianCalendar = (GregorianCalendar)calendar2;
		System.out.println(gregorianCalendar);
		System.out.println(gregorianCalendar.get(Calendar.YEAR));
		System.out.println(gregorianCalendar.get(Calendar.HOUR));
		
		//Összefoglalva, ezeket az oszályokat használjuk java11-ben
		//LocalDate
		//GregorianCalendar
		//TimeZone
		//Time
		//Külső könyvtárak: Date4J, JodaTime
	}
}
