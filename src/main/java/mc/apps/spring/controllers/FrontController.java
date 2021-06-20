package mc.apps.spring.controllers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontController {
    private static final Logger logger = LogManager.getLogger(FrontController.class);
    private static final String DEFAULT_PATH = "/";


    @RequestMapping(value={"/","/{action}"})
    public String display(@PathVariable(required = false) String action,  Model model){
        logger.log(Level.INFO, "****************************************");
        logger.log(Level.INFO, "page = "+action);
        logger.log(Level.INFO, "****************************************");

        model.addAttribute("title", (action==null)?"Index":formatted(action));

        String page = (action==null)?"index":"template"; //action
        return page;
    }


    @PostMapping(value="/{action}")
    public String post(@PathVariable String action, @ModelAttribute Object object){
        logger.log(Level.INFO, "action = "+action);
        //        switch (action){
        //            ...
        //        }
        return "redirect:"+DEFAULT_PATH;
    }
    private String formatted(String page) {
        return page.substring(0,1).toUpperCase()+page.substring(1).toLowerCase();
    }
}
