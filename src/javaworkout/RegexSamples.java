package javaworkout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.UUID;

public class RegexSamples {


	public static void main(String a[]){
		/*		STRING LINE = "THIS ORDER WAS PLACED FOR QT! OK?";
		STRING PATTERN = "(.*)(\\D+)(.*)";
		IF(LINE.MATCHES(PATTERN)) {
			SYSTEM.OUT.PRINTLN("FOUND");
		}ELSE
			SYSTEM.OUT.PRINTLN("NOT FOUND");*/



		//String line1 = "pre-certify partyprofileserv git@github.paypal.com:User-R/partyprofileserv.git release";
		//String line1 = "pre-certify paypalimportantservice https://github.paypal.com/rbhat/paypalimportantservice.git develop";
		/*		String line1 = "What is the process to certificate my component? ";
		//String pattern1 = "^pre-certify(\\s+)(\\w+)(\\s+)(.+)(\\s+)(\\w+)$";
		String pattern1 = "^(.+)(certification|certify|certificate)(.+)$";
		if(line1.matches(pattern1)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/

		/*		String line1 = "What is the process to certificate batch my component? ";
		//String pattern1 = "^pre-certify(\\s+)(\\w+)(\\s+)(.+)(\\s+)(\\w+)$";
		String pattern1 = "^(.+)(certify batch|certify a batch|certificate batch)(.+)$";
		if(line1.matches(pattern1)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/

		/*		String line1 = "   testdash";
		//String pattern1 = "^pre-certify(\\s+)(\\w+)(\\s+)(.+)(\\s+)(\\w+)$";
		String pattern1 = "^(\\s*)testdash(\\s*)$";
		if(line1.matches(pattern1)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/

		/*		String line2 = "How to run   devrunner";
		//String pattern1 = "^pre-certify(\\s+)(\\w+)(\\s+)(.+)(\\s+)(\\w+)$";
		String pattern2 = "^(.+)run(\\s+)devrunner(.*)$";
		if(line2.matches(pattern2)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/

		/*		UUID idOne = UUID.randomUUID();
		System.out.println("idOne - "+idOne);*/


		/*		String line2 = "hgdshdg  help  jhdjkdh";
		//String pattern1 = "^pre-certify(\\s+)(\\w+)(\\s+)(.+)(\\s+)(\\w+)$";
		String pattern2 = "^(\\s*)(help|Help)(\\s*)$";
		if(line2.matches(pattern2)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/



		//String line2 = "pre-certify   <mailto:git@github.paypal.com/Customer-Support-R/custnotifnenrichserv.git> testcase-grouping";
		/*		String line2 = "pre-certify <https://github.paypal.com/Checkout-R/retailcheckoutv2serv.git> develop";
		//String line2 = "pre-certify <https://github.paypal.com/Customers-R/partnerapiplatformserv.git> develop";	
		String pattern2 = "^pre-certify(\\s+)(<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>)(\\s+)([a-zA-Z0-9-_]+)$";
		if(line2.matches(pattern2)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/
		/*	

		//String line3 = "pre-certify custnotifnenrichserv <mailto:git@github.paypal.com:Customer-Support-R/custnotifnenrichserv.git> develop";
		String line3 = "pre-certify fdskjhfjdsh <https://github.paypal.com/Customers-R/partnerapiplatformserv.git> develop";		
		String pattern3 ="^pre-certify(\\s+)(\\w+)(\\s+)(<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>)(\\s+)([a-zA-Z0-9-_]+)$";
		if(line3.matches(pattern3)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");




		//<mailto:git@github.paypal.com|git@github.paypal.com>:Customers-R/partnerapiplatformserv.git
		//String line4 = "pre-certify  <mailto:git@github.paypal.com|git@github.paypal.com>:Customers-R/partnerapiplatformserv.git testcase-grouping";
		//String line4 = "pre-certify   <mailto:git@github.paypal.com|git@github.paypal.com>:Customers-R/partnerapiplatformserv.git testcase-grouping";
		String line4 = "pre-certify custnotifnenrichserv <mailto:git@github.paypal.com>:Customer-Support-R/custnotifnenrichserv.git develop";
		//String line4 = "pre-certify https://github.paypal.com/Customers-R/partnerapiplatformserv.git develop";
		String pattern4 = "^(pre-certify(\\s+)(\\w+)(\\s+)(<\\b(mailto):[-a-zA-Z0-9+&@#/%?=~_|!:,.;>]*[-a-zA-Z0-9+&@#/%=~_|])(\\s+)([a-zA-Z0-9-_]+)|pre-certify(\\s+)(<\\b(mailto):[-a-zA-Z0-9+&@#/%?=~_|!:,.;>]*[-a-zA-Z0-9+&@#/%=~_|])(\\s+)([a-zA-Z0-9-_]+))$";
		if(line4.matches(pattern4)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/




		//String line2 = "pre-certify   <mailto:git@github.paypal.com/Customer-Support-R/custnotifnenrichserv.git> testcase-grouping";
/*		String line5 = "dr-run <https://github.paypal.com/QualityInfrastructure/jaws-parent.git> develop clean run build";	
		String pattern5 = "^dr-run(\\s+)(<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>)(\\s+)([a-zA-Z0-9-_]+)(.*)$";
		if(line5.matches(pattern5)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/


		/*		String line6 = "certify-jira <https://github.paypal.com/Customers-R/partnerinternalserv> develop ECI-251";
		String pattern6 = "^certify-jira(\\s+)(<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>)(\\s+)([a-zA-Z0-9-_]+)(\\s+)([a-zA-Z0-9-_]+)$";
		if(line6.matches(pattern6)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");

		 */


/*		String line6 = "dr ft <https://github.paypal.com/Customers-R/partnerinternalserv> develop";
		String pattern6 = "^(dr|devrunner)(\\s+)(ft|functional-test)(.+)(<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>)(\\s+)([a-zA-Z0-9-_]+)$";
		if(line6.matches(pattern6)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/



		
/*		String line7 = "certify-status ";
		String pattern7 = "^(\\s*)certify-status(\\s*)([a-zA-Z0-9-_]*)$";
		if(line7.matches(pattern7)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");*/


		/*		String scmRepo = "https://github.paypal.com/Customers-R/donatenodeweb/";
		String repo = scmRepo.split("https://github.paypal.com/")[1];
		String gitCommand = "";		
		String scmBranch ="";

		if (!(scmRepo.endsWith(".git")) && !(repo.endsWith("/"))) {
			//System.out.print("git ls-remote --heads git@github.paypal.com:"+repo+".git | grep refs/heads/"+scmBranch);
			gitCommand = "1st git ls-remote --heads git@github.paypal.com:"+repo+".git | grep refs/heads/"+scmBranch;
		}else if(repo.endsWith("/")){
			//System.out.print("git ls-remote --heads git@github.paypal.com:"+repo.substring(0,repo.length()-1)+" | grep refs/heads/"+scmBranch);
			gitCommand = "2nd git ls-remote --heads git@github.paypal.com:"+repo.substring(0,repo.length()-1)+".git | grep refs/heads/"+scmBranch;
		}else{
			//System.out.print("git ls-remote --heads git@github.paypal.com:"+repo+" | grep refs/heads/"+scmBranch);
			gitCommand = "3rd git ls-remote --heads git@github.paypal.com:"+repo+" | grep refs/heads/"+scmBranch;
		}
		System.out.println("gitCommand --"+gitCommand); */
		
		
		
/*		System.out.print("---");
		System.out.print(String.format("%1$-" + 26 + "s", "None"));
		System.out.print("---");
		System.out.println("");
		System.out.print("---");
		System.out.print(String.format("%1$-" + 26 + "s", "Auto-Certified"));
		System.out.print("---");*/
		
		
		
		
		String line6 = "apptype: r";
		String pattern6 = "^apptype(\\s*):(\\s*)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+$";
		if(line6.matches(pattern6)) {
			System.out.println("Found");
		}else
			System.out.println("NOT Found");
	}




}

