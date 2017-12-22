package com.lyjsh.web.controller.system;

import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Dictionary;
import com.lyjsh.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("dictionary")
@Controller
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @ResponseBody
    @PostMapping("/save")
    public ExecuteResult save(@Valid Dictionary dictionary,BindingResult result) {
        ExecuteResult executeResult = null;
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            executeResult = ExecuteResult.validateError(list.get(0).getDefaultMessage(),dictionary);
            return executeResult;
        }
        try {
            boolean oprateSuccess = dictionaryService.save(dictionary);
            if (oprateSuccess) {
                return ExecuteResult.success(dictionary);
            }
        }catch (BussException buss) {
            buss.printStackTrace();
            return ExecuteResult.bussError(buss.getMessage(),dictionary);
        }catch (Exception e) {
            e.printStackTrace();
            return ExecuteResult.error();
        }
        return ExecuteResult.oprateFault("保存失败",dictionary);
    }
}
