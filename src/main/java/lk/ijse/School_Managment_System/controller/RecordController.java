package lk.ijse.School_Managment_System.controller;

import lk.ijse.School_Managment_System.constant.CommonResponse;
import lk.ijse.School_Managment_System.dto.RecordDTO;
import lk.ijse.School_Managment_System.service.RecordService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static lk.ijse.School_Managment_System.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.School_Managment_System.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/api/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveRecord(@RequestBody RecordDTO recordDTO) {
        recordService.saveRecord(recordDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateRecord(@RequestBody RecordDTO recordDTO) {
        recordService.updateRecord(recordDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @DeleteMapping(value = "/{recordId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteRecord(@PathVariable long recordId) {
        recordService.deleteRecord(recordId);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }
}
