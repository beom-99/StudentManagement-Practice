import java.util.ArrayList;
import java.util.List;

// 인터페이스를 구현한 클래스는 구현체 클
public class StudentRepositoryImpl implements StudentRepository {
    
	private final List<Student> students = new ArrayList<>();
	private int nextId = 1;
	
	public StudentRepositoryImpl() {
		System.out.println("StudentRepository 생성");
	}
	
	@Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
//    	for(int i =0;i<students.size();i++) {
//    		if(students.get(i).getId() == id) {
//    			return students.get(i);
//    		}
//    	}
//    	for each 문
    	for (Student student : students) {
    		if(student.getId()==id) {
    			return student;
    		}
    	}
    	
    	return null;
    }
      
    
     
    
    
    @Override
    public void save(Student student) {
    	student = new Student(nextId++, student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public void update(int id, Student updatedStudent) {
    	Student student = findById(id);
    	if(student != null) {
    		student.setName(updatedStudent.getName());
    		student.setMajor(updatedStudent.getMajor());
    	}
    }

    @Override
    public void delete(int id) {
//    	  students.removeIf(student -> student.getId() == id); 
    	
    	for (int i=0; i< students.size();i++) {
    		if(students.get(i).getId()==id) {
    			students.remove(i);
    			break;
    		}
    	}
    }
}
