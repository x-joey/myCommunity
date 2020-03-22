package com.example.junwei.service;

import com.example.junwei.dto.PaginationDTO;
import com.example.junwei.dto.QuestionDTO;
import com.example.junwei.mapper.QuestionMapper;
import com.example.junwei.mapper.UserMapper;
import com.example.junwei.model.Question;
import com.example.junwei.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        //如果输入页面小于1，则输出第一个页面
        if (page < 1) {
            page = 1;
        }
        //如果输入页面大于最多页面，则输出最后一个页面
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        // size*(i-1)  i is 页码
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset , size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions){
            User user = userMapper.findByid(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);


        return paginationDTO;
    }
}
