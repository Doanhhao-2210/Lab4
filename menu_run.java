import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class menu_run {
    private static Vector<student> studentVector = new Vector<>();

    public static void main(String[] args) {
        loadStudentsFromFile();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Chon hanh dong:");
            System.out.println("1. Them sinh vien cao dang");
            System.out.println("2. Them sinh vien dai hoc");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Hien thong tin sinh vien");
            System.out.println("5. Hien ket qua tot nghiep");
            System.out.println("6. Loc sinh vien");
            System.out.println("7. Tim kiem theo ten");
            System.out.println("8. Thoat");
            System.out.print("Nhap hanh dong can lam: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    addCollege(sc);
                    break;
                case 2:
                    addUniversity(sc);
                    break;
                case 3:
                    removeStudent(sc);
                    break;
                case 4:
                    showStudents();
                    break;
                case 5:
                    showGraduates();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 7:
                    searchByName(sc);
                    break;
                case 8:
                    run = false;
                    saveStudentsToFile();
                    break;
                default:
                    System.out.println("Hanh dong khong hop le.");
                    break;
            }
        }
        sc.close();
    }

    private static void addCollege(Scanner sc) {
        System.out.print("Ma so sinh vien: ");
        String id = sc.nextLine();
        System.out.print("Ho ten: ");
        String name = sc.nextLine();
        System.out.print("Tin chi: ");
        int credits = sc.nextInt();
        System.out.print("Diem trung binh: ");
        double avg = sc.nextDouble();
        System.out.print("Diem tot nghiep: ");
        double exam = sc.nextDouble();
        sc.nextLine(); 

        student s = new collegeStudent(id, name, credits, avg, exam);
        studentVector.add(s);
        System.out.println("Them sinh vien cao dang.");
        saveStudentsToFile(); 
    }

    private static void addUniversity(Scanner sc) {
        System.out.print("Ma so sinh vien: ");
        String id = sc.nextLine();
        System.out.print("Ho ten: ");
        String name = sc.nextLine();
        System.out.print("Tin chi: ");
        int credits = sc.nextInt();
        System.out.print("Diem trung binh: ");
        double avg = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Ten cua do an : ");
        String title = sc.nextLine();
        System.out.print("Diem cua do an: ");
        double thesis = sc.nextDouble();
        sc.nextLine(); 

        student s = new universityStudent(id, name, credits, avg, title, thesis);
        studentVector.add(s);
        System.out.println("Them sinh vien dai hoc.");
        saveStudentsToFile(); 
    }

    private static void removeStudent(Scanner sc) {
        System.out.print("Nhap ma so sinh vien: ");
        String id = sc.nextLine();
        studentVector.removeIf(stu -> stu.getStudentId().equals(id));
        System.out.println("Sinh vien da duoc xoa.");
        saveStudentsToFile(); 
    }

    private static void showStudents() {
        for (student s : studentVector) {
            System.out.println(s);
        }
    }

    private static void showGraduates() {
        int count = 0;
        for (student s : studentVector) {
            if (s.isGraduated()) {
                System.out.println(s);
                count++;
            }
        }
        System.out.println("Tong so sinh vien du dieu kien tot nghiep: " + count);
    }

    private static void sortStudents() {
        studentVector.sort((s1, s2) -> {
            int typeComparison = s1.getClass().getSimpleName().compareTo(s2.getClass().getSimpleName());
            if (typeComparison == 0) {
                return s1.getStudentId().compareTo(s2.getStudentId());
            }
            return typeComparison;
        });
        System.out.println("Loc sinh vien.");
        saveStudentsToFile(); 
    }

    private static void searchByName(Scanner sc) {
        System.out.print("Nhap ten can tim kiem: ");
        String name = sc.nextLine();
        List<student> result = studentVector.stream()
                .filter(s -> s.getFullName().contains(name))
                .collect(Collectors.toList());

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result.dat"))) {
            oos.writeObject(result);
        } catch (IOException e) {
            System.out.println("Loi ghi vao file: " + e.getMessage());
        }
        System.out.println("Ket qua tim kiem da duoc luu vao result.dat.");
    }

    private static void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(studentVector);
        } catch (IOException e) {
            System.out.println("Loi luu vao file: " + e.getMessage());
        }
    }

    private static void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            studentVector = (Vector<student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file lien quan den sinh vien.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}
