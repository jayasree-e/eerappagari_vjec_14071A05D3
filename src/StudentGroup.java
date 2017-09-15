import java.util.Date;
import java.util.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		
		this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		
		int i=this.students.length;
		for(int j=i;j>0;j--)
		this.students[j]=this.students[j-1];
		this.students[0]=student;
		this.students[i+1]=null;
	}

	@Override
	public void addLast(Student student) {
		
		int i=this.students.length;
		this.students[i]=student;
		this.students[i+1]=null;
	}

	@Override
	public void add(Student student, int index) {
		
		int i=this.students.length;
		for(int j=i;j>index;j--)
		this.students[j]=this.students[j-1];
		this.students[index]=student;
		this.students[i+1]=null;
	}

	@Override
	public void remove(int index) {
		
		int i=this.students.length;
		for(int j= index;j<i;j++)
		this.students[j]=this.students[j+1];
		this.students[i+1]=null;
	}

	@Override
	public void remove(Student student) {
		
		int i=this.students.length;
		int index=0;
             for(int j=0;j<i;j++)
		if(this.students[j].equals(student))
		{index=j;
		break;
                }
		for(int j=index;j<i;j++)
		this.students[j]=this.students[j+1];
		this.students[i+1]=null;
	}

	@Override
	public void removeFromIndex(int index) {
		
		int i=this.students.length;
		this.students[index]=null;
	}

	@Override
	public void removeFromElement(Student student) {
		
		int i=this.students.length;
		int index=0;
             for(int j=0;j<i;j++)
		if((this.students[j]).equals(student))
		{index=j;
		break;
                }
		//this.students[index]=this.students[i];
		this.students[index]=null;
	}

	@Override
	public void removeToIndex(int index) {
		
		int j=this.students.length;
		for(int i=0; i<= j-index;i++)
		this.students[i]=this.students[i+index+1];
		this.students[j+1]=null;
	}

	@Override
	public void removeToElement(Student student) {
		
		int i=this.students.length;
		int index=0;
             for(int j=0;j<i;j++)
		if((this.students[j]).equals(student))
		{index=j;
		break;
                }
		int j=this.students.length;
		for(i=0;i<=j-index;i++)
		this.students[i]=this.students[i+index+1];
		this.students[i+1]=null;
	}

	@Override
	public void bubbleSort() {
		
		//int n=this.students.length;
		//for(int i=0;i<n-1;i++){
		//	
		//	for(int j=i+1;j<n;j++){
		//		
		//		if(this.students[i].compareTo(this.students[j]))
		//		{
                //                  Student student= new Student();
		//		    student=this.students[i];
		//		    this.students[i]=this.students[j];
		//    		    this.students[j]=student;	
                //                 }			
		//	}
		//
		//}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		
		int n=this.students.length;
		Student[] students_by_birthdate = new Student[n];
		if(date == null)
			throw new IllegalArgumentException("date cannot be null");
		else{
			
			for(int i=0,j=0; i<n; i++){
				if(this.students[i].getBirthDate().equals(date))
				students_by_birthdate[j++] = this.students[i];
			}
				
			}
		return students_by_birthdate;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		
		int n=this.students.length;
		Student[] students_by_birthdate = new Student[n];
		if( firstDate == null || lastDate == null)
			throw new IllegalArgumentException("first or last dates cannot be null");
		else{
			
			for(int i=0,j=0; i<n; i++){
				if(this.students[i].getBirthDate().after(firstDate) || this.students[i].getBirthDate().before(lastDate)||this.students[i].getBirthDate().equals(lastDate)||this.students[i].getBirthDate().equals(firstDate))
				students_by_birthdate[j++] = this.students[i];
			}
				
			}
		return students_by_birthdate;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		
		int n=this.students.length;
		Student[] students_by_birthdate = new Student[n];
		if(date == null)
			throw new IllegalArgumentException("date cannot be null");
		else{
			
			for(int i=0,j=0; i<n; i++){
				if(this.students[i].getBirthDate().equals(date)||this.students[i].getBirthDate().compareTo(date)==days)
				students_by_birthdate[j++] = this.students[i];
			}
				
			}
		return students_by_birthdate;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		
		int age = 0;
		if(indexOfStudent == 0)
			throw new IllegalArgumentException("indexOfStudent cannot be 0");
		try {
			Date date1 = this.students[indexOfStudent].getBirthDate();
			Calendar now = Calendar.getInstance();
			Calendar dob = Calendar.getInstance();
			dob.setTime(date1);
		if (dob.after(now)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
			int year1 = now.get(Calendar.YEAR);
			int year2 = dob.get(Calendar.YEAR);
			age = year1 - year2;
			int month1 = now.get(Calendar.MONTH);
			int month2 = dob.get(Calendar.MONTH);
		if (month2 > month1) {
			age--;
		} else if (month1 == month2) {
			int day1 = now.get(Calendar.DAY_OF_MONTH);
			int day2 = dob.get(Calendar.DAY_OF_MONTH);
		if (day2 > day1) {
			age--;
		}
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return age ;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		
		
		int n=this.students.length;
		Student[] students_by_age = new Student[n];
		for(int i=0, j=0; i<n ;i++)
		{
			if(age == getCurrentAgeByDate(i))
				students_by_age[j++] = this.students[i];		
		}
		return students_by_age;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		
		int n=this.students.length, total = 0, avg=0;
		Student[] students_by_highest_avg_mark = new Student[n];
		for(int i=0; i<n ;i++)
			total+=this.students[i].getAvgMark();
		avg = total/n;
		for(int i=0, j=0; i<n ;i++){
			if(this.students[i].getAvgMark()> avg)
				students_by_highest_avg_mark[j++] = this.students[i];
		}
		return students_by_highest_avg_mark;
	}

	@Override
	public Student getNextStudent(Student student) {
		
		if (student == null)
			throw new IllegalArgumentException("student cannot be null");
		int index = 0;
		int n=this.students.length;
		for(int i=0;i<n;i++)
		{
			if(this.students[i].getId() == student.getId() && this.students[i].getFullName() == student.getFullName() && this.students[i].getBirthDate() == student.getBirthDate() && this.students[i].getAvgMark() == student.getAvgMark() )
			index = i+1;
		}
		return this.students[index];
	}
}
