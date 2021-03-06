package com.jlu.jtee;

import com.jlu.jtee.domain.ChoiceQuestion;
import com.jlu.jtee.service.ChoiceQuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

public class ImportTest {


    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @Test
    @GetMapping("choiceQuestion")
    @ResponseBody
    public String importChoice(ChoiceQuestion choiceQuestion){
        choiceQuestion.setContent("1,下列哪些方法是ArrayList和LinkedList集合中都定义的（多选）（     ）");
        choiceQuestion.setChoiceA("A. add(Object o)");
        choiceQuestion.setChoiceB("B. removeFirst()");
        choiceQuestion.setChoiceC("C. remove(Object o)");
        choiceQuestion.setChoiceD("D. add(int index,Object o)");
        choiceQuestion.setAnswer("A,C,D");
        choiceQuestion.setContributor("测试");
        choiceQuestion.setCreateTime(new Date());
        choiceQuestion.setType("Java集合类");
        choiceQuestionService.importChoice(choiceQuestion);
        return "加入成功";

    }

}
