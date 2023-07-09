package com.example.FileTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.annotation.PostConstruct;

@Controller
public class WebController {
	private List<Student> studentList = new ArrayList<>();
	int id;

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentList);
		return "students";
	}

	@GetMapping("/students/add")
	public String addStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "add-student";
	}

	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student student) {
		student.setId(studentList.size()+1);
		studentList.add(student);
		return "redirect:/students";
	}


	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable("id") long id, Model model) {
		Student student = getStudentById(id);
		model.addAttribute("student", student);
		return "edit-student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable("id") long id, @ModelAttribute("student") Student updatedStudent) {
		Student student = getStudentById(id);
		student.setName(updatedStudent.getName());
		student.setEmail(updatedStudent.getEmail());
		return "redirect:/students";
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		studentList.removeIf(student -> student.getId() == id);
		for(int i=0;i<studentList.size();i++) {
			studentList.get(i).setId(i+1);
		}
		return "redirect:/students";
	}

	private Student getStudentById(long id) {
		return studentList.stream().filter(student -> student.getId() == (id)).findFirst().orElse(null);
	}
}
