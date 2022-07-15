package com.example.workshop13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workshop13.model.Contact;
import com.example.workshop13.util.Contacts;

@Controller
@RequestMapping(path="/addressbook")
public class AddressBookController {

    @Autowired
    Contacts ctcz;

    @Autowired
    ApplicationArguments appArgs;

    @GetMapping
    public String showAddressForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressbook";
    }

    @PostMapping
    public String saveContact(@ModelAttribute Contact contact, Model model){
        ctcz.saveContact(contact, model, appArgs);
        return "showContact";
    }

    @GetMapping("{contactid}")
    public String getContactById(Model model, @PathVariable String contactId) {
        ctcz.getContactById(model, contactId, appArgs);
        return "showContact";
    }
}
