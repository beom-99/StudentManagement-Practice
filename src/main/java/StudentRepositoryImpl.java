import java.util.ArrayList;
import java.util.List;

// 인터페이스를 구현한 클래스는 구현체 클
public class StudentRepositoryImpl implements StudentRepository {
    
//	메모리 저장
	private final List<Student> students = new ArrayList<>();
	private int nextId=1;
	
	public StudentRepositoryImpl() {
		System.out.println("StudentRepository 생성");
	}
	
	@Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
    	 for (Student student : students) {
    	        if (student.getId() == id) {
    	            return student; // ID가 일치하면 해당 학생 반환
    	        }
    	    }
    	    return null; // ID를 찾지 못하면 null 반환
    }

    @Override
    public void save(Student student) {
    	student = new Student(nextId++, student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public void update(int id, Student updatedStudent) {
    	 for (int i = 0; i < students.size(); i++) {
    	        if (students.get(i).getId() == id) {
    	            // 기존 학생을 새로운 정보로 업데이트
    	            students.set(i, new Student(id, updatedStudent.getName(), updatedStudent.getMajor()));
    	            System.out.println("ID :" + id + " 학생 정보가 업데이트되었습니다.");	
    	            return;
    	        }
    	    }
    	    System.out.println("ID " + id + " 학생을 찾을 수 없습니다.");
    }

    @Override
    public void delete(int id) {
    	  students.removeIf(student -> student.getId() == id); 
    }
}
