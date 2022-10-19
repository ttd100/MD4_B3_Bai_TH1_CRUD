package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rikkei.academy.model.Student;
import rikkei.academy.service.IStudentService;

@Controller
public class AppController {
    @Autowired
    private IStudentService studentService;
    @RequestMapping("/")
    public String star(Model model){
        model.addAttribute("listStudent",studentService.findAll());
        return "list";
    }
    @GetMapping("/student")
    public String showCreate(Model model){
        Student student =new Student();
        model.addAttribute("showCreate",student);
        return "create";
    }
    @PostMapping("/create")
    public String create(Student student){
//        int lastIndex =studentService.findAll().size()-1;
//        int lastId = studentService.findAll().get(lastIndex).getId();
//        student.setId(lastId+1);
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/showEdit")
    public String showEdit(@RequestParam int id,Model model ){
        studentService.findById(id);
        Student student = studentService.findById(id);
        model.addAttribute("editStudent",student);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Student student) {
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping("/showDelete")
    public String showDelete(@RequestParam int id,Model model) {
        studentService.findById(id);
        Student student = studentService.findById(id);
        model.addAttribute("delete",student);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Student student) {
        studentService.delete(student.getId());
        return "redirect:/";
    }
}

