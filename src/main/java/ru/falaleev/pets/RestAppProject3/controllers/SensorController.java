package ru.falaleev.pets.RestAppProject3.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.falaleev.pets.RestAppProject3.dto.SensorDTO;
import ru.falaleev.pets.RestAppProject3.models.Sensor;
import ru.falaleev.pets.RestAppProject3.service.SensorService;
import ru.falaleev.pets.RestAppProject3.util.*;

import java.util.List;
import java.util.stream.Collectors;

import static ru.falaleev.pets.RestAppProject3.util.ErrorsUtil.returnErrorsToClient;

//Этот контроллер отвечает за логику работы сенсора
@RestController //все методы будут возвращать данные а не представления
@RequestMapping("/sensors") // указываем что адрес у всех начинается с...
public class SensorController {
    private final SensorService sensorService;
    private final SensorValidator sensorValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorValidator sensorValidator, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
        this.modelMapper = modelMapper;
    }


    // метод, который вернет статус проведенной операции сюда можно
    //положить хоть какой объект в том числе и Sensor sensor...
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        //@RequestBody аннотация при получении данных из jonson сконвертирует их в обьект
        Sensor sensorToAdd = convertToSensor(sensorDTO);

        sensorValidator.validate(sensorToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        sensorService.register(sensorToAdd);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException
            (MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // статус 400
    }


    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }


}
