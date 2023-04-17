package com.exercise.controllers.rest;

import com.exercise.configuration.AmazonProperties;
import com.exercise.configuration.GoogleProperties;
import com.exercise.repository.user_rep.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spring")
@RequiredArgsConstructor
public class SpringInvestigationController {

    private final List<UserRepository> repositoryList;

    private final AmazonProperties amazonProperties;

    private final GoogleProperties googleConfig;


    @GetMapping("/info/yml")
    public ResponseEntity<Map<String, Object>> getCloudsConfigs() {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("amazon", amazonProperties.toString());
        result.put("google", googleConfig.toString());

        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
