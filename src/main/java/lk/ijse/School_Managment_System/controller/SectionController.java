package lk.ijse.School_Managment_System.controller;

import lk.ijse.School_Managment_System.constant.CommonResponse;
import lk.ijse.School_Managment_System.dto.SectionDTO;
import lk.ijse.School_Managment_System.service.SectionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static lk.ijse.School_Managment_System.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.School_Managment_System.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveSection(@RequestBody SectionDTO sectionDTO) {
        sectionService.saveSection(sectionDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateSection(@RequestBody SectionDTO sectionDTO) {
        sectionService.updateSection(sectionDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }
}
