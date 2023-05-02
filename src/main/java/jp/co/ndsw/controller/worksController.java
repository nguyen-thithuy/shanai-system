package jp.co.ndsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jp.co.ndsw.entites.RegisterForm;
import jp.co.ndsw.service.UserService;

@Controller
public class worksController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
    	return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
    	return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
    	return "login?logout";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @GetMapping("/works/workList")
    public String workList(Model model) {
    	return "/works/workList";
    }

    @GetMapping("/works/workInput")
    public String workInput(Model model) {
    	return "/works/workInput";
    }

    @GetMapping("/works/todokeList")
    public String todokeList(Model model) {
    	return "/works/todokeList";
    }

    @GetMapping("/works/todokeInput")
    public String todokeInput(Model model) {
    	return "/works/todokeInput";
    }
    
    // 登録画面の POST 受け付け
    @PostMapping("/register")
    public String postRegister(
        @ModelAttribute @Valid RegisterForm registerForm,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // エラーがある場合は、エラーメッセージを表示したいので
            // View をレンダリングする。
            return "register";
        }

        
        userService.createUser(
        	registerForm.getNo(),
            registerForm.getEmail(),
            registerForm.getPassword(),
            new String[] { "ADMIN", "USER" });

        // ユーザー登録処理が成功したらログイン画面にリダイレクトする。
        return "redirect:/login";
    }
}
