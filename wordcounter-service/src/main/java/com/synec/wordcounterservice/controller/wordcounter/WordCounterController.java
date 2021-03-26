package com.synec.wordcounterservice.controller.wordcounter;

import com.synec.wordcounterservice.advice.ExecutionTimeTracker;
import com.synec.wordcounterservice.controller.wordcounter.model.AddOutput;
import com.synec.wordcounterservice.controller.wordcounter.model.GetCountOutput;
import com.synec.wordcounterservice.model.response.OKResponse;
import com.synec.wordcounterservice.model.response.SynecResponse;
import com.synec.wordcounterservice.service.WordCounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(path = "api/v1/wordcounter")
@RequiredArgsConstructor
@RestController
public class WordCounterController {

    private final WordCounterService wordCounterService;

    @ExecutionTimeTracker
    @PostMapping("/{word}")
    public SynecResponse<AddOutput> add(@PathVariable String word) {
        wordCounterService.add(word);
        return new OKResponse();
    }

    @ExecutionTimeTracker
    @GetMapping("/{word}")
    public SynecResponse<GetCountOutput> getCount(@PathVariable String word) {
        return new OKResponse(wordCounterService.getCount(word));
    }
}
