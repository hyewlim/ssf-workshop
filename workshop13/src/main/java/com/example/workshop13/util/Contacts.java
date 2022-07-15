package com.example.workshop13.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import com.example.workshop13.model.Contact;

@Component("contacts")
public class Contacts {
    private static final Logger logger = LoggerFactory.getLogger(Contacts.class);

    public void saveContact(Contact ctc, Model model, ApplicationArguments appArgs){
        String dataFilename = ctc.getId();
        PrintWriter pw = null;
        try {
            FileWriter fileWriter = new FileWriter(getDataDir(appArgs)+ "/" + dataFilename);
            pw = new PrintWriter(fileWriter);
            pw.println(ctc.getName());
            pw.println(ctc.getEmail());
            pw.println(ctc.getPhoneNumber());
            pw.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } 
        model.addAttribute("contact", new Contact(ctc.getId(), ctc.getName(), 
                            ctc.getEmail(), ctc.getPhoneNumber()));

    }
 
        public void getContactById(Model model, String contactId, ApplicationArguments appArgs) {
            Contact ctc = new Contact();
            try {
                Path filePath = new File(getDataDir(appArgs) + "/" + contactId).toPath();
                Charset charset = Charset.forName("UTF-8");
                List<String> stringList = Files.readAllLines(filePath, charset);
                ctc.setId(contactId);
                ctc.setName(stringList.get(0));
                ctc.setEmail(stringList.get(1));
                ctc.setPhoneNumber(Integer.parseInt(stringList.get(2)));
            
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact info not found");
            }

            model.addAttribute("contact", ctc);
        }

        private String getDataDir(ApplicationArguments appArgs) {
            Set<String> opsNames = appArgs.getOptionNames();
            String[] optNamesArr = opsNames.toArray(new String[opsNames.size()]);
            List<String> optValues = appArgs.getOptionValues(optNamesArr[0]);
            String[] optValuesArr = optValues.toArray(new String[optValues.size()]);
            return optValuesArr[0];
        }
}

