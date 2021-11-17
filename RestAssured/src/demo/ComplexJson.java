package demo;

import io.restassured.path.json.JsonPath;
import payload.AddPayLoad;

public class ComplexJson {
	public static void main(String[] args) {

		JsonPath js = new JsonPath(AddPayLoad.coursePrice());

		// 1. Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println("1. Print No of courses returned by API is " + count);

		// 2.Print Purchase Amount
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		System.out.println("2. Print Purchase Amount " + purchaseAmount);

		// 3. Print Title of the first course
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("3. Title of the first course is " + firstCourseTitle);

		String secondCourseTitle = js.getString("courses[1].title");
		System.out.println("3. Title of the second course is " + secondCourseTitle);

		String thirdCourseTitle = js.getString("courses[2].title");
		System.out.println("3. Title of the third course is " + thirdCourseTitle);

		// 4. Print All course titles and their respective Prices

		/*
		 * List<Object> titles = js.getList("courses"); System.out.println(titles);
		 */
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println("4. All courses and their titles are as below : ");
			System.out.println("The Course Title is " + courseTitles);
			
			System.out.println("The Course Price is " + js.getInt("courses[" + i + "].price"));
		}

		// 5. Print no of copies sold by RPA Course
		/*
		 * int RpaSoldCopies = js.getInt("courses[2].copies");
		 * System.out.println(RpaSoldCopies);
		 */
		for (int i = 0; i < count; i++) {
			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("RPA"))

			{
				System.out.println("5. RPA Sold Copies are " + js.get("courses[" + i + "].copies").toString());
				break;
			}
		}

		// 6. Verify if Sum of all Course prices matches with Purchase Amount

		int sum = 0;
		for (int i = 0; i < count; i++) {

			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			int amount = price * copies;
			sum = sum + amount;

		}

		// Assert.assertEquals(sum, purchaseAmount);
		if (purchaseAmount == sum) {
			System.out.println("6. Sum of all Course prices matches with Purchase Amount");
		} else {
			System.out.println("6. Sum of all Course prices not matches with Purchase Amount");
		}

	}

}
