package com.upgrad.ublog.utils;

/**
 * TODO: 5.1. Create a method with the following signature.
 *  public static boolean isValidEmail(String email) throws EmailNotValidException
 * TODO: 5.2. This method accepts email id and checks for the following.
 *  a. Consider a dummy email id, <part 1>@<part 2>.<part 3>
 *  b. part 1, part 2 and part 3 should only contain alphanumeric characters. They can't be an empty string.
 *  c. part 3 should contain at least 2 and at most 6 characters.
 * TODO 5.3: This method should return (boolean) true if the email id is in the given format. Otherwise,
 *  it should throw EmailNotValidException with the "Please provide valid email address" message.
 */

public class EmailValidator {

/*
    public static void main(String[] args) {
		List<String> passingEmails = Arrays.asList(
				"ish@so.com",
				"a@b.com"
			);
		List<String> failingEmails = Arrays.asList(

				"@.",
				"%@xyz.com",
				"a@b.c",
				"a@b.correspondance",
				"a@b",
				"a.b"
			);
		System.out.println("All pass");
		for (String email: passingEmails) {
			System.out.print("checking " + email + " : ");
			try {
				EmailValidator.isValidEmail(email);
				System.out.println("PASSED");
			} catch (EmailNotValidException ex) {
				System.out.println("FAILED");
			}
		}

		System.out.println("All fails");
		for (String email: failingEmails) {
			System.out.print("checking " + email + " : ");
			try {
				EmailValidator.isValidEmail(email);
				System.out.println("PASSED");
			} catch (EmailNotValidException ex) {
				System.out.println("FAILED");
			}
		}
	}
	*/
}
