package com.example.springtask.controller;

import com.example.springtask.Model.RequestForm;
import com.example.springtask.repository.RequestFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/forms")
public class RequestFormController {

    @Autowired
    private RequestFormRepo requestFormRepository;

    // Display All Forms
    @GetMapping
    public String getAllForms(Model model) {
        model.addAttribute("forms", requestFormRepository.findAll());
        return "form-list"; // List view template
    }

    // Show Create Form Page
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("requestForm", new RequestForm());
        return "form-create"; // Create form template
    }

    // Save Form (For Create and Update)
    @PostMapping("/save")
    public String saveForm(@ModelAttribute RequestForm requestForm) {
        requestFormRepository.save(requestForm);
        return "redirect:/forms"; // Redirect to list view
    }

    // Show Update Form Page (Edit Form)
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<RequestForm> form = requestFormRepository.findById(id);
        if (form.isPresent()) {
            model.addAttribute("requestForm", form.get());
            return "form-edit"; // Show the edit page
        }
        return "redirect:/forms"; // Redirect if form is not found
    }

    // Update Form (Handles the form submission for updating)
    @PostMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, @ModelAttribute RequestForm requestForm) {
        requestForm.setId(id); // Ensure the form's ID is set for the update
        requestFormRepository.save(requestForm); // Save the updated form
        return "redirect:/forms"; // Redirect to form list
    }

    // Delete Form
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id) {
        requestFormRepository.deleteById(id);
        return "redirect:/forms";
    }
}
