package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class TV_CSV {

	public static void main(String[] args) throws IOException {

		String csv_file = "C:/Workspace/HW_36_TV_CSV/src/main/resources/csv.txt";
		BufferedReader br;
		String line;
		String test_case_id;
		String url;
		String title_expected;

		br = new BufferedReader(new FileReader(csv_file));
		WebDriver driver = new HtmlUnitDriver();
		while ((line = br.readLine()) != null) {

			String[] csv = line.split("\\^");

			test_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			
			System.out.println("");
			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			} else {
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");

			}

		
		}//while
		driver.quit();
		br.close();
	}//main
		
	}//class
