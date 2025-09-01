import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String registration;
    private String name;
    private int age;

    public Student(String registration, String name, int age) {
        this.registration = registration;
        this.name = name;
        this.age = age;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Matrícula: " + registration + ", Nome: " + name + ", Idade: " + age;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Aluno " + student.getName() + " adicionado com sucesso!");
    }

    public Student findStudentByRegistration(String registration) {
        for (Student student : students) {
            if (student.getRegistration().equals(registration)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(String registration, String newName, int newAge) {
        Student student = findStudentByRegistration(registration);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            System.out.println("Aluno com matrícula " + registration + " atualizado com sucesso!");
        } else {
            System.out.println("Aluno com matrícula " + registration + " não encontrado.");
        }
    }

    public void deleteStudent(String registration) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRegistration().equals(registration)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Aluno com matrícula " + registration + " removido com sucesso!");
        } else {
            System.out.println("Aluno com matrícula " + registration + " não encontrado.");
        }
    }

    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n--- Lista de Alunos ---");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("-----------------------");
        }
    }
}

    public class CadastroDeAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;
        do {
            System.out.println("\n--- Menu de Cadastro de Alunos ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Todos os Alunos");
            System.out.println("3. Buscar Aluno por Matrícula");
            System.out.println("4. Atualizar Dados do Aluno");
            System.out.println("5. Excluir Aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (choice) {
                case 1:
                    System.out.print("Matrícula: ");
                    String regAdd = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nameAdd = scanner.nextLine();
                    System.out.print("Idade: ");
                    int ageAdd = scanner.nextInt();
                    scanner.nextLine();
                    manager.addStudent(new Student(regAdd, nameAdd, ageAdd));
                    break;
                case 2:
                    manager.listAllStudents();
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno para buscar: ");
                    String regSearch = scanner.nextLine();
                    Student foundStudent = manager.findStudentByRegistration(regSearch);
                    if (foundStudent != null) {
                        System.out.println("Aluno encontrado: " + foundStudent);
                    } else {
                        System.out.println("Aluno com matrícula " + regSearch + " não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno para atualizar: ");
                    String regUpdate = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nova Idade: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    manager.updateStudent(regUpdate, newName, newAge);
                    break;
                case 5:
                    System.out.print("Digite a matrícula do aluno para excluir: ");
                    String regDelete = scanner.nextLine();
                    manager.deleteStudent(regDelete);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);

        scanner.close();
    }

}
