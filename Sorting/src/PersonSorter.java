import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSorter
{
	private void sortUsingComparator(final List<Person> personList)
	{

		Collections.sort(personList, new Comparator<Person>()
		{

			@Override
			public int compare(final Person o1, final Person o2)
			{
				// TODO Auto-generated method stub
				int compareName = o1.getName().compareTo(o2.getName());
				if (compareName != 0)
				{
					return compareName;
				}
				return o1.getAge() - o2.getAge();
			}
		});

		System.out.println("Using Comparator: ");
		for (Person person : personList)
		{
			System.out.println(person.toString());
		}
	}


	private void sortUsingLambda(final List<Person> personList)
	{

		Collections.sort(personList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("Using lambda: ");
		for (Person person : personList)
		{
			System.out.println(person.toString());
		}

	}


	public static void main(final String[] args)
	{
		Person p1 = new Person();
		p1.setName("AAA");
		p1.setAge(40);
		Person p2 = new Person();
		p2.setName("AAD");
		p2.setAge(70);
		Person p3 = new Person();
		p3.setName("AAC");
		p3.setAge(60);
		Person p4 = new Person();
		p4.setName("AAB");
		p4.setAge(50);

		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);

		System.out.println("------------");
		new PersonSorter().sortUsingComparator(personList);

		System.out.println("-------------");
		new PersonSorter().sortUsingLambda(personList);

	}

}
