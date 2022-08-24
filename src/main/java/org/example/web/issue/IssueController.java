package org.example.web.issue;

import lombok.RequiredArgsConstructor;
import org.example.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @GetMapping
        public String showList(Model model){
                model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        return "issues/creationForm";
    }

    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(),form.getDescription());
        return "redirect:/issues";
    }
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model ){
        model.addAttribute("issue",issueService.findById(issueId));
        return "issues/detail";
    }
    @GetMapping("/edit/{issueId}")
    public String edit(@PathVariable("issueId") long issueId, Model model){
        model.addAttribute("issue",issueService.findById(issueId));
        return "issues/editForm";
    }
    @PostMapping("/editForm/{issueId}")
    public String update(@PathVariable("issueId") long issueId, @Validated EditIssueForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return edit(issueId,model);
        }
        issueService.update(form.getId(), form.getSummary(),form.getDescription());
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }
    @PostMapping("/{issueId}")
    public String delete(@PathVariable("issueId") long issueId){
        issueService.delete(issueId);
        return "redirect:/issues";
    }
}